package controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Bicycle;
import model.Motorcycle;
import model.Vehicle;

public class VehicleController {

    private final ArrayList<Vehicle> vehicleList = new ArrayList();
    private static final String PATH_MOTOR = "src/resources/Motorcycle.txt";
    private static final String PATH_BICYCLE = "src/resources/Bicycle.txt";

    public VehicleController() {
        readDataFromFile(PATH_MOTOR, Motorcycle.class);
        readDataFromFile(PATH_BICYCLE, Bicycle.class);
    }

    public <T extends Vehicle> void readDataFromFile(String path, Class<T> clazz) {
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(",");
                if (arr.length == 6) {
                    T v = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class, Double.class, Boolean.class)
                            .newInstance(arr[0], arr[1], arr[2], arr[3], Double.parseDouble(arr[4]), Boolean.parseBoolean(arr[5]));
                    vehicleList.add(v);
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

    public void addNewVehicle(Vehicle newVehicle) {
        vehicleList.add(newVehicle);
    }

    public ArrayList<Vehicle> search(Predicate<Vehicle> p) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle s : vehicleList) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
    
    public Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Vehicle> searchMaxRentalPerHour() {
        if (vehicleList.isEmpty()) {
            return Collections.emptyList(); // Trả về danh sách rỗng nếu danh sách phương tiện rỗng
        }

        double maxCost = vehicleList.stream()
                .mapToDouble(Vehicle::getCostPerHour)
                .max()
                .orElse(0.0);

        return vehicleList.stream()
                .filter(vehicle -> vehicle.getCostPerHour() == maxCost)
                .collect(Collectors.toList());
    }

    public List<Vehicle> searchMinRentalPerHour() {
        if (vehicleList.isEmpty()) {
            return Collections.emptyList(); // Trả về danh sách rỗng nếu danh sách phương tiện rỗng
        }

        double minCost = vehicleList.stream()
                .mapToDouble(Vehicle::getCostPerHour)
                .min()
                .orElse(0.0);

        return vehicleList.stream()
                .filter(vehicle -> vehicle.getCostPerHour() == minCost)
                .collect(Collectors.toList());
    }

    public int totalVehicles() {
        return vehicleList.size();
    }

//    public <T extends Vehicle> void searchByType(ArrayList<Vehicle> vehicles, Class<T> clazz) {
//        for (Vehicle vehicle : vehicles) {
//            if (clazz.isInstance(vehicle)) {
//                T specificVehicle = clazz.cast(vehicle);
//                if (specificVehicle instanceof Bicycle bicycle) {
//                    bicycle.show();
//                } else if (specificVehicle instanceof Motorcycle motorcycle) {
//                    motorcycle.show();
//                }
//            }
//        }
//    }
    public void deleteAVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
        
    }

    public void sortMinToMax() {
        vehicleList.sort(Comparator.comparing(Vehicle::getCostPerHour));
    }

    public void sortMaxToMin() {
        vehicleList.sort(Comparator.comparing(Vehicle::getCostPerHour).reversed());
    }

    public void displayAllVehicles() {
        for (Vehicle vehicle : vehicleList) {
            if(vehicle.isIsAvailable())
                vehicle.show();
        }
    }

    public void displayMotorcycles() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Motorcycle && vehicle.isIsAvailable()) {
                vehicle.show();
            }
        }
    }

    public void displayBicycles() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Bicycle && vehicle.isIsAvailable()) {
                vehicle.show();
            }
        }
    }
}
