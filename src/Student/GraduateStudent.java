//SGS
//Lim Wen Chao
//23.11.2021
//GraduateStudent.java
//This is a GraduateStudent class is a sub class of student that holds GraduateStudent data and has a reportgrade function that will return a string with graduate student's information

package Student;

import Helper.Date;
import Unit.GraduateUnit;

public class GraduateStudent extends Student {  //Inheritance
    private char enrolmentType = 'G';

    // Constructors
    public GraduateStudent() {
        super();
    }
    public GraduateStudent(long studentId, String firstName, String lastName, Date birthDate) {
        super(studentId, firstName, lastName, birthDate);
    }

    // Getters
    /** 
     * A method that return the enrolmentType
     * @return char
     */
    public char GetEnrolmentType() {
        return enrolmentType;
    }

    // Other methods
    /** 
     * A method that build a string that contains the information of an undergraduate student and returns it
     * @return String   A string that contain student's information
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
            string.append("Enrolment type: ");
            string.append(((GraduateUnit) super.GetUnit()).GetGradEnrolmentType());
            string.append("\n");
            string.append("Years required: ");
            string.append(((GraduateUnit) super.GetUnit()).GetYearsRequired());
            string.append("\n");
            string.append("Final grade: ");
            string.append(((GraduateUnit) super.GetUnit()).GetFinalGrade());
            string.append("\n");
        } else {
            string.append("No Unit/marks information found.");
            string.append("\n");
        }

        return string.toString();
    }
}
