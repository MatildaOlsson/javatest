import java.time.LocalDate;
import java.util.UUID;

public class Transactions {
    protected UUID id;
    protected double sum;
    protected String type;
    protected String currency;

    protected String day;
    protected String month;
    protected int year;
    protected String week;

    Transactions(double sum, String type, String currency, int year, String month, String day, String week) {
        this.id = UUID.randomUUID();
        this.sum = sum;
        this.type = type;
        this.currency = currency;
        this.year = year;
        this.month = month;
        this.day = day;
        this.week = week;
    }


    public void setSum(double sum) {
        this.sum = sum;

    }

    public void setDay(String day) {
        this.day = day;

    }

    public void setMonth(String month) {
        this.month = month;

    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSum() {
        return sum;
    }
    public String getDay() {
        return day;
    }
    public int getYear(){
        return year;
    }
    public String getMonth() {
        return month;
    }
    public String getWeek() {
        return week;
    }
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
       return   sum +
                " " + currency +
                ", Type: '" + type + '\'' +
                ", Date: " + day + "/" + month + "/" + year +
                ", Week: " + week;
    }
}

