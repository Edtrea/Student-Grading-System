//SGS
//Lim Wen Chao
//23.11.2021
//UndergraduateStudent.java
//This is a UndergraduateStudent class is a sub class of student that holds UndergraduateStudent data and has a reportgrade function that will return a string with Undergraduate student's information

package Student;

import Helper.Date;
import Unit.UndergraduateUnit;

public class UndergraduateStudent extends Student { //Inheritance
    private char enrolmentType = 'U';

    // Constructors
    public UndergraduateStudent() {
        super();
    }
    public UndergraduateStudent(Long studentId, String firstName, String lastName, Date birthDate) {
        super(studentId, firstName, lastName, birthDate);
    }

    // Getter
    /** 
     * A method that returns a graduate student's enrolmentType
     * @return char The enrolmentType of student
     */
    public char GetEnrolmentType() {
        return enrolmentType;
    }

    // Other methods
    /** 
     * A method that build a string that contains the information of an undergraduate student and returns it
     * @return String   A string that that contains student's information
     */
    public String ReportGrade() {
        StringBuilder string = new StringBuilder();

        string.append("Student type: ");
        string.append(enrolmentType);
        string.append("\n");
        string.append("Student Name: ");
        string.append(super.GetFirstName());
        string.append(" ");
        string.append(super.GetLastName());
        string.append("\n");
        string.append("Student ID: ");
        string.append(super.GetStudentID());
        string.append("\n");
        if (super.GetUnit() != null) {
            string.append("Unit ID: ");
            string.append(((UndergraduateUnit) super.GetUnit()).GetUnitId());
            string.append("\n");
            string.append("Unit Level: ");
            string.append(((UndergraduateUnit) super.GetUnit()).GetUnitLevel());
            string.append("\n");
            string.append("Assignment 1 marks: ");
            string.append(((UndergraduateUnit) super.GetUnit()).GetAssignment1());
            string.append("\n");
            string.append("Assignment 2 marks: ");
            string.append(((UndergraduateUnit) super.GetUnit()).GetAssignment2());
            string.append("\n");
            string.append("Practical work marks: ");
            string.append(((UndergraduateUnit) super.GetUnit()).GetPracticalWork());
            string.append("\n");
            string.append("Final exam marks: ");
            string.append(((UndergraduateUnit) super.GetUnit()).GetFinalExam());
            string.append("\n");
            string.append("Overall mark: ");
            string.append(((UndergraduateUnit) super.GetUnit()).CalOverallMark());
            string.append("\n");
            string.append("Final grade: ");
            string.append(((UndergraduateUnit) super.GetUnit()).CalFinalGrade());
            string.append("\n");
        } else {
            string.append("No unit/marks information found.");
            string.append("\n");
        }

        return string.toString();
    }
}
