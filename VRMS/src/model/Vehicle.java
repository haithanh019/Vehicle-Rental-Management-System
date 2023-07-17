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

    protected String type;
    protected String id;
    protected String brand;
    protected String licensePlates;
    protected Double costPerHour;
    protected boolean isAvailable;

    public Vehicle() {
    }

    public Vehicle(String type, String id, String brand, String licensePlates, Double costPerHour) {
        this.type = type;
        this.id = id;
        this.brand = brand;
        this.licensePlates = licensePlates;
        this.costPerHour = costPerHour;
        this.isAvailable = true;
    }
    
    public Vehicle(String type, String id, String brand, String licensePlates, Double costPerHour, Boolean isAvailable) {
        this.type = type;
        this.id = id;
        this.brand = brand;
        this.licensePlates = licensePlates;
        this.costPerHour = costPerHour;
        this.isAvailable = isAvailable;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public abstract void show();
}
