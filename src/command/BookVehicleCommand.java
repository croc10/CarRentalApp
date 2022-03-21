package command;

import booking.BookingManager;
import vehicle.VehicleType;

public class BookVehicleCommand implements Command {

    String branchName;
    String vehicleType;
    String startTime;
    String endTime;

    public BookVehicleCommand(String branchName, String vehicleType, String startTime, String endTime) {
        this.branchName = branchName;
        this.vehicleType = vehicleType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public void execute(BookingManager bookingManager) {
        VehicleType vehicleTypeEnum = VehicleType.valueOf(vehicleType);
        int startTimeInt = Integer.parseInt(startTime);
        int endTimeInt = Integer.parseInt(endTime);
        System.out.println(bookingManager.performBooking(branchName, vehicleTypeEnum, startTimeInt, endTimeInt));
    }
}
