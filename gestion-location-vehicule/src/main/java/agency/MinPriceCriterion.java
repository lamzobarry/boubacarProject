package agency;

import java.util.function.Predicate;

import commons.Vehicle;

public class MinPriceCriterion implements Predicate<Vehicle> {
    Vehicle vehicle;
    int price;

    public MinPriceCriterion(Vehicle vehicle, int price) {
        this.vehicle = vehicle;
        this.price = price;
    }


    @Override
    public boolean test(Vehicle vehicle) {
        return vehicle.dailyRentalPrice() >= this.price;
    }
}
