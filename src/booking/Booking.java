package booking;

import vehicle.Vehicle;

public class Booking {

    String bookingId;
    String branchName;
    Vehicle vehicle;
    double cost;
    int startTime;
    int endTime;

    public String getBookingId() {
        return bookingId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getCost() {
        return cost;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    static class BookingBuilder {
        private Booking booking;
        public BookingBuilder aBookingBuilder() {
            booking = new Booking();
            return this;
        }

        public BookingBuilder bookingId(String bookingId) {
            booking.bookingId = bookingId;
            return this;
        }

        public BookingBuilder branchName(String branchName) {
            booking.branchName = branchName;
            return this;
        }

        public BookingBuilder vehicle(Vehicle vehicle) {
            booking.vehicle = vehicle;
            return this;
        }

        public BookingBuilder cost(double cost) {
            booking.cost = cost;
            return this;
        }

        public BookingBuilder startTime(int startTime) {
            booking.startTime = startTime;
            return this;
        }

        public BookingBuilder endTime(int endTime) {
            booking.endTime = endTime;
            return this;
        }

        public Booking build() {
            return booking;
        }
    }
}
