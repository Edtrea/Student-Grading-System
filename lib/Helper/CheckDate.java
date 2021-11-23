//SGS
//Lim Wen Chao
//23.11.2021
//CheckDate.java
//This is a helper class that will help check if individual date portions are valid dates

package Helper;

public class CheckDate {
    
    /** 
     * A method that checks whether an int has 4 character only and more than 0
     * @param year  A year data in int
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean CheckYear(int year) {
        // Check if the year is a positive number
        // Check if the year is number with only 4 digits
        if (CountDigit(year) == 4 && year > 0) {
            return true;
        }
        return false;
    }

    
    /** 
     * A method that checks whether an int is between 1 - 12 inclusive
     * @param month A month data in int
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean CheckMonth(int month) {
        // Check if month is between 1 and 12 inclusive only
        if (month >= 1 && month <= 12) {
            return true;
        }
        return false;
    }

    
    /** 
     * A method that checks whether an int is between 1 - 31 inclusive
     * @param day   A day data in int
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean CheckDay(int day) {
        // Check if day is between 1 and 31 inclusive only
        if (day >= 1 && day <= 31) {
            return true;
        }
        return false;
    }

    
    /** 
     * A method that will return the number of character that form a number
     * @param num   A int
     * @return int  returns an int number that represents that number of characters of a number
     */
    public static int CountDigit(int num) {
        int count = 0;
        while (num != 0) {
            // removing the last digit of the number n
            num = num / 10;
            // increasing count by 1
            count = count + 1;
        }
        return count;
    }
}
