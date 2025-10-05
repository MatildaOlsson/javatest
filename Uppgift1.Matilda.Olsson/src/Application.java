import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public void start() {
        String nameInput = null;
        String currencyInput = null;
        ArrayList<Transaktioner> transaktionIncome = new ArrayList<>();
        ArrayList<Transaktioner> transaktionExpenses = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        nameInput = scan.nextLine();
        System.out.println("Enter your currency: ");
        currencyInput = scan.nextLine();
        System.out.println("Welcome to your personal-finance-application, " + nameInput + "!");
        User user = new User(nameInput, transaktionIncome, transaktionExpenses);

        while (true) {
            System.out.println("====YOUR PERSONAL-FINANCE-APPLICATION====");
            System.out.println("Make one of following choice:");
            System.out.println(" 1. Register income \n 2. Register expense \n 3. Delete income transaction \n 4. Delete expense transaction \n 5. View current account balance \n 6. View income history \n 7. View expense history \n 8. Exit");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your choice:");

            int commandChoice = input.nextInt();
            if (commandChoice == 8) {
                System.out.println("The application will close");
                return;
            }
            switch (commandChoice) {
                case 1:
                    RegisterTransactionCommand.executeRegistration(user.transactionIncome, "income", currencyInput);
                    break;
                case 2:
                    RegisterTransactionCommand.executeRegistration(user.transactionExpense, "expense", currencyInput);
                    break;
                case 3:
                    ManageTransactionCommand.deleteTransaction(user.transactionIncome, currencyInput);
                    break;
                case 4:
                    ManageTransactionCommand.deleteTransaction(user.transactionExpense, currencyInput);
                    break;
                case 5:
                    ManageTransactionCommand.getCurrentAccountBalance(user.transactionIncome, user.transactionExpense, currencyInput);
                    break;
                case 6:
                    transactionHistoryChoice(user.transactionIncome, currencyInput);
                    break;
                case 7:
                    transactionHistoryChoice(user.transactionExpense, currencyInput);
                    break;
            }
        }
    }

    public static void transactionHistoryChoice(ArrayList<Transaktioner> transactions, String currencyInput) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Make one of following choice to filter transaction history:");
        System.out.println(" 1. Year \n 2. Month \n 3. Day \n 4. Week");
        int choice = scan.nextInt();
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice");
        }
        switch (choice) {
            case 1:
                ViewHistoryCommand.printYearHistory(transactions, currencyInput);
                break;
            case 2:
                ViewHistoryCommand.printMonthHistory(transactions, currencyInput);
                break;
            case 3:
                ViewHistoryCommand.printDayHistory(transactions, currencyInput);
                break;
            case 4:
                ViewHistoryCommand.printWeekHistory(transactions, currencyInput);
                break;


        }
    }

}