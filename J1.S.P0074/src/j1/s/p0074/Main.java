/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0074;

/**
 *
 * @author tuana
 */
public class Main {

    public static void main(String[] args) {
        do {
            //Step 1: Display menu
            Manager.displayMenu();
            //Step 2: Get user input from 1 to 4 to select option
            int option = GetData.getUserInput(1, 4);
            switch (option) {
                //Option 1: Addition matrix
                case 1:
                    Manager.displayAddition("-------- Addition --------");
                    int[][] addMatrix1 = GetData.Matrix1();
                    int[][] addMatrix2 = GetData.Matrix2(addMatrix1, option);
                    int[][] additionMatrixResult = Calculator.additionMatrix(addMatrix1, addMatrix2);
                    Manager.displayResult(addMatrix1, addMatrix2, additionMatrixResult, option);
                    break;
                //Option 2: Subtraction matrix
                case 2:
                    Manager.displaySubtraction("----- Subtraction ------");
                    int[][] subMatrix1 = GetData.Matrix1();
                    int[][] subMatrix2 = GetData.Matrix2(subMatrix1, option);
                    int[][] subtractionMatrixResult = Calculator.subtractionMatrix(subMatrix1, subMatrix2);
                    Manager.displayResult(subMatrix1, subMatrix2, subtractionMatrixResult, option);
                    break;
                //Option 3: Multiplication matrix
                case 3:
                    Manager.displayMultiplication("-------- Multiplication -------");
                    int[][] multiMatrix1 = GetData.Matrix1();
                    int[][] multiMatrix2 = GetData.Matrix2(multiMatrix1, option);
                    int[][] multiplicationMatrixResult = Calculator.multiplicationMatrix(multiMatrix1, multiMatrix2);
                    Manager.displayResult(multiMatrix1, multiMatrix2, multiplicationMatrixResult, option);
                    break;
                //Option 4: Exit program
                case 4:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
