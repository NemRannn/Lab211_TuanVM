/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class Input {

    public static Scanner scan = new Scanner(System.in);

    public static int inputInt(String titile, int min, int max) {
        while (true) {
            System.out.print(titile);
            try {
                String input = scan.nextLine().trim();
                //Check if input is empty
                if (input.isEmpty()) {
                    System.out.println("Input must not be empty!");
                    continue;
                }
                int output = Integer.parseInt(input);
                //Check input must be from min to max
                if (output < min || output > max) {
                    System.out.println("Input must be from " + min + " to " + max);
                    continue;
                }
                return output;
            } catch (NumberFormatException e) {
                System.out.println("Input must be integer!");
            }
        }
    }

    public static int inputOption() {
        int choice = inputInt("Enter your choice: ", 1, 4);
        return choice;
    }

    public static String inputString(String title, String msg, String regex) {
        String input;
        do {
            System.out.print(title);
            input = scan.nextLine().trim();
            //Check input = null
            if (input.isEmpty()) {
                System.out.println("Input cann't empty!");
                continue;
            } else {
                if (regex.isEmpty()) {
                    break;
                } //Check format input
                else if (!input.matches(regex)) {
                    System.out.println(msg);
                    continue;
                } else {
                    break;
                }
            }
        } while (true);
        return input;
    }

    public static Date inputDate(ArrayList<Task> taskList, String title) {
        Date date;
        do {
            System.out.print(title);
            String input = scan.nextLine().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            //Check input = null
            if (input.isEmpty()) {
                System.out.println("Date can't empty!");
                continue;
                //\d{1,2}: the number have 1 or 2 digit number
                //[-]: contain character -
                //\d{4}: the number must have 4 digit
            } else if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                System.out.println("Wrong date format!");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                Date now = new Date();
                //Check date must be before now
                if (date.before(now)) {
                    System.out.println("Date could not be the past. Please enter again!");
                    continue;
                }
                if (Validate.isDayFull(taskList, date)) {
                    System.out.println("This day is out of free time. Please choose another day!");
                    continue;
                }
                break;
            } catch (ParseException e) {
                System.out.println("Date doesn't existed!!");
            }
        } while (true);
        return date;
    }

    public static double inputPlan(String title, String msg, double min, double max) {
        double result;
        String input;
        do {
            //\d: accept input be a digit from 0-9
            //\.: after digit is a dot
            //([5]): after a dot just accpet digit 5
            //(...)?: the characters in brackets may or may not be in the input
            input = inputString(title, "Input just accept x or x.5 number", "^(\\d+(\\.[5])?)$");

            try {
                result = Double.parseDouble(input);
                //check choice in range min and max
                if (result < min || result > max) {
                    System.out.println(msg);
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a real number!");
            }

        } while (true);
        return result;
    }

    public static double inputPlanFrom(ArrayList<Task> taskList, Date date) {
        while (true) {
            double from = Input.inputPlan("From: ", "Plan From must be within 8h-17h", 8.0, 17.0);
            if (Validate.checkTimeFrom(taskList, date, from) == true) {
                System.out.println("There was a task in progress at this time!");
                continue;
            }
            return from;
        }
    }

//    public static double inputPlanTo(ArrayList<Task> taskList, Date date, double from) {
//        while (true) {
//            double to = Input.inputPlan("To: ", "Plan To must be within From to 17h30", from + 0.5, 17.5);
//            if (Validate.checkTimeTo(taskList, date, from, to) == true || Validate.checkTimeTo(taskList, date, from, to) == true) {
//                System.out.println("There was a task in progress at this time!");
//                continue;
//            }
//            return to;
//        }
//    }
    
    public static double inputPlanTo(ArrayList<Task> taskList, Date date, double from) {
    while (true) {
        double to = Input.inputPlan("To: ", "Plan To must be within From to 17h30", from, 17.5);
        if (Validate.checkTimeTo(taskList, date, from, to) == true) {
            System.out.println("There was a task in progress at this time!");
            continue;
        }
        return to;
    }
}

}
