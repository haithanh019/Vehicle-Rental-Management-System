/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author haith
 */
public class Motorcycle extends Vehicle{
    private String type;
    private double costPerHour;

    public Motorcycle() {
    }

    public Motorcycle(String type, double costPerHour, String id, String brand, String licensePlates, boolean isValid, int total) {
        super(id, brand, licensePlates, isValid, total);
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
