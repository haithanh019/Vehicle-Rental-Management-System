/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author haith
 */
public class Bill {
    private String id;
    private Vehicle vehicle;
    private Customer customer;
    private Date dateOfRent;
    private Date dateOfPay;
    private double hours;
    private double cost;

    public Bill() {
    }

    public Bill(String id, Vehicle vehicle, Customer customer, double hours) {
        this.id = id;
        this.vehicle = vehicle;
        this.customer = customer;
        this.hours = hours;
        this.dateOfRent = initializeDateOfRent();
        this.dateOfPay = calculateDateOfPay(dateOfRent, hours);
        this.cost = calculate();
    }

    private Date initializeDateOfRent() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Lấy thời gian hiện tại

        // Đặt giá trị cho các trường giờ, phút và giây
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

        return calendar.getTime();
    }

    private Date calculateDateOfPay(Date dateOfRent, double hours) {
        long rentTimeInMillis = dateOfRent.getTime();
        long hoursInMillis = (long) (hours * 60 * 60 * 1000);
        long dateOfPayInMillis = rentTimeInMillis + hoursInMillis;

        return new Date(dateOfPayInMillis);
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
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

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(Date dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public Date getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(Date dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public double calculate(){
        return vehicle.getCostPerHour()* hours;
    }
     
    public String getDateOfRentFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(dateOfRent);
    }

    public String getDateOfPayFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(dateOfPay);
    }
    public void genarateBill(){
        System.out.println("======== VEHICLE RENTAL BILL ========");
        System.out.println("ID: " + id);
        System.out.println("Date: " + getDateOfRentFormatted());
        System.out.println("Lend date: " + getDateOfPayFormatted());
        System.out.println("-------------------------------------");
        System.out.println("Customer's name: " + customer.getName());
        System.out.println("Customer's phone: " + customer.getPhoneNumber());
        System.out.println("Customer's address: " + customer.getAddress());
        System.out.println("-------------------------------------");
        System.out.println("Vehicle's id: " + vehicle.getId());
        System.out.println("Vehicle's license plates: " + vehicle.getLicensePlates());
        System.out.println("Vehicle's brand: " + vehicle.getBrand());
        System.out.println("Vehicle's type: " + vehicle.getType());
        System.out.println("-------------------------------------");
        System.out.println("TOTAL: " + getCost());
    }
}
