/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0052;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ManageEastAsiaCountries {
    
    public static void displayMenu() {
        System.out.println("                      MENU                               ");
        System.out.println("==================================================================");
        System.out.println("1. Enter the information for 11 countries in Southeast Asia.");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit.");
        System.out.println("==================================================================");

    }

    public static void addCountryInformation(ArrayList<EastAsiaCountries> country) {

        //Check if the country number is greater than 11
        if (country.size() > 10) {
            System.err.println("Only enter the information of 11 countries in East Asia");
            return;
        }

        System.out.println("Enter code of country:");
        String inputCode = InputData.getInputString().toUpperCase();

        //Check if enter country code already exists
        if (!InputData.checkCountryExist(country, inputCode)) {
            System.err.println("The country already exists");
            return;
        }

        System.out.println("Enter name of country:");
        String inputName = InputData.getInputString();
        System.out.println("Enter total Area:");
        float inputTotalArea = InputData.getInputTotalArea();
        System.out.println("Enter terrain of country:");
        String inputTerrain = InputData.getInputString();

        country.add(new EastAsiaCountries(inputCode, inputName, inputTotalArea, inputTerrain));

    }

    public static void displayInformationJustInput(ArrayList<EastAsiaCountries> country) throws Exception {

        //checks if ArrayList is empty
        if (country.isEmpty()) {
            System.err.println("No country information entered yet.");
        } else {
            System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
            //Get the last element in the ArrayList
            country.get(country.size() - 1).display();
        }

    }

    public static void searchInformationByName(ArrayList<EastAsiaCountries> country) {

        System.out.println("Enter the name you want to search for:");
        String name = InputData.getInputSearchByName();

        //Initializes a boolean variable 'found' to 'false'
        boolean found = false;

        //Use loop for-each to iterate through each country in the Arraylist
        for (EastAsiaCountries c : country) {
            /*checks if the name entered by the user (name) matches the name of the country already in the ArrayList
              with case-insensitive*/
            if (c.getCountryName().equalsIgnoreCase(name)) {
                System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
                c.display();
                //Sets the 'found' variable to 'true' to indicate that a match has been found.
                found = true;
            }
        }

        //If variable 'found' is still 'false'
        if (!found) {
            System.err.println("There is no information about the country you are looking for!!! ");
            System.err.println("Please check again your input(Search by Name)!!!");
        }

    }

    public static void displayInfomationSortedAscendingByName(ArrayList<EastAsiaCountries> country) throws Exception {
        //checks if ArrayList is empty
        if (country.isEmpty()) {
            System.err.println("No country information entered yet.");
            return;
        }
        //Use bubble sort algorithm to sort the ArrayList
        //Use loop to accessed from the first to last element of ArrayList
        for (int i = 0; i < country.size(); i++) {
            /*Use loop to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < country.size() - i - 1; j++) {
                /*Compares the country names of each pair of adjacent elements in the Arraylist with case-insensitive  
                If the result of this comparison is greater than 0, it means that the current element's name is 
                lexicographically greater than the next element's name
                 */
                if (country.get(j).getCountryName().compareToIgnoreCase(country.get(j + 1).getCountryName()) > 0) {
                    // Swap elements if they are out of order
                    EastAsiaCountries temp = country.get(j);
                    country.set(j, country.get(j + 1));
                    country.set(j + 1, temp);
                }
            }
        }
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        //Use loop for-each to iterate through each country in the Arraylist
        for (EastAsiaCountries c : country) {
            c.display();
        }
    }

}
