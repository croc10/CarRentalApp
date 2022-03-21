package command;

import booking.BookingManager;
import vehicle.Vehicle;
import vehicle.VehicleFactory;
import vehicle.VehicleType;

public class AddVehicleCommand implements Command {

    CommandType commandType;
    String branchName;
    String vehicleType;
    String vehicleId;
    String price;

    public AddVehicleCommand(String branchName, String vehicleType, String vehicleId, String price) {
        this.branchName = branchName;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.price = price;
    }

    @Override
    public void execute(BookingManager bookingManager) {
        VehicleType vehicleTypeEnum = VehicleType.valueOf(vehicleType);
        double priceDouble = Double.parseDouble(price);
        Vehicle vehicle = VehicleFactory.getVehicle(vehicleId, priceDouble, vehicleTypeEnum);
        System.out.println(bookingManager.getBranches().get(branchName).addVehicle(vehicle));
    }
}
