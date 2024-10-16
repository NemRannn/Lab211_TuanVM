/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0101.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class Input {

    public static int inputNumberInRange(int min, int max, int mode) {
        Scanner input = new Scanner(System.in);
        int result = 0;
        //loop for valid input
        while (true) {
            try {
                String choice = input.nextLine().trim();
                //check empty input
                if (choice.isEmpty() && mode == 1) {
                    System.err.println("Empty input");
                    System.out.print("Enter again: ");
                } else if (choice.isEmpty() && mode == 0) {
                    break;
                } else {
                    result = Integer.parseInt(choice);
                    //number not in valid range
                    if (result < min || result > max) {
                        System.err.println("Please enter a number in range from " + min + " to " + max + "!!");
                        System.out.print("Enter again: ");
                    //number in valid range
                    } else {
                        return result;
                    }
                }
            //exception if input is a character
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number!!!");
                System.out.print("Enter again: ");
            }
        }
        return result;
    }

    public static int inputPositiveNumber(String msg, int mode) {
        Scanner input = new Scanner(System.in);
        int result = 0;
        System.out.print(msg);
        //loop for valid number
        while (true) {
            try {
                String temp = input.nextLine().trim();
                //check empty input
                if (temp.isEmpty() && mode == 0) {
                    System.err.println("Empty input!");
                    System.out.print("Enter again: ");
                } else {
                    result = Integer.parseInt(temp);
                    //input number not positive
                    if (result <= 0) {
                        System.err.println("Please enter positive number!");
                        System.out.print("Enter again: ");
                    //valid input    
                    } else {
                        return result;
                    }
                }
            //user enter a character    
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number!");
                System.out.print("Enter again: ");
            }

        }
    }

    public static String inputName(String msg, int mode) {
        //name contains only letters
        String validName = "[a-zA-Z ]+|$";
        Scanner input = new Scanner(System.in);
        String result = "";
        System.out.print(msg);
        //loop for valid name
        while (true) {
            result = input.nextLine().trim();
            //check empty input
            if (result.isEmpty() && mode == 1) {
                System.err.println("Empty input!");
                System.out.print("Enter again: ");
            //name doesn't contains only letters
            } else if (!result.matches(validName)) {
                System.err.println("Please use only letters!");
                System.out.print("Enter again: ");
            //valid input
            } else {
                return result;
            }
        }
    }

    public static String inputPhone(String msg, int mode) {
        //phone contains only numbers
        String validName = "[0-9]+|$";
        Scanner input = new Scanner(System.in);
        String result = "";
        System.out.print(msg);
        //loop for valid phone
        while (true) {
            result = input.nextLine().trim();
            //check empty input
            if (result.isEmpty() && mode == 1) {
                System.err.println("Empty input!");
                System.out.print("Enter again: ");
            //phone doesn't contains only numbers
            } else if (!result.matches(validName)) {
                System.err.println("Please use only numbers!");
                System.out.print("Enter again: ");
            //valid input    
            } else {
                return result;
            }
        }
    }

    public static String inputEmail(String msg, int mode) {
        System.out.print(msg);
        String validEmail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$|$";
        String result = "";
        Scanner input = new Scanner(System.in);
        //loop for valid email
        while (true) {
            result = input.nextLine().trim();
            //check empty input
            if (result.isEmpty() && mode == 1) {
                System.err.println("Empty input!");
                System.out.print("Enter again: ");
            } else if (!result.matches(validEmail)) {
                System.err.println("Please enter valid email!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

  public static Date inputDate(String prompt, int minimumAge) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        Scanner scanner = new Scanner(System.in); // Add this line to create a new scanner instance
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                date = dateFormat.parse(input);
                // Add your minimum age validation here, if needed
                return date;
            } catch (ParseException e) {
                System.err.println("Invalid date format. Please use the format dd/MM/yyyy.");
            }
        }
    }


    public static String inputSex(String msg, int mode) {
        System.out.println(msg);
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        System.out.print("Your choice: ");
        int choice = inputNumberInRange(1, 3, mode);
        if (choice == 0) {
            return null;
        } else if (choice == 1) {
            return "Male";
        } else if (choice == 2) {
            return "Female";
        } else {
            return "Other";
        }
    }

    public static double inputDouble(String msg, int mode) {
        Scanner input = new Scanner(System.in);
        double result = -1;
        System.out.print(msg);
        //loop for valid number
        while (true) {
            try {
                String temp = input.nextLine().trim();
                //check empty input
                if (temp.isEmpty() && mode == 1) {
                    System.err.println("Empty input!");
                    System.out.print("Enter again: ");
                }
                //check empty input
                if (temp.isEmpty() && mode == 0) {
                    break;
                } else {
                    result = Double.parseDouble(temp);
                    //input number not positive
                    if (result <= 0) {
                        System.err.println("Please enter positive number!");
                        System.out.print("Enter again: ");
                    //valid input    
                    } else {
                        return result;
                    }
                }
            //user enter a character
            } catch (NumberFormatException e) {
                System.err.println("Please enter an double number!");
                System.out.print("Enter again: ");
            }

        }
        return result;
    }

    public static String inputString(String msg, int mode) {
        Scanner input = new Scanner(System.in);
        String result = "";
        System.out.print(msg);
        //loop for valid string
        while (true) {
            result = input.nextLine().trim();
            //check empty input
            if (result.isEmpty() && mode == 1) {
                System.err.println("Empty input");
                System.out.print("Enter again: ");
            //valid string    
            } else {
                return result;
            }
        }
    }
    
    
}
