public class Car {
    private String brand;
    private String model;
    private int year;
    private static int carCount = 0;

    public Car() {}

    public Car(String brand, String model, int year){
            this.brand = brand;
            this.model = model;
            this.year = year;
            carCount++;
        }

        private void secretMethod () {
            System.out.println("This is a secret!");
        }

        public void start () {
            System.out.println("Car is starting...");
        }

    @Override
    public String toString() {
       return brand + " " + model + " " + year;
    }

    // Getters och setters
    }
