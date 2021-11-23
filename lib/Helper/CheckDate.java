package Helper;

public class CheckDate {
    // //Data QC
    // public static boolean CheckDate(int day, int month, int year) throws
    // InvalidDateException
    // {
    // boolean validDay = true, validMonth = true, validYear = true;
    // if (CheckYear(year) == false)
    // {
    // validYear = false;
    // throw new InvalidDateException("Invalid year: " + year);
    // }

    // if(CheckMonth(month) == false)
    // {
    // validMonth = false;
    // throw new InvalidDateException("Invalid month: " + month);
    // }

    // if(CheckDay(day) == false)
    // {
    // validDay = false;
    // throw new InvalidDateException("Invalid day: " + day);
    // }

    // if(validDay == true && validMonth == true && validYear == true)
    // {
    // return true;
    // }
    // return false;
    // }

    public static boolean CheckYear(int year) {
        // Check if the year is a positive number
        // Check if the year is number with only 4 digits
        if (CountDigit(year) == 4 && year > 0) {
            return true;
        }
        return false;
    }

    public static boolean CheckMonth(int month) {
        //Check if month is between 1 and 12 inclusive only
        if (month >= 1 && month <= 12) {
            return true;
        }
        return false;
    }

    public static boolean CheckDay(int day) {
        //Check if day is between 1 and 31 inclusive only
        if (day >= 1 && day <= 31) {
            return true;
        }
        return false;
    }

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
