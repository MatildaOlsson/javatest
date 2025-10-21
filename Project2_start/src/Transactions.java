import java.time.LocalDate;

public class Transactions {
    protected double sum;
    protected String type;
    protected String currency;

    protected int day;
    protected int month;
    protected int year;
    protected int week;

    Transactions(double sum, String type, String currency, int year, int month, int day, int week) {
        this.sum = sum;
        this.type = type;
        this.currency = currency;
        this.year = year;
        this.month = month;
        this.day = day;
        this.week = 0;

    }


    public void setSum(double sum) {
        this.sum = sum;

    }

    public void setDay(int day) {
        this.day = day;

    }

    public void setMonth(int month) {
        this.month = month;

    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSum() {
        return sum;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "sum=" + sum +
                ", type='" + type + '\'' +
                ", date=" + day + "/" + month + "/" + year +
                ", week=" + week +
                '}';
    }
}

