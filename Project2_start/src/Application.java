import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

public class Application {
    protected String nameInput = null;
    protected String currencyInput = null;
    protected ArrayList<Transactions> transactionsList = new ArrayList<>();

    protected User user;
    protected RegisterTransactionCommand incomeRegistrationCommand;
    protected RegisterTransactionCommand expenseRegistrationCommand;
    protected DeleteTransactionCommand deleteTransactionCommand;
    protected ViewAccountBalanceCommand viewAccountBalanceCommand;
    protected ViewHistoryCommand viewHistoryCommand;
    protected FilterHistoryCommand filterHistoryCommand;


    public void start() {
        System.out.println("Enter name:");
        nameInput = Main.input.nextLine();
        System.out.println("Enter currency: ");
        currencyInput = Main.input.nextLine();
        System.out.println("Welcome to your personal-finance-application, " + nameInput + "!");

        user = new User(nameInput, currencyInput, transactionsList);
        incomeRegistrationCommand = new RegisterTransactionCommand(user.name, "income", currencyInput, 0, user.transactions);
        expenseRegistrationCommand = new RegisterTransactionCommand(user.name, "expense", currencyInput, 0, user.transactions);
        deleteTransactionCommand = new DeleteTransactionCommand(user.name, currencyInput, user.transactions);
        viewAccountBalanceCommand = new ViewAccountBalanceCommand(user.name, transactionsList);
        viewHistoryCommand = new ViewHistoryCommand("history", user.transactions);
        filterHistoryCommand = new FilterHistoryCommand("filterHistory", user.transactions);


        while (true) {
            System.out.println("====YOUR PERSONAL-FINANCE-APPLICATION====");
            System.out.println("Make one of following choice:");
            System.out.println(" 1. Register income \n 2. Register expense \n 3. Delete transaction \n 4. View current account balance \n 5. View transaction history \n 6. Filter transaction history \n 7. Exit");
            Scanner input = new Scanner(System.in);  // TODO Snyggare commandomany, se WIlliams project?
            System.out.println("Enter your choice:");

            int commandChoice = input.nextInt();

            switch (commandChoice) {
                case 1: incomeRegistrationCommand.execute();
                break;
                case 2: expenseRegistrationCommand.execute();
                break;
                case 3: deleteTransactionCommand.execute();
                break;
                case 4: viewAccountBalanceCommand.execute();
                break;
                case 5: viewHistoryCommand.execute();
                break;
                case 6: filterHistoryCommand.execute();
                break;
                case 7:
                    System.out.println("Application wil close");
                return;


            }
        }
    }
}