import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public void start() {
        String nameInput = null;
        ArrayList<Transaktioner> transaktionIncome = new ArrayList<>();
        ArrayList<Transaktioner> transaktionExpenses = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        nameInput = scan.nextLine();
        System.out.println("Welcome to your personal-finance-application " + nameInput + "!");
        User user = new User(nameInput, transaktionIncome, transaktionExpenses);

        while (true) {
            System.out.println("====YOUR PERSONAL-FINANCE-APPLICATION====");
            System.out.println("Make one of following choice:");
            System.out.println(" 1. Register income \n 2. Register expense \n 3. Delete transaction \n 4. View current account balance \n 5. View income history \n 6. View expense history \n 7. Exit");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your choice:");

            int commandChoice = input.nextInt();
            if (commandChoice == 7) {
                System.out.println("The application will close");
                return;
            }
            switch (commandChoice) {
                case 1:
                    RegisterTransactionCommand.executeRegistration(user.transactionIncome, "income");
                    break;
                case 2:
                    RegisterTransactionCommand.executeRegistration(user.transactionExpense, "expense");
                    break;
                case 3:
                    ManageTransactionCommand.deleteTransaction(user.transactionIncome, user.transactionExpense);
                    break;
                case 4:
                    ManageTransactionCommand.getCurrentAccountBalance(user.transactionIncome, user.transactionExpense);
                    break;
                case 5:
                    transactionHistoryChoice(user.transactionIncome);
                case 6:
                    transactionHistoryChoice(user.transactionExpense);
            }
        }
    }

    public static void transactionHistoryChoice(ArrayList<Transaktioner> transactions){
        Scanner scan = new Scanner(System.in);
        System.out.println("Make one of following choice to filter transaction history:");
        System.out.println(" 1. Year \n 2. Month \n 3. Day \n 4. Week");
        int choice = scan.nextInt();
        try {
            choice = scan.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid choice");
        }
        switch (choice) {
            case 1:
               ViewHistoryCommand.printYearHistory(transactions);
               break;
            case 2:
               ViewHistoryCommand.printMonthHistory(transactions);
               break;
            case 3:


        }
    }

}