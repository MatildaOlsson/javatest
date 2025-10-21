public class Car extends Vehicle {
    private int numberOfDoors;

    Car(String brand, int year, double maxSpeed, double milesDriven, double feulCostPerLiter, int numberOfDoors) {
        super(brand, year, maxSpeed, milesDriven, feulCostPerLiter);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void startEngine() {
        super.startEngine();
    }

    @Override
    public double calculateFuelConsumption() {
        return fuelCostPerLiter * milesDriven;
    }
}
