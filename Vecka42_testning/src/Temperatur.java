public class Temperatur {
    private double celsius;

    public Temperatur(double celsius) {
        this.celsius = celsius;
    }
    public double getCelsius() {
        return celsius;
    }
    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
    public double getFahrenheitFromCelsius() {
        return celsius * 1.8 + 32;
    }
    public double getCelsiusFromFahrenheit(double fahrenheit) {
        return celsius = (fahrenheit -32) / 1.8;
    }
}


