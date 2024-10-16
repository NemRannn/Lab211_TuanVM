/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p00011;

import java.util.Scanner;

/**
 *
 * @author tuana
 */
class InputData {

    public static int baseNumber(int optionMin, int optionMax, int inputBase) {
        do {
            int userChoice;
            int base = -1;
            String input;
            Scanner sc = new Scanner(System.in);
            //Check if user are input base input
            if (inputBase == 0) {
                System.out.print("Choose your base input: ");
            } else {
                System.out.print("Choose your base output: ");
            }
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please enter something!");
            } else {
                try {
                    userChoice = Integer.parseInt(input.trim());
                    //Check user choice option are in option range or not
                    if (userChoice < optionMin || userChoice > optionMax) {
                        System.out.println("Choice must be in range " + optionMin + " to " + optionMax);
                    } else {
                        switch (userChoice) {
                            case 1:
                                base = 2;
                                break;
                            case 2:
                                base = 10;
                                break;
                            case 3:
                                base = 16;
                                break;
                            case 4:
                                System.exit(0);
                        }
                        //Check value of variable baseIn with base choose by user
                        if (base == inputBase) {
                            System.out.println("Base of output can't be same base of input");
                        } else {
                            return base;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Choice must be integer!");
                }
            }
        } while (true);
    }

    public static String value(String msg, int inputBase) {
        do {
            Scanner sc = new Scanner(System.in);
            String input;
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please enter something!");
            } else {
                String regexBase = "";
                switch (inputBase) {
                    //Regular expression input for binary
                    case 2:
                        //Accept input is digit is 0 or 1 from begin to end of string
                        regexBase = "^[01]*+$";
                        break;
                    //Regular expression input for decimal 
                    case 10:
                        //Accept input is digit from 0 to 9 from begin to end of string
                        regexBase = "^[0-9]*+$";
                        break;
                    //Regular expression input for hexadecimal 
                    case 16:
                        //Accept input is a to f both uppercase or lowercase 
                        //and digit from 0 to 9 in unlimited length
                        regexBase = "^[a-fA-F0-9]*+$";
                        break;
                }
                //Check format of input by regular expression
                if (input.matches(regexBase)) {
                    return input.toUpperCase();
                } else {
                    System.out.println("Input must be in base " + inputBase);
                }
            }

        } while (true);
    }

}
