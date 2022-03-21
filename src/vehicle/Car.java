package vehicle;

public class Car extends AbstractVehicle {

    public Car(String vehicleId, double price) {
        this.vehicleId = vehicleId;
        this.price = price;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
