/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0101.employee;

/**
 *
 * @author tuana
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            //Step 1: display menu
            Manager.displayMenu();
            //Step 2: input number in range 1-6
            int choice = Input.inputNumberInRange(1, 6, 1);
            //Step 3: choice one of option
            switch (choice) {
                //Option 1: Add employees
                case 1:
                    Manager.addEmployees();
                    break;
                //Option 2: Update employees
                case 2:
                    Manager.updateEmployees();
                    break;
                //Option 3: Remove employees
                case 3:
                    Manager.removeEmployees();
                    break;
                //Option 4: Search employees
                case 4:
                    Manager.searchEmployees();
                    break;
                //Option 5: Sort employees by salary
                case 5:
                    Manager.sortEmployeesBySalary();
                    break;
                //Option 6: Exit
                case 6:
                    return;
            }
        }
    }
}
