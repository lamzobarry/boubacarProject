package commons;

public abstract interface Vehicle {

    public abstract String getBrand();
    public abstract String getModel();
    public abstract int getProductionYear();
    public abstract double dailyRentalPrice();
    public abstract boolean equals(Object o);
    public abstract String toString();

}
