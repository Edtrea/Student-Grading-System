package Unit;

public class Unit {
    private char enrolmentType;

    //Constructors
    public Unit()
    {
        enrolmentType = ' ';
    }
    public Unit(char enrolmentType)
    {
        this.enrolmentType = enrolmentType;
    }

    //Setter
    public void SetEnrolmentType(char enrolmentType)
    {
        this.enrolmentType = enrolmentType;
    }

    //Getter
    public char GetEnrolmentType()
    {
        return enrolmentType;
    }

    //Other methods
    public String ReportGrade()
    {
        return "NA";
    }
}
