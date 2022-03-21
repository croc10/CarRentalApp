package booking;

import branch.Branch;
import vehicle.VehicleType;

public interface IBookingManager {

    boolean registerBranch(Branch branch);
    double performBooking(String branchName, VehicleType vehicleType, int startTime, int endTime);
    void displayVehicles(String branchName, int startTime, int endTime);
}
