package branch;

import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String branchName;
    private List<VehicleType> vehicleTypes;
    private List<Vehicle> vehicles;

    public Branch(String branchName, List<VehicleType> vehicleTypes) {
        this.branchName = branchName;
        this.vehicleTypes = vehicleTypes;
        vehicles = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if(vehicle != null && doesSupportVehicleType(vehicle.getVehicleType())) {
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public boolean doesSupportVehicleType(VehicleType vehicleType) {
        return vehicleTypes.contains(vehicleType);
    }

}
