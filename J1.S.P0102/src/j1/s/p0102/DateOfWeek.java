/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0102;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tuana
 */
class DateOfWeek {

    public static boolean checkFormat(String i) {
        return i.matches("\\d{1,2}[-/]\\d{1,2}[-/]\\d{4}");
    }

    public static boolean checkCharacter(String a) {
        return a.matches("^[0-9-/]*$");
    }

    public static boolean checkException(String a) {
        if (a.isEmpty()) {
            System.out.println("The user has not entered a date");
            return false;
        } else if (!checkCharacter(a)) {
            System.out.println("Invalid characters found in the input");
            return false;
        } else if (!checkFormat(a)) {
            System.out.println("Format error");
            return false;
        }
        return true;
    }

    public static String enterDateWithFormat(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.print(input);
        while (true) {
            String inputDate = sc.nextLine();

            if (checkException(inputDate) && checkDateExists(inputDate)) {
                return inputDate;
            } else {
                System.out.print("Please enter date with format [dd/mm/yyyy]: ");
            }
        }
    }

    public static boolean checkDateExists(String a) {
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat dfm = new SimpleDateFormat(dateFormat);
        dfm.setLenient(false);
        try {
            Date transDate = dfm.parse(a);
            return true;
        } catch (ParseException ex) {
            System.out.println("Date not exists");
            return false;
        }
    }

    public static Date convertStringToDate(String a) {
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat dfm = new SimpleDateFormat(dateFormat);
        dfm.setLenient(false);
        try {
            Date transDate = dfm.parse(a);
            return transDate;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static void determineDayOfWeek(String a, boolean dateExists) {
        if (dateExists) {
            Date dateAfterConvert = convertStringToDate(a);
            String[] allDayOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            Calendar c = Calendar.getInstance();
            c.setTime(dateAfterConvert);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            String dayName = allDayOfWeek[dayOfWeek - 1];
            System.out.println("Your day is " + dayName);
        } else {
            System.out.println("Please check again!!");
        }
    }
}
