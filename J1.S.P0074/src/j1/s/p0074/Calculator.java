/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0074;

/**
 *
 * @author tuana
 */
public class Calculator {

    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int numRowResult = matrix1.length;
        int numColumnResult = matrix1[0].length;

        int[][] result = new int[numRowResult][numColumnResult];
        //traverse from first element of row to last element of row matrix result
        for (int i = 0; i < numRowResult; i++) {
            //traverse from first element of column to last element of column matrix result
            for (int j = 0; j < numColumnResult; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int numRowResult = matrix1.length;
        int numColumnResult = matrix1[0].length;

        int[][] result = new int[numRowResult][numColumnResult];
        //traverse from first element of row to last element of row matrix result
        for (int i = 0; i < numRowResult; i++) {
            //traverse from first element of column to last element of column matrix result
            for (int j = 0; j < numColumnResult; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int numRowResult = matrix1.length;
        int numColumnResult = matrix2[0].length;
        int numRowMatrix2 = matrix2.length;

        int[][] result = new int[numRowResult][numColumnResult];
        //traverse from first element of row to last element of row matrix result
        for (int i = 0; i < numRowResult; i++) {
            //traverse from first element of column to last element of column matrix result
            for (int j = 0; j < numColumnResult; j++) {
                //traverse from first element of row to last element of row matrix 2
                for (int k = 0; k < numRowMatrix2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
