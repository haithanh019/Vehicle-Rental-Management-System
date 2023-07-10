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

    static String[] menu = {"Display all vehicles", "Search a vehicle", "Sort vehicles list by cost per hour", "Exit"};

    public VehicleManagement() {
        super("Vehicle Rental Management", menu, null);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                //Vi du
                showAllVehicles();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.out.println("Exiting application...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!");
                break;
        }
    }

    public void searchVehicle() {
        String[] mSearch = {"Mortorcycle", "Bicycle", "Back to MENU"};
        Menu m = new Menu("Vehicle Searching", mSearch, this) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
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
    
    public void showAllVehicles() {
        vc.readDataFromFile(PATH_MOTOR, Motorcycle.class);
        vc.readDataFromFile(PATH_BICYCLE, Bicycle.class);
        vc.displayVehiclesList();
    }
}
