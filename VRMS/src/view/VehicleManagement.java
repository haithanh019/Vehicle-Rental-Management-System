package view;

import controllers.VehicleController;
import model.Bicycle;
import model.Motorcycle;

public class VehicleManagement extends Menu<String> {

    private VehicleController vc = new VehicleController();
    private static final String PATH_MOTOR = "D:\\FPT_doc\\SU23_PRO192_V2\\Assignments\\Vehicle-Rental-Management-System\\VRMS\\src\\resources\\Motorcycle.txt";
    private static final String PATH_BICYCLE = "D:\\FPT_doc\\SU23_PRO192_V2\\Assignments\\Vehicle-Rental-Management-System\\VRMS\\src\\resources\\Bicycle.txt";
    
    public static void main(String[] args) {
        VehicleManagement vm = new VehicleManagement();
        vm.run();
    }


    public VehicleManagement() {
        super("Who are you?..", menu, null);
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
        String[] mSearch = {"Display all vehicles", "Search Vehicle", "Sort Vehicle", "Your Profile", "Back to MENU"};
        Menu m = new Menu("USER - Vehicle Rental Management", mSearch, this) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        //display vehicle
                        break;
                    case 2:
                        //search
                        searchVehicleOfUser();
                        break;
                    case 3:
                        //sort
                        sortListVehicleOfUser();
                        break;
                    case 4:
                        yourProfile();
                        //profile
                        break;
                    case 5:
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

    public void Admin() {
        String[] mSearch = {"Display all vehicles", "Display all rental vehicles", "Display all customers", "Search Vehicle", "Search Customer", "Add new vehicle", "Delete vehicle", "Back to MENU"};
        Menu m = new Menu("ADMIN - Vehicle Rental Management", mSearch, this) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        //display all vehicle
                        break;
                    case 2:
                        //Display all rental vehicles
                        break;
                    case 3:
                        //Display all customers
                        break;
                    case 4:
                        searchVehicleOfAdmin();
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

    
    //User
    
    public void searchVehicleOfUser() {
        String[] mSearch = {"Search by type", "Search by brand", "The vehicle with the cheapest hourly rental rate", "The most expensive vehicle to rent per hour", "Back to USER interface"};
        Menu m = new Menu("Vehicle Searching", mSearch, this) {
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
                        System.out.println("Returning to the main User.");
                        if (parentMenu != null) {
                            ((VehicleManagement) parentMenu).User();
                        }
                        break;
                }
            }
        };
        m.run();
    }
    
    public void sortListVehicleOfUser() {
        String[] mSearch = {"Min to Max", "Max to Min", "Back to USER interface"};
        Menu m = new Menu("Vehicle Sorting", mSearch, this) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Returning to the main User.");
                        if (parentMenu != null) {
                            ((VehicleManagement) parentMenu).User();
                        }
                        break;
                }
            }
        };
        m.run();
    }
    
    public void yourProfile() {
        String[] mSearch = {"Create", "Update", "Back to USER interface"};
        Menu m = new Menu("Your Profile", mSearch, this) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Returning to the main User.");
                        if (parentMenu != null) {
                            ((VehicleManagement) parentMenu).User();
                        }
                        break;
                }
            }
        };
        m.run();
    }    
    
    //Admin    
    
    public void searchVehicleOfAdmin() {
        String[] mSearch = {"Search by ID", "Search by type", "Search by brand", "The vehicle with the cheapest hourly rental rate", "The most expensive vehicle to rent per hour", "Back to USER interface"};
        Menu m = new Menu("Vehicle Searching", mSearch, this) {
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
                        if (parentMenu != null) {
                            ((VehicleManagement) parentMenu).Admin();
                        }
                        break;
                }
            }
        };
        m.run();
    } 

    public void searchCustomer() {
        String[] mSearch = {"Search by CCCD", "Search by name", "Back to USER interface"};
        Menu m = new Menu("Vehicle Sorting", mSearch, this) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Returning to the main Admin.");
                        if (parentMenu != null) {
                            ((VehicleManagement) parentMenu).Admin();
                        }
                        break;
                }
            }
        };
        m.run();
    }    
    
    
    
    public void showAllVehicles() {
        vc.readDataFromFile(PATH_MOTOR, Motorcycle.class);
        vc.readDataFromFile(PATH_BICYCLE, Bicycle.class);
        vc.displayVehiclesList();
    }
}
