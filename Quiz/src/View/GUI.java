/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import model.Person;

/**
 *
 * @author Lab Informatika
 */
public class GUI extends JFrame{
    private JLabel lname = new JLabel("Full Name");
    private JTextField fname = new JTextField();
    private JLabel lnim = new JLabel("Nim");
    private JTextField fnim = new JTextField();
    private JLabel lnil1  = new JLabel("Writing Exam");
    private JTextField fnil1 = new JTextField();
    private JLabel lnil2  = new JLabel("Coding Test");
    private JTextField fnil2 = new JTextField();
    private JLabel lnil3  = new JLabel("Interview Test");
    private JTextField fnil3 = new JTextField();
    private JLabel AndDev  = new JLabel("Android Developer:");
    private JTextField AndDevResult = new JTextField();
    private JLabel WebDev  = new JLabel("Web Developer:");
    private JTextField WebDevResult = new JTextField();
    public JButton bsubmit = new JButton("Submit");
    
    public GUI (){
        setTitle("This is Title");
        setSize(500,400);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(lname);
        lname.setBounds(10, 10, 120, 16);
        add(fname);
        fname.setBounds(120, 10, 120, 16);
        add(lnim);
        lnim.setBounds(10, 30, 120, 16);
        add(fnim);
        fnim.setBounds(120, 30, 120, 16);
        add(lnil1);
        lnil1.setBounds(10, 50, 120, 16);
        add(fnil1);
        fnil1.setBounds(120, 50, 120, 16);
        add(lnil2);
        lnil2.setBounds(10, 70, 120, 16);
        add(fnil2);
        fnil2.setBounds(120, 70, 120, 16);
        add(lnil3);
        lnil3.setBounds(10, 90, 120, 16);
        add(fnil3);
        fnil3.setBounds(120, 90, 120, 16);
        add(bsubmit);
        bsubmit.setBounds(10, 120, 240, 40);
        add(AndDev);
        AndDev.setBounds(10, 180, 120, 16);
        add(WebDev);
        WebDev.setBounds(10, 210, 120, 16);
        add(AndDevResult);
        AndDevResult.setBounds(120, 180, 120, 16);
        add(WebDevResult);
        WebDevResult.setBounds(120, 210, 120, 16);
        
        
    }
    public JLabel getlnil1() {
        return getLnil1();
    }

    public void setlnil1(JLabel lnil1) {
        this.setLnil1(lnil1);
    }
    public JLabel getlnil2() {
        return getLnil2();
    }

    public void setlnil2(JLabel lnil2) {
        this.setLnil2(lnil2);
    }
    public JLabel getlnil3() {
        return getLnil3();
    }

    public void setlnil3(JLabel lnil1) {
        this.setLnil3(getLnil3());
    }

    /**
     * @return the lname
     */
    public JLabel getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(JLabel lname) {
        this.lname = lname;
    }

    /**
     * @return the fname
     */
    public JTextField getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(JTextField fname) {
        this.fname = fname;
    }

    /**
     * @return the lnim
     */
    public JLabel getLnim() {
        return lnim;
    }

    /**
     * @param lnim the lnim to set
     */
    public void setLnim(JLabel lnim) {
        this.lnim = lnim;
    }

    /**
     * @return the fnim
     */
    public JTextField getFnim() {
        return fnim;
    }

    /**
     * @param fnim the fnim to set
     */
    public void setFnim(JTextField fnim) {
        this.fnim = fnim;
    }

    /**
     * @return the lnil1
     */
    public JLabel getLnil1() {
        return lnil1;
    }

    /**
     * @param lnil1 the lnil1 to set
     */
    public void setLnil1(JLabel lnil1) {
        this.lnil1 = lnil1;
    }

    /**
     * @return the fnil1
     */
    public JTextField getFnil1() {
        return fnil1;
    }

    /**
     * @param fnil1 the fnil1 to set
     */
    public void setFnil1(JTextField fnil1) {
        this.fnil1 = fnil1;
    }

    /**
     * @return the lnil2
     */
    public JLabel getLnil2() {
        return lnil2;
    }

    /**
     * @param lnil2 the lnil2 to set
     */
    public void setLnil2(JLabel lnil2) {
        this.lnil2 = lnil2;
    }

    /**
     * @return the fnil2
     */
    public JTextField getFnil2() {
        return fnil2;
    }

    /**
     * @param fnil2 the fnil2 to set
     */
    public void setFnil2(JTextField fnil2) {
        this.fnil2 = fnil2;
    }

    /**
     * @return the lnil3
     */
    public JLabel getLnil3() {
        return lnil3;
    }

    /**
     * @param lnil3 the lnil3 to set
     */
    public void setLnil3(JLabel lnil3) {
        this.lnil3 = lnil3;
    }

    /**
     * @return the fnil3
     */
    public JTextField getFnil3() {
        return fnil3;
    }

    /**
     * @param fnil3 the fnil3 to set
     */
    public void setFnil3(JTextField fnil3) {
        this.fnil3 = fnil3;
    }

    /**
     * @return the AndDev
     */
    public JLabel getAndDev() {
        return AndDev;
    }

    /**
     * @param AndDev the AndDev to set
     */
    public void setAndDev(JLabel AndDev) {
        this.AndDev = AndDev;
    }

    /**
     * @return the WebDev
     */
    public JLabel getWebDev() {
        return WebDev;
    }

    /**
     * @param WebDev the WebDev to set
     */
    public void setWebDev(JLabel WebDev) {
        this.WebDev = WebDev;
    }

    /**
     * @return the bsubmit
     */
    public JButton getBsubmit() {
        return bsubmit;
    }

    /**
     * @param bsubmit the bsubmit to set
     */
    public void setBsubmit(JButton bsubmit) {
        this.bsubmit = bsubmit;
    }

    /**
     * @return the AndDevResult
     */
    public JTextField getAndDevResult() {
        return AndDevResult;
    }

    /**
     * @param AndDevResult the AndDevResult to set
     */
    public void setAndDevResult(JTextField AndDevResult) {
        this.AndDevResult = AndDevResult;
    }

    /**
     * @return the WebDevResult
     */
    public JTextField getWebDevResult() {
        return WebDevResult;
    }

    /**
     * @param WebDevResult the WebDevResult to set
     */
    public void setWebDevResult(JTextField WebDevResult) {
        this.WebDevResult = WebDevResult;
    }
}