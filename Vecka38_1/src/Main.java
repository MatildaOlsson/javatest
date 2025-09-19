import javax.swing.*;
import java.io.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         //Skapar en fil och skriver i den, skickar in genom att anropa "close"
        try {

            File fil = new File("minfil.txt");
            FileWriter skrivare = new FileWriter("minfil.txt");
            skrivare.write("Sådär, nu ska vi see....");
            skrivare.close();

        }
        catch (IOException e) {
            System.out.println("Ett fel uppstod");
        }


        //Läser in text från fil mha Bufferedreader
        try {
            BufferedReader reader = new BufferedReader(new FileReader("minfil.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        catch (IOException e) {
            System.out.println("Ett fel uppstod");
        }


    }
}