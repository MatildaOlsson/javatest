import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
     ArrayList<Transactions> transactionList = new ArrayList<>();
     RegisterTransactionCommand incometran = new RegisterTransactionCommand("harald", "expense", "SEK", 0, 0, 0, 0,0, transactionList);
     incometran.execute();



    }
}