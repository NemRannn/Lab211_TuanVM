/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0105;

import java.util.ArrayList;

/**
 *
 * @author tuana
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Storekeeper> storeList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
       //Re-enter
       while(true){
            //Step 1 :Display menu
            Display.displayMenu();
            // Step 2 :Get option 
            int choice = InputData.GetOption();
            switch(choice){
                //Option 1 .Add Storekeeper
                case 1:
                    ManagerProduct.addStore(storeList);
                    break;
                //Option 2. Add product
                case 2:
                    ManagerProduct.addProduct(productList, storeList);
                    break;
                //Option 3. Update product
                case 3:
                    ManagerProduct.UpdateProduct(productList, storeList);
                    break;
                //Option 4. Search product by Name, Category, Storekeeper, ReceiptDate
                case 4:
                    ManagerProduct.search(productList);
                    break;
                //Option 5. Sort product by Expiry date, Date of manufacture
                case 5:
                    ManagerProduct.sort(productList);
                    break;
                //Option 6. Exit
                case 6:
                   return;
            }
    
       }
    }
}
