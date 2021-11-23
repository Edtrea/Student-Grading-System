package Unit;

public class UndergraduateUnit extends Unit {
    private String unitId;
    private int unitLevel, assignment1, assignment2, practicalWork, finalExam;

    //Constructors
    public UndergraduateUnit()
    {
        super();
    }
    public UndergraduateUnit(String unitId, int unitLevel, int assignment1, int assignment2, int practicalWork, int finalExam)
    {
        super('U');
        this.unitId = unitId;
        this.unitLevel = unitLevel;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.practicalWork = practicalWork;
        this.finalExam = finalExam;
    }

    //Setter
    public void SetUnitId(String unitId)
    {
        this.unitId = unitId;
    }
    public void SetUnitLevel(int unitLevel)
    {
        this.unitLevel = unitLevel;
    }
    public void SetAssignment1(int assignment1)
    {
        this.assignment1 = assignment1;
    }
    public void SetAssignment2(int assignment2)
    {
        this.assignment2 = assignment2;
    }
    public void SetPracticalWork(int practicalWork)
    {
        this.practicalWork = practicalWork;
    }
    public void SetFinalExam(int finalExam)
    {
        this.finalExam = finalExam;
    }

    //Getter
    public String GetUnitId()
    {
        return unitId;
    }
    public int GetUnitLevel()
    {
        return unitLevel;
    }
    public int GetAssignment1()
    {
        return assignment1;
    }
    public int GetAssignment2()
    {
        return assignment2;
    }
    public int GetPracticalWork()
    {
        return practicalWork;
    }
    public int GetFinalExam()
    {
        return finalExam;
    }

    //Other method
    public double CalOverallMark()
    {
        double overallMark;

        overallMark = (assignment1/4) + (assignment2/4) + (practicalWork/5) + (finalExam*0.3);

        return overallMark;
    }

    public String CalFinalGrade()
    {
        double overallMark = CalOverallMark();
        if(overallMark >= 80)
        {
            return "HD";
        }
        else if(overallMark >= 70 && overallMark < 80)
        {
             return "D";
        }
        else if(overallMark >= 60 && overallMark < 70)
        {
            return "C";
        }
        else if(overallMark >= 50 && overallMark < 60)
        {
            return "P";
        }
        else
        {
            return "N";
        }
    }

}
