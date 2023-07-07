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
    private String id;
    private String brand;
    private String licensePlates;
    private boolean isValid;
    private int total;

    public Vehicle() {
    }

    public Vehicle(String id, String brand, String licensePlates, boolean isValid, int total) {
        this.id = id;
        this.brand = brand;
        this.licensePlates = licensePlates;
        this.isValid = isValid;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
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
    
