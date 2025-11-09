import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        String katt = "kattenGustav";
//
//        int tal = 4;
//
//        UnsafeBox unsafeBox = new UnsafeBox();
//
//        unsafeBox.store(katt);
//        int getCat = Integer.parseInt();
//        System.out.println(getCat);
//
//        SafeBox<String> safeBox = new SafeBox<>();
//        SafeBox<Integer> safeBox1 = new SafeBox<>();
//
//        safeBox.store(katt);
//        String getCat = safeBox.retrieve();
//        System.out.println(getCat);
//
//        safeBox1.store(tal);
//        System.out.println(safeBox1.retrieve());

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(35);
        numbers.add(-36);
        numbers.add(3);

        NumberContainer <Double> temps1 = new NumberContainer<>();
        NumberContainer<Integer> temps2 = new NumberContainer<>();
        NumberContainer<Number> temps = new NumberContainer<>();

        NumberContainer<?> temps3 = new NumberContainer<>();

        temps.add(23.5);
        temps.add(18.2);
        temps.add(31.7);
        temps.add(15.8);
        temps.add(19);
        temps.add(25);
        temps.add(17);
        temps.add(22);

        System.out.println("Medelvärde : " + temps.getAverage());



//
//        int max = -1000;
//        int min = 1000;
//
//        for (Integer n : numbers){
//            if (max < n) {
//               max = n;
//            }
//            else if (min > n){
//                min = n;
//            }
//        }
//        System.out.println("Min = " + min + " Max = " + max);

        Pair<Integer, Integer> maxOchMin = findMinMax(numbers);
        System.out.println(maxOchMin);

    }

    public static Pair<Integer,Integer> findMinMax(List<Integer> numbers) {
        int max = -1000;
        int min = 1000;

        for (Integer n : numbers){
            if (max < n) {
               max = n;
            }
            else if (min > n){
                min = n;
            }
        }

        System.out.println("Min = " + min + "Max = " + max);

        return new Pair<>(min, max);
    }
}