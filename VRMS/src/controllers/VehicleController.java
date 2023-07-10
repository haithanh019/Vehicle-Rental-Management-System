package controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import model.Bicycle;
import model.Motorcycle;
import model.Vehicle;

public class VehicleController {

    private final ArrayList<Vehicle> vehicleList = new ArrayList();

    public <T extends Vehicle> void readDataFromFile(String path, Class<T> clazz) {
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

    public <T extends Vehicle> void searchByType(ArrayList<Vehicle> vehicles, Class<T> clazz) {
        for (Vehicle vehicle : vehicles) {
            if (clazz.isInstance(vehicle)) {
                T specificVehicle = clazz.cast(vehicle);
                if (specificVehicle instanceof Bicycle bicycle) {
                    bicycle.show();
                } else if (specificVehicle instanceof Motorcycle motorcycle) {
                    motorcycle.show();
                }
            }
        }
    }

    public void deleteAVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    public void sortByCost() {
        vehicleList.sort(Comparator.comparing(Vehicle::getCostPerHour));
    }
    
    public void displayVehiclesList() {
        for (Vehicle vehicle : vehicleList) {
            vehicle.show();
        }
    }
}
