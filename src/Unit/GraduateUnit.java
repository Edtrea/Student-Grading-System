package Unit;

public class GraduateUnit extends Unit {
    private String enrolmentType;
    private char finalGrade;
    private int yearsRequired;

    //Constructors
    public GraduateUnit()
    {
        super();
    }
    public GraduateUnit(String graduateType, int yearsRequired, char finalGrade)
    {
        super('G');
        this.enrolmentType = graduateType;
        this.yearsRequired = yearsRequired;
        this.finalGrade = finalGrade;
    }

    //setter
    public void SetEnrolmentType(String enrolmentType)
    {
        this.enrolmentType = enrolmentType;
    }
    public void SetYearRequired(int yearsRequired)
    {
        this.yearsRequired = yearsRequired;
    }
    public void SetFinalGrade(String finalGrade)
    {
        this.finalGrade = finalGrade.charAt(0);
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
}
