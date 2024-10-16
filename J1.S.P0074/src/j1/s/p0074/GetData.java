/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0074;

import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class GetData {

    public static int getUserInput(int optionMin, int optionMax) {
        do {
            Scanner sc = new Scanner(System.in);
            int option;
            String input;
            input = sc.nextLine();

            //Check user input empty or not
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
            } else {
                try {
                    option = Integer.parseInt(input.trim());
                    //Check user choice option are in option range or not
                    if (option < optionMin || option > optionMax) {
                        System.out.println("Input must be in range " + 1 + " to " + 4 + "!");
                    } else {
                        return option;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input must be integer!");
                }
            }
        } while (true);
    }

    public static int userInput(String msg, int optionMin, int optionMax) {
        do {
            Scanner sc = new Scanner(System.in);
            int option;
            String input;
            System.out.print(msg);
            input = sc.nextLine();

            //Check user input empty or not
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
            } else {
                try {
                    option = Integer.parseInt(input.trim());
                    //Check user choice option are in option range or not
                    if (option < optionMin || option > optionMax) {
                        System.out.println("Input must be in range " + optionMin + " to " + optionMax + "!");
                    } else {
                        return option;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input must be integer!");
                }

            }
        } while (true);
    }

    public static int getMatrix(int matrix, int i, int j) {
        String inputValue;
        int outputValue;
        do {
            Scanner sc = new Scanner(System.in);
            inputValue = sc.nextLine();
            //Check user input empty or not
            if (inputValue.isEmpty()) {
                System.out.println("Input couldn't be empty!");
                System.out.print("Enter Matrix" + matrix + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            } else {
                try {
                    outputValue = Integer.parseInt(inputValue.trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Value of matrix is digit");
                    System.out.print("Enter Matrix" + matrix + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                }
            }
        } while (true);
        return outputValue;
    }

    public static int[][] Matrix1() {
        int row = userInput("Enter Row Matrix 1:", 1, Integer.MAX_VALUE);
        int col = userInput("Enter Column Matrix 1:", 1, Integer.MAX_VALUE);
        int[][] newMatrix = new int[row][col];
        //Loop traverse from first element of col to last element of col of matrix
        for (int i = 0; i < row; i++) {
            //Loop traverse from first element of row to last element of row of matrix
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix1" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                newMatrix[i][j] = getMatrix(1, i, j);
            }
        }
        return newMatrix;
    }

    public static int[][] Matrix2(int[][] matrix1, int option) {
        int rowM1 = matrix1.length;
        int colM1 = matrix1[0].length;
        int rowM2, colM2;
        //Check user choice if its option 3(MultiplicationMatrix)
        if (option == 3) {
            do {
                rowM2 = userInput("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //Check row of Matrix2 equal or not equal to column of Matrix1
                if (rowM2 != colM1) {
                    System.out.println("Row of Matrix2 must be equal to column of Matrix1!");
                } else {
                    colM2 = userInput("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                    break;
                }

            } while (true);
        } else {
            do {
                rowM2 = userInput("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //Check row of Matrix2 equal or not equal to row of Matrix1
                if (rowM2 != rowM1) {
                    System.out.println("Row of Matrix2 must be equal to row of Matrix1!");
                } else {
                    break;
                }
            } while (true);
            do {
                colM2 = userInput("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                //Check column of Matrix2 equal or not euqal to column of Matrix1
                if (colM2 != colM1) {
                    System.out.println("Column of Matrix2 must be equal to column of Matrix1!");
                } else {
                    break;
                }
            } while (true);
        }
        int[][] matrix2 = new int[rowM2][colM2];
        //Loop traverse from first element of row to last element of row of matrix
        for (int i = 0; i < rowM2; i++) {
            //Loop traverse from first element of column to last element of column of matrix
            for (int j = 0; j < colM2; j++) {
                System.out.print("Enter Matrix2" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix2[i][j] = getMatrix(2, i, j);
            }
        }
        return matrix2;
    }

}
