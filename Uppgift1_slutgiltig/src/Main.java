
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Application application = new Application();
      application.start();
//        Scanner input = new Scanner(System.in);
////        int inkomst = 0;
////        int utgift = 0;
////        int kontobalans = 0;
//        ArrayList<Integer> inkomstLista = new ArrayList<>();
//        ArrayList<Integer> utgiftLista = new ArrayList<>();
//        ArrayList<Transaktioner> transaktionIncome = new ArrayList<>();
//        ArrayList<Transaktioner> transaktionExpenses = new ArrayList<>();
//
//
//
//        while (true) {
//            System.out.println("-----YOUR PERSONAL-FINANCE-APPLICATION-----");
//            System.out.println("Make one of following choice: \n 1. Register income \n 2. Register expense \n 3. Delete transaction \n 4. View current account balance \n 5. View income history \n 6. View expense history \n 7. Exit");
//            int choice = input.nextInt();
//            switch (choice) {
//                case 1:
//                    incomeRegistration(transaktionIncome, inkomstLista);
//                    break;
//                case 2:
//                    expenseRegistration(transaktionExpenses, utgiftLista);
//                    break;
//                case 3:
//                    deleteTransaktion(transaktionIncome);
//                    break;
//                case 4:
//                    accountBalance(transaktionIncome,transaktionExpenses);
//                case 5:
//                    incomeHistory(transaktionIncome);
//                    break;
//                case 6:
//                    expenseHistory(transaktionExpenses);
//
//                case 7:
//                 break; //fungrar inte??
//
//
//
//            }
//
//            // Gå igenom metoderna och kör felhantering, try catch... etc...
//        }
    }

    public static void incomeRegistration(ArrayList<Transaktioner> transaktionerMedObjekt, ArrayList<Integer> inkomstLista) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in din inkomst: ");
        int income = input.nextInt();
        System.out.println("Vill du lägga in transaktionen på dagens datum? Ja/Nej");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();

        if (choice.equalsIgnoreCase("nej")) {
            System.out.println("Skriv in året enligt formatet yyyy");
            int yearValue = input.nextInt();
            System.out.println("Skriv in månaden enligt formatet mm");
            int monthValue = input.nextInt();
            System.out.println("Skriv in dagen enligt formatet dd"); // här blir det problem med sparandet om månad < 10 och dag < 10
            int dayValue = input.nextInt();
            int weekValue = weekOfDate2025(monthValue, dayValue);
            Transaktioner transaktion = new Transaktioner(income, weekValue, dayValue, monthValue, yearValue);
            System.out.println("din transaktion" + transaktion.getSum());
            transaktionerMedObjekt.add(transaktion);
            inkomstLista.add(income);
            System.out.println("Din transaktion sparas på datum: " + yearValue + "-" + monthValue + "-" + dayValue);
        } else {
            LocalDate today = LocalDate.now();
            int monthValue = today.getMonthValue();
            int yearValue = today.getYear();
            int dayValue = today.getDayOfMonth();
            int weekValue = weekOfDate2025(monthValue, dayValue);
            Transaktioner transaktion = new Transaktioner(income, weekValue, dayValue, monthValue, yearValue);
            transaktionerMedObjekt.add(transaktion);
            inkomstLista.add(income);
            System.out.println("Din transaktion sparas på datum: " + today);
        }
    }


    public static void incomeHistory(ArrayList<Transaktioner> transaktionerMedObjekt) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in året du önskar historik enligt formatet yyyy");
        int choiceYear = input.nextInt();
        boolean notEmpty = false;
        for (int i = 0; i < transaktionerMedObjekt.size(); i++) {
            if (choiceYear == transaktionerMedObjekt.get(i).year) {
                notEmpty = true;
                System.out.println("År " + choiceYear + ": " + transaktionerMedObjekt.get(i).getSum() + " SEK");
            }
            if (notEmpty == false) {
                System.out.println("Det finns ingen historik för valt år. Gör ett nytt val");
                return;
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
                        System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ": " + transaktionerMedObjekt.get(i).getSum() + " SEK");

                        System.out.println("Vill du även få statestik för specifik dag? ja/nej");
                        String choiceIfDay = scan.nextLine();
                        if (choiceIfDay.equalsIgnoreCase("ja")) {
                            System.out.println("Skriv datum för dagen du önskar historik");
                            int choiceDay = input.nextInt();
                            for (int j = 0; j < transaktionerMedObjekt.size(); j++) {
                                if (choiceDay == transaktionerMedObjekt.get(j).day && choiceMonth == transaktionerMedObjekt.get(j).month && choiceYear == transaktionerMedObjekt.get(j).year) {
                                    System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ", Dag: " + choiceDay + ":" + transaktionerMedObjekt.get(j).getSum() + " SEK");
                                    return;
                                } else {
                                    System.out.println("Det finns ingen historik för aktuell dag");
                                    return;
                                }
                            }
                        } else {
                            return;
                        }

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
                            System.out.println("Vecka " + choiceWeek + ": " + transaktionerMedObjekt.get(i).getSum() + " SEK");

                        else {
                            System.out.println("Det finns ingen historik för aktuell vecka");
                            return;
                        }
                    }
                }


            }
        }
    }


    public static void expenseRegistration(ArrayList<Transaktioner> transaktionExpenses, ArrayList<Integer> utgiftLista) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in din utgift: ");
        int expense =  input.nextInt();
        System.out.println("Vill du lägga in transaktionen på dagens datum? Ja/Nej");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();

        if (choice.equalsIgnoreCase("nej")) {
            System.out.println("Skriv in året enligt formatet yyyy");
            int yearValue = input.nextInt();
            System.out.println("Skriv in månaden (1-12)");
            int monthValue = input.nextInt();
            System.out.println("Skriv in dagen"); // här blir det problem med sparandet om månad < 10 och dag < 10
            int dayValue = input.nextInt();
            int weekValue = weekOfDate2025(monthValue, dayValue);
            Transaktioner transaktion = new Transaktioner(expense, weekValue, dayValue, monthValue, yearValue);
            System.out.println("din transaktion" + transaktion.toString());
            transaktionExpenses.add(transaktion);
            utgiftLista.add(expense);
            System.out.println("Din transaktion sparas på datum: " + yearValue + "-" + monthValue + "-" + dayValue);
        }
        else {
            LocalDate today = LocalDate.now();
            int monthValue = today.getMonthValue();
            int yearValue = today.getYear();
            int dayValue = today.getDayOfMonth();
            int weekValue = weekOfDate2025(monthValue, dayValue);
            Transaktioner transaktion = new Transaktioner(expense, weekValue, dayValue, monthValue, yearValue);
            transaktionExpenses.add(transaktion);
            utgiftLista.add(expense);
            System.out.println("Din transaktion sparas på datum: " + today);
        }
    }

    public static void expenseHistory(ArrayList<Transaktioner> transaktionExpenses) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in året du önskar historik enligt formatet yyyy");
        int choiceYear = input.nextInt();
        boolean notEmpty = false;
        for (int i = 0; i < transaktionExpenses.size(); i++) {
            if (choiceYear == transaktionExpenses.get(i).year) {
               notEmpty = true;
               System.out.println("År " + choiceYear + ": " + transaktionExpenses.get(i).getSum() + " SEK");
            }
               if (!notEmpty) {
               System.out.println("Det finns ingen historik för valt år. Gör ett nytt val i huvudmenyn");
               return;
            }
        }

        System.out.println("Vill du gå vidare, ja/nej");
        Scanner scan = new Scanner(System.in);
        String choiceFurther = scan.nextLine();
        System.out.println(choiceFurther);

        if (choiceFurther.equalsIgnoreCase("nej")) {
        System.out.println("Du återvänder till huvudmenyn");
        }

        else if (choiceFurther.equalsIgnoreCase("ja")) {
            System.out.println("Tryck 1. för måndadshistorik \nTryck 2. för veckohistorik");
            int choiceMonthOrWeek = input.nextInt();
            if (choiceMonthOrWeek == 1) {
            System.out.println("Skriv in månadsnummer (1-12)");
            int choiceMonth = input.nextInt();
                for (int i = 0; i < transaktionExpenses.size(); i++) {
                    if (choiceMonth == transaktionExpenses.get(i).month && choiceYear == transaktionExpenses.get(i).year) {
                        System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ": " + transaktionExpenses.get(i).getSum() + " SEK");

                        System.out.println("Vill du även få statestik för specifik dag? ja/nej");
                        String choiceIfDay = scan.nextLine();
                    if (choiceIfDay.equalsIgnoreCase("ja")) {
                        System.out.println("Skriv dagen (dd) du önskar historik");
                        int choiceDay = input.nextInt();
                        for (int j = 0; j < transaktionExpenses.size(); j++) {
                            if (choiceDay == transaktionExpenses.get(j).day && choiceMonth == transaktionExpenses.get(j).month && choiceYear == transaktionExpenses.get(j).year) {
                                System.out.println("År " + choiceYear + ", Månad " + choiceMonth + ", Dag: " + choiceDay + ":" + transaktionExpenses.get(j).getSum() + " SEK");
                                return;
                            } else {
                                System.out.println("Det finns ingen historik för aktuell dag");
                                return;
                            }
                        }
                    } else {
                        return;
                    }

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
                for (int i = 0; i < transaktionExpenses.size(); i++) {
                    if (choiceWeek == transaktionExpenses.get(i).week)
                        System.out.println("Vecka " + choiceWeek + ": " + transaktionExpenses.get(i).getSum() + " SEK");

                    else {
                        System.out.println("Det finns ingen historik för aktuell vecka");
                        return;
                    }
                }
            }


        }
    }
}



    public static void deleteTransaktion(ArrayList<Transaktioner> transaktionMedObjekt) {
        System.out.println("Välj den transaktion som du vill radera: ");
        Scanner input = new Scanner(System.in);
        int choice;
        for (int i = 0; i < transaktionMedObjekt.size(); i++) {
            System.out.println(i + 1 + ". " + transaktionMedObjekt.get(i).getSum() + " SEK" + " (" + transaktionMedObjekt.get(i).year + "-" + transaktionMedObjekt.get(i).month + "-" + transaktionMedObjekt.get(i).day + ")");
        }
        choice = input.nextInt() - 1;
        if (choice > 0 || choice < transaktionMedObjekt.size()) {
            System.out.println("Transktionen " + transaktionMedObjekt.get(choice).getSum() + " SEK kommer att raderas");
            transaktionMedObjekt.remove(choice);
        } else {
            System.out.println("Något gick fel. Försök igen genom att skriva in siffran för den transaktion du vill radera");
            return;
        }
    }

    public static double accountBalance(ArrayList<Transaktioner> transaktionMedObjekt, ArrayList<Transaktioner> transaktionExpenses) {
        double accountBalance = 0;
        double totalIncome = 0;
        double totalExpense = 0;
        for (int i = 0; i < transaktionMedObjekt.size(); i++) {
            totalIncome += transaktionMedObjekt.get(i).getSum();
        }
        System.out.println("Dina totala inkomster: " + totalIncome);

        for (int i = 0; i < transaktionExpenses.size(); i++) {
            totalExpense += transaktionExpenses.get(i).getSum();
        }
        System.out.println("Dina totala utgifter: " + totalExpense);
        accountBalance = totalIncome + totalExpense;
        System.out.println("Din nuvarande kontobalans är: " + accountBalance + " SEK");
        return accountBalance;
    }

    /**
     ** Retunerar veckan för ett aktuellt datum baserat på dag och månad
     * OBS aktuell metod fungerar endast för år 2025!
     * @param monthValue månad
     * @param dayValue dagen i aktuell månad
     * @return veckan (enligt ISO standard)
     */
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




