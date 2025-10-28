import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.stream;

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


        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 999.99));
        products.add(new Product("Mus", 49.99));
        products.add(new Product("Tangentbord", 79.99));
        products.add(new Product("Apple iPad", 599.99));
        products.add(new Product("Hörlurar", 199.99));

        products.stream()
                .filter(product -> product.getPrice() > 500)
                .forEach(p -> System.out.println(p));

        Object dyrast = products.stream()
                .max(Comparator.comparingDouble(product -> product.getPrice()))
                .get();

        System.out.println("Din dyraste produkt: " + dyrast);

        products.stream()
                .filter(product -> product.getName().startsWith("H"))
                .forEach(p -> System.out.println(p));












    }
}