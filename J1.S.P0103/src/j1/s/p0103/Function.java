/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0103;

import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class Function {

    Scanner sc = new Scanner(System.in);

    public String inputDateWithFormat(String str) {
        int n = 1;
        String Date = "";
        //initializes a while loop to input data
        while (n != 0) {
            int a0 = 0; // Initialize a variable as a condition for the for loop
            int a1 = 0;
            System.out.print(str);
            Date = sc.nextLine();
            if(Date.isEmpty()) {
                System.out.println("String can not empty. Please enter again!");
                continue;
            }
            String[] input1 = Date.split("/"); // Convert input data into array and separate into each element of the array after /
            // Initialize a for loop to check elements in the array
            
             // Initialize a for loop to check elements in the array
            for (int i = 0; i < input1.length; i++) {
                //Use the checkletter function to check
                if (checkDigits(input1[i]) == false) {
                    System.out.println("String contain characters. Please enter again!");
                    a1 = 1;  //Use variable a1 to get the result to stop or continue the next command line
                    break;
                }
            }
            //This statement is used to stop the next command line according to variable a1
            if (a1 == 1) {
                continue;
            }
            //Check the input array length according to format
            if (input1.length != 3) {
                System.out.println("Format is wrong");
                continue;
            }
            int day1 = Integer.parseInt(input1[0]); //Convert from string data type to int
            int month1 = Integer.parseInt(input1[1]); 
            int year1 = Integer.parseInt(input1[2]); 
            //Check the date format according to the topic 
            if (day1 > 99) {
                System.out.println("Format is wrong");
                continue;
            }
            //Check the month format according to the topic 
            if (month1 > 99) {
                System.out.println("Format is wrong");
                continue;
            }
            //Check the year format according to the topic 
            if (year1 < 1000 || year1 > 9999) {
                System.out.println("Format is wrong");
                continue;
            }
            // Check valid date
            if (checkValiddate(day1, month1, year1) == false) {
                System.out.println("Invalid date. Please enter again!");
                continue;
            }
            n = 0; // end the loop

        }
        return Date;
    }

    public boolean checkDigits(String check) {
        boolean a = false;
        //Check if the number is from 0-9
        if (check.matches("\\d+")) {
            a = true;
        }
        return a;
    }

    public boolean checkValiddate(int day, int month, int year) {
        boolean a = true;
        // Check date month year overview
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0) {
            a = false;
        }
        //Check for months with 30 days
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                a = false;
            }
        }
        if (month == 2) {
            //check leap year
            if ((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0)) {
                if (day > 29) {
                    a = false;
                }
            } 
            // not leap year
            else {              
                if (day > 28) {
                    a = false;
                }
            }
        }
        return a;
    }

    public int compareDate(String c, String d) {
        String[] c1 = c.split("/"); // Convert input data into array and separate into each element of the array after /
        String[] d1 = d.split("/"); 
        int day1 = Integer.parseInt(c1[0]); //Convert from string data type to int
        int month1 = Integer.parseInt(c1[1]); 
        int year1 = Integer.parseInt(c1[2]);  

        int day2 = Integer.parseInt(d1[0]); //Convert from string data type to int
        int month2 = Integer.parseInt(d1[1]); 
        int year2 = Integer.parseInt(d1[2]);  
        //Compare year
        if (year1 < year2) {
            return -1;
        } else if (year1 > year2) {
            return 1;
        } else {
            // COmpare month
            if (month1 < month2) {
                return -1;
            } else if (month1 > month2) {
                return 1;
            } else {
                // compare day
                if (day1 < day2) {
                    return -1;
                } else if (day1 > day2) {
                    return 1;
                } // if date same
                else {
                    return 0;
                }
            }
        }
    }

    public void Display(int k) {
        // Check value from k    
        if (k < 0) {
            System.out.println("\nDate1 is before Date2");
        } else if (k > 0) {
            System.out.println("\nDate1 is after Date2");
        } else {
            System.out.println("\nDate1 and Date2 are the same");
        }
    }
}
