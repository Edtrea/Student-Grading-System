//SGS
//Lim Wen Chao
//23.11.2021
//Date.java
//This is the Date class. Holds day, month and year and has a method that will return a string date of dd/mm/yyyy format

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

    // Getters
    /** 
     * @return int Returns the day portion of date
     */
    public int getDay() {
        return day;
    }
    /** 
     * @return int returns the month portion of date
     */
    public int getMonth() {
        return month;
    }
    /** 
     * @return int returns the year portion of date
     */
    public int getYear() {
        return year;
    }

    /** 
     * A method that will build and return a string date with format dd/mm/yyyy
     * @return String A string date format dd/mm/yyyy
     */
    // Other methods
    public String getFullDate() {
        return day + "/" + month + "/" + year;
    }
}
