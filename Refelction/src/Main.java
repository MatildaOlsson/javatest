import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Volvo","V75",1996);

        Class<?> clazz = Car.class;
        Field[] lista = clazz.getDeclaredFields();

        try {
            Method method = clazz.getDeclaredMethod("secretMethod");
            method.invoke();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        String name = clazz.getName();



        System.out.println(name);

        System.out.println(lista);



    }
}