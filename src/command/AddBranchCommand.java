package command;

import booking.BookingManager;
import branch.Branch;
import vehicle.VehicleType;

import java.util.Arrays;
import java.util.List;

public class AddBranchCommand implements Command {

    CommandType commandType;
    String branchName;
    String vehicleTypes;

    public AddBranchCommand(String branchName, String vehicleTypes) {
        commandType = CommandType.ADD_BRANCH;
        this.branchName = branchName;
        this.vehicleTypes = vehicleTypes;
    }

    @Override
    public void execute(BookingManager bookingManager) {
        String[] vehicleTypesArray = vehicleTypes.split(",");
        List<VehicleType> vehicleTypeList = Arrays.stream(vehicleTypesArray).map(VehicleType::valueOf).toList();
        Branch branch = new Branch(branchName, vehicleTypeList);
        System.out.println(bookingManager.registerBranch(branch));
    }
}
