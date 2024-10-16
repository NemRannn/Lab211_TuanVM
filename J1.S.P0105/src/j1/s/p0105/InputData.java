/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class InputData {

    private static final Scanner sc = new Scanner(System.in);

    public static int InputIntLimit(int min, int max) {
        //loop until user input correct
        int result;
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("String can not empty. Please enter again!");
                continue;
            }
            if (!checkdigits(input)) {
                System.out.println("String contain characters. Please enter again!");
                continue;
            }
            result = Integer.parseInt(input);
            if (result < min || result > max) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
                continue;
            }
            return result;
        }
    }

    public static int GetOption() {
        int choice = InputIntLimit(1, 6);
        return choice;
    }

    //check user input string
    public static String InputString(String msg) {
        //loop until user input correct
        System.out.printf(msg);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static int InputInt(String msg) {
        //loop until user input correct
        int result;
        while (true) {
            System.out.printf(msg);
            String input = sc.nextLine().trim();
            // check empty
            if (input.isEmpty()) {
                System.out.println("String can not empty. Please enter again!");
                System.out.print("Enter again: ");
                continue;
            }
            //check digit input
            if (!checkdigits(input)) {
                System.out.println("String contain characters. Please enter again!");
                System.out.print("Enter again: ");
                continue;
            }
            result = Integer.parseInt(input);
            return result;
        }
    }

    public static double checkInputDouble(String msg) {
        //loop until user input correct
        while (true) {
            System.out.printf(msg);
            String input = sc.nextLine().trim();
            double result = 0;
            //Check empty
            if (input.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
                continue;
            }
            //Check real number
            try {
                result = Double.parseDouble(input);
                if (result < 0) {
                    System.out.println("Please enter price > 0");
                    System.out.println("Enter agains");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter number.");
                System.out.println("Enter agains:");
            }
        }
    }

    public static Boolean CheckFormatDate(String str) {

        if (str.isEmpty()) {
            System.out.println("String can not empty. Please enter again!");
            return false;
        }
        // split string into array
        String[] input1 = str.split("/"); // Convert input data into array and separate into each element of the array after /

        // Initialize a for loop to check elements in the array
        for (int i = 0; i < input1.length; i++) {
            //Use the checkletter function to check
            if (checkdigits(input1[i]) == false) {
                System.out.println("String contain characters. Please enter again!");
                return false;
            }
        }
        //Check the input array length according to format
        if (input1.length != 3) {
            System.out.println("Format is wrong");
            return false;
        }
        int day1 = Integer.parseInt(input1[0]); //Convert from string data type to int
        int month1 = Integer.parseInt(input1[1]);
        int year1 = Integer.parseInt(input1[2]);
        //Check the date format according to the topic 
        if (day1 > 99) {
            System.out.println("Format is wrong");
            return false;
        }
        //Check the month format according to the topic 
        if (month1 > 99) {
            System.out.println("Format is wrong");
            return false;
        }
        //Check the year format according to the topic 
        if (year1 < 1000 || year1 > 9999) {
            System.out.println("Format is wrong");
            return false;
        }
        return true;
    }

    public static boolean checkdigits(String check) {
        boolean a = false;
        //Check if the number is from 0-9
        if (check.matches("\\d+")) {
            a = true;
        }
        return a;
    }

    public static Date InputDate(String msg) {
        String input;
        Date date = null;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
             if (!CheckFormatDate(input)) {
                continue;
            }
            try {
                date = dateFormat.parse(input);
            } catch (ParseException exception) {
                System.out.println("Date doesn't existed!!");
                continue;
            }
            break;
        } while (true);

        return date;
    }

    public static boolean checkInputYN(String msg) {
        Scanner sc = new Scanner(System.in);
        String yes_no;
        int a1 = 0;
        System.out.print(msg);
        while (a1 == 0) {
            yes_no = sc.nextLine();
            //Check user enter YES/NO
            if ("Y".equals(yes_no) || "y".equals(yes_no)) {
                a1 = 1;
                continue;
            } else if ("N".equals(yes_no) || "n".equals(yes_no)) {
                a1 = -1;
                continue;
            }
            System.out.println("Please enter (Y/N): ");
            a1 = 0;
        }

        if (a1 == -1) {
            return false;
        }
        return true;
    }
}
