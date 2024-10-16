/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p071;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class Manage {

    public static void addTask(ArrayList<Task> taskList) {
        taskList.clear();
        taskList = DoFile.readToFile("task.txt", taskList);
        System.out.println("----- Add Task -----");

        int ID = DoFile.getIDFromFile();
        String requirementName = Input.inputString("Requirement Name: ", "", "");
        int taskType = Input.inputInt("Task Type: ", 1, 4);
        Date date = Input.inputDate(taskList, "Date: ");
        double from = Input.inputPlanFrom(taskList, date);
        double to = Input.inputPlanTo(taskList, date, from);
        String assignee = Input.inputString("Assignee: ", "", "");
        String reviewer = Input.inputString("Reviewer: ", "", "");

        Task task = new Task(ID, requirementName, taskType, date, from, to, assignee, reviewer);
        taskList.add(task);

        DoFile.writeToFile("task.txt", taskList);
        DoFile.saveIDFromFile(ID);
    }

    public static Task findTask(int id, ArrayList<Task> taskList) {
        for (Task task : taskList) {
            if (task.getID() == id) {
                return task;
            }
        }
        return null;
    }

    public static void deleteTask(ArrayList<Task> taskList) {
        taskList.clear();
        taskList = DoFile.readToFile("task.txt", taskList);
        if (taskList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("----- Delete Task -----");
            int id = Input.inputInt("ID: ", 0, Integer.MAX_VALUE);
            Task task = findTask(id, taskList);
            if (task == null) {
                System.out.println("Not found");
            } else {
                taskList.remove(task);
            }
            DoFile.writeToFile("task.txt", taskList);
            System.out.println("Delete successed!");
            Display.displayTask(taskList);
        }
    }

    public static void showTask(ArrayList<Task> taskList) {
        taskList.clear();
        taskList = DoFile.readToFile("task.txt", taskList);
        if (taskList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            Display.displayTask(taskList);
        }
    }
}

