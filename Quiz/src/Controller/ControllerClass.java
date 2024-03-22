/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lab Informatika
 */
public class ControllerClass {
    GUI gui;
    public ControllerClass (GUI gui) {
    this.gui = gui;
    
    gui.bsubmit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        int WriteScore = Integer.parseInt(gui.getFnil1().getText());            
        int CodeScore = Integer.parseInt(gui.getFnil2().getText());
        int InterviewScore = Integer.parseInt(gui.getFnil3().getText()); 
        double FinalScore1, FinalScore2;
        FinalScore1 = (WriteScore * 0.2) + (CodeScore * 0.5) + (InterviewScore * 0.3); 
        FinalScore2 = (WriteScore * 0.4) + (CodeScore * 0.35) + (InterviewScore * 0.25);       
        if (FinalScore1 > 85){
            //KIRIM
        } 
    }
    
    
    });
}

}