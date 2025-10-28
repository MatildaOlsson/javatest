import java.util.ArrayList;
import java.util.Scanner;

public class DeleteTransactionCommand extends Command {
    ArrayList<Transactions> transactionList;
    String currency;

    DeleteTransactionCommand(String name,String currency, ArrayList<Transactions> transactionList) {
        super(name);
        this.currency = currency;
        this.transactionList = transactionList;

    }
    @Override
    public void execute() {
        System.out.println("Please select the transaction you want to delete: ");
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.println(i + 1 + ". " + transactionList.get(i).getSum() + " " + currency + " (" + transactionList.get(i).year + "-" + transactionList.get(i).month + "-" + transactionList.get(i).day + ")");
        }
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt() - 1;
        try {
            if (choice > 0 || choice < transactionList.size()) {
                System.out.println("The transaction " + transactionList.get(choice).getSum() + " " + currency+ " will be deleted.");
                transactionList.remove(choice);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid input. There where no such transaction found");
        }
    } // TODO Lägga till UUID borttagning för säkerhet?



    }



