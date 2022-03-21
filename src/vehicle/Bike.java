package vehicle;

public class Bike extends AbstractVehicle {

    public Bike(String vehicleId, double price) {
        this.vehicleId = vehicleId;
        this.price = price;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }
}
