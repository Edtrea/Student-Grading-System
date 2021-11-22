package Student;

import Unit.Unit;
import Helper.Date;

public class Student {
    private Long studentId;
    private String firstName, lastName;
    private Date birthDate;
    private Unit unit;

    //Constructors
    public Student()
    {
        studentId = -1L;
        firstName = "";
        lastName = "";
        birthDate = null;
        unit = null;
    }
    public Student(Long studentId, String firstName, String lastName, Date birthDate)
    {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        unit = null;
    }

    //Setter
    public void SetStudentId(Long studentId)
    {
        this.studentId = studentId;
    }
    public void SetFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void SetLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void SetBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }
    public void SetUnit(Unit unit)
    {
        this.unit = unit;
    }

    //Getter
    public Long GetStudentID()
    {
        return studentId;
    }
    public String GetFirstName()
    {
        return firstName;
    }
    public String GetLastName()
    {
        return lastName;
    }
    public Date GetBirthDate()
    {
        return birthDate;
    }
    public Unit GetUnit()
    {
        return unit;
    }
    public char GetEnrolmentType()
    {
        return ' ';
    }

    //Other methods
    public String ReportGrade()
    {
        return "There is no grade here.";
    }

    public boolean Equals(Long id)
    {
        if(studentId.equals(id))
        {
            return true;
        }
        return false;
    }
}
