import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.time.temporal.WeekFields;
import java.util.HashMap;
//import java.lang.Math;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inkomst = 0;
        double utgift = 0;
        double kontobalans = 0;
        ArrayList<Integer> inkomstLista = new ArrayList<>();
        ArrayList<Double> utgiftLista = new ArrayList<>();
        ArrayList<Double> transaktioner = new ArrayList<>();
        ArrayList<Transaktioner> transaktionMedObjekt = new ArrayList<>();
        System.out.println("Metodtest:" + weekOfDate2025(3, 17));
        System.out.println("--------");





        int[] dayOfMonth = new int[13];
        int days = 0;
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

        int manad = 1;
        float totalDaysBeforeMonth = 0;
        int week = 0;
        int day = 31; //dag 10

        // antal dagar till månadsskifte
        for (int i = 0; i < manad; i++) {
            totalDaysBeforeMonth+= dayOfMonth[i];

        }
        // hårdkodad första och andra veckan 2025
        if (manad == 1 && day <= 5) {
            week = 1;
        }
        else if (manad == 1) {
            double sub = (totalDaysBeforeMonth+ day - 2) / 7;
            week = (int)Math.round(sub) + 1;

        }
        else {
            // -- Debugging
            //int totalDaysSubtraktion = totaldays - dayOfMonth[manad];
            System.out.println("totala dagar: " + totalDaysBeforeMonth);
            System.out.println("*" + dayOfMonth[manad]);
           // System.out.println("T" + totalDaysSubtraktion);
            System.out.println("Dag: " + day);
            // --

            // 2025-03-14
            // totalDaysBeforeMonth + day + 1 / 7
            // (53 + 14 + 1) / 7 = 9
            double sub = (totalDaysBeforeMonth+ day + 4) / 7;
            double test1 = (totalDaysBeforeMonth+ day + 1);
            System.out.println("D1: (kan bli decimaltal pga division " + sub);
            System.out.println("Test1 (kan inte bli decimaltal: " + test1);

            //week = (int)sub;

           week = (int)Math.round(sub) + 1;
        }




        System.out.println("Vecka: " + week);

//        HashMap<Integer, HashMap> outer = new HashMap<>();
//        //loop 1
//        HashMap<String, Integer> inner = new HashMap<>();
//        inner.put("year", 2025);
//        inner.put("month", 2);
//        inner.put("day", 1);
//        inner.put("amount", 2321);
//        outer.put(1, inner);
//        //loop 2
//        HashMap<String, Integer> inner2 = new HashMap<>();
//        inner2.put("year", 2025);
//        inner2.put("month", 2);
//        inner2.put("day", 3);
//        inner2.put("amount", 21);
//        outer.put(2, inner2);
////        outer.get(1).get("year");
//        System.out.println(outer);

        LocalDate today = LocalDate.now();


        System.out.println(today.toString());
        int monthValue = today.getMonthValue();

        System.out.println("Månad:" +monthValue);
        int yearValue = today.getYear();
        int dayValue = today.getDayOfMonth();
        int previousMonthValue = monthValue - 1;
        int weekValue = (31 * previousMonthValue + dayValue) / 7; //en uppskattning...
        //System.out.println("månad: " + monthValue + " År " + yearValue + " Vecka " + weekValue + " Dag " + dayValue);

