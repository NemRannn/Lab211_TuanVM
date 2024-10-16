/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0070.bank;

/**
 *
 * @author tuana
 */
public class Menu {
    public static int mainMenu(){
        int choice;
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        choice = GetInput.checkLimit("Please choice one option: ", 1, 3);
        return choice;
    }
}
