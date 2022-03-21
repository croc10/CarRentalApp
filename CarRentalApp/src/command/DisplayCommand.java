package command;

import booking.BookingManager;

public class DisplayCommand implements Command {

    String branchName;
    String startTime;
    String endTime;

    public DisplayCommand(String branchName, String startTime, String endTime) {
        this.branchName = branchName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public void execute(BookingManager bookingManager) {
        int startTimeInt = Integer.parseInt(startTime);
        int endTimeInt = Integer.parseInt(endTime);
        bookingManager.displayVehicles(branchName, startTimeInt, endTimeInt);
    }
}
