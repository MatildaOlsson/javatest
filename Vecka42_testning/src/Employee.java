public class Employee {
    protected String name;
    protected double baseSalary;

    Employee (String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

  public double getSalary () {
      return baseSalary;
  }

}
