public class Rectangle extends Shape implements Drawable, Resizable{
    private double legnth;
    private double hight;

    Rectangle (double legnth, double hight, String color){
        this.legnth = legnth;
        this.hight = hight;
        this.color = color;

    }
    @Override
    public void draw() {
        System.out.println("Drawing an rectangle");

    }

    @Override
    public void move(int x, int y) {


    }

    @Override
    public void resize(double factor) {

    }

    @Override
    public double calculateArea() {
        return legnth * hight;
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }
}
