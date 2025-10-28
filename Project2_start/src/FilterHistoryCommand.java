import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Comparator;
import java.util.List;

public class FilterHistoryCommand extends ViewHistoryCommand {

    FilterHistoryCommand(String name, ArrayList<Transactions> transactionList) {
        super(name, transactionList);
    }

    @Override
    public void execute() {

        System.out.println("Select type of filter by selecting a number:");
        System.out.println("1. Year");
        System.out.println("2. Month");
        System.out.println("3. Day");
        System.out.println("4. Week");

        int choice = 0;
        try {
            choice = Main.input.nextInt();
            Main.input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice. Select a number (1-4) representing the filter you want");
        }

        switch (choice) {
            case 1:
                int year = SelectHistoryYear();
                streamAndFilter(transactionList, year, null, null, null);
                break;
            case 2:
                year = SelectHistoryYear();
                String month = SelectHistoryDayMonthOrWeek("month");
                streamAndFilter(transactionList, year, month, null, null);
                break;
            case 3:
                year = SelectHistoryYear();
                month = SelectHistoryDayMonthOrWeek("month");
                String day = SelectHistoryDayMonthOrWeek("day");
                streamAndFilter(transactionList, year, month, day, null);
                break;
            case 4:
               String week = SelectHistoryDayMonthOrWeek("week");
               streamAndFilter(transactionList, 2025, null, null, week);
                break;
        }

    }

    private int SelectHistoryYear() {
        System.out.println("Type the year you want history (format yyyy): ");
        int year;
        try {
            year = Main.input.nextInt();
        } catch (Exception e) {
            throw new InputMismatchException("Error");
        }
        Main.input.nextLine(); // Extra scanner för att "rensa" en kvarvarande tom String efter ints
        return year;
    }

    private String SelectHistoryDayMonthOrWeek(String type) {
        System.out.println("Type the " + type + " you want history:");
        String value;
        try {
            value = Main.input.nextLine();
        } catch (Exception e) {
            throw new InputMismatchException("You must");
        }
        return value;
    }

    private void streamAndFilter(ArrayList<Transactions> transactionList, int year, String month, String day, String week) {

        List<Transactions> matchingTransactions = transactionList.stream()
                .filter(t -> t.getYear() == year)
                .filter(t -> month == null || t.getMonth().equals(month))
                .filter( t-> day == null || t.getDay().equals(day))
                .filter(t-> week == null || t.getWeek().equals(week))
                .toList();

        if (matchingTransactions.isEmpty()) {
            System.out.println("No matchning transactions found");
        }
        else {
            matchingTransactions.forEach(t-> System.out.println(t));
        }

    }



    //    protected int fromStringToInt(String value) {
//        return Integer.parseInt(value);
//
//    }
}
//TODO Streams och Lambadas för at filtera och beräkna account balace
