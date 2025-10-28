import java.util.ArrayList;

public class ViewHistoryCommand extends Command {
    ArrayList<Transactions> transactionList = new ArrayList<>();

    ViewHistoryCommand(String name, ArrayList<Transactions> transactionList) {
        super(name);
        this.transactionList = transactionList;
    }

    @Override
    public void execute() {
        transactionList.stream()
                        .forEach(t-> System.out.println(t));
    }

    public static void viewTotalHistory(ArrayList<Transactions> transactionsArrayList) {
        System.out.println("Your transactions: ");
        for (Transactions t : transactionsArrayList) {
            System.out.println("Transaction: " + t);
        }

    }
}
