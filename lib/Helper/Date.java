package Helper;
import Exceptions.InvalidDateException;

public class Date {
    //Declare variable
    private int day, month, year;

    //Constructors
    public Date(int day, int month, int year)
    {
        try
        {
            if (CheckDate(day, month, year) == true)
            {
                this.day = day;
                this.month = month;
                this.year = year;
            }
        }
        catch (InvalidDateException e)
        {
            System.out.println(e);
        }
    }

    //Getter
    public int getDay()
    {
        return day;
    }
    public int getMonth()
    {
        return month;
    }
    public int getYear()
    {
        return year;
    }

    //Data QC
    private boolean CheckDate(int day, int month, int year) throws InvalidDateException
    {
        boolean validDay = true, validMonth = true, validYear = true;
        if (CheckYear(year) == false)
        {
            validYear = false;
            throw new InvalidDateException("Invalid year.");
        }
        
        if(CheckMonth(month) == false)
        {
            validMonth = false;
            throw new InvalidDateException("Invalid month.");
        }

        if(CheckDay(day) == false)
        {
            validDay = false;
            throw new InvalidDateException("Invalid day.");
        }

        if(validDay == true && validMonth == true && validYear == true)
        {
            return true;
        }
        return false;
    } 

    private boolean CheckYear(int year)
    {        
        //Check if the year is a positive number
        //Check if the year is number with only 4 digits
        if(CountDigit(year) == 4 && year > 0)
        {
            return true;
        }
        return false;
    }

    private boolean CheckMonth(int month)
    {
        if(month >= 1 && month <= 12)
        {
            return true;
        }
        return false;
    }

    private boolean CheckDay(int day)
    {
        if(day >= 1 && day <= 31)
        {
            return true;
        }
        return false;
    }

    private int CountDigit(int num)
    {
        int count = 0;  
        while(num != 0)  
        {  
        // removing the last digit of the number n  
        num = num / 10;  
        // increasing count by 1  
        count = count + 1;  
        }  
        return count;  
    }


    //Other methods
    public String getFullDate()
    {
        return day + "/" + month + "/" + "year";
    }
}
