import command.CommandExecutor;

import java.io.FileNotFoundException;

public class CarRentalApp {
    public static void main(String[] args) {
        CarRentalApp carRentalApp = new CarRentalApp();
        carRentalApp.start(args[0]);
    }

    private void start(String filePath) {
        try {
            CommandExecutor commandExecutor = new CommandExecutor(filePath);
            commandExecutor.execute();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
