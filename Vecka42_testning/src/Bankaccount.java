public class Bankaccount {
    private double balance;
    private String number;

    public Bankaccount(String number, double balance) {
        this.balance = balance;
        this.number = number;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount && isAmountValid(amount)) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean deposit(double amount) {
       if (isAmountValid(amount)) {
           balance += amount;
           return true; //varför true och false?
       }
       return false;
    }

    public void getBalance() {
        System.out.println("Balance is: " + balance);
    }

    public void getBalanceWithNumber() {
        System.out.println("Balance is: " + balance);
        System.out.println("Number is: " + number);
    }

    private boolean isAmountValid (double amount) {
        if (amount >= 0)
        {return true;}

        return false;
    }
}