//        System.out.println("Ditt datum " + skapaDatum(yearValue, monthValue, dayValue));
////        int week = weekValue(yearValue, monthValue, dayValue);
//        System.out.println(week);

        while (true) {
            System.out.println("-----DIN EKONOMIAPPLIKATION-----");
            System.out.println("Gör ett av följande val: \n 1. Registera inkomst \n 2. Registera utgift \n 3. Radera transaktioner \n 4. Se nuvarande kontobalans \n 5. Se inkomsthistorik \n 6. Se utgiftshistorik \n 7. Avsluta applikationen" );
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    incomeRegistration(transaktionMedObjekt, inkomstLista, inkomst);
                    break;
                case 2:
                    expenseRegistration(transaktioner, utgiftLista, utgift);
                    break;
                case 3:
                    deleteTransaktion(transaktioner, choice);
                    break;
//              case 4:
//                    accountBalance(inkomstLista, utgiftLista, inkomst, utgift, kontobalans);
                case 5:
                    incomeHistory(transaktionMedObjekt, inkomst);
                    break;
                case 6:
                    //expenseHistory


            }

            // Gå igenom metoderna och kör felhantering, try catch... etc...
        }
    }
        public static void incomeRegistration (ArrayList < Transaktioner > transaktionerMedObjekt, ArrayList < Integer > inkomstLista,
        int income){
            Scanner input = new Scanner(System.in);
            LocalDate today = LocalDate.now();
            int monthValue = today.getMonthValue();
            int yearValue = today.getYear();
            int dayValue = today.getDayOfMonth();
            int weekValue = weekOfDate2025(monthValue, dayValue);
            System.out.println("Skriv in din inkomst: ");
            income = input.nextInt();

            Transaktioner transaktion = new Transaktioner(income, weekValue, dayValue, monthValue, yearValue);
            transaktionerMedObjekt.add(transaktion);
            inkomstLista.add(income);


            System.out.println("Din inkomst sparas");
            for (int i = 0; i < transaktionerMedObjekt.size(); i++) {
                System.out.println(transaktionerMedObjekt.get(i).toString());
            }


        }

        public static void incomeHistory (ArrayList < Transaktioner > transaktionerMedObjekt, int income) {
            System.out.println("Skriv in året enligt yyyy för då du vill se historik");
            System.out.println("Skriv in månadsnummer (1-12)");
            System.out.println("Skriv in");
            System.out.println("Gör ett av följande val nedan för att filtera inkomsthistorik:");
            System.out.println(" 1. År \n 2. Vecka \n 3. Månad \n 4. Specifik dag");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
//                case 1:
//                    System.out.println("För vilken dag vill du se dina inkomster, skriv enligt yyyy-mm-dd");
//                    String choice2 = input.nextLine();
//                    if (choice2.equalsIgnoreCase(transaktionerMedObjekt.get(i).getDate())) {}

                case 2:
                    System.out.println("Skriv in veckonummer för den vecka du vill se historik");
                    int choice3 = input.nextInt();
                    for (int i = 0; i < transaktionerMedObjekt.size(); i++) {
                        if (choice3 == transaktionerMedObjekt.get(i).week)
                            System.out.println("Vecka " + choice3 + ": " + transaktionerMedObjekt.get(i).sum + " SEK");
                    }
                case 3:
                    System.out.println("Skriv in vilken månad du vill se historik (1-12)");
                    int choice4 = input.nextInt();
                    for (int i = 0; i < transaktionerMedObjekt.size(); i++) {
                        if (choice4 == transaktionerMedObjekt.get(i).month)
                            System.out.println("Månad " + choice4 + ": " + transaktionerMedObjekt.get(i).sum + " SEK");

                    }
                case 4:
                    System.out.println("Skriv in året du önskar historik enligt formatet yyyy");
                    int choiceYear = input.nextInt();
                    boolean notEmpty = false;
                    for (int i = 0; i < transaktionerMedObjekt.size(); i++) {
                        if (choiceYear == transaktionerMedObjekt.get(i).year) {
                            notEmpty = true;
                            System.out.println("År " + choiceYear + ": " + transaktionerMedObjekt.get(i).sum + " SEK");
                        }
                        if (notEmpty == false) {
                            System.out.println("Det finns ingen historik för valt år. Gör ett nytt val");
                            return ;
                        }
                    }

                    System.out.println("Vill du gå vidare, ja/nej");
                    Scanner scan = new Scanner(System.in);
                    String choiceFurther = scan.nextLine();
                    System.out.println(choiceFurther);
                    if (choiceFurther.equalsIgnoreCase("nej")) {
                        System.out.println("Du återvänder till huvudmenyn");
                        return;
                    } else if (choiceFurther.equalsIgnoreCase("ja")) {
                        System.out.println("Tryck 1. för måndadshistorik \nTryck 2. för veckohistorik");
                        int choiceMonthOrWeek = input.nextInt();
                        if (choiceMonthOrWeek == 1) {
                            System.out.println("Skriv in månadsnummer (1-12)");
                            int choiceMonth = input.nextInt();
                            for (int i = 0; i < transaktionerMedObjekt.size(); i++) {
                                if (choiceMonth == transaktionerMedObjekt.get(i).month && choiceYear == transaktionerMedObjekt.get(i).year) {
                                    System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ": " + transaktionerMedObjekt.get(i).sum + " SEK");

                                    System.out.println("Vill du även få statestik för specifik dag? ja/nej");
                                    String choiceIfDay = scan.nextLine();
                                    if (choiceIfDay.equalsIgnoreCase("ja")) {
                                        System.out.println("Skriv datum för dagen du önskar historik");
                                        int choiceDay = input.nextInt();
                                        for  (int j = 0; j < transaktionerMedObjekt.size(); j++) {
                                            if (choiceDay == transaktionerMedObjekt.get(j).day && choiceMonth == transaktionerMedObjekt.get(j).month && choiceYear == transaktionerMedObjekt.get(j).year) {
                                                System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ", Dag: " + choiceDay + ":" + transaktionerMedObjekt.get(j).sum + " SEK");
                                                return;
                                            }
                                            else {
                                                System.out.println("Det finns ingen historik för aktuell dag");
                                                return;
                                            }
                                        }
                                    }
                                    else { return; }

                                } else
                                    System.out.println("Det finns ingen historik registerad för vald månad");

                            }


                        } else if (choiceMonthOrWeek == 2) {
                            if (choiceYear != 2025) {
                                System.out.println("Det är inte möjligt att få historik för valt år tyvärr");
                                return;
                            } else {
                                System.out.println("Skriv in veckonummer för den vecka du vill se historik");
                                int choiceWeek = input.nextInt();
                                for (int i = 0; i < transaktionerMedObjekt.size(); i++) {
                                    if (choiceWeek == transaktionerMedObjekt.get(i).week)
                                        System.out.println("Vecka " + choiceWeek + ": " + transaktionerMedObjekt.get(i).sum + " SEK");

                                    else {
                                        System.out.println("Det finns ingen historik för aktuell vecka");
                                        return;
                                    }
                                }
                            }

//                            System.out.println("Skriv in månadsnummer (1-12)");
//                            int choice8 = input.nextInt();
//                            for (int i = 0; i <= transaktionerMedObjekt.size(); i++) {
//                                if (choice8 == transaktionerMedObjekt.get(i).month && choiceYear == transaktionerMedObjekt.get(i).year) {
//                                    System.out.println("År " + choiceYear + ", Månad " + choice8 + ": " + transaktionerMedObjekt.get(i).sum + " SEK");
//                                }  //Här printas bara första transaktionen ut, varför?
//                                else
//                                    System.out.println("Det finns ingen historik registerad för vald månad");
//                            }


                        }
                    }
            }
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

        public static Integer weekOfDate2025 (int monthValue, int dayValue){
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
                totalDaysBeforeMonth+= dayOfMonth[i];
            }

            //Specialcase då första veckan i januari 2025 börjar en onsdag
            if (monthValue == 1 && dayValue <= 5) {
                week = 1;
            }
            //Spceicalräkning för januarimånad då den månaden inte följer samma mönster som övriga
            else if (monthValue == 1) {
                double sub = (totalDaysBeforeMonth+ dayValue - 2) / 7;
                week = (int)Math.round(sub) + 1;
            }
            //Övriga månader år 2025
            else {
                double sub = (totalDaysBeforeMonth+ dayValue + 4) / 7;
                week = (int)Math.round(sub) + 1;
            }
            // System.out.println("Vecka: " + week);
            return week;
        }

//
//    public static int weekValueEstimate (int yearValue, int monthValue, int dayValue) {
//        skapaDatum(yearValue, monthValue, dayValue);
//
//        int weekValue = 0;
//
//        if (monthValue <= 9) {
//            weekValue = (30 * (monthValue - 1) + dayValue) / 7; //en uppskattning...
//            System.out.println("månad: " + monthValue + " År " + yearValue + " Vecka " + weekValue + " Dag " + dayValue);
//
//        } else if (monthValue > 9 && monthValue <= 12) {
//            weekValue = (30 * (monthValue - 1) + dayValue) / 7;
//        }
//
//        return weekValue;

//        public static int weekValue ( int yearValue, int monthValue, int dayValue){
//            LocalDate date = skapaDatum(yearValue, monthValue, dayValue);
//            int week = date.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
//            return week;
//        }


    }


