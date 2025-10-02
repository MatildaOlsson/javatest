import java.util.ArrayList;
import java.util.Scanner;

public class ManageTransactionCommand {

    public static void deleteTransaction(ArrayList<Transaktioner> transaktionIncome, ArrayList<Transaktioner> transaktionExpenses) {
            transaktionIncome.addAll(transaktionExpenses);
            System.out.println("Please select the transaction you want to delete: ");
            for (int i = 0; i < transaktionIncome.size(); i++) {
                System.out.println(i + 1 + ". " + transaktionIncome.get(i).getSum() + " SEK" + " (" + transaktionIncome.get(i).year + "-" + transaktionIncome.get(i).month + "-" + transaktionIncome.get(i).day + ")");
            }
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt() - 1;
            if (choice > 0 || choice < transaktionIncome.size()) {
                System.out.println("The transaction " + transaktionIncome.get(choice).getSum() + " will be deleted.");
                transaktionIncome.remove(choice);
            } else {
                System.out.println("Something went wrong. Try again by select the number of the transaction you want to delete: .");
            }
        }

    public static double getCurrentAccountBalance(ArrayList<Transaktioner> transaktionIncome, ArrayList<Transaktioner> transaktionExpenses) {
        double accountBalance = 0;
        double totalIncome = 0;
        double totalExpense = 0;
        for (int i = 0; i < transaktionIncome.size(); i++) {
            totalIncome += transaktionIncome.get(i).getSum();
        }
        System.out.println("Your total income: " + totalIncome);
        for (int i = 0; i < transaktionExpenses.size(); i++) {
            totalExpense += transaktionExpenses.get(i).getSum();
        }
        System.out.println("Your total expenses: " + totalExpense);
        accountBalance = totalIncome - totalExpense;
        System.out.println("Current account balance: " + accountBalance);
        return accountBalance;
    }


}



