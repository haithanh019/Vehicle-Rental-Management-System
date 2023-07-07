/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author haith
 */
public class Bicycle extends Vehicle {
    private String type;
    private double costPerHour;

    public Bicycle() {
    }

    public Bicycle(String type, double costPerHour, String ID, String Brand, String LicensePlates, boolean isValid, int total) {
        super(ID, Brand, LicensePlates, isValid, total);
        this.type = type;
        this.costPerHour = costPerHour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    
   
}
