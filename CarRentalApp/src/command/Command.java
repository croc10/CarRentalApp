package command;

import booking.BookingManager;

public interface Command {

    void execute(BookingManager bookingManager);
}
