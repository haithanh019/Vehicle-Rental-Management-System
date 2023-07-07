/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author haith
 */
public class Bill {
    private String id;
    private Vehicle vehicle;
    private Customer customer;
    private String dateOfRent;
    private String dateOfPay;
    private double cost;

    public Bill() {
    }

    public Bill(String ID, Vehicle vehicle, Customer customer, String dateOfRent, String dateOfPay, double cost) {
        this.id = id;
        this.vehicle = vehicle;
        this.customer = customer;
        this.dateOfRent = dateOfRent;
        this.dateOfPay = dateOfPay;
        this.cost = cost;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(String dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public String getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(String dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public double caculate(){
        return 0;
    }
    public void genarateBill(){
        
    }
}
