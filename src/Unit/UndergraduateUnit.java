package Unit;

import Exceptions.WrongDataTypeException;
import Helper.CheckType;

public class UndergraduateUnit extends Unit {
    private String unitId;
    private int unitLevel, assignment1, assignment2, practicalWork, finalExam;

    //Constructors
    public UndergraduateUnit()
    {
        super();
    }
    public UndergraduateUnit(String unitId, String unitLevel, String assignment1, String assignment2, String practicalWork, String finalExam)
    {
        super('U');
        try
        {
            if(CheckLevel(unitLevel) == true && CheckAssignmentExam(assignment1) == true && CheckAssignmentExam(assignment2) == true && CheckPractical(practicalWork) == true && CheckAssignmentExam(finalExam) == true)
            {
                this.unitId = unitId;
                this.unitLevel = Integer.parseInt(unitLevel);
                this.assignment1 = Integer.parseInt(assignment1);
                this.assignment2 = Integer.parseInt(assignment2);
                this.practicalWork = Integer.parseInt(practicalWork);
                this.finalExam = Integer.parseInt(finalExam);
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

    //Check data
    private boolean CheckLevel(String level)
    {
        if(CheckType.IsInt(level) == true)
        {
            return true;
        }
        return false;
    }
    private boolean CheckAssignmentExam(String score)
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
    private boolean CheckPractical(String score)
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
