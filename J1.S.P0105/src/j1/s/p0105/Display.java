/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0105;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author tuana
 */
public class Display {

    public static void displayMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1. Add Storekeeper");
        System.out.println("\t2. Add product");
        System.out.println("\t3. Update product");
        System.out.println("\t4. Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("\t5. Sort product by Expiry date, Date of manufacture");
        System.out.println("\t6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void displayProducstList(ArrayList<Product> product) {
        String headerFormat = "%-5s%-13s%-10s%-15s%-20s%-15s%-15s%-16s%-15s\n";
        String dataformat = "%-5d%-15s%-10s%-15.2f%-20s%-15s%-15s%-16s%-15s\n";
        System.out.printf(headerFormat, "Id", "Name", "Location", "Price", "Manufacture date", "Expiry date", "Category", "Storekeeper", "Receipt date");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < product.size(); i++) {
            String DateOfManufacture = dateFormat.format(product.get(i).getDateOfManufacture());
            String Expirydate = dateFormat.format(product.get(i).getExpirydate());
            String ReceiptDate = dateFormat.format(product.get(i).getReceiptDate());
            System.out.printf(dataformat, product.get(i).getId(),
                    product.get(i).getName(),
                    product.get(i).getLocation(),
                    product.get(i).getPrice(),
                    DateOfManufacture,
                    Expirydate,
                    product.get(i).getCategory(),
                    product.get(i).getStorekeeper().toString(),
                    ReceiptDate);
        }
    }

    public static void displayMenuSearch() {
        System.out.println("Search menu:");
        System.out.println("\t1. Search By Name");
        System.out.println("\t2. Search By Category");
        System.out.println("\t3. Search By Storekeeper");
        System.out.println("\t4. Search By Receipt Date");
        System.out.println("\t5. Exit search");
        System.out.print("Enter your choice: ");
    }

    public static void displayMenuSort() {
        System.out.println("Sort menu:");
        System.out.println("\t1.Sort By Expiry Date:");
//        System.out.println("\t2.Sort By Date Of Manufacture");
        System.out.println("\t2.Exit sort");
        System.out.print("Enter your choice: ");
    }

}