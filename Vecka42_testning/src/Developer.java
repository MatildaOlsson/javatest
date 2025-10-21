import java.util.Scanner;

public class Developer extends Employee{
    private int overtimeInHours;
    private double overtimeSalaryHourly;

    Developer (String name, double baseSalary, int overtimeInHours, double overtimeSalaryHourly) {
        super(name, baseSalary);
        this.overtimeInHours = overtimeInHours;
        this.overtimeSalaryHourly = overtimeSalaryHourly;

    }

    private double getOvertimeSalary() {
        return overtimeInHours * overtimeSalaryHourly;
    }

    @Override
    public double getSalary() {
       return super.getSalary() + getOvertimeSalary();
    }

    public static void calculateTotalIncome () {
        String name = "";
        double income = 0;
        int overtimeHours = 0;
        double overtimeSalary = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Print your name: ");
        name = scan.nextLine();
        System.out.println("Print your income: ");
        income = scan.nextDouble();
        System.out.println("Print overtime hours: ");
        overtimeHours = scan.nextInt();
        System.out.println("Print overtime salary");
        overtimeSalary = scan.nextDouble();


        Developer Developer = new Developer(name, income, overtimeHours, overtimeSalary);
        double totalSalary = Developer.getSalary();
        System.out.println("Your total income: " + totalSalary);

    }




}
