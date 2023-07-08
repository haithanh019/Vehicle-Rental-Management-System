package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import model.Bicycle;
import model.Motorcycle;
import model.Vehicle;

public class VehicleController {
    private final ArrayList<Vehicle> vehicleList = new ArrayList();
    
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
    
    public static <T extends Vehicle> void searchByType(ArrayList<Vehicle> vehicles, Class<T> clazz) {
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
}
