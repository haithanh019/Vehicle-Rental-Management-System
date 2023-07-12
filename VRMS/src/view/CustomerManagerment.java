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
    static Customer customer = new Customer();
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
        customers = new Customer(cccd, name, dateOfBirth, address, phoneNumber);
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

    public void Update() {
        String[] mSearch = {"Update CCCD", "Update name", "Update date of birth", "Update address", "Update phone number"};
        Menu m = new Menu("UPDATE INFORMATION", mSearch, this) {
            @Override
            public void execute(int n) {
                System.out.print("Enter the customer CCCD to update: ");
                String cccd = scanner.nextLine();
                switch (n) {
                    case 1:
                        String newCccd = Input.inputString("Enter CCCD: ", DataValidator.CCCD_regex);
                        cusc.updateCustomerCCCD(customer, cccd);
                        break;
                    case 2:
                        String newName = Input.inputString("Enter Name");
                        cusc.updateCustomerName(customer, newName);
                        break;
                    case 3:
                        System.out.println("Enter date birth (dd/mm/yyyy): ");
                        String newDateOfBirth = scanner.nextLine();
                        if (!DataValidator.validateDateOfBirth(newDateOfBirth)) {
                            System.out.println("Invalid Date of Birth format.");
                            return;
                        }
                        cusc.updateCustomerDateOfBirth(customer, newDateOfBirth);
                        break;
                    case 4:
                        String address = Input.inputString("Enter address: ");
                        cusc.updateCustomerAddress(customer, address);
                        
                        break;
                    case 5:
                        String phoneNumber = Input.inputString("Phone Number (10 numbers)", DataValidator.phone_regex);
                        cusc.updateCustomerPhoneNumber(customer, phoneNumber);
                    case 6:
                        System.out.println("Returning to the main menu.");
                        if (parentMenu != null) {
                            parentMenu.run();
                        }
                        break;
                }
            }
        };
        m.run();
    }

}
