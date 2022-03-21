package vehicle;

public class Van extends AbstractVehicle {

    public Van(String vehicleId, double price) {
        this.vehicleId = vehicleId;
        this.price = price;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.VAN;
    }
}
