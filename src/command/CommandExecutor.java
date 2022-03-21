package command;

import booking.BookingManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandExecutor {
    String filePath;
    BookingManager bookingManager;

    public CommandExecutor(String filePath) {
        this.filePath = filePath;
        this.bookingManager = new BookingManager();
    }

    public void execute() throws FileNotFoundException {
        BookingManager bookingManager = new BookingManager();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            CommandType commandType = CommandType.valueOf(parts[0]);
            switch (commandType) {
                case ADD_BRANCH -> new AddBranchCommand(parts[1], parts[2]).execute(bookingManager);
                case ADD_VEHICLE -> new AddVehicleCommand(parts[1], parts[2], parts[3], parts[4]).execute(bookingManager);
                case BOOK -> new BookVehicleCommand(parts[1], parts[2], parts[3], parts[4]).execute(bookingManager);
                case DISPLAY_VEHICLES -> new DisplayCommand(parts[1], parts[2], parts[3]).execute(bookingManager);
                default -> System.out.println("Invalid command");
            }
        }
    }
}
