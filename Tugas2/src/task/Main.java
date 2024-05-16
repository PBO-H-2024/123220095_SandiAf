/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task;

import Controller.Controller;
import View.Output;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        new Output(controller);
    }
}
