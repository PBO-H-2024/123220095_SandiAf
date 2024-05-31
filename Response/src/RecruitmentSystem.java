import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class RecruitmentSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/recruitdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private ArrayList<Candidate> candidates;

    public RecruitmentSystem() {
        candidates = new ArrayList<>();
        setupUI();
    }

    private Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void addCandidateToDB(String name, String path, double writingExamScore, double codingTestScore, double interviewTestScore) {
        double averageScore = (writingExamScore + codingTestScore + interviewTestScore) / 3.0;
        String status = averageScore >= 70 ? "Passed" : "Failed";
        String insertSQL = "INSERT INTO recruitment (name, path, writing, coding, interview, score, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, path); 
            pstmt.setDouble(3, writingExamScore);
            pstmt.setDouble(4, codingTestScore);
            pstmt.setDouble(5, interviewTestScore);
            pstmt.setDouble(6, averageScore);
            pstmt.setString(7, status);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Candidate added successfully to database!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding candidate to database: " + e.getMessage());
        }
    }

    public void displayCandidatesFromDB() {
        String selectSQL = "SELECT name, path, score, status FROM recruitment";
        StringBuilder sb = new StringBuilder();
        
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                sb.append("Name: ").append(rs.getString("name"))
                  .append(", Path: ").append(rs.getString("path"))  
                  .append(", Average Score: ").append(rs.getDouble("score"))
                  .append(", Status: ").append(rs.getString("status")).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving candidates from database: " + e.getMessage());
        }
    }

    private void setupUI() {
        JFrame frame = new JFrame("Recruitment System");
        frame.setSize(400, 400); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(160, 20, 165, 25);
        panel.add(nameText);

        JLabel pathLabel = new JLabel("Path:");
        pathLabel.setBounds(10, 50, 80, 25);
        panel.add(pathLabel);

        String[] paths = { "Android Developer", "Web Developer" };
        JComboBox<String> pathComboBox = new JComboBox<>(paths);
        pathComboBox.setBounds(160, 50, 165, 25);
        panel.add(pathComboBox);

        JLabel writingLabel = new JLabel("Writing Exam Score:");
        writingLabel.setBounds(10, 80, 150, 25);
        panel.add(writingLabel);

        JTextField writingText = new JTextField(20);
        writingText.setBounds(160, 80, 165, 25);
        panel.add(writingText);

        JLabel codingLabel = new JLabel("Coding Test Score:");
        codingLabel.setBounds(10, 110, 150, 25);
        panel.add(codingLabel);

        JTextField codingText = new JTextField(20);
        codingText.setBounds(160, 110, 165, 25);
        panel.add(codingText);

        JLabel interviewLabel = new JLabel("Interview Test Score:");
        interviewLabel.setBounds(10, 140, 150, 25);
        panel.add(interviewLabel);

        JTextField interviewText = new JTextField(20);
        interviewText.setBounds(160, 140, 165, 25);
        panel.add(interviewText);

        JButton addButton = new JButton("Add Candidate");
        addButton.setBounds(10, 170, 150, 25);
        panel.add(addButton);

        JButton displayButton = new JButton("Display Candidates");
        displayButton.setBounds(170, 170, 150, 25);
        panel.add(displayButton);

        addButton.addActionListener(e -> {
            String name = nameText.getText();
            String path = (String) pathComboBox.getSelectedItem();
            try {
                double writingScore = Double.parseDouble(writingText.getText());
                double codingScore = Double.parseDouble(codingText.getText());
                double interviewScore = Double.parseDouble(interviewText.getText());

                if (writingScore < 0 || writingScore > 100 || codingScore < 0 || codingScore > 100 || interviewScore < 0 || interviewScore > 100) {
                    JOptionPane.showMessageDialog(panel, "Scores must be between 0 and 100");
                    return;
                }

                addCandidateToDB(name, path, writingScore, codingScore, interviewScore);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Please enter valid scores.");
            }
        });

        displayButton.addActionListener(e -> displayCandidatesFromDB());
    }

    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}

class Candidate {
    private String name;
    private String path;
    private double writingExamScore;
    private double codingTestScore;
    private double interviewTestScore;

    public Candidate(String name, String path, double writingExamScore, double codingTestScore, double interviewTestScore) {
        this.name = name;
        this.path = path;
        this.writingExamScore = writingExamScore;
        this.codingTestScore = codingTestScore;
        this.interviewTestScore = interviewTestScore;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public double getAverageScore() {
        return (writingExamScore + codingTestScore + interviewTestScore) / 3.0;
    }
}
