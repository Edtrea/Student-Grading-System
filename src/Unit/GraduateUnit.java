package Unit;

import Exceptions.WrongDataTypeException;
import Helper.CheckType;

public class GraduateUnit extends Unit {
    private String enrolmentType;
    private char finalGrade;
    private int yearsRequired;

    //Constructors
    public GraduateUnit()
    {
        super();
    }
    public GraduateUnit(String graduateType, String yearsRequired, String finalGrade)
    {
        super('G');
        try
        {
            if(CheckEnrolmentType(graduateType) == true && CheckYears(yearsRequired) == true && CheckGrade(finalGrade) == true)
            {
                this.enrolmentType = graduateType;
                this.yearsRequired = Integer.parseInt(yearsRequired);
                this.finalGrade = finalGrade.charAt(0);
            }
            else
            {
                throw new WrongDataTypeException("Data type/value does not match accepted type/value.Please check data dictionary provided.");
            }
        }
        catch(WrongDataTypeException e)
        {
            System.out.println(e);
        }
    }

    //setter
    public void SetEnrolmentType(String enrolmentType)
    {
        try
        {
            if(CheckEnrolmentType(enrolmentType) == true)
            {
                this.enrolmentType = enrolmentType;
            }
            else
            {
                throw new WrongDataTypeException("Data type does not match accepted type.");
            }
        }
        catch (WrongDataTypeException e)
        {
            System.out.println(e);
        }
    }
    public void SetYearRequired(String yearsRequired)
    {
        try
        {
            if(CheckYears(yearsRequired) == true)
            {
                this.yearsRequired = Integer.parseInt(yearsRequired);
            }
            else
            {
                throw new WrongDataTypeException("Data type does not match accepted type.");
            }
        }
        catch(WrongDataTypeException e)
        {
            System.out.println(e);
        }
    }
    public void SetFinalGrade(String finalGrade)
    {
        try
        {
            if(CheckGrade(finalGrade) == true)
            {
                this.finalGrade = finalGrade.charAt(0);
            }
            else
            {
                throw new WrongDataTypeException("Data type does not match accepted type.");
            }
        }
        catch(WrongDataTypeException e)
        {
            System.out.println(e);
        }
    }

    //Getter
    public String GetGradEnrolmentType()
    {
        return enrolmentType;
    }
    public int GetYearsRequired()
    {
        return yearsRequired;
    }
    public char GetFinalGrade()
    {
        return finalGrade;
    }

    //Check Data
    private boolean CheckEnrolmentType(String type)
    {
        if(type.equals("Master") == true || type.equals("PhD") == true)
        {
            return true;
        }
        return false;
    }
    private boolean CheckYears(String year)
    {
        if(CheckType.IsInt(year) == true)
        {
            return true;
        }
        return false;
    }
    private boolean CheckGrade(String grade)
    {
        if(grade.length() == 1 && (grade.equals("C") == true || grade.equals("N") || grade.equals("S")))
        {
            return true;
        }
        return false;
    }
}
