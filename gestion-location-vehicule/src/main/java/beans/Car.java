package beans;

import commons.AbstractVehicle;
import commons.TypeOfVehicleEnum;
import commons.Vehicle;
import utils.TimeProvider;

public class Car extends AbstractVehicle implements Vehicle {

    public static final double MINIMUM_NUMBER_OF_SEATS=1.0;
    private static final int ID_INIT=1;
//    private String brand;
//    private String model;
//    private final int productionYear;
    public final double numberOfSeats;
//    private int id;

    public Car(int id, String brand, String model, int productionYear, double numberOfSeats) throws IllegalArgumentException{
        this.brand = brand;
        this.model = model;
        super.typeOfVehicle = TypeOfVehicleEnum.C;
        
        if (productionYear < MINIMUM_PRODUCTION_YEAR || productionYear > TimeProvider.currentYearValue()){
            throw new IllegalArgumentException(String.valueOf(productionYear));
        }
        this.productionYear = productionYear;
        if (numberOfSeats < MINIMUM_NUMBER_OF_SEATS) {
            throw new IllegalArgumentException(String.valueOf(numberOfSeats));
        }
        this.numberOfSeats = numberOfSeats;
        
        if (id < ID_INIT) {
            throw new IllegalArgumentException("l' id doit être unique et supérieur " + ID_INIT);
        }
        this.id = id;
        
    }
    
    public Car(int id, String brand, String model, int productionYear) throws IllegalArgumentException{
        this.brand = brand;
        this.model = model;
        super.typeOfVehicle = TypeOfVehicleEnum.C;
        numberOfSeats = MINIMUM_NUMBER_OF_SEATS;
        
        if (productionYear < MINIMUM_PRODUCTION_YEAR || productionYear > TimeProvider.currentYearValue()){
            throw new IllegalArgumentException(String.valueOf(productionYear));
        }
        this.productionYear = productionYear;
        
        
        if (id < ID_INIT) {
            throw new IllegalArgumentException("l' id doit être unique et supérieur " + ID_INIT);
        }
        this.id = id;
        
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getProductionYear() {
        return this.productionYear;
    }

    @Override
    public double dailyRentalPrice() {
        return isNew() ? 40 * this.numberOfSeats : 20 * this.numberOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car) {
            Car otherCar =(Car)o;
            return otherCar.getBrand().equals(this.getBrand()) && otherCar.getModel().equals(this.getModel())
                    && otherCar.productionYear == this.productionYear;
        }
        else return false;

    }

    @Override
    public String toString() {
        if(numberOfSeats>1){
            return "Car"+ " " + getBrand() +" "+getModel()+" "+getProductionYear()+" "+"("+this.numberOfSeats+" seats"+")"+" : "+this.dailyRentalPrice()+"€";
        }
        return "Car"+ " " + getBrand() +" "+getModel()+" "+getProductionYear()+" "+"("+this.numberOfSeats+" seat"+")"+" : "+this.dailyRentalPrice()+"€";
    }

    public boolean isNew(){
        return (TimeProvider.currentYearValue() - getProductionYear()) <= 5;

    }




}
