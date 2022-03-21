package vehicle;

public class BookedVehicle {
    Vehicle vehicle;
    boolean isDynamicPrice;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isDynamicPrice() {
        return isDynamicPrice;
    }

    public void setDynamicPrice(boolean dynamicPrice) {
        isDynamicPrice = dynamicPrice;
    }

    public double getCost(double dynamicPriceCharge) {
        return isDynamicPrice ? vehicle.getPrice()*dynamicPriceCharge : vehicle.getPrice();
    }
}
