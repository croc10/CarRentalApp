package vehicle;

public class VehicleFactory {

    public static Vehicle getVehicle(String vehicleId, double price, VehicleType vehicleType) {
        Vehicle vehicle = null;
        switch (vehicleType) {
            case CAR:
                vehicle = new Car(vehicleId, price);
                break;
            case BUS:
                vehicle = new Bus(vehicleId, price);
                break;
            case BIKE:
                vehicle = new Bike(vehicleId, price);
                break;
            case VAN:
                vehicle = new Van(vehicleId, price);
                break;
            default:
                break;
        }
        return vehicle;
    }
}
