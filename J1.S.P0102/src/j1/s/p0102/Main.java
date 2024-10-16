/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0102;

/**
 *
 * @author tuana
 */
public class Main {

    public static void main(String[] args) {
        //Step 1: Enter date with format
        String inputDate = DateOfWeek.enterDateWithFormat("Please enter date with format [dd/mm/yyyy]: ");
        //Step 2: Check date exits
        boolean dateExists = DateOfWeek.checkDateExists(inputDate);
        //Step 3: Determine day of week with input date
        DateOfWeek.determineDayOfWeek(inputDate, dateExists);
    }
}
