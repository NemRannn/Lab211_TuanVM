/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0103;

/**
 *
 * @author tuana
 */
public class Main {

    public static void main(String[] args) {
        Function callFunction = new Function();
        //step 1: Enter the first date with format
        String FirstDate = callFunction.inputDateWithFormat("Please enter the first date: ");
        //Step 2: Enter the first date with format
        String SecondDate = callFunction.inputDateWithFormat("Please enter the second date: ");
        //Step 3: Compare date
        int variableDisplay = callFunction.compareDate(FirstDate, SecondDate);
        //Step 4: Display
        callFunction.Display(variableDisplay);
    }
}
