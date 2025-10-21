import java.util.ArrayList;

public class User {
    protected String name;
    protected ArrayList<Transactions> transactions;

    User(String name, ArrayList<Transactions> transactions) {
        this.name = name;
        this.transactions = transactions;
    }
}
