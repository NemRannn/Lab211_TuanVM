/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p071;

import java.util.ArrayList;

/**
 *
 * @author tuana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        while (true) {
            //Step 1: Display menu
            Display.displayMenu();
            //Step 2: Input an option
            int choice = Input.inputOption();
            switch(choice) {
                case 1:
                    //Option 1: Add Task
                    Manage.addTask(taskList);
                    break;
                case 2:
                    //Option 2: Delete Task
                    Manage.deleteTask(taskList);
                    break;
                case 3:
                    //Option 3: Show Task
                    Manage.showTask(taskList);
                    break;
                case 4:
                    //Option 4: Exit program
                    System.exit(0);
            }
        }
    }
    
}
