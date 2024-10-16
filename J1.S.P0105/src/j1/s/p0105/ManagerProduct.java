/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0105;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class ManagerProduct {

    InputData input = new InputData();
    Display display = new Display();

    public static void addStore(ArrayList<Storekeeper> ListStorekeeper) {
        //Check the ListStorekeeper to see if it is empty and then print it to ListStorekeeper
        if (!ListStorekeeper.isEmpty()) {
            System.out.println("------------List Storekeeper Created------------");
            System.out.println("ST" + "  " + "Name");
            for (int i = 0; i < ListStorekeeper.size(); i++) {
                System.out.println(i + 1 + "   " + ListStorekeeper.get(i).getStorekeeperName());
            }
        }
        System.out.println("=========Add Storekeeper===========");
        //Re-Enter 
        while (true) {
            String StoreName = InputData.InputString("Enter new storekeeper: ");
            //Check the ListStorekeeper to see if it is empty
            if (!ListStorekeeper.isEmpty()) {
                //Check duplicates name storekeeper
                if (!CheckduplicatesStore(ListStorekeeper, StoreName)) {
                    System.out.println("Store is exist");
                    continue;
                }
            }
            ListStorekeeper.add(new Storekeeper(StoreName));
            System.out.println("Add successfully.");
            //Exits Input StoreName 
            if (!InputData.checkInputYN("Do you want add more?(Y/N):")) {
                break;
            }
        }
    }

    public static boolean CheckduplicatesStore(ArrayList<Storekeeper> storekeeper, String StoreName) {
        //Browse each section of List storekepper
        for (int i = 0; i < storekeeper.size(); i++) {
            //If the Storekeeper Name input matches the Storekeeper in the list, return the value
            if (StoreName.equalsIgnoreCase(storekeeper.get(i).getStorekeeperName())) {
                return false;
            }
        }
        return true;

    }

    public static void addProduct(ArrayList<Product> ListProduct, ArrayList<Storekeeper> storekeeper) {
        // Check to see if there is a Storekepper Name
        if (storekeeper.isEmpty()) {
            System.out.println("The storekeeper list is empty. Need to create storekeeper.");
            return; // exits add products
        }
        // Check empty
        if (!ListProduct.isEmpty()) {
            System.out.println("------------List Product Created------------");
            Display.displayProducstList(ListProduct);
        }
        while (true) {
            int ProductID = InputData.InputInt("Enter product ID: "); // input Product ID
            //Check Products ID exits
            if (!checkIdExist(ListProduct, ProductID)) {
                System.out.println("Id exist");
                continue;
            }

            String ProductName = InputData.InputString("Enter product name : "); // input product name
            String Location = InputData.InputString("Enter location of products: "); // input Location
            double price = InputData.checkInputDouble("Enter price:"); // input Price
            Date DateOfManufacture;
            while (true) {
                DateOfManufacture = InputData.InputDate("Date of manufacture: "); // input Date Of Manufacture
                Date now = new Date();
                if (DateOfManufacture.after(now)) {
                    System.out.println("Date of manufacture must be in the past.");
                    continue;
                }
                break;
            }
            Date ExpiryDate;
            //Re- Enter 
            while (true) {
                ExpiryDate = InputData.InputDate("Expiry Date:"); // input Expiry Date
                // Compare DateOfManufacture and ExpiryDate
                if (DateOfManufacture.after(ExpiryDate)) {
                    System.out.println("Expiry date must be after date of manufacture");
                    continue;
                }
                break; //exits loop
            }
            String Category = InputData.InputString("Enter category: "); // Input category
            System.out.println("ST" + "  " + "Name");
            for (int i = 0; i < storekeeper.size(); i++) {
                System.out.println(i + 1 + "   " + storekeeper.get(i).getStorekeeperName());
            }
            String StoreName;
            //Re- Enter 
            while (true) {
                StoreName = InputData.InputString("Enter storekepper in list :"); // Input Storekepper Name
                // Check the Storekepper Name input is equal to the storekepper name in the Storekepper List 
                if (CheckduplicatesStore(storekeeper, StoreName) == true) {
                    System.out.println("StoreKepper not in list.");
                    continue;
                }
                break;
            }
            Storekeeper store = new Storekeeper(StoreName);
            Date receiptDate;
            //Re- Enter 
            while (true) {
                receiptDate = InputData.InputDate("Enter receipt date: "); // input receipt date
                // Check if receiptDate matches DateOfManufacture and ExpiryDate
                Date now = new Date();
                // If 'receiptDate' is after the current time (now), it is considered invalid.
                if (receiptDate.after(now)) {
                    System.out.println("Receipt date must be in the past.");
                    continue;
                }
                //If 'DateOfManufacture' is equal to or after 'receiptDate', it is also considered invalid.
                if (DateOfManufacture.after(receiptDate) || DateOfManufacture.equals(receiptDate)) {
                    System.out.println("Receipt date must be greater than Date Of Manufacture");
                    continue;
                }

                break;
            }
            System.out.println("Add successfully.");

            ListProduct.add(new Product(ProductID, ProductName, Location, price, ExpiryDate, DateOfManufacture, Category, store, receiptDate));
            //Exits add 
            if (!InputData.checkInputYN("Do you want add more?(Y/N):")) {
                break;
            }
        }

    }

    public static boolean checkIdExist(ArrayList<Product> product, int id) {
        for (int i = 0; i < product.size(); i++) {
            //Check duplicate IDs
            if (id == product.get(i).getId()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDuplicateUpdate(ArrayList<Product> product, int id, int idsearch) {
        int count = 0;
        int count1 = 0;
        //Check the new update id is not in the product list
        for (int i = 0; i < product.size(); i++) {
            //Check id 
            if (id == product.get(i).getId()) {
                count++;
            }
        }
        //Return value
        if (count == 0) {
            return true;
        }
        // Check the new update id is in the product list and must be equal to Id Search
        for (int i = 0; i < product.size(); i++) {
            if (id == product.get(i).getId() && idsearch == id) {
                count1++;
            }
        }
        //Return value
        if (count1 == 1) {
            return true;
        }
        return false;
    }

    public static void UpdateProduct(ArrayList<Product> ListProduct, ArrayList<Storekeeper> ListStorekeeper) {
        System.out.println("=========Update Product===========");
        // Check List product empty
        if (ListProduct.isEmpty()) {
            System.out.println("List of products is empty, please Add Products");
            return;
        }
        while (true) {
            int ProductIDSearch;
            int pos;
            while (true) {
                ProductIDSearch = InputData.InputInt("Enter product ID for update: "); // Input product idsearch
                pos = posProductByID(ListProduct, ProductIDSearch); //Get pos of ID
                // ID not in List Product
                if (pos == -1) {
                    System.out.println("Id not in List Product");
                    continue;
                }
                break;
            }
            int ProductID;
            while (true) {
                ProductID = InputData.InputInt("Enter product ID: ");// input product id
                if (!checkDuplicateUpdate(ListProduct, ProductID, ProductIDSearch)) {
                    System.out.println("New id not in the list product.");
                    continue;
                }
                break;
            }
            String ProductName = InputData.InputString("Enter product name : "); // input product name
            String Location = InputData.InputString("Enter location of products: "); // input Location
            double price = InputData.checkInputDouble("Enter price:"); // input Price
            Date DateOfManufacture;
            while (true) {
                DateOfManufacture = InputData.InputDate("Date of manufacture: "); // input Date Of Manufacture
                Date now = new Date();
                // If 'DateOfManufacture' is after the current time (now), it is considered invalid.
                if (DateOfManufacture.after(now)) {
                    System.out.println("Date of manufacture must be in the past.");
                    continue;
                }
                break;
            }
            Date ExpiryDate;
            //Re- Enter 
            while (true) {
                ExpiryDate = InputData.InputDate("Expiry Date:"); // input Expiry Date
                // Compare DateOfManufacture and ExpiryDate
                if (DateOfManufacture.after(ExpiryDate)) {
                    System.out.println("Expiry date must be after date of manufacture");
                    continue;
                }
                break; //exits loop
            }
            String Category = InputData.InputString("Enter category: "); // Input category
            System.out.println("ST" + "  " + "Name");
            for (int i = 0; i < ListStorekeeper.size(); i++) {
                System.out.println(i + 1 + "   " + ListStorekeeper.get(i).getStorekeeperName());
            }
            String StoreName;
            //Re- Enter 
            while (true) {
                StoreName = InputData.InputString("Enter storekepper in list :"); // Input Storekepper Name
                // Check the Storekepper Name input is equal to the storekepper name in the Storekepper List 
                if (CheckduplicatesStore(ListStorekeeper, StoreName) == true) {
                    System.out.println("StoreKepper not in list.");
                    continue;
                }
                break;
            }
            Storekeeper store = new Storekeeper(StoreName);
            Date receiptDate;
            //Re- Enter 
            while (true) {
                receiptDate = InputData.InputDate("Enter receipt date: "); // input receipt date
                Date now = new Date();
                // If 'receiptDate' is after the current time (now), it is considered invalid.
                if (receiptDate.after(now)) {
                    System.out.println("Receipt date must be in the past.");
                    continue;
                }
                // Check if receiptDate matches DateOfManufacture 
                if (DateOfManufacture.after(receiptDate) || DateOfManufacture.equals(receiptDate)) {
                    System.out.println("Receipt date must be greater than Date Of Manufacture");
                    continue;
                }
                break;
            }
//            int Index = ListProduct.indexOf(ProductIDSearch);
            Product updatedProduct = new Product(ProductID, ProductName, Location, price, ExpiryDate, DateOfManufacture, Category, store, receiptDate);
            ListProduct.set(pos, updatedProduct); // Update info product
            System.out.println("Update successfully.");
            // Exits update products
            if (!InputData.checkInputYN("Do you want update more?(Y/N):")) {
                break;
            }
        }
    }

    public static int posProductByID(ArrayList<Product> productsList, int id) {
        int position = -1;
        //Check list is empty or not
        if (productsList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            //Loop use to access each element of arraylist from begining to the end
            for (Product product : productsList) {
                //Compare id input and each id of product has in list
                if (id == product.getId()) {
                    position = productsList.indexOf(product);
                    break;
                }
            }
        }
        return position;
    }

    public static void search(ArrayList<Product> productList) {
        while (true) {
            //Step 1 :Display Menu Search
            Display.displayMenuSearch();
            //Step 2: User choice option
            int choice = InputData.InputIntLimit(1, 5);
            //Step 3 : Run choice
            switch (choice) {
                // Option 1 : searchByName
                case 1:
                    searchByName(productList);
                    break;
                // Option 2 : searchByCategory 
                case 2:
                    searchByCategory(productList);
                    break;
                // Option 3 : searchByStorekeeper
                case 3:
                    searchByStorekeeper(productList);
                    break;
                // Option 4 : searchByReceiptdate
                case 4:
                    searchByReceiptdate(productList);
                    break;
                // Option 5 : exits
                case 5:
                    return;
            }
        }
    }

    public static void searchByName(ArrayList<Product> ListProduct) {
        //Re-Enter
        while (true) {
            ArrayList<Product> List = new ArrayList<>();
            System.out.println("==========Search By Name============");
            //Check empty
            if (ListProduct.isEmpty()) {
                System.out.println("List is empty!");
                return;
            }
            String SearchName = InputData.InputString("Enter name for searching: "); // input search name
            //Browse each element in the products list
            for (int i = 0; i < ListProduct.size(); i++) {
                //Checks for equality with search name input 
                if (ListProduct.get(i).getName().equalsIgnoreCase(SearchName)) {
                    List.add(ListProduct.get(i)); // Add list
                }
            }
            //Check empty 
            if (List.isEmpty()) {
                System.out.println("Product is not found!");
            } else {
                Display.displayProducstList(List); // Print Producst List for search name
            }
            //Exits
            if (!InputData.checkInputYN("Do you want search name more?(Y/N):")) {
                break;
            }
        }
    }

    public static void searchByCategory(ArrayList<Product> product) {
        while (true) {
            ArrayList<Product> List = new ArrayList<>();
            System.out.println("==========Search By Category============");
            //Check empty
            if (product.isEmpty()) {
                System.out.println("List is empty!");
                return;
            }
            String SearchCategory = InputData.InputString("Enter category for searching: "); // input search category
            //Browse each element in the products list
            for (int i = 0; i < product.size(); i++) {
                //Checks for equality with search name input 
                if (product.get(i).getCategory().equalsIgnoreCase(SearchCategory)) {
                    List.add(product.get(i)); // Add list
                }
            }
            //Check empty 
            if (List.isEmpty()) {
                System.out.println("Product is not found!");
            } else {
                Display.displayProducstList(List); // Print Producst List for category 
            }
            //Exits
            if (!InputData.checkInputYN("Do you want search category more?(Y/N):")) {
                break;
            }
        }
    }

    public static void searchByStorekeeper(ArrayList<Product> product) {
        while (true) {
            ArrayList<Product> List = new ArrayList<>();
            System.out.println("==========Search By Storekeeper============");
            //Check empty
            if (product.isEmpty()) {
                System.out.println("List is empty!");
                return;
            }
            String SearchStorekeeper = InputData.InputString("Enter storekeeper for searching: "); // input search Storekeeper name
            //Browse each element in the products list
            for (int i = 0; i < product.size(); i++) {
                //Checks for equality with search name input 
                if (product.get(i).getStorekeeper().toString().equalsIgnoreCase(SearchStorekeeper)) {
                    List.add(product.get(i));// Add list
                }
            }
            //Check empty 
            if (List.isEmpty()) {
                System.out.println("List product is empty");
            } else {
                Display.displayProducstList(List); // Print Producst List for Storekeeper name 
            }
            //Exits
            if (!InputData.checkInputYN("Do you want search storekeeper more?(Y/N):")) {
                break;
            }
        }
    }

    public static void searchByReceiptdate(ArrayList<Product> product) {
        while (true) {
            System.out.println("==========Search By Receipt Date============");
            ArrayList<Product> List = new ArrayList<>();
            //Check empty
            if (product.isEmpty()) {
                System.out.println("List is empty!");
            } else {
                Date receiptdate = InputData.InputDate("Enter receipt date for search: "); // input search receiptdate 
                //Browse each element in the products list
                for (int i = 0; i < product.size(); i++) {
                    //Checks for equality with search name input 
                    if (product.get(i).getReceiptDate().equals(receiptdate)) {
                        List.add(product.get(i)); // Add list
                    }
                }
                //Check empty 
                if (List.isEmpty()) {
                    System.out.println("Product is not found!");
                } else {
                    Display.displayProducstList(List); // Print Producst List for receipt date 
                }
            }
            //Exits
            if (!InputData.checkInputYN("Do you want search receipt date more?(Y/N):")) {
                break;
            }
        }
    }

    public static void sort(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        while (true) {
            //Step 1 : Display menu
            Display.displayMenuSort();
            // Step 2 : Get choice
            int choice = InputData.InputIntLimit(1, 3);
            // Step 3: Run choice 
            switch (choice) {
                // Option 1: sort By Expiry Date
                case 1:
                    sortByExpiryDate(productList);
                    break;
                // Option 2: sort By Date Of Manufacture

                //Option 3 : Exits
                case 2:
                    return;
            }
        }
    }

    public static void sortByExpiryDate(ArrayList<Product> productList) {
        /*Loop 1: Loop use to access from the first to last element of list, 
            after each loop, one element is sorted*/
        for (int i = 0; i < productList.size(); i++) {
            /*Loop 2: Loop use to access from the first unsorted element to the 
                element stand before the last unsorted element*/
            // The inner loop compares adjacent products' expiry dates unsorted
            for (int j = 0; j < (productList.size() - i - 1); j++) {
                //If the expiry date of the current product is after the expiry date of the next product
                if (productList.get(j).getExpirydate().equals(productList.get(j + 1).getExpirydate())) {
                    if (productList.get(j).getDateOfManufacture().after(productList.get(j + 1).getDateOfManufacture())) {
                        //Swap
                        Product temp = productList.get(j);
                        productList.set(j, productList.get(j + 1));
                        productList.set(j + 1, temp);
                    }

                    if (productList.get(j).getExpirydate().after(productList.get(j + 1).getExpirydate())) {
                        //Swap
                        Product temp = productList.get(j);
                        productList.set(j, productList.get(j + 1));
                        productList.set(j + 1, temp);

                    }
                }
            }
        }

        Display.displayProducstList(productList); // Display the sorted productList by Expiry Date
    }
}
//    public static void sortByDateOfManufacture(ArrayList<Product> productList) {
//        /*Loop 1: Loop use to access from the first to last element of list, 
//            after each loop, one element is sorted*/
//        for (int i = 0; i < productList.size(); i++) {
//            /*Loop 2: Loop use to access from the first unsorted element to the 
//                element stand before the last unsorted element*/
//            // The inner loop compares adjacent products' expiry dates unsorted
//            for (int j = 0; j < (productList.size() - i - 1); j++) {
//                //If the expiry date of the current product is after the expiry date of the next product
//                if (productList.get(j).getDateOfManufacture().after(productList.get(j + 1).getDateOfManufacture())) {
//                    //Swap
//                    Product temp = productList.get(j);
//                    productList.set(j, productList.get(j + 1));
//                    productList.set(j + 1, temp);
//                }
//            }
//        }
//        Display.displayProducstList(productList); // Display the sorted productList by Date Of Manufacture
//    }
//}
