import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Transaktioner> incomeList = new ArrayList<>();
        ArrayList<Transaktioner> expenseList = new ArrayList<>();

        executeRegistration(incomeList, "income");

    }
    public static void executeRegistration(ArrayList<Transaktioner> transactionList, String typeOfTransaction) {
        Scanner input = new Scanner(System.in);
        System.out.println("Plaas enter your " + typeOfTransaction + ":");
        int transaction = input.nextInt();
        System.out.println("Do you want to add the transaction on the day of today? (Yes/No)");
        Scanner scan = new Scanner(System.in); //Behövde skapa en ny scanner då jag "blandar" datatyper (verkar det som)?
        String choice = scan.nextLine();
        int yearValue = 0;
        int monthValue = 0;
        int dayValue = 0;

        if (choice.contains("n")) { //TODO Se till så men inte kan ange en felaktig månad eller dag
            try {
                System.out.println("Enter the year of the transaction (yyyy)");
                yearValue = input.nextInt();
                System.out.println("Enter the month of the transaction (mm)");
                monthValue = input.nextInt();
                System.out.println("Enter the day of the transaction (dd)");
                dayValue = input.nextInt(); }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again with an integer ");
            }
            int weekValue = weekOfDate2025(monthValue, dayValue);
            Transaktioner transaktion = new Transaktioner(transaction, weekValue, dayValue, monthValue, yearValue);
            System.out.println("Din transaktion: " + transaktion.getSum());
            transactionList.add(transaktion);
            System.out.println("Din transaktion sparas på datum: " + yearValue + "-" + monthValue + "-" + dayValue);
        } else {
            LocalDate today = LocalDate.now();
            monthValue = today.getMonthValue();
            yearValue = today.getYear();
            dayValue = today.getDayOfMonth();
            int weekValue = weekOfDate2025(monthValue, dayValue);
            Transaktioner transaktion = new Transaktioner(transaction, weekValue, dayValue, monthValue, yearValue);
            transactionList.add(transaktion);
            System.out.println("Din transaktion sparas på datum: " + today);
        }
    }

    public static Integer weekOfDate2025(int monthValue, int dayValue) {
        //Skapar en array med 13 platser där alla månaders dagar hårdkodas
        int[] dayOfMonth = new int[13];
        dayOfMonth[0] = 0;  //justera index för att matcha månadsnummer
        dayOfMonth[1] = 25; //januari (från den 6e januari)
        dayOfMonth[2] = 28; //februari
        dayOfMonth[3] = 31;
        dayOfMonth[4] = 30;
        dayOfMonth[5] = 31; // maj
        dayOfMonth[6] = 30;
        dayOfMonth[7] = 31;
        dayOfMonth[8] = 31;
        dayOfMonth[9] = 30;
        dayOfMonth[10] = 31;
        dayOfMonth[11] = 30; //november
        dayOfMonth[12] = 31;
        float totalDaysBeforeMonth = 0;
        int week = 0;

        //Loopar igenom alla månader innan aktuell månad för att få fram antal dagar
        for (int i = 0; i < monthValue; i++) {
            totalDaysBeforeMonth += dayOfMonth[i];
        }

        //Specialcase då första veckan i januari 2025 börjar en onsdag
        if (monthValue == 1 && dayValue <= 5) {
            week = 1;
        }
        //Spceicalräkning för januarimånad då den månaden inte följer samma mönster som övriga
        else if (monthValue == 1) {
            double sub = (totalDaysBeforeMonth + dayValue - 2) / 7;
            week = (int) Math.round(sub) + 1;
        }
        //Övriga månader år 2025
        else {
            double sub = (totalDaysBeforeMonth + dayValue + 4) / 7;
            week = (int) Math.round(sub) + 1;
        }
        // System.out.println("Vecka: " + week);
        return week;
    }
}