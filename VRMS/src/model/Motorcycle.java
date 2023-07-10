/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author haith
 */
public class Motorcycle extends Vehicle{
    public Motorcycle() {
    }

    public Motorcycle(String type, String id, String brand, String licensePlates, Double costPerHour) {
        super(type, id, brand, licensePlates, costPerHour);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void show() {
        System.out.printf("\n|MOTORCYCLE|%-10s|%4s|%-10s|%8s|%7s|", type, id, brand, licensePlates, costPerHour);
    }
}
