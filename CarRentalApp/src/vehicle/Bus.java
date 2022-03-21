package vehicle;

public class Bus extends AbstractVehicle {

    public Bus(String vehicleId, double price) {
        this.vehicleId = vehicleId;
        this.price = price;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BUS;
    }
}
