//SGS
//Lim Wen Chao
//23.11.2021
//Unit.java
//This is a Unit class holds Unit data and has a reportgrade function that will return 'NA'

package Unit;

public class Unit {
    private char enrolmentType;

    // Constructors
    public Unit() {
        enrolmentType = ' ';
    }
    public Unit(char enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    // Setter
    /** 
     * Sets enrolmentType of unit
     * @param enrolmentType
     */
    public void SetEnrolmentType(char enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    // Getter
    /** 
     * Returns enrolmentType of unit
     * @return char
     */
    public char GetEnrolmentType() {
        return enrolmentType;
    }

    
    /** 
     * Returns 'NA'
     * @return String
     */
    // Other methods
    public String ReportGrade() {
        return "NA";
    }
}
