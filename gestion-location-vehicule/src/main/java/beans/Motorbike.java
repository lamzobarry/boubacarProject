package beans;

import commons.AbstractVehicle;
import commons.TypeOfVehicleEnum;
import commons.Vehicle;
import utils.TimeProvider;

public class Motorbike extends AbstractVehicle implements Vehicle {

	/*
	 * private String brand; private String model; private int productionYear;
	 */
	private static final int MINIMUM_CYLINDER_CAPACITY = 50;
	private static final int ID_INIT = 1;
	public double cylinderCapacity;

	public Motorbike(int id, String brand, String model, int productionYear, double cylinderCapacity)
			throws IllegalArgumentException {
		this.brand = brand;
		this.model = model;
		typeOfVehicle = TypeOfVehicleEnum.M;

		if (productionYear < MINIMUM_PRODUCTION_YEAR || productionYear > TimeProvider.currentYearValue()) {
			throw new IllegalArgumentException(productionYear + " est inferieur à " + MINIMUM_PRODUCTION_YEAR
					+ " ou superieur à " + TimeProvider.currentYearValue());
		}
		this.productionYear = productionYear;

		if (cylinderCapacity < MINIMUM_CYLINDER_CAPACITY) {
			throw new IllegalArgumentException(cylinderCapacity + " est inférieure à " + MINIMUM_CYLINDER_CAPACITY);
		}
		this.cylinderCapacity = cylinderCapacity;

		if (id < ID_INIT) {
			throw new IllegalArgumentException("l' id doit être unique et supérieur " + ID_INIT);
		}
		this.id = id;

	}
	
	public Motorbike(int id, String brand, String model, int productionYear)
			throws IllegalArgumentException {
		this.brand = brand;
		this.model = model;
		typeOfVehicle = TypeOfVehicleEnum.M;

		if (productionYear < MINIMUM_PRODUCTION_YEAR || productionYear > TimeProvider.currentYearValue()) {
			throw new IllegalArgumentException(productionYear + " est inferieur à " + MINIMUM_PRODUCTION_YEAR
					+ " ou superieur à " + TimeProvider.currentYearValue());
		}
		this.productionYear = productionYear;

		
		this.cylinderCapacity = MINIMUM_CYLINDER_CAPACITY;

		if (id < ID_INIT) {
			throw new IllegalArgumentException("l' id doit être unique et supérieur " + ID_INIT);
		}
		this.id = id;

	}

	/*
	 * @Override public String getBrand() { return this.brand; }
	 * 
	 * @Override public String getModel() {
	 * 
	 * return this.model; }
	 * 
	 * @Override public int getProductionYear() {
	 * 
	 * return this.productionYear; }
	 */

	@Override
	public double dailyRentalPrice() {

		return 0.25 * this.cylinderCapacity;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Motorbike) {
			Motorbike otherMotorbike = (Motorbike) o;
			return otherMotorbike.getBrand().equals(this.getBrand())
					&& otherMotorbike.getModel().equals(this.getModel())
					&& otherMotorbike.productionYear == this.productionYear;
		} else
			return false;

	}

	@Override
	public String toString() {

		return "Motorbike" + " " + getBrand() + " " + getModel() + " " + getProductionYear() + " " + "("
				+ this.cylinderCapacity + " cm3" + ")" + " : " + this.dailyRentalPrice() + "€";
	}

}
