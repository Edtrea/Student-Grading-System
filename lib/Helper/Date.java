package Helper;

public class Date {
    // Declare variable
    private int day, month, year;

    // Constructors
    public Date(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getter
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Other methods
    public String getFullDate() {
        return day + "/" + month + "/" + year;
    }
}
