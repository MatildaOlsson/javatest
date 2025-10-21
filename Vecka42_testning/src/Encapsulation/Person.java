package Encapsulation;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
       if (name == null || age < 0 || age > 100) {
           System.out.println("Invalid Input");
           return;
       }

       this.name = name;
       this.age = age;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge(String name) {
        return age;
    }
    public void setAge(int age) {
        if (age < 0 || age > 110) {
            throw new IllegalArgumentException("Age must be between 0 and 110");
        }
    }
    public static Person createPersonObject(String name, int age) {
        return new Person (name, age);
    }
}




