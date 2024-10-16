/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p071;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tuana
 */
public class Validate {

    public static boolean checkTimeFrom(ArrayList<Task> taskList, Date date, double from) {
        for (Task task : taskList) {
            if (task.getDate().equals(date)) {
                if (task.getPlanTo() >= from && task.getPlanFrom() <= from) {
                    return true;
                }
            }
        }
        return false;
    }

//    public static boolean checkTimeTo(ArrayList<Task> taskList, Date date, double from, double to) {
//        for (Task task : taskList) {
//            if (task.getDate().equals(date)) {
//                if (task.getPlanTo() >= to && task.getPlanFrom() <= to) {
//                    return true;
//                }
//                if (task.getPlanTo() < from) {
//                    if (task.getPlanFrom() <= to) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
   public static boolean checkTimeTo(ArrayList<Task> taskList, Date date, double from, double to) {
        for (Task task : taskList) {
            if (task.getDate().equals(date)) {
                if (task.getPlanTo() >= to && task.getPlanFrom() < to) {
                    return true;
                }
                if (task.getPlanTo() > from && task.getPlanFrom() <= from) {
                    return true;
                }
//                if (task.getPlanTo() == from) {
//                    return true; 
//                }
            }
        }
        return false;
    }

    public static boolean isDayFull(ArrayList<Task> taskList, Date date) {
        // Filter the list of tasks on the selected day
        List<Task> tasksInSameDay = taskList.stream()
                .filter(task -> task.getDate().equals(date))
                .collect(Collectors.toList());
        // Check if there is any time slot from 8:00 to 17:30 not occupied by a task
        for (double time = 8.0; time <= 17.5; time += 0.5) {
            final double checkTime = time;
            boolean timeOccupied = tasksInSameDay.stream()
                    .anyMatch(task -> checkTime >= task.getPlanFrom() && checkTime <= task.getPlanTo());
            if (!timeOccupied) {
                return false; // If there is an available time slot, return false
            }
        }

        return true; // If all time slots are occupied, return true
    }

}
