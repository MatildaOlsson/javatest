import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.stream;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        List<String> names = Arrays.asList("Charlie", "Alice", "Monica", "Linnea");
//
//        names.sort((a,b) -> a.compareTo(b));
//        names.forEach(n -> System.out.println(n));
//
//        System.out.println("-------");
//
//        names.sort((a,b) -> b.compareTo(a));
//        names.forEach(n -> System.out.println(n));
//
//        System.out.println("------");
//
//        names.sort((String a, String b) -> Integer.compare(b.length(), a.length()));
//        names.forEach(n -> System.out.println(n));


//        ArrayList<Product> products = new ArrayList<>();
//        products.add(new Product("Laptop", 999.99));
//        products.add(new Product("Mus", 49.99));
//        products.add(new Product("Tangentbord", 79.99));
//        products.add(new Product("Apple iPad", 599.99));
//        products.add(new Product("Hörlurar", 199.99));
//
//        products.stream()
//                .filter(product -> product.getPrice() > 500)
//                .forEach(p -> System.out.println(p));
//
//        Object dyrast = products.stream()
//                .max(Comparator.comparingDouble(product -> product.getPrice()))
//                .get();
//
//        System.out.println("Din dyraste produkt: " + dyrast);
//
//        products.stream()
//                .filter(product -> product.getName().startsWith("H"))
//                .forEach(p -> System.out.println(p));



//        Calculator myCalculator = new Calculator();
//        Scanner input = new Scanner(System.in);
//        while (true) {
//
//            System.out.println("DIN MINIRÄKNARE: ");
//            System.out.println("First number: ");
//            double tal1 = input.nextDouble();
//            System.out.println("Select operatior: (+ , - , / , *)");
//            char operator = input.next().charAt(0);
//            System.out.println("Second number: ");
//            double tal2 = input.nextDouble();
//
//            if (operator == '*') {
//                System.out.println("Result: " + myCalculator.calculate(tal1, tal2, Operation.MULTIPLICATION));
//            } else if (operator == '+')
//                System.out.println("Result: " + myCalculator.calculate(tal1, tal2, Operation.ADDITION));
//            else if (operator == '-')
//                System.out.println("Result: " + myCalculator.calculate(tal1, tal2, Operation.SUBTRACTION));
//            else if (operator == '/')
//                System.out.println("Result: " + myCalculator.calculate(tal1, tal2, Operation.DIVISON));
//        }

        Predicate<String> emailValidation = s -> s.contains("@") && s.contains(".");
        Predicate<String> passwordValidation = s -> s.length() >= 8 && containsNumbers(s);
        Predicate<Integer> yearValidation = i ->  i > 13 && i < 120;
        Function<String, String> textToUppercase = s -> s.toUpperCase();
        Function<Boolean, String> printMessage = s -> s.

        //&& isNumeric(s);


        System.out.println(emailValidation.test("Hej@email.com"));
        System.out.println(passwordValidation.test("hejsanmamma1"));
        System.out.println(yearValidation.test(112));
        System.out.println(textToUppercase.apply("hejsan"));
        System.out.println();



    boolean validation1 = isNumeric("hej5");
    System.out.println("första:" + validation1);
    boolean validation2 = isNumeric("2323");
    System.out.println("andra: " + validation2) ;











    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return  false;
        }
    }

    public static boolean containsNumbers(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit((s.charAt(i)))) {
                return true;
            }
        }
        return false;

    }
}