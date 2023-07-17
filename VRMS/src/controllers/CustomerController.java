/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import model.Customer;
import utils.DataValidator;
import utils.Input;

/**
 *
 * @author HP
 */
public class CustomerController {

    public ArrayList<Customer> customerList = new ArrayList<>();
    private static final String PATH_CUSTOMER = "src/resources/Customer.txt";

    public CustomerController() {
        readDataFromFile(PATH_CUSTOMER);
    }

    //add customer
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        System.out.println("Added successfully!");
    }

    //display all customer
    public void displayCustomer() {
        customerList.forEach(c -> System.out.println(c));
    }

    //total customer
    public int totalCustomer() {
        return customerList.size();
    }

    //search customer
    public ArrayList<Customer> searchCustomer(Predicate<Customer> p) {
        ArrayList<Customer> searchResult = new ArrayList<>();
        for (Customer customer : customerList) {
            if (p.test(customer)) {
                searchResult.add(customer);
            }
        }
        return searchResult;
    }

    public Customer findCustomerByCCCD(String cccd) {
        for (Customer customer : customerList) {
            if (customer.getCccd().equalsIgnoreCase(cccd)) {
                return customer;
            }
        }
        return null;
    }

    public void updateCustomerCCCD(Customer c, String newCccd) {
        c.setCccd(newCccd);
    }

    public void updateCustomerName(Customer c, String name) {
        c.setName(name);
    }

    public void updateCustomerDateOfBirth(Customer c, Date dateOfBirth) {
        c.setDateOfBirth(dateOfBirth);
    }

    public void updateCustomerAddress(Customer c, String address) {
        c.setAddress(address);
    }

    public void updateCustomerPhoneNumber(Customer c, String phoneNumber) {
        c.setPhoneNumber(phoneNumber);
    }

    public void readDataFromFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(",");
                if (arr.length == 5) {
                    if (Input.convertStringToDate(arr[3], DataValidator.date_format) != null) {
                        boolean isValidCCCD = DataValidator.checkRegex(arr[0], DataValidator.CCCD_regex);
                        boolean isValidName = DataValidator.checkRegex(arr[1], DataValidator.name_regex);
                        boolean isValidPhone = DataValidator.checkRegex(arr[4], DataValidator.phone_regex);
                        boolean isValidDob = DataValidator.checkRegex(arr[3], DataValidator.date_regex);

                        if (isValidCCCD && isValidName && isValidPhone && isValidDob) {
                            Customer customer = new Customer(arr[0], arr[1], Input.convertStringToDate(arr[3], DataValidator.date_format), arr[2], arr[4]);
                            customerList.add(customer);
                        }
                    }
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean writeDataToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(PATH_CUSTOMER);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Customer customer : customerList) {
                String line = customer.getCccd() + "," + customer.getName() + "," + customer.getAddress() + "," + customer.getFormattedDOB() + "," + customer.getPhoneNumber();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
