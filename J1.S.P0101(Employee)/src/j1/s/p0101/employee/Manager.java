/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0101.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class Manager {

    public static void displayMenu() {
        System.out.println("------Employees Management-------");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static ArrayList<Employee> foundEmployeeList = new ArrayList<>();

    public static void addEmployees() {
        System.out.println("------Add employees---------");
        int ID;
        //loop to enter valid ID that doesn't exist
        while (true) {
            ID = Input.inputPositiveNumber("Enter employee ID: ", 1);
            if (checkIDExist(ID)) {
                System.err.println("ID already exist!");
            } else {
                break;
            }
        }
        String firstName = Input.inputName("Enter employee first name: ", 1);
        String lastName = Input.inputName("Enter employee last name: ", 1);
        String phone = Input.inputPhone("Enter employee phone: ", 1);
        String email = Input.inputEmail("Enter employee email: ", 1);
        String address = Input.inputString("Enter employee address: ", 1);
        Date dob = Input.inputDate("Enter employee date of birth: ", 1);
        String sex = Input.inputSex("Choose employee sex: ", 1);
        double salary = Input.inputDouble("Enter employee salary: ", 1);
        String agency = Input.inputString("Enter employee agency: ", 1);
        employeeList.add(new Employee(ID, firstName, lastName, phone, email, address, dob, sex, salary, agency));
        System.out.println("=======Add employee successfully=======");
    }

    public static void updateEmployees() {
        //check if employee list is empty
        if (employeeList.isEmpty()) {
            System.err.println("Employee list is empty");
            return;
        }
        System.out.println("------Update employee----------");
        int ID;

        //loop to enter valid existing ID
        while (true) {
            ID = Input.inputPositiveNumber("Enter employee ID to update: ", 1);
            if (!checkIDExist(ID)) {
                System.err.println("ID doesn't exist!");

            } else {
                break;
            }
        }
        Employee employee = findEmployeeByID(ID);
        int newID;

        while (true) {
            newID = Input.inputPositiveNumber("Enter new employee ID: ", 0);
            if (newID != -1 && newID != ID) {
                if (checkIDExist(newID)) {
                    System.err.println("ID already exists! Please enter a different ID.");
                } else {
                    employee.setID(newID);
                    break;
                }
            } else {
                break;
            }
        }
        String newFirstName = Input.inputName("Enter new employee first name: ", 0);
        String newLastName = Input.inputName("Enter new employee last name: ", 0);
        String newPhone = Input.inputPhone("Enter new employee phone: ", 0);
        String newEmail = Input.inputEmail("Enter new employee email: ", 0);
        String newAddress = Input.inputString("Enter new employee address: ", 0);
        Date newDob = Input.inputDate("Enter new employee date of birth: ", 0);
        String newSex = Input.inputSex("Choose new employee sex: ", 0);
        double newSalary = Input.inputDouble("Enter new employee salary: ", 0);
        String newAgency = Input.inputString("Enter new employee agency: ", 0);

        if (!newFirstName.isEmpty()) {
            employee.setFirstName(newFirstName);
        }
        if (!newLastName.isEmpty()) {
            employee.setLastName(newLastName);
        }
        if (!newPhone.isEmpty()) {
            employee.setPhone(newPhone);
        }
        if (!newEmail.isEmpty()) {
            employee.setEmail(newEmail);
        }
        if (!newAddress.isEmpty()) {
            employee.setAddress(newAddress);
        }
        if (newDob != null) {
            employee.setDob(newDob);
        }
        if (newSex != null) {
            employee.setSex(newSex);
        }
        if (newSalary != -1) {
            employee.setSalary(newSalary);
        }
        if (!newAgency.isEmpty()) {
            employee.setAgency(newAgency);
        }
        System.out.println("=======Update successfully=======");
    }

    public static void removeEmployees() {
        //check if employee list is empty
        if (employeeList.isEmpty()) {
            System.err.println("Employee list is empty");
            return;
        }
        System.out.println("------Remove employees--------");
        int ID;
        //loop to enter valid existing ID
        while (true) {
            ID = Input.inputPositiveNumber("Enter employee ID to remove: ", 1);
            if (!checkIDExist(ID)) {
                System.err.println("ID doesn't exist!");
            } else {
                break;
            }
        }
        Employee employee = findEmployeeByID(ID);
        employeeList.remove(employee);
        System.out.println("=======Remove successfully=======");
    }

    public static void searchEmployees() {
        //check if employee list is empty
        if (employeeList.isEmpty()) {
            System.err.println("Employee list is empty");
            return;
        }
        System.out.println("-------Search empployee--------");
        String name;
        //loop to enter valid existing name 
//        while (true) {
            name = Input.inputName("Enter name or part of name to find employee: ", 1);
//            if (!checkNameExist(name)) {
//                System.err.println("Name doesn't exist!");
//            } else {
//                break;
//            }
//        }
        ArrayList<Employee> foundEmployeeList = findEmployeeByName(name);
        System.out.printf("%-5s%-12s%-12s%-15s%-25s%-25s%-15s%-10s%-15s%s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        //traverse through employee found list and print them
        for (int i = 0; i < foundEmployeeList.size(); i++) {
            int ID = foundEmployeeList.get(i).getID();
            String firstName = foundEmployeeList.get(i).getFirstName();
            String lastName = foundEmployeeList.get(i).getLastName();
            String phone = foundEmployeeList.get(i).getPhone();
            String email = foundEmployeeList.get(i).getEmail();
            String address = foundEmployeeList.get(i).getAddress();
            Date dob = foundEmployeeList.get(i).getDob();
            String sex = foundEmployeeList.get(i).getSex();
            double salary = foundEmployeeList.get(i).getSalary();
            String agency = foundEmployeeList.get(i).getAgency();
            System.out.printf("%-5s%-12s%-12s%-15s%-25s%-25s%-15s%-10s%-15s%s\n", ID, firstName, lastName, phone, email, address, dob, sex, salary, agency);
            foundEmployeeList.remove(foundEmployeeList.get(i));
        }
    }

    public static void sortEmployeesBySalary() {
        //check if employee list is empty
        if (employeeList.isEmpty()) {
            System.err.println("Employee list is empty");
            return;
        }
        System.out.println("------Sort employees by salary------");
        Collections.sort(employeeList);
        System.out.printf("%-5s%-12s%-12s%-15s%-25s%-25s%-15s%-10s%-15s%s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        //traverse through sorted employee list and print them
        for (int i = 0; i < employeeList.size(); i++) {
            int ID = employeeList.get(i).getID();
            String firstName = employeeList.get(i).getFirstName();
            String lastName = employeeList.get(i).getLastName();
            String phone = employeeList.get(i).getPhone();
            String email = employeeList.get(i).getEmail();
            String address = employeeList.get(i).getAddress();
            Date dob = employeeList.get(i).getDob();
            String sex = employeeList.get(i).getSex();
            double salary = employeeList.get(i).getSalary();
            String agency = employeeList.get(i).getAgency();
            System.out.printf("%-5s%-12s%-12s%-15s%-25s%-25s%-15s%-10s%-15s%s\n", ID, firstName, lastName, phone, email, address, dob, sex, salary, agency);
        }
    }

    public static boolean checkIDExist(int ID) {
        //traverse through employee list and check if ID already exist
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getID() == ID) {
                return true;
            }
        }
        return false;
    }

    public static Employee findEmployeeByID(int ID) {
        //traverse through employee list and find employee with this ID
        for (int i = 0; i < employeeList.size(); i++) {
            if (ID == employeeList.get(i).getID()) {
                return employeeList.get(i);
            }
        }
        return null;
    }

//    public static boolean checkNameExist(String name) {
//        // Chuyển đổi name và first name, last name thành chữ thường
//        String lowerCaseName = name.toLowerCase();
//
//        // Duyệt qua danh sách nhân viên và kiểm tra xem phần của first name và last name có tồn tại trong danh sách hay không
//        for (Employee employee : employeeList) {
//            String lowerCaseFirstName = employee.getFirstName().toLowerCase();
//            String lowerCaseLastName = employee.getLastName().toLowerCase();
//
//            if (lowerCaseFirstName.contains(lowerCaseName) || lowerCaseLastName.contains(lowerCaseName)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    public static ArrayList<Employee> findEmployeeByName(String name) {
        ArrayList<Employee> foundEmployeeList = new ArrayList<>();
        String searchName = name.replaceAll("\\s+", "").toLowerCase();
        //traverse through employee list and get all employees with this name
        for (Employee employee : employeeList) {
            String fullName = employee.getFirstName() + employee.getLastName();
            if (fullName.toLowerCase().contains(searchName)) {
                foundEmployeeList.add(employee);
            }
        }
        return foundEmployeeList;
    }

}
