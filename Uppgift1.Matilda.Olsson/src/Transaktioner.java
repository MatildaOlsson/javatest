public class Transaktioner {
    private double sum;
    int week;
    int day;
    int month;
    int year;

    public Transaktioner(double sum, int week, int day, int month, int year) {
        this.sum = sum;
        this.week = week;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return sum + " " + week + " " + day + " " + month + " " + year;
    }

    public double getSum() {
        return sum;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getWeek() {
        return week;
    }

    public String getDate() {
        String date;

        date = "" + year;

        if (month < 10) {
            date = date + "-" + "0" + month;
        } else {
            date = date + "-" + month;
        }

        if (day < 10) {
            date = date + "-" + "0" + day;
        } else {
            date = date + "-" + day;
        }

        return date;
    }
}
