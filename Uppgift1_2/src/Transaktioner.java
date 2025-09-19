public class Transaktioner {
    int sum;
    int week;
    int day;
    int month;
    int year;

    public Transaktioner(int sum, int week, int day, int month, int year) {
        this.sum = sum;
        this.week = week;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString () {
        return sum + " " + week + " " + day + " " + month + " " + year;
    }
}
