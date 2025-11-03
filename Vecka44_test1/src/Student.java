import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades;

    public Student(String name, Integer... grades) {
        this.name = name;
        this.grades = Arrays.asList(grades);
    }
    List<Student> students = Arrays.asList(
            new Student("Anna", 85, 92, 78, 96),
            new Student("Erik", 45, 67, 55, 49),
            new Student("Lisa", 88, 91, 84, 87),
            new Student("Carl", 72, 69, 77, 74),
            new Student("Sara", 95, 88, 92, 89)
    );

    public String getName() {
        return name;
    }
}
