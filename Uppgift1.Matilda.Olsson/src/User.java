import java.util.ArrayList;

public class User {
    private String name;
    ArrayList<Transaktioner> transactionIncome;
    ArrayList<Transaktioner> transactionExpense;

    public User(String name, ArrayList transactionIncome, ArrayList transactionExpense) {
        this.name = name;
        this.transactionIncome = transactionIncome;
        this.transactionExpense = transactionExpense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


