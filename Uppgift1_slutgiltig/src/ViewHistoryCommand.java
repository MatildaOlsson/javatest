import java.util.ArrayList;
import java.util.Scanner;

public class ViewHistoryCommand {

    public static void printYearHistory(ArrayList<Transaktioner> transaktioner) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type the year you want history: ");
        int choiceYear = input.nextInt();
        boolean empty = false;
        for (int i = 0; i < transaktioner.size(); i++) {
            if (choiceYear == transaktioner.get(i).year) {
                empty = true;
                System.out.println("Year: " + choiceYear + ": " + transaktioner.get(i).getSum());
            }
            else {
                System.out.println("History from year " + choiceYear + " not found");
                return;
            }
        }

    }

    public static void printMonthHistory(ArrayList<Transaktioner> transaktioner) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type the year you want history: ");
        int choiceYear = input.nextInt();
        System.out.println("Type the month you want history: ");
        int choiceMonth = input.nextInt();
        for (int i = 0; i < transaktioner.size(); i++) {
            if (choiceMonth == transaktioner.get(i).month && choiceYear == transaktioner.get(i).year) {
                System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ": " + transaktioner.get(i).getSum());
            }
            else {
                    System.out.println("History from year " + choiceYear + " not found");
            }
        }
    }
}
