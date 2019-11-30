package agency;

import java.util.function.Predicate;

import commons.Vehicle;

public class BrandCriterion implements Predicate<Vehicle> {

    public String brand;

    public BrandCriterion(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean test(Vehicle vehicle) {
        return vehicle.getBrand().equals(this.brand);
    }


}
