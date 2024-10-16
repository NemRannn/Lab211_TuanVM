/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0105;

/**
 *
 * @author tuana
 */
public class Storekeeper {
    String StorekeeperName;

    public Storekeeper(String StorekeeperName) {
        this.StorekeeperName = StorekeeperName;
    }

    public String getStorekeeperName() {
        return StorekeeperName;
    }

    public void setStorekeeperName(String StorekeeperName) {
        this.StorekeeperName = StorekeeperName;
    }

    @Override
    public String toString() {
        return  StorekeeperName;
    }  
}

