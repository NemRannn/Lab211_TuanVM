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
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<EastAsiaCountries> countries = new ArrayList<>();
        while (true) {
            //Step 1: Display menu
            ManageEastAsiaCountries.displayMenu();
            //Step 2: input option 1-5
            int choice = InputData.getInputOption(1, 5);
            switch (choice) {
                //Option 1: Add information for a country
                case 1:
                    ManageEastAsiaCountries.addCountryInformation(countries);
                    break;
                //Option 2: Display information of countries just input
                case 2:
                    ManageEastAsiaCountries.displayInformationJustInput(countries);
                    break;
                //Option 3: Search information of countries by user-entered name
                case 3:
                    ManageEastAsiaCountries.searchInformationByName(countries);
                    break;
                //Option 4: Displays the names of countries by name ascending
                case 4:
                    ManageEastAsiaCountries.displayInfomationSortedAscendingByName(countries);
                    break;
                //Option 5: Exit
                case 5:
                    System.exit(0);
            }
        }
    }
}
