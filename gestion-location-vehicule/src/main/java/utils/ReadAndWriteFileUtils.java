package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Car;
import beans.Motorbike;
import commons.AbstractVehicle;
import commons.TypeOfVehicleEnum;
import commons.Vehicle;

public class ReadAndWriteFileUtils {
	String PATH;
	String directoryName;
	String fileName;

	/**
	 * 
	 * @param PATH
	 * @param directoryName
	 * @param fileName
	 */
	public ReadAndWriteFileUtils(String PATH, String directoryName, String fileName) {
		super();
		this.PATH = PATH;
		this.directoryName = PATH.concat(directoryName);
		this.fileName = fileName;
	}

	/**
	 * 
	 * @param PATH
	 * @param directoryName
	 * @param fileName
	 */
	public void createDirectory() {
		File directory = new File(directoryName);
		if (!directory.exists()) {
			if (directory.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}

	public File createFile() {
		File file = new File(directoryName + "/" + fileName);

		// Create the file
		try {
			if (file.createNewFile()) {
				System.out.println("New Text File is created!");
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public File writeInFile(List<AbstractVehicle> abstractVehicles) throws IOException {
		File fileCreated = createFile();
		FileWriter writer = new FileWriter(fileCreated);
		for (AbstractVehicle abstractVehicle : abstractVehicles) {
			writer.write(abstractVehicle.writeVehicleInFile());
		}

		// Write Content
//		String code = vehicle.typeOfVehicle().getCode();
//		writer.write(code + ";" + vehicle.getId() + ";" + vehicle.getBrand() + ";" + vehicle.getModel() + ";"
//				+ vehicle.getProductionYear() + ";" + vehicle.dailyRentalPrice() + "\n");
		writer.close();

		return fileCreated;
	}

	/**
	 * Read file
	 * 
	 * @param file
	 * @return
	 */
	public List<Vehicle> readFile(File file) {
		final List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

		// delimited file
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			// Check if there is another line of input
			while (sc.hasNextLine()) {
				String str = sc.nextLine();

				Vehicle vehicle = parseLine(str);
				if (null != vehicle)
					vehiclesList.add(vehicle);
				System.out.println(vehicle.toString());
			}

		} catch (IOException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}

		sc.close();
		return vehiclesList;
	}

	/**
	 * Parse line of file
	 * 
	 * @param str
	 * @return
	 */
	private static Vehicle parseLine(String str) {
		final Scanner scanner = new Scanner(str);
		scanner.useDelimiter(";");
		Vehicle v = null;
		// Check if there is another line of input
		while (scanner.hasNext()) {
			// String codeTypeOfVehicule = scanner.next();
			// TypeOfVehicleEnum typeByCode =
			// TypeOfVehicleEnum.getTypeByCode(codeTypeOfVehicule);
			scanner.next();
			if (str.startsWith(TypeOfVehicleEnum.C.getCode())) {
				v = new Car(Integer.parseInt(scanner.next()), scanner.next(), scanner.next(),
						Integer.parseInt(scanner.next()));
			} else if (str.startsWith(TypeOfVehicleEnum.M.getCode())) {
				v = new Motorbike(Integer.parseInt(scanner.next()), scanner.next(), scanner.next(),
						Integer.parseInt(scanner.next()));

			}

		}
		return v;

	}

}
