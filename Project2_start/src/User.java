import java.util.ArrayList;

public class User {
    protected String name;
    protected String currency;
    protected ArrayList<Transactions> transactions;

    User(String name, String currency, ArrayList<Transactions> transactions) {
        this.name = name;
        this.currency = currency;
        this.transactions = transactions;

    }
}
