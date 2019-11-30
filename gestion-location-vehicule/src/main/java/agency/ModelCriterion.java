package agency;

import java.util.function.Predicate;

import commons.Vehicle;

public class ModelCriterion implements Predicate<Vehicle> {
    Vehicle vehicle;
    String brand;

    public ModelCriterion(Vehicle vehicle, String brand) {
        this.vehicle = vehicle;
        this.brand = brand;
    }

    @Override
    public boolean test(Vehicle vehicle) {
        return vehicle.getBrand().equals(this.brand);
    }
}
