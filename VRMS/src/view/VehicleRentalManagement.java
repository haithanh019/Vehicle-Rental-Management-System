package view;

import controllers.CustomerController;
import controllers.VehicleController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Bill;
import model.Customer;
import model.Vehicle;
import utils.DataValidator;
import utils.Input;

public class VehicleRentalManagement extends Menu<String> {

    private static VehicleController vc = new VehicleController();
    private static CustomerController cc = new CustomerController();

    public static void main(String[] args) {
        VehicleRentalManagement vm = new VehicleRentalManagement();
        vm.run();
    }

    public VehicleRentalManagement() {
        super("Who are you?", menu);
    }
    static String[] menu = {"User", "Admin", "Exit"};

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                User();
                break;
            case 2:
                Admin();
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

    //Chose a role
    public void User() {
        String[] mSearch = {"Display all vehicles", "Search Vehicle", "Sort Vehicles by rental per hour", "Rent vehicles", "Lend vehicles", "Your Profile", "Exit"};
        Menu m = new Menu("USER - Vehicle Rental Management", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> showVehicles();
                    case 2 -> searchVehicleOfUser();
                    case 3 -> sortListVehicleOfUser();
                    case 4 -> rentVehicles();
                    case 5 -> lendVehicles();                    
                    case 6 -> yourProfile();
                    case 7 -> {
                        System.out.println("Exiting application...");
                        System.exit(0);
                    }
                }
            }
        };
        m.run();
    }

    public void rentVehicles() {
        String vehicleID = Input.inputString("Enter vehicle's id: ", DataValidator.vehicle_id_regex);
        Vehicle vehicle = vc.findVehicleById(vehicleID);
        if (vehicle.isIsAvailable()) {
            String cccd = Input.inputString("Enter your cccd: ", DataValidator.CCCD_regex);
            Customer customer = cc.findCustomerByCCCD(cccd);
            Double hours = Input.getAnPositiveDouble("Enter hours: ");
            Bill bill = new Bill("B00", vehicle, customer, hours);
            System.out.println("Rental successfully!");
            vehicle.setIsAvailable(false);
            bill.genarateBill();
        }

    }

    public void lendVehicles() {
        String vehicleID = Input.inputString("Enter vehicle's id: ", DataValidator.vehicle_id_regex);
        Vehicle vehicle = vc.findVehicleById(vehicleID);
        if (!vehicle.isIsAvailable()) {
            vehicle.setIsAvailable(true);
            System.out.println("Lended successfully!");
        }
    }

    public void Admin() {
        String[] mSearch = {"Display all vehicles", "Display all rental vehicles", "Display all customers", "Search Vehicle", "Search Customer", "Add new vehicle", "Delete vehicle", "Exit"};
        Menu m = new Menu("ADMIN - Vehicle Rental Management", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        showVehicles();
                        break;
                    case 2:
                        //Display all rental vehicles
                        break;
                    case 3:
                        //Display all customers
                        break;
                    case 4:
                        //searchVehicleOfAdmin();
                        //Search Vehicle
                        break;
                    case 5:
                        //Search Customer
                        searchCustomer();
                        break;
                    case 6:
                        //Add new vehicle
                        break;
                    case 7:
                        //Delete vehicle
                        break;
                    case 8:
                        System.out.println("Exiting application...");
                        System.exit(0);
                        break;
                }
            }
        };
        m.run();
    }

    //User
    public void searchVehicleOfUser() {
        String[] mSearch = {"Search by type", "Search by brand", "The vehicle with the cheapest hourly rental rate", "The most expensive vehicle to rent per hour", "Back to USER menu"};
        Menu m = new Menu("Vehicle Searching", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        searchByType();
                        break;
                    case 2:
                        searchByBrand();
                        break;
                    case 3:
                        searchMinRentalPerHour();
                        break;
                    case 4:
                        searchMaxRentalPerHour();
                        break;
                    case 5:
                        System.out.println("Returning to the main User.");
                        break;
                }
            }
        };
        m.run();
    }

    public void sortListVehicleOfUser() {
        String[] mSearch = {"Min to Max", "Max to Min", "Back to USER menu"};
        Menu m = new Menu("Vehicle Sorting", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        vc.sortMinToMax();
                        vc.displayAllVehicles();
                    }
                    case 2 -> {
                        vc.sortMaxToMin();
                        vc.displayAllVehicles();
                    }
                    case 3 -> {
                        System.out.println("Returning to the main User.");
                    }
                }
            }
        };
        m.run();
    }

    public void yourProfile() {
        String[] mSearch = {"Create", "Update", "Show your profile", "Back to menu"};
        Menu m = new Menu("Your Profile", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        inputCustomer();
                        cc.writeDataToFile();
                    }
                    case 2 ->
                        updateCustomer();
                    case 3 ->
                        showProfile();
                    case 4 ->
                        System.out.println("Returning to the main User.");
                }
            }
        };
        m.run();
    }

    public void showProfile() {
        String cccd = Input.inputString("Enter your cccd: ", DataValidator.CCCD_regex);
        Customer customer = cc.findCustomerByCCCD(cccd);
        if (customer == null) {
            System.out.println("Customer not found! Make sure you have the customer account before.");
        } else {
            System.out.println(customer);
        }
    }

    public void updateCustomer() {
        String cccd = Input.inputString("Enter your cccd: ", DataValidator.CCCD_regex);
        Customer customer = cc.findCustomerByCCCD(cccd);
        if (customer == null) {
            System.out.println("Customer not found! Make sure you have the customer account before.");
        } else {
            String options[] = {"Update cccd", "Update phone", "Update name", "Update date of birth", "Update address", "Exit"};
            Menu menu = new Menu("Update menu", options) {
                @Override
                public void execute(int n) {
                    switch (n) {
                        case 1 ->
                            updateCustomerCCCD(customer);
                        case 2 ->
                            updateCustomerPhone(customer);
                        case 3 ->
                            updateCustomerName(customer);
                        case 4 ->
                            updateCustomerDob(customer);
                        case 5 ->
                            updateCustomerAddress(customer);
                        case 6 ->
                            System.out.println("Returning to the main User.");
                    }
                }
            };
            menu.run();
        }

    }

    public void updateCustomerCCCD(Customer c) {
        String newCccd = Input.inputString("Enter new Cccd: ", DataValidator.CCCD_regex);
        cc.updateCustomerCCCD(c, newCccd);
        cc.writeDataToFile();
    }

    public void updateCustomerName(Customer c) {
        String name = Input.inputString("Enter new Cccd: ", DataValidator.CCCD_regex);
        cc.updateCustomerCCCD(c, name);
        cc.writeDataToFile();
    }

    public void updateCustomerDob(Customer c) {
        String cccd = Input.inputString("Enter your cccd: ", DataValidator.CCCD_regex);
        String dob = Input.inputString("Enter new date of birth: ", DataValidator.date_regex);
        cc.updateCustomerCCCD(c, dob);
        cc.writeDataToFile();
    }

    public void updateCustomerPhone(Customer c) {
        String cccd = Input.inputString("Enter your cccd: ", DataValidator.CCCD_regex);
        String phone = Input.inputString("Enter new phone: ", DataValidator.phone_regex);
        cc.updateCustomerCCCD(c, phone);
        cc.writeDataToFile();
    }

    public void updateCustomerAddress(Customer c) {
        String cccd = Input.inputString("Enter your cccd: ", DataValidator.CCCD_regex);
        String address = Input.inputString("Enter new addres: ");
        cc.updateCustomerCCCD(c, address);
        cc.writeDataToFile();
    }

    public void showVehicles() {
        String[] mSearch = {"Motorcycle", "Bicycle", "All", "Back to menu"};
        Menu m = new Menu("Show vehicles", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        vc.displayMotorcycles();
                        break;
                    case 2:
                        vc.displayBicycles();
                        break;
                    case 3:
                        vc.displayAllVehicles();
                        break;
                    case 4:
                        System.out.println("Returning to the main User.");
//                        if (parentMenu != null) {
//                            ((VehicleRentalManagement) parentMenu).User();
//                        }
                        break;
                }
            }
        };
        m.run();
    }

    //Admin    
    public void searchVehicleOfAdmin() {
        String[] mSearch = {"Search by ID", "Search by type", "Search by brand", "The vehicle with the cheapest hourly rental rate", "The most expensive vehicle to rent per hour", "Back to USER interface"};
        Menu m = new Menu("Vehicle Searching", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Returning to the main Admin.");
                        break;
                }
            }
        };
        m.run();
    }

    public void searchCustomer() {
        String[] mSearch = {"Search by CCCD", "Search by name", "Back to USER interface"};
        Menu m = new Menu("Vehicle Sorting", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Returning to the main Admin.");
                        break;
                }
            }
        };
        m.run();
    }

    public void inputCustomer() {
        System.out.println("_______ADD NEW CUSTOMER_________");
        String cccd = Input.inputString("Enter CCCD: ", DataValidator.CCCD_regex);
        String name = Input.inputString("Enter Name: ");
        Date dateOfBirth = Input.getDateOfBirth("Enter date of birth: ");
        String address = Input.inputString("Enter address: ");
        String phoneNumber = Input.inputString("Phone Number (10 numbers): ", DataValidator.phone_regex);
        cc.addCustomer(new Customer(cccd, name, dateOfBirth, address, phoneNumber));
    }

    public void searchByType() {
        String type = Input.inputString("Enter the type: ");
        ArrayList<Vehicle> results = vc.search(v -> v.getType().equalsIgnoreCase(type));
        if (results.isEmpty()) {
            System.out.println("[No matching vehicles found.]");
        } else {
            for (Vehicle vehicle : results) {
                vehicle.show();
            }
            System.out.println("Total: " + results.size() + " vehicle(s)");
        }
    }

    public void searchByBrand() {
        String brand = Input.inputString("Enter the brand: ");
        ArrayList<Vehicle> results = vc.search(v -> v.getBrand().equalsIgnoreCase(brand));
        if (results.isEmpty()) {
            System.out.println("[No matching vehicles found.]");
        } else {
            for (Vehicle vehicle : results) {
                vehicle.show();
            }
            System.out.println("\nTotal: " + results.size() + " vehicle(s)");
        }
    }

    public void searchMaxRentalPerHour() {
        List<Vehicle> results = vc.searchMaxRentalPerHour();
        if (results.isEmpty()) {
            System.out.println("[No matching vehicles found.]");
        } else {
            for (Vehicle vehicle : results) {
                vehicle.show();
            }
            System.out.println("\nTotal: " + results.size() + " vehicle(s)");
        }
    }

    public void searchMinRentalPerHour() {
        List<Vehicle> results = vc.searchMinRentalPerHour();
        if (results.isEmpty()) {
            System.out.println("[No matching vehicles found.]");
        } else {
            for (Vehicle vehicle : results) {
                vehicle.show();
            }
            System.out.println("\nTotal: " + results.size() + " vehicle(s)");
        }
    }
}
