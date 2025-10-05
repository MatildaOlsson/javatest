import java.util.ArrayList;
import java.util.Scanner;

public class ManageTransactionCommand {

    public static void deleteTransaction(ArrayList<Transaktioner> transaktion, String currencyInput) {
        System.out.println("Please select the transaction you want to delete: ");
        for (int i = 0; i < transaktion.size(); i++) {
            System.out.println(i + 1 + ". " + transaktion.get(i).getSum() + " " + currencyInput + " (" + transaktion.get(i).year + "-" + transaktion.get(i).month + "-" + transaktion.get(i).day + ")");
        }
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt() - 1;
        try {
            if (choice > 0 || choice < transaktion.size()) {
                System.out.println("The transaction " + transaktion.get(choice).getSum() + " " + currencyInput + " will be deleted.");
                transaktion.remove(choice);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid input. There where no such transaction found");
        }
    }

    public static double getCurrentAccountBalance(ArrayList<Transaktioner> transaktionIncome, ArrayList<Transaktioner> transaktionExpenses, String currencyInput) {
        double accountBalance = 0;
        double totalIncome = 0;
        double totalExpense = 0;
        for (int i = 0; i < transaktionIncome.size(); i++) {
            totalIncome += transaktionIncome.get(i).getSum();
        }
        System.out.println("Your total income: " + totalIncome + " " + currencyInput);
        for (int i = 0; i < transaktionExpenses.size(); i++) {
            totalExpense += transaktionExpenses.get(i).getSum();
        }
        System.out.println("Your total expenses: " + totalExpense + " " + currencyInput);
        accountBalance = totalIncome + totalExpense;
        System.out.println("Current account balance: " + accountBalance + " " + currencyInput);
        return accountBalance;
    }
}



