/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author haith
 */
public abstract class Vehicle {

    protected String id;
    protected String brand;
    protected String licensePlates;
    protected double costPerHour;

    public Vehicle() {
    }

    public Vehicle(String id, String brand, String licensePlates, double costPerHour) {
        this.id = id;
        this.brand = brand;
        this.licensePlates = licensePlates;
        this.costPerHour = costPerHour;
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

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public abstract void show();
}
