/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0105;

import java.util.Date;

/**
 *
 * @author tuana
 */
public class Product {
    int Id;
    String Name;
    String Location;
    Double Price ;
    Date Expirydate;
    Date DateOfManufacture;
    String Category;
    Storekeeper storekeeper;
    Date ReceiptDate;

    public Product(int Id, String Name, String Location, Double Price, Date Expirydate, Date DateOfManufacture, String Category, Storekeeper storekeeper, Date ReceiptDate) {
        this.Id = Id;
        this.Name = Name;
        this.Location = Location;
        this.Price = Price;
        this.Expirydate = Expirydate;
        this.DateOfManufacture = DateOfManufacture;
        this.Category = Category;
        this.storekeeper = storekeeper;
        this.ReceiptDate = ReceiptDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public Date getExpirydate() {
        return Expirydate;
    }

    public void setExpirydate(Date Expirydate) {
        this.Expirydate = Expirydate;
    }

    public Date getDateOfManufacture() {
        return DateOfManufacture;
    }

    public void setDateOfManufacture(Date DateOfManufacture) {
        this.DateOfManufacture = DateOfManufacture;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(Date ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    } 
}
