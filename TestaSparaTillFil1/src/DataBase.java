import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataBase {
    public static void create (String input) {
        try {
            FileWriter file = new FileWriter("database.txt", true);

            System.out.println(file);

            file.write(input);
            System.out.println("write complete");

            file.close();
            System.out.println("close complete");
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void read () {
        try {
            BufferedReader file = new BufferedReader(new FileReader("database.txt"));

            String line;
            while ((line = file.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }
}
