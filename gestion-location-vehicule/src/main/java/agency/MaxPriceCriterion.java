package agency;

import java.util.function.Predicate;

import commons.Vehicle;

public class MaxPriceCriterion implements Predicate<Vehicle> {
    public int price;
    private Vehicle vehicle;

    public MaxPriceCriterion(int price, Vehicle vehicle) {
        this.price = price;
        this.vehicle = vehicle;
    }

    @Override
    public boolean test(Vehicle vehicle) {
        return vehicle.dailyRentalPrice() <= this.price;
    }
}
