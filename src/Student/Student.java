//SGS
//Lim Wen Chao
//23.11.2021
//Student.java
//This is a student class that holds student data

package Student;

import Unit.Unit;
import Helper.Date;

public class Student {
    private Long studentId;
    private String firstName, lastName;
    private Date birthDate;
    private Unit unit;

    // Constructors
    public Student() {
        studentId = -1L;
        firstName = "";
        lastName = "";
        birthDate = null;
        unit = null;
    }
    public Student(Long studentId, String firstName, String lastName, Date birthDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        unit = null;
    }

    // Setter
    /** 
     * A method that will set studentId to the one given
     * @param studentId A long type data representing studentId
     */
    public void SetStudentId(Long studentId) {
        this.studentId = studentId;
    }
    /** 
     * A method that will set firstname to the one given
     * @param firstName A string type data representing firstname of student
     */
    public void SetFirstName(String firstName) {
        this.firstName = firstName;
    }
    /** 
     * A method that will set lastname to the one given
     * @param lastName  A string type data representing lastname of student
     */
    public void SetLastName(String lastName) {
        this.lastName = lastName;
    }
    /** 
     * A method that will set birthdate to the one given
     * @param birthDate A Date type object representing birth date of student
     */
    public void SetBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    /** 
     * A method that will set unit to the one given
     * @param unit  A Unit type object representing unit taken by student
     */
    public void SetUnit(Unit unit) {
        this.unit = unit;
    }

    // Getter
    /** 
     * A method that will return the studentId
     * @return Long returns a Long type data
     */
    public Long GetStudentID() {
        return studentId;
    }
    /** 
     * A method that will return the firstName
     * @return String   returns a string type data
     */
    public String GetFirstName() {
        return firstName;
    }
    /** 
     * A method that will return the lastName
     * @return String   return a string type data
     */
    public String GetLastName() {
        return lastName;
    }
    /** 
     * A method that will return the BirthDate object
     * @return Date    returns a Date object data
     */
    public Date GetBirthDate() {
        return birthDate;
    }
    /** 
     * A method that will return the unit object
     * @return Unit Returns a unit object data
     */
    public Unit GetUnit() {
        return unit;
    }
    /** 
     * A method that will return a blank enrolment type
     * @return char returns a char type data
     */
    public char GetEnrolmentType() {
        return ' ';
    }

    // Other methods
    /** 
     * A method that will return a string that say no grade
     * @return String   returns a string type data
     */
    public String ReportGrade() {  
        return "There is no grade here.";
    }

    /** 
     * A method that compares if the id is the same and another student's id
     * @param id    Another student's Id
     * @return boolean  returns true/false depending on whether a student's id matches with id given
     */
    public boolean Equals(Long id) {
        if (studentId.equals(id)) {
            return true;
        }
        return false;
    }
}
