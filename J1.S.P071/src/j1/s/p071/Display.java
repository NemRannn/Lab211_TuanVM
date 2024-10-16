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
public class Display {

    public static void displayMenu() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Task\n"
                + "2. Delete task\n"
                + "3. Display Task\n"
                + "4. Exit");
    }

    public static void displayTask(ArrayList<Task> listTask) {
        System.out.println("----- Task -----");
        System.out.format("%-5s %-15s %-10s %-10s %-10s %-5s %-15s %-15s\n", "ID",
                "Name", "Task Type", "Date", "From", "To", "Assignee", "Reviewer");
        for (Task task : listTask) {
            System.out.println(task);
        }
        System.out.println("");
    }
}
