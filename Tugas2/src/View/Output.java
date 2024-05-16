/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

public class Output {
    JFrame window = new JFrame("Read Data Student");
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object columnName[] = {
        "ID", "NIM", "Name", "Age"
    };
    
    JButton btnAdd = new JButton("ADD");
    JButton btnRefresh = new JButton("REFRESH");
        
    public Output(Controller controller){
        tableModel = new DefaultTableModel(columnName, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
      
        window.setLayout(null);
        window.setSize(550, 600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        window.add(scrollPane);
        window.add(btnAdd);
        window.add(btnRefresh);
        scrollPane.setBounds(20, 35, 500, 300);
        btnAdd.setBounds(20, 350, 90, 20);
        btnRefresh.setBounds(120, 350, 120, 20);
        
        refreshTable(controller);
        
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = tabel.getSelectedRow();
                int id = Integer.parseInt(tabel.getValueAt(row,0).toString());
                String name = tabel.getValueAt(row,2).toString();
                
                int input = JOptionPane.showConfirmDialog(null,
                            "Do you want to delete " + name + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                
                if(input == 0){
                    controller.deleteData(id);
                    refreshTable(controller);
                } else {
                    input = JOptionPane.showConfirmDialog(null,
                            "Do you want to update " + name + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                    if(input == 0){
                        new Update(id, controller);
                    }
                }
            }
        });
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Input(controller);
            }
        });
        
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable(controller);
            }
        });
    }
    
    private void refreshTable(Controller controller) {
        String[][] data = controller.readData();
        tableModel.setRowCount(0); // Clear existing data
        for (String[] row : data) {
            if (row[0] != null) { // Ensure the row is not empty
                tableModel.addRow(row);
            }
        }
    }
}

