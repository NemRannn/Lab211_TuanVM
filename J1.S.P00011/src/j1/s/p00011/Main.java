/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p00011;

/**
 *
 * @author tuana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            // Step 1. Display a menu
            Display.displayMenu();
            // Step 2. Users choose the base number input
            int baseInput = InputData.baseNumber(1,4,0);
            // Step 3. Users choose the base number output
            int baseOutput = InputData.baseNumber(1,4,baseInput);
            // Step 4. User enter the input value
            String inputValue = InputData.value("Enter value:",baseInput);
            // Step 5. Program process convert value
            String result =  Convert.convertValue(inputValue, baseInput, baseOutput);
            // Step 6. Display result
            Display.displayResult(result);
        }
    }

}
