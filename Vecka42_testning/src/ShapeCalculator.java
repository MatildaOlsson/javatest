public class ShapeCalculator {
    public static double calculateTotalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculateArea();
        }
        return total;
    }

    public void printShapeInfo(Shape shape) {
        System.out.println("Area " + shape.calculateArea());

        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            System.out.println("Radius: " + circle.getRadius(circle.getDiameter()));
        }
    }
}
