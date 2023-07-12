/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Customer;

/**
 *
 * @author HP
 */
public class CustomerController {

    public ArrayList<Customer> customerList = new ArrayList<>();

    //add customer
    public void addCustomer(Customer customer) {
        customerList.add(customer);
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

//    //update customer
//    public void updateCustomer(String cccd, String name, String dateOfBirth, String address, String phoneNumber){
//        for(Customer customer : customerList){
//            if(customer.getCccd().equalsIgnoreCase(cccd)){
//                customer.setCccd(cccd);
//                customer.setName(name);
//                customer.setDateOfBirth(dateOfBirth);
//                customer.setAddress(address);
//                customer.setPhoneNumber(phoneNumber);
//                System.out.println("Update successfully!");
//                return;
//           }
//        }
//        System.out.println("Customer not found with CCCD: " + cccd);
//    }
    public void updateCustomer(String cccd, String name, String dateOfBirth, String address, String phoneNumber) {
        Customer customer = findCustomerByCCCD(cccd);
        if (customer != null) {
            updateCustomerName(customer, name);
            updateCustomerDateOfBirth(customer, dateOfBirth);
            updateCustomerAddress(customer, address);
            updateCustomerPhoneNumber(customer, phoneNumber);
            System.out.println("Update successfully!");
        } else {
            System.out.println("Customer not found with CCCD: " + cccd);
        }
    }

    public Customer findCustomerByCCCD(String cccd) {
        for (Customer customer : customerList) {
            if (customer.getCccd().equalsIgnoreCase(cccd)) {
                return customer;
            }
        }
        return null;
    }
    
        public void updateCustomerCCCD(Customer customer, String cccd) {
        customer.setCccd(cccd);
    }
    public void updateCustomerName(Customer customer, String name) {
        customer.setName(name);
    }

    public void updateCustomerDateOfBirth(Customer customer, String dateOfBirth) {
        customer.setDateOfBirth(dateOfBirth);
    }

    public void updateCustomerAddress(Customer customer, String address) {
        customer.setAddress(address);
    }

    public void updateCustomerPhoneNumber(Customer customer, String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
    }

    //ham doc du lieu
    public <T extends Customer> void readDataFromFile(String path, Class<T> clazz) {
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(",");
                if (arr.length == 5) {
                    T v = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class, Double.class)
                            .newInstance(arr[0], arr[1], arr[2], arr[3], Double.parseDouble(arr[4]));
                    customerList.add(v);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T extends Customer> void writeDataToFile(String path, Class<T> clazz) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            for (Customer customer : customerList) {
                if (clazz.isInstance(customer)) {
                    T castCustomer = clazz.cast(customer);
                    String line = castCustomer.getCccd() + ","
                            + castCustomer.getName() + ","
                            + castCustomer.getDateOfBirth() + ","
                            + castCustomer.getAddress() + ","
                            + castCustomer.getPhoneNumber();

                    bw.write(line);
                    bw.newLine();
                }
            }

            bw.close();
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
