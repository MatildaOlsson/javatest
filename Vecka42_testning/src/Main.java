import java.util.Random;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//
//        Temperatur temperature = new Temperatur(30);
//        double tempFarenheit = temperature.getFahrenheitFromCelsius();
//        System.out.println("Fahrenheit is: " + tempFarenheit);
//
//        double tempCelcius = temperature.getCelsiusFromFahrenheit(tempFarenheit);
//        System.out.println("Celcius is: " + tempCelcius);

//        Bankaccount myBankaccount = new Bankaccount("12345", 1200);
//        myBankaccount.deposit(500);
//        myBankaccount.withdraw(200);
//        myBankaccount.getBalance();
//        myBankaccount.getBalanceWithNumber();

//        Car myCar = new Car("Volvo", 1999, 200, 4);
//        myCar.startEngine();
//        myCar.getBrand();


       //Developer.calculateTotalIncome();

//       Dog dog = new Dog();
//       dog.makeSound();
//       Cat cat = new Cat();
//       cat.makeSound();
//       Cow cow = new Cow();
//       cow.makeSound();


//      Car myCar = new Car("Volvo",2004, 202, 90, 1.6, 5);
//      double feulCost = myCar.calculateFuelConsumption();
//      System.out.println(feulCost);

//        NallePhu nallPhu = new NallePhu(2, "NallePhu", 40, 5);
//        HarryPotter harry = new HarryPotter(9, "Harry", 10);
//        nallPhu.performAttack(harry);

Circle circle1 = new Circle(10, "Grön");
Rectangle rectangle1 = new Rectangle(20,30, "Blå");
Circle circle2 = new Circle(14, "Rosa");
Rectangle rectangle2 = new Rectangle(11,22,"Gul");

Shape[] shapes = {circle1, circle2, rectangle1, rectangle2};

System.out.println(circle1.getRadius(circle1.getDiameter()));

double area = ShapeCalculator.calculateTotalArea(shapes);
System.out.println("Total area " + area);






















    }
}
