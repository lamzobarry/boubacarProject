package agency;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import commons.Vehicle;

public class Fichier {

    Path source;
    Scanner scanner;
    File file;

    public Fichier(String path) throws IOException {

        Path source = Paths.get(String.valueOf(path));
        Files.createFile(source);
        File file = new File(String.valueOf(source));
        Scanner scanner = new Scanner(file);
    }

    public void readFile() {

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public boolean ContainsVehicle(Vehicle vehicle) throws IOException {

        return false;
    }

    public void writeInFile(Vehicle vehicle) throws IOException {

        Files.write(source, (vehicle.getBrand() + " ; " + vehicle.getModel() + " ; " + vehicle.getProductionYear() + " ; " + vehicle.dailyRentalPrice() + "\n").getBytes(),
                StandardOpenOption.APPEND, StandardOpenOption.WRITE);

    }


}
