/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0070.bank;

import static j1.s.p0070.bank.EBank.loginWithEnglish;
import static j1.s.p0070.bank.EBank.loginWithVietNamese;
import static j1.s.p0070.bank.GetInput.displayExit;

/**
 *
 * @author tuana
 */
public class Main {
        public static void main(String[] args) {
        OUTER:
        while (true) {
            int choose = Menu.mainMenu();
            //Perform opinition base use on the choice
            switch (choose) {
                case 1:
                    //Step 2: : Switch the interface language to Vietnamese and perform “check login” function.
                    loginWithVietNamese();
                    break;
                case 2:
                    //Step 3: Keep the English interface and perform “check login” function.
                    loginWithEnglish();
                    break;
                default:
                    //Step 4: Exit program
                    displayExit();
                    break OUTER;
            }
        }

    }
}
