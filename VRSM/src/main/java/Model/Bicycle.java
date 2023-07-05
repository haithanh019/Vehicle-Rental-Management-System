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
    private String Type;
    private double CostPerHour;

    public Bicycle() {
    }

    public Bicycle(String Type, double CostPerHour, String ID, String Brand, String LicensePlates, boolean isValid, int total) {
        super(ID, Brand, LicensePlates, isValid, total);
        this.Type = Type;
        this.CostPerHour = CostPerHour;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getCostPerHour() {
        return CostPerHour;
    }

    public void setCostPerHour(double CostPerHour) {
        this.CostPerHour = CostPerHour;
    }
    public void searchByType(){
        
    }
}
