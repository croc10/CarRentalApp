package booking;

import branch.Branch;
import vehicle.BookedVehicle;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.*;

public class BookingManager implements IBookingManager {

    private final Map<String, List<Booking>> branchBookingMap;
    private final Map<String, Branch> branches;
    private final double dynamicPricingLimit;
    private final double dynamicPricingCharge;

    public BookingManager() {
        branchBookingMap = new HashMap<>();
        branches = new HashMap<>();
        dynamicPricingLimit = 70;
        dynamicPricingCharge = 10;
    }

    public boolean registerBranch(Branch branch) {
        if(!branchBookingMap.containsKey(branch.getBranchName())) {
            branchBookingMap.put(branch.getBranchName(), new ArrayList<>());
            branches.put(branch.getBranchName(), branch);
            return true;
        }
        return false;
    }

    public Map<String, Branch> getBranches() {
        return branches;
    }

    public double performBooking(String branchName, VehicleType vehicleType, int startTime, int endTime) {
        //run validations first
        if (!branchBookingMap.containsKey(branchName)) {
            //System.out.println("branch.Branch: " + branchName + " is not yet registered with the booking manager");
            return -1;
        }
        Branch branch = branches.get(branchName);
        if(!branch.doesSupportVehicleType(vehicleType)) {
            //System.out.println("branch.Branch: " + branch.getBranchName() + " does not support vehicle.Vehicle Type "+ vehicleType);
            return -1;
        }
        BookedVehicle vehicle = getAvailableVehicle(branch, vehicleType, startTime, endTime);
        if(vehicle == null) {
            //System.out.println("branch.Branch: " + branch.getBranchName() + " does not have vehicle.Vehicle Type "+ vehicleType + " available for given time");
            return -1;
        } else {
            Booking booking = new Booking.BookingBuilder().aBookingBuilder()
                            .bookingId(UUID.randomUUID().toString())
                            .branchName(branchName)
                            .vehicle(vehicle.getVehicle())
                            .cost(vehicle.getCost(1 + dynamicPricingCharge/100)*(endTime-startTime))
                            .startTime(startTime)
                            .endTime(endTime)
                            .build();
            branchBookingMap.get(branchName).add(booking);
            return booking.getCost();
        }
    }

    public void displayVehicles(String branchName, int startTime, int endTime) {
        Branch branch = branches.get(branchName);
        List<VehicleType> vehicleTypes = branch.getVehicleTypes();
        List<Vehicle> allAvailableVehicles = new ArrayList<>();
        vehicleTypes.forEach(vehicleType -> allAvailableVehicles.addAll(getAvailableVehicles(branch, vehicleType, startTime, endTime)));
        allAvailableVehicles.forEach(vehicle -> {
            System.out.print(vehicle.getVehicleId()+",");
        });
    }

    private List<Vehicle> getAvailableVehicles(Branch branch, VehicleType vehicleType, int startTime, int endTime) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        List<Vehicle> tempVehicles = branch.getVehicles().stream().filter(vehicle -> vehicle.getVehicleType() == vehicleType).toList();
        for(Vehicle vehicle: tempVehicles) {
            boolean addFlag = true;
            List<Booking> tempBookings = branchBookingMap.get(branch.getBranchName())
                    .stream().filter(booking -> booking.getVehicle().getVehicleId().equals(vehicle.getVehicleId())).toList();
            for(Booking booking: tempBookings) {
                if((startTime < endTime && (endTime <= booking.startTime || startTime >=booking.endTime))) {
                    continue;
                } else {
                    addFlag=false;
                    break;
                }
            }
            if (addFlag)
                availableVehicles.add(vehicle);
        }
        return availableVehicles;
    }

    private BookedVehicle getAvailableVehicle(Branch branch, VehicleType vehicleType, int startTime, int endTime) {
        List<Vehicle> allVehiclesOfType = branch.getVehicles().stream().filter(vehicle -> vehicle.getVehicleType() == vehicleType).toList();
        List<Vehicle> allAvailableVehicles = getAvailableVehicles(branch, vehicleType, startTime, endTime);
        if(allAvailableVehicles.isEmpty())
            return null;
        allAvailableVehicles.sort(new LowestFirstPricingStrategy());
        Vehicle vehicle = allAvailableVehicles.get(0);
        double availabilityPercentage = ((double)(allAvailableVehicles.size())/(double)(allVehiclesOfType.size()))*100;
        BookedVehicle bookedVehicle = new BookedVehicle();
        bookedVehicle.setVehicle(vehicle);
        bookedVehicle.setDynamicPrice(availabilityPercentage<(100-dynamicPricingLimit));
        return bookedVehicle;
    }
}
