import java.util.ArrayList;

public class User {
    private String name;
    ArrayList<Transaktioner> transactionIncome;
    ArrayList<Transaktioner> transactionExpense;
    ArrayList<Transaktioner> allTransactions;

    public User (String name, ArrayList transactionIncome, ArrayList transactionExpense) {
        this.name = name;
        this.transactionIncome = transactionIncome;
        this.transactionExpense = transactionExpense;
        this.allTransactions = transactionExpense;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}


