import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in din dag");
        String day = input.nextLine();
        int nummer = Integer.parseInt(input.nextLine());

        DataBase db = new DataBase();

        db.create(day);

        db.read();

        db.create(day);


    }
}