/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0052;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class InputData {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInputOption(int min, int max) {
        //Use loop to user enter a choice until correct format
        while (true) {
            System.out.println("Enter your choice:");
            try {
                //Use Scanner class to input String
                String inputOption_raw = scanner.nextLine();
                //Convert String to Integer
                int inputNumber = Integer.parseInt(inputOption_raw);
                //Checks if the input results are out of the min to max range
                if (inputNumber < min || inputNumber > max) {
                    throw new NumberFormatException();
                }
                return inputNumber;
            } catch (NumberFormatException e) {
                System.err.println("Input invalid!! Choose option in range from " + min + " to " + max);
            }
        }
    }

    public static String getInputString() {
        //Use loop to user enter until correct format
        while (true) {
            String inputString = scanner.nextLine();

            if (inputString.trim().isEmpty()) {
                System.err.println("Plear enter information of 11 contries in East Asia!! ");
                continue;
            }
            return inputString;
        }
    }

    public static boolean checkCountryExist(ArrayList<EastAsiaCountries> country, String code) {
        //Use loop for-each to iterate through each country in the Arraylist
        for (EastAsiaCountries c : country) {
            /*Check if the input country code already exists in ArrayList by removing any 
              space characters with case-insensitive*/
            if (c.getCountryCode().replaceAll("\\s+", "").equalsIgnoreCase(code.replaceAll("\\s+", ""))) {
                return false;
            }
        }
        return true;
    }

    public static Float getInputTotalArea() {
        //Use loop to user enter until correct format
        while (true) {
            try {
                //Use Scanner class to input String
                String inputTotalArea_raw = scanner.nextLine();
                //Check if user input is empty
                if (inputTotalArea_raw.trim().isEmpty()) {
                    System.err.println("Please enter total Area!! ");
                    continue;
                }
                //Convert String to Float
                Float inputTotalArea = Float.parseFloat(inputTotalArea_raw);
                //Checks if the user enters a number less than or equal 0
                if (inputTotalArea <= 0) {
                    throw new NumberFormatException();
                }
                return inputTotalArea;
            } catch (NumberFormatException e) {
                System.err.println("Total area must be greater than 0.");
            }
        }
    }

    public static String getInputSearchByName() {
        //Use loop to user enter until correct format
        while (true) {
            //Use Scanner class to input String
            String inputSearch = scanner.nextLine();
            //Check if user input is empty
            if (inputSearch.trim().isEmpty()) {
                System.err.println("Please enter the name you want to search");
                continue;
            }

            return inputSearch;
        }
    }

}
