package commons;

public abstract class AbstractVehicle {
    public static final int MINIMUM_PRODUCTION_YEAR=1900 ;
    protected  int id;
    protected String brand;
    protected String model;
    protected int productionYear;
    protected TypeOfVehicleEnum typeOfVehicle;
    

    public abstract boolean equals(Object o);

    public abstract double dailyRentalPrice();

    public abstract String toString();
    

    public String getBrand() {
        return this.brand;
    }


    public String getModel() {
        return this.model;
    }

    public int getProductionYear() {
        return this.productionYear;
    }
    
    
    public String writeVehicleInFile() {
    	return typeOfVehicle.getCode() + ";" + id + ";" + brand + ";" + model + ";"
				+ productionYear + "\n";
    }

}
