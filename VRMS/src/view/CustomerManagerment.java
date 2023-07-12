/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controllers.CustomerController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Customer;
import utils.DataValidator;
import utils.Input;
import static utils.Input.inputString;

/**
 *
 * @author Admin
 */
public class CustomerManagerment extends Menu<String> {

    private CustomerController cusc = new CustomerController();
    static ArrayList<Customer> customerList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_MOTOR = "D:\\FPT_doc\\SU23_PRO192_V2\\Assignments\\Vehicle-Rental-Management-System\\VRMS\\src\\resources\\Customer.txt";

    public static void main(String[] args) {
        CustomerManagerment cm = new CustomerManagerment();
        cm.run();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                ;
                break;
            case 2:
                ;
                break;
            case 3:
                System.out.println("Exiting application...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!");
                break;
        }
    }

    public void addCustomer(Customer customer) {
        cusc.addCustomer(customer);
    }

    public void addCustomer() {
        System.out.println("_______ADD NEW CUSTOMER_________");
        String cccd = Input.inputString("Enter CCCD: ", DataValidator.CCCD_regex);
        String name = Input.inputString("Enter Name");
        System.out.println("Enter date birth (dd/mm/yyyy): ");
        String dateOfBirth = scanner.nextLine();
        if (!DataValidator.validateDateOfBirth(dateOfBirth)) {
            System.out.println("Invalid Date of Birth format.");
            return;
        }
        String address = Input.inputString("Enter address: ");
        String phoneNumber = Input.inputString("Phone Number (10 numbers)", DataValidator.phone_regex);
        Customer customers;
        customers = new Customer(cccd,name,dateOfBirth,address, phoneNumber);
        cusc.addCustomer(customers);
        System.out.println("Customer added successfully!");
    }
    
    public void displayCustomer() {
        customerList.forEach(c -> System.out.println(c));
        System.out.println("_______Display Customer__________");
        cusc.displayCustomer(); 
        System.out.println("Total of customer is: " + cusc.totalCustomer());
    }

    public void searchCustomer() {
        int searchChoice;
        while (true) {
            System.out.println("_______SEARCH CUSTOMER_________");
            System.out.println("1.Search by CCCD");
            System.out.println("2.Search by name");
            System.out.println("3.Exit");
            System.out.println("Enter your choice: ");
            try {
                searchChoice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input ! Please re-enter");
                continue;
            }
            ArrayList<Customer> searchResults;
            switch (searchChoice) {
                case 1:
                    String cccd = inputString("Search CCCD: ");
                    searchResults = cusc.searchCustomer(c -> c.getCccd().contains(cccd));
                    if (searchResults.isEmpty()) {
                        System.out.println("No matching customers found.");
                    } else {
                        System.out.println("Search results: ");
                        for (Customer customer : searchResults) {
                            System.out.println(customer);
                        }
                        System.out.println("Total: " + searchResults.size() + " customer(s)");
                    }
                    break;

                case 2:
                    String name = inputString("Search name: ");
                    searchResults = cusc.searchCustomer(c -> c.getName().contentEquals(name));
                    if (searchResults.isEmpty()) {
                        System.out.println("No matching customers found.");
                    } else {
                        System.out.println("Search results: ");
                        for (Customer customer : searchResults) {
                            System.out.println(customer);
                        }
                        System.out.println("Total: " + searchResults.size() + " customer(s)");
                    }
                    break;
                case 3:
                    break;

                default:
                    System.out.println("Invalid choice. Return menu.");
                    return;
            }
            if (searchChoice == 2) {
                break;

            }

        }
    }
    
    public void updateCustomerDetails() {
        System.out.print("Enter the customer CCCD to update: ");
        String cccd = scanner.nextLine();
        System.out.print("Enter the new CCCD: ");
        String newCccd = scanner.nextLine();
        System.out.print("Enter the new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter the new date of Birth (dd/MM/yyyy): ");
        String newDateOfBirth = scanner.nextLine();
        System.out.print("Enter the new address: ");
        String newAddress = scanner.nextLine();
        System.out.print("Enter the new phone: ");
        String newPhone = scanner.nextLine();
        cusc.updateCustomer(newCccd,newName,newDateOfBirth,newAddress,newPhone);
    }

}
