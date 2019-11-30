package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.Car;
import beans.Motorbike;
import commons.AbstractVehicle;

public class TestMain {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		final ReadAndWriteFileUtils fileUtils = new ReadAndWriteFileUtils("src/main/resources/", "mesTests",
				"vehiclesFile.txt");
		fileUtils.createDirectory();
		final List<AbstractVehicle> listeOfVehicles = new ArrayList<>();
		for (int i = 1; i < 14; i++) {
			 Car car = new Car(i, "test" + i, "test" + i, 2018, 5.0);
			 Motorbike motorbike = new Motorbike(i, "brand" + i, "model" + i, 2016, 51.0);
			listeOfVehicles.add(car);
			listeOfVehicles.add(motorbike);
		}
		final File file = fileUtils.writeInFile(listeOfVehicles);
		fileUtils.readFile(file);
	}

}
