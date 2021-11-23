package Helper;

public class CheckUnit {
    //Check Undergraduate data
    public static boolean CheckLevel(String level)
    {
        if(CheckType.IsInt(level) == true)
        {
            return true;
        }
        return false;
    }
    public static boolean CheckAssignmentExam(String score)
    {
        if(CheckType.IsInt(score) == true)
        {
            if(Integer.parseInt(score) <= 100 && Integer.parseInt(score) >= 0)
            {
                return true;
            }
            return false;
        }
        return false;
    }
    public static boolean CheckPractical(String score)
    {
        if(CheckType.IsInt(score) == true)
        {
            if(Integer.parseInt(score) <= 20 && Integer.parseInt(score) >= 0)
            {
                return true;
            }
            return false;
        }
        return false;
    }
    //Check Graduate Data
    public static boolean CheckGradEnrolmentType(String type)
    {
        if(type.equals("Master") == true || type.equals("PhD") == true)
        {
            return true;
        }
        return false;
    }
    public static boolean CheckYears(String year)
    {
        if(CheckType.IsInt(year) == true)
        {
            return true;
        }
        return false;
    }
    public static boolean CheckGrade(String grade)
    {
        if(grade.length() == 1 && (grade.equals("C") == true || grade.equals("N") || grade.equals("S")))
        {
            return true;
        }
        return false;
    }
}
