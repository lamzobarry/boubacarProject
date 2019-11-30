package agency;

import java.util.*;
import java.util.function.Predicate;

import beans.Client;
import commons.UnknownVehicleException;
import commons.Vehicle;

public class RentalAgency {

   private List<Vehicle> vehicles;
    private Map<Client, Vehicle> rentedVehicles;

    public RentalAgency() {
        vehicles = new ArrayList<>();
        this.rentedVehicles = new HashMap<>();
    }

    public RentalAgency(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        this.rentedVehicles = new HashMap<>();
    }

    public boolean add(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public void remove(Vehicle vehicle) throws UnknownVehicleException {

        if (!contains(vehicle))
            throw new UnknownVehicleException(vehicle);
        vehicles.remove(vehicle);
    }

    public boolean contains(Vehicle vehicle) {
        if (vehicles.contains(vehicle))
            return true;
        return false;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Vehicle> select(Predicate<Vehicle> criterion) {
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle vehicule : vehicles) {
            if (criterion.test(vehicule))
                list.add(vehicule);
        }
        return list;
    }

    public void printSelectedVehicles(Predicate<Vehicle> criterion) {

        List<Vehicle> list = new ArrayList<>();
        list = select(criterion);
        for (Vehicle vehicule : list) {
            System.out.println(vehicule);
        }

    }

    public double rentVehicle(Client client, Vehicle vehicle) throws UnknownVehicleException, IllegalStateException {

        if (!contains(vehicle)) {
            throw new UnknownVehicleException(vehicle);
        }
        if (vehicleIsRented(vehicle) || aVehicleIsRentedBy(client)) {
            throw new IllegalStateException();
        }
        rentedVehicles.put(client,vehicle);

        return vehicle.dailyRentalPrice();
    }

    public boolean aVehicleIsRentedBy(Client client) {
        return rentedVehicles.containsKey(client);
    }

    public boolean vehicleIsRented(Vehicle v) {
        return rentedVehicles.containsValue(v);
    }

    public void returnVehicle(Client client) {
        if (aVehicleIsRentedBy(client))
            rentedVehicles.remove(client);
    }

    public Collection<Vehicle> allRentedVehicles() {
        return rentedVehicles.values();
    }

}
