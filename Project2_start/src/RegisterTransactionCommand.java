import java.util.ArrayList;
import java.time.LocalDate;

public class RegisterTransactionCommand extends Command {
    protected ArrayList<Transactions> transactionList;
    protected String fileName;
    protected double sum;
    protected String type;
    protected String currency;

    LocalDate today = LocalDate.now();
    protected int day = today.getDayOfMonth();
    protected int month = today.getMonthValue();
    protected int year = today.getYear();
    protected String week;

    public RegisterTransactionCommand(String name, String fileName, String type, String currency, double sum, ArrayList<Transactions> transactionlist) {
        super(name);
        this.fileName = fileName;
        this.type = type;
        this.sum = sum;
        this.currency = currency;
        this.transactionList = transactionlist;
    }

    @Override
    public void execute() {
        sum = registerSum(type);
        saveTransactionToArrayList(sum, fileName); // Dessa bör kanske bakas ihop??
    }

    protected double registerSum(String type) {
        System.out.println("Please enter your " + type + ":");
        if (type.equals("income")) {
            sum = Main.input.nextDouble();
        } else if (type.equals("expense")) {
            sum = Main.input.nextDouble() * -1;
        }
        return sum;
    }

    protected void saveTransactionToArrayList(double sum, String fileName) {
            Main.input.nextLine();
            System.out.println("Do you want to add the transaction on today's date?");
            String choice = Main.input.nextLine();

            if (choice.contains("n")) {
                Transactions transactions = setOwnDateOnTransaction();
                transactions.setSum(sum);
                printTransaction(transactions);
                transactionList.add(transactions);
                TransactionRepository.saveToFile(transactions, fileName);
            } else {
                String monthString = getStringFormatOfDateValue(month);
                String dayString = getStringFormatOfDateValue(day);

                if (year == 2025) {
                    week = weekOfDate2025(month, day);
                }
                else {
                    week = "Not available";
                }
                Transactions transactions = new Transactions(sum, type, currency, year, monthString, dayString, week);
                printTransaction(transactions);
                transactionList.add(transactions);
                TransactionRepository.saveToFile(transactions, fileName);
            }

    }

    protected Transactions setOwnDateOnTransaction() {
        System.out.println("Type year, format xxxx");
        year = Main.input.nextInt();
        System.out.println("Type month, format mm"); //TODO Lägga till try catches för felhantering
        month = Main.input.nextInt();
        System.out.println("Type day, format dd");
        day = Main.input.nextInt();

        if (year == 2025) {
            week = weekOfDate2025(month, day);
        }
        else {
            week = "Not available";
        }

        String monthString = getStringFormatOfDateValue(month);
        String dayString = getStringFormatOfDateValue(day);

        return new Transactions(0, type, currency, year, monthString, dayString, week);
    }

    protected void printTransaction(Transactions transactions) {
        String dayString = getStringFormatOfDateValue(day);
        String monthString = getStringFormatOfDateValue(month);

        System.out.println("Your transaction " + sum + " " + currency + " will be saved on " +year+"-"+monthString+"-"+dayString);
    }

    protected static String getStringFormatOfDateValue(int dayMonthOrWeekValue) {
        String stringedValue;
        if (dayMonthOrWeekValue < 10 && dayMonthOrWeekValue > 0) {
            stringedValue = "0" + dayMonthOrWeekValue;
        } else {
            stringedValue = "" + dayMonthOrWeekValue;
        }
        return stringedValue;
    }

    private String weekOfDate2025(int monthValue, int dayValue) {
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

        return getStringFormatOfDateValue(week);

    }

}