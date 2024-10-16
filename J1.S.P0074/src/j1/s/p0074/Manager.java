/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0074;

/**
 *
 * @author tuana
 */
public class Manager {

    public static void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice:");
    }

    public static void displayAddition(String msg) {
        System.out.println(msg);
    }

    public static void displaySubtraction(String msg) {
        System.out.println(msg);
    }

    public static void displayMultiplication(String msg) {
        System.out.println(msg);
    }

    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //Loop traverse from first element of column to last element of column of matrix
        for (int i = 0; i < row; i++) {
            //Loop traverse from first element of row to last element of row of matrix
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int option) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        switch (option) {
            //Addition option
            case 1:
                System.out.println("+");
                break;
            //Subtraction option
            case 2:
                System.out.println("-");
                break;
            //Multiplication option
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
}
