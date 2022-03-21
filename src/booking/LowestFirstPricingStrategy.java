package booking;

import vehicle.Vehicle;

import java.util.Comparator;

public class LowestFirstPricingStrategy implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
