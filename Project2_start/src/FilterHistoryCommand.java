import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class FilterHistoryCommand extends ViewHistoryCommand {
    int choice = 0;
    int year;
    String month;
    String day;
    String week;

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

//        int choice = 0;
//        int year;
//        String month;
//        String day;
//        String week;

        try {
            choice = Main.input.nextInt();
            Main.input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice. Select a number (1-4) representing the filter you want");
        }

        switch (choice) {
            case 1:
                year = SelectYear();
                streamAndFilter(transactionList, year, null, null, null);
                break;
            case 2:
                year = SelectYear();
                month = SelectDayMonthOrWeek("month");
                streamAndFilter(transactionList, year, month, null, null);
                break;
            case 3:
                year = SelectYear();
                month = SelectDayMonthOrWeek("month");
                day = SelectDayMonthOrWeek("day");
                streamAndFilter(transactionList, year, month, day, null);
                break;
            case 4:
               week = SelectDayMonthOrWeek("week");
               streamAndFilter(transactionList, 2025, null, null, week);
                break;
        }

    }

   public static int SelectYear() {
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

    public static String SelectDayMonthOrWeek(String type) {
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
            System.out.println("No matchning transactions was found");
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
