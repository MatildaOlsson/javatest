import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewHistoryCommand {

    public static void printYearHistory(ArrayList<Transaktioner> transaktioner, String currencyInput) {
        Scanner input = new Scanner(System.in);
        int choiceYear = 0;
        System.out.println("Type the year you want history (format yyyy): ");
        try {
            choiceYear = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again with an integer representing a year");
        }
        boolean notEmpty = false;
        for (int i = 0; i < transaktioner.size(); i++) {
            if (choiceYear == transaktioner.get(i).year) {
                System.out.println("Year " + choiceYear + ": " + transaktioner.get(i).getSum() + " " + currencyInput);
                notEmpty = true;
            }
        }
        if (!notEmpty) {
            System.out.println("History from year " + choiceYear + " not found");
        }
    }

    public static void printMonthHistory(ArrayList<Transaktioner> transaktioner, String currencyInput) {
        Scanner input = new Scanner(System.in);
        int choiceYear = 0;
        int choiceMonth = 0;
        try {
            System.out.println("Type the year you want history (format yyyy): ");
            choiceYear = input.nextInt();
            System.out.println("Type the month you want history (format mm): ");
            choiceMonth = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again with an integer");
        }

        boolean notEmpty = false;
        for (int i = 0; i < transaktioner.size(); i++) {
            if (choiceYear == transaktioner.get(i).year && choiceMonth == transaktioner.get(i).month) {
                System.out.println("Year: " + choiceYear + ", Month: " + choiceMonth + ": " + transaktioner.get(i).getSum() + " " + currencyInput);
                notEmpty = true;
            }
        }
        if (!notEmpty) {
            System.out.println("History from that year and month not found");
        }
    }

    public static void printDayHistory(ArrayList<Transaktioner> transaktioner, String currencyInput) {
        Scanner input = new Scanner(System.in);
        int choiceYear = 0;
        int choiceMonth = 0;
        int choiceDay = 0;
        try {
            System.out.println("Type the year you want history (format yyyy): ");
            choiceYear = input.nextInt();
            System.out.println("Type the month you want history (format mm): ");
            choiceMonth = input.nextInt();
            System.out.println("Type the day you want history (format dd): ");
            choiceDay = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again with an integer");
        }
        boolean notEmpty = false;
        for (int i = 0; i < transaktioner.size(); i++) {
            if (choiceYear == transaktioner.get(i).year && choiceMonth == transaktioner.get(i).month && choiceDay == transaktioner.get(i).day) {
                System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ", Dag: " + choiceDay + ": " + transaktioner.get(i).getSum() + currencyInput);
                notEmpty = true;
            }
        }
        if (!notEmpty) {
            System.out.println("History from that day not found");
        }
    }

    public static void printWeekHistory(ArrayList<Transaktioner> transaktioner, String currencyInput) {
        Scanner input = new Scanner(System.in);
        int choiceYear = 0;
        int choiceWeek = 0;
        try {
            System.out.println("Type the year you want history (format yyyy): ");
            choiceYear = input.nextInt();
            System.out.println("Type the week you want history: ");
            choiceWeek = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again with an integer representing year");
        }
        if (choiceYear != 2025) {
            System.out.println("Unfortunately its not possible (at the moment) to get week history from that year");
        }
        boolean notEmpty = false;

        for (int i = 0; i < transaktioner.size(); i++) {
            if (choiceWeek == transaktioner.get(i).week) {
                System.out.println("Year 2025, Week " + choiceWeek + ": " + transaktioner.get(i).getSum() + " " + currencyInput);
                notEmpty = true;
            }
        }
        if (!notEmpty) {
            System.out.println("History from that week not found");
        }


    }
}