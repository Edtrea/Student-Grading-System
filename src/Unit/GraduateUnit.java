//SGS
//Lim Wen Chao
//23.11.2021
//GraduateUnit.java
//This is a GraduateUnit class is a subclass of unit of student that holds GraduateUnit data

package Unit;

public class GraduateUnit extends Unit {    //Inheritance
    private String enrolmentType;
    private char finalGrade;
    private int yearsRequired;

    // Constructors
    public GraduateUnit() {
        super();
    }
    public GraduateUnit(String graduateType, int yearsRequired, char finalGrade) {
        super('G');
        this.enrolmentType = graduateType;
        this.yearsRequired = yearsRequired;
        this.finalGrade = finalGrade;
    }

    // setter
    /** 
     * Sets enrolmentType to given string
     * @param enrolmentType
     */
    public void SetEnrolmentType(String enrolmentType) {
        this.enrolmentType = enrolmentType;
    }
    /** 
     * Sets yearsRequired to given int
     * @param yearsRequired
     */
    public void SetYearRequired(int yearsRequired) {
        this.yearsRequired = yearsRequired;
    }
    /** 
     * Set finalGrade to given String
     * @param finalGrade
     */
    public void SetFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade.charAt(0);
    }

    // Getter
    /** 
     * Return EnrolmentType of graduate unit
     * @return String
     */
    public String GetGradEnrolmentType() {
        return enrolmentType;
    }
    /** 
     * return yearsRequired of graduate unit
     * @return int
     */
    public int GetYearsRequired() {
        return yearsRequired;
    }
    /** 
     * return finalGrade of graduate unit
     * @return char
     */
    public char GetFinalGrade() {
        return finalGrade;
    }
}
