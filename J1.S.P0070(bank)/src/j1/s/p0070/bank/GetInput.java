/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0070.bank;

import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class GetInput {

    public static Scanner sc = new Scanner(System.in);

    public static int checkLimit(String msg, int min, int max) {
        int choice;
        ////Loop until user enter positive number in range of min and max
        while (true) {
            System.out.print(msg);
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Can you choice 1, 2 or 3");
                }
            } catch (NumberFormatException errorName) {
                System.out.println("This is not digit");
            }
        }
    }

    public static String getString(String mess, String fomatRequireMsg, String inputError, String regex) {
        String input;
        ////Loop until user enter String from the keyboard
        while (true) {
            System.out.print(mess);
            input = sc.nextLine().trim();
            //User didn't enter anything from the keyboard
            if (input.isEmpty()) {
                System.out.println(inputError);
            } else {
                //if regex is empty
                if (regex.isEmpty()) {
                    break;
                } else {
                    //Check matches of the input
                    if (input.matches(regex)) {
                        break;
                    } else {
                        //if input of user not flow the matches with regex
                        System.out.println(fomatRequireMsg);
                    }
                }
            }
        }
        return input;
    }

    public static String getPassword(String mess, String inputEmptyError, String err) {
        String input;
        ////Loop until user enter String from the keyboard
        while (true) {
            System.out.print(mess);
            input = sc.nextLine().trim();
            int countNumber = 0;
            int countLetter = 0;
            //User didn't enter anything from the keyboard
            if (input.isEmpty()) {
                System.out.println(inputEmptyError);
                continue;
            }
            //Traverso to first element to last element 
            for (int i = 0; i < input.length(); i++) {
                //if element is digit increase value
                if (Character.isDigit(input.charAt(i))) {
                    countNumber++;
                }
                //if element is letter increase value
                if (Character.isLetter(input.charAt(i))) {
                    countLetter++;
                }
            }
            if (countLetter > 0 && countNumber > 0 && input.length() >= 8 && input.length() <= 31) {
                break;
            } else {
                System.out.println(err);
            }
        }
        return input;
    }

    public static void displayExit() {
        System.out.println("Exit program");
    }

}
