public abstract class Vehicle {
    protected String brand;
    protected int year;
    protected double maxSpeed;
    protected double milesDriven;
    protected final double fuelCostPerLiter;

    Vehicle(String brand, int year, double maxSpeed, final double fuelCostPerLiter, double milesDriven) {
        this.brand = brand;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.fuelCostPerLiter = fuelCostPerLiter;
        this.milesDriven = milesDriven;
    }

    public void startEngine() {
        System.out.println("Engine of your " + brand + " starts");
    }

    public abstract double calculateFuelConsumption();

    public void getBrand () {
        System.out.println(brand);
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }
}
