import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterTransactionCommand {
    public static void executeRegistration(ArrayList<Transaktioner> transactionList, String typeOfTransaction, String currencyInput) {
        Scanner scanner = new Scanner(System.in);
        double transaction = 0.0;
        System.out.println("Please enter your " + typeOfTransaction + ":");

        try {
            if (typeOfTransaction.equals("expense")) {
                transaction = scanner.nextDouble() * -1;
            } else if (typeOfTransaction.equals("income")) {
                transaction = scanner.nextDouble();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number. If your number have an decimal, please use this ',' symbol"); // Detta tyckte jag blev lite skumt, brukar det inte vanligtvis vara '.' som man använder för att mata in double?
            return;
        }
        System.out.println("Do you want to add the transaction on current day? (Yes/No)");
        Scanner scan = new Scanner(System.in); //Behövde skapa en ny scanner då jag "blandar" datatyper (verkar det som)?
        String choice = scan.nextLine();
        int yearValue = 0;
        int monthValue = 0;
        String month = ""; //Lägger månaderna och dagarna som både String och Integers, då Integers behövs för veckouträckningen längre ner och String för att få formatet "dd" och "mm".
        int dayValue = 0;
        String day = "";
        int weekValue = weekOfDate2025(monthValue, dayValue);

        if (choice.contains("n")) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter the year of the transaction (yyyy)");
                yearValue = input.nextInt();
                System.out.println("Enter the month of the transaction (mm)");
                monthValue = input.nextInt();
                month = getStringFormatOfDayOrMonth(monthValue);
                System.out.println("Enter the day of the transaction (dd)");
                dayValue = input.nextInt();
                day = getStringFormatOfDayOrMonth(dayValue);
                weekValue = weekOfDate2025(monthValue, dayValue);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again with numbers representing year, month and day. ");
            }
            Transaktioner transaktion = new Transaktioner(transaction, weekValue, dayValue, monthValue, yearValue);
            transactionList.add(transaktion);
            System.out.println("Your transaction " + transaktion.getSum() + " " + currencyInput + " will be added on: " + yearValue + "-" + month + "-" + day);
        } else {
            LocalDate today = LocalDate.now();
            weekValue = 0;
            monthValue = today.getMonthValue();
            yearValue = today.getYear();
            dayValue = today.getDayOfMonth();
            if (yearValue == 2025) {
                weekValue = weekOfDate2025(monthValue, dayValue);
            }
            Transaktioner transaktion = new Transaktioner(transaction, weekValue, dayValue, monthValue, yearValue);
            transactionList.add(transaktion);
            System.out.println("Your transaction " + transaktion.getSum() + " " + currencyInput + " will be added on: " + today);
        }
    }


    public static Integer weekOfDate2025(int monthValue, int dayValue) {
        //Skapar en array med 13 platser där alla månaders dagar hårdkodas
        int[] dayOfMonth = new int[13];
        dayOfMonth[0] = 0;  //justerar index för att matcha månadsnummer
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
        return week;
    }

    public static String getStringFormatOfDayOrMonth(int dayOrMonthValue) {
        String dayOrMonthValueString;
        if (dayOrMonthValue < 10 && dayOrMonthValue > 0) {
            dayOrMonthValueString = "0" + dayOrMonthValue;
        } else {
            dayOrMonthValueString = "" + dayOrMonthValue;
        }
        return dayOrMonthValueString;
    }

    public static int getIntegerFormatOfString(String value) {
      return Integer.parseInt(value);
    }

}



