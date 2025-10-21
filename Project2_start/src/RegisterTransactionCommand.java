import java.sql.SQLOutput;
import java.util.ArrayList;
import java.time.LocalDate;

public class RegisterTransactionCommand extends Command {
    protected double sum;
    protected ArrayList<Transactions> transactionList = new ArrayList<>();
    protected String type;
    protected String currency;

    LocalDate today = LocalDate.now();
    protected int day;
    protected int month;
    protected int year;
    protected int week = 0;

    public RegisterTransactionCommand(String name, String type, String currency, double sum, int day, int month, int year, int week, ArrayList<Transactions> transactionlist) {
        super(name);
        this.type = type;
        this.sum = sum;
        this.currency = currency;
        this.day = today.getDayOfMonth();
        this.month = today.getMonthValue();
        this.year = today.getYear();

        if (year == 2025) {
            this.week = weekOfDate2025(month, day);
        }
    }

    @Override
    public void execute() {
        registerTransaction(type);
    }

    protected void registerTransaction(String type) {
        System.out.println("Please enter your " + type +":");
        if (type.equals("income")) {
            sum = Main.input.nextDouble();
        }
        else if (type.equals("expense")) {
            sum = Main.input.nextDouble() * -1;
        }

        Main.input.nextLine();
        System.out.println("Do you want to add the transaction on today's date?");
        String choice = Main.input.nextLine();

        if (choice.contains("n")) {
            Transactions transactions = setOwnDateOnTransaction();
            transactions.setSum(sum);
            printTransaction(transactions);
            transactionList.add(transactions);
        }
        else {
            Transactions transactions = new Transactions(sum, type, currency, year, month, day, week);
            printTransaction(transactions);
            transactionList.add(transactions);
        }

    }

    protected Transactions setOwnDateOnTransaction() {
        System.out.println("Type year,format xxxx"); //TODO Lösning för veckor behövs nog
        year = Main.input.nextInt();
        System.out.println("Type month, format mm"); //TODO sätta datum som Strings? Metod för det?
        month = Main.input.nextInt();
        System.out.println("Type day, format dd");
        day = Main.input.nextInt();

        if (year == 2025) {
            week = weekOfDate2025(month, day);
        }

        return new Transactions(0, type, currency, year, month, day, week);
    }

    public void printTransaction(Transactions transactions) {
        System.out.println("Your transaction " + sum +  " will be saved on " +year+"-"+month+"-"+day);
    }


    private int weekOfDate2025(int monthValue, int dayValue) {
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
}
