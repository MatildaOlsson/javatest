import java.io.File;
import java.util.ArrayList;

public class User {
    protected String name;
    protected String currency;
    protected ArrayList<Transactions> transactions;
    protected File userFile;

    User(String name, String currency, ArrayList<Transactions> transactions, File userFile) {
        this.name = name;
        this.currency = currency;
        this.transactions = transactions;
        this.userFile = userFile;

    }
}
