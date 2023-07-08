/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author haith
 */
public class Bicycle extends Vehicle {
    private String type;

    public Bicycle() {
    }

    public Bicycle(String id, String brand, String licensePlates, int total,double costPerHour, String type) {
        super(id, brand, licensePlates, total, costPerHour);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void show() {
        System.out.printf("|BICYCLE|%7s|%5s|%8s|%8s|%5s|%2s|", type, id, brand, licensePlates, costPerHour, total);
    }

}
