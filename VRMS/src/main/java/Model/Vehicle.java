/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author haith
 */
public class Vehicle {
    private String ID;
    private String Brand;
    private String LicensePlates;
    private boolean isValid;
    private int total;

    public Vehicle() {
    }

    public Vehicle(String ID, String Brand, String LicensePlates, boolean isValid, int total) {
        this.ID = ID;
        this.Brand = Brand;
        this.LicensePlates = LicensePlates;
        this.isValid = isValid;
        this.total = total;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getLicensePlates() {
        return LicensePlates;
    }

    public void setLicensePlates(String LicensePlates) {
        this.LicensePlates = LicensePlates;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public void show(){

    }
    public void sortByCost(){
        
    }
    public void addNewVehicle(){
        
    }
    public void searchByBrand(){
        
    }
    public void searchByValid(){
        
    }
    public void delete(){
        
    }
}
    
