import java.util.ArrayList;
import java.util.List;

public class NumberContainer <T extends Number> {
    private T number;
    private final List<T> numberList = new ArrayList<>();

//    public NumberContainer(T number) {
//        this.number = number;
//    }

    public void add(T number) {
        numberList.add(number);
    }

    public double getSum() {
        return numberList.stream()
                .mapToDouble(number -> number.doubleValue())
                .sum();
    }
    public double getAverage() {
        double sum = getSum();
        double numberOfUnits = numberList.size();

        return sum / numberOfUnits;
    }




}




