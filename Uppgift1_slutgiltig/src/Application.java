import java.util.ArrayList;
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


                }

        }
    }
}