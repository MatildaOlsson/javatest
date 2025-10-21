import java.sql.SQLOutput;
import java.lang.Math;

public class Circle extends Shape implements Drawable, Resizable{
    private double diameter;


    Circle (double diameter, String color) {
        this.diameter = diameter;
        this.color = color;

    }
    @Override
    public void draw() {
        System.out.println("Draving a circle");

    }

    public double getDiameter(){
        return diameter;
    }

    public double getRadius(double diameter) {
        return diameter / 2;
    }

    @Override
    public void move(int x, int y) {
        if (x < 0 && y < 0) {
            System.out.println("Cirkeln flyttas till höger");
        }
        else if (x > 0 && y < 0) {
            System.out.println("Cirkeln flyttas nedåt");
        }
        else if (x > 0 && y > 0) {
            System.out.println("Cirklen flyttas uppåt");
        }
        else {
            System.out.println("Cirklen flyttas åt vänster");

        }
    }

    @Override
    public void resize(double factor) {

    }

    @Override
    public double calculateArea() {
        return getRadius(diameter) * getRadius(diameter) * Math.PI;
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }
}
