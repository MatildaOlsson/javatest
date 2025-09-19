import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.time.temporal.WeekFields;
import java.util.HashMap;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double inkomst = 0;
        double utgift = 0;
        double kontobalans = 0;
        ArrayList<Double> inkomstLista = new ArrayList<>();
        ArrayList<Double> utgiftLista = new ArrayList<>();
        ArrayList<Double> transaktioner = new ArrayList<>();
        ArrayList<Transaktioner> transaktionMedObjekt = new ArrayList<>();


        LocalDate today = LocalDate.now();


        System.out.println(today.toString());
        int monthValue = today.getMonthValue();
        int yearValue = today.getYear();
        int dayValue = today.getDayOfMonth();
        int previousMonthValue = monthValue - 1;
        int weekValue = (31 * previousMonthValue + dayValue) / 7; //en uppskattning...
        //System.out.println("månad: " + monthValue + " År " + yearValue + " Vecka " + weekValue + " Dag " + dayValue);

        System.out.println("Ditt datum " + skapaDatum(yearValue, monthValue, dayValue));
        int week = weekValue(yearValue, monthValue, dayValue);
        System.out.println(week);

        while (true) {
            System.out.println("-----DIN PERSONLIGA EKONOMIAPPLIKATION-----");
            System.out.println("Gör ett av följande val: \n 1. Registera inkomst \n 2. Registera utgift \n 3. Radera transaktioner \n 4. Se nuvarande kontobalans \n 5. Se historik");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    incomeRegistration(transaktioner, inkomstLista, inkomst);
                    break;
                case 2:
                    expenseRegistration(transaktioner, utgiftLista, utgift);
                    break;
                case 3:
                    deleteTransaktion(transaktioner, choice);
                    break;
                case 4:
                    accountBalance(inkomstLista, utgiftLista, inkomst, utgift, kontobalans);
                case 5:
                    System.out.println("Skriv in din inkomst");
                    Scanner imput = new Scanner(System.in);
                    int in = imput.nextInt();
                    Transaktioner transaktion = new Transaktioner(in, weekValue, dayValue, monthValue, yearValue);
                    transaktionMedObjekt.add(transaktion);

                    System.out.println("DINA TRANSKATIONER:");
                    for (int i = 0; i < transaktionMedObjekt.size(); i++) {
                        System.out.println(i + 1 + ". " + transaktionMedObjekt.get(i) + " SEK");



                    }
            }

            // Gå igenom metoderna och kör felhantering, try catch... etc...
        }
    }
        public static void incomeRegistration (ArrayList < Double > transaktioner, ArrayList < Double > inkomstLista,
        double income){
            Scanner input = new Scanner(System.in);
            System.out.println("Skriv in din inkomst: ");
            income = input.nextDouble();
            transaktioner.add(income);
            inkomstLista.add(income);
            System.out.println("Din inkomst sparas");
        }

        public static void expenseRegistration (ArrayList < Double > transaktioner, ArrayList < Double > utgiftLista,
        double expense){
            Scanner input = new Scanner(System.in);
            System.out.println("Skriv in din utgift: ");
            expense = input.nextDouble() * -1;
            transaktioner.add(expense);
            utgiftLista.add(expense);
            System.out.println("Din utgift sparas");
        }

        public static void deleteTransaktion (ArrayList < Double > transaktioner,int choice){
            System.out.println("Välj den transaktion som du vill radera: ");
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < transaktioner.size(); i++) {
                System.out.println(i + 1 + ". " + transaktioner.get(i) + " SEK");
            }
            choice = input.nextInt() - 1;
            if (choice > 0 || choice < transaktioner.size()) {
                System.out.println("Transktionen " + transaktioner.get(choice) + " kommer att raderas");
                transaktioner.remove(choice);
            } else {
                System.out.println("Något gick fel. Försök igen genom att skriva in siffran för den transaktion du vill radera");
                return;
            }
        }
        public static double accountBalance (ArrayList < Double > inkomstLista, ArrayList < Double > utgiftLista,
        double income, double expense, double accountBalance){
            for (int i = 0; i < inkomstLista.size(); i++) {
                income += inkomstLista.get(i);
            }
            System.out.println("Dina totala inkomster: " + income);
            for (int i = 0; i < utgiftLista.size(); i++) {
                expense += utgiftLista.get(i);
            }
            System.out.println("Dina totala utgifter: " + expense);
            accountBalance = income + expense;
            System.out.println("Din nuvarande kontobalans är: " + accountBalance + " SEK");
            return accountBalance;
        }

        public static LocalDate skapaDatum ( int yearValue, int monthValue, int dayValue){
            return LocalDate.of(yearValue, monthValue, dayValue);
        }


//    public static int weekValue (int yearValue, int monthValue, int dayValue, ) {
//        skapaDatum(yearValue, monthValue, dayValue);
//
//        if (monthValue <= 9) {
//            weekValue = (31 * (monthValue - 1) + dayValue) / 7; //en uppskattning...
//            System.out.println("månad: " + monthValue + " År " + yearValue + " Vecka " + weekValue + " Dag " + dayValue);
//
//        } else if (monthValue > 9 && monthValue <= 12) {
//            weekValue = (30 * (monthValue - 1) + dayValue) / 7;
//        }
//
//        return weekValue;

        public static int weekValue ( int yearValue, int monthValue, int dayValue){
            LocalDate date = skapaDatum(yearValue, monthValue, dayValue);
            int week = date.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
            return week;
        }


    }

