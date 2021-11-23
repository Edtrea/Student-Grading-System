//SGS
//Lim Wen Chao
//23.11.2021
//UndergraduateUnit.java
//This is a UndergraduateUnit class is a subclass of unit of student that holds UndergraduateUnit data and has a method that calculate overall marks and a method that determines the grade based on overall marks

package Unit;

public class UndergraduateUnit extends Unit {   //Inheritance
    private String unitId;
    private int unitLevel, assignment1, assignment2, practicalWork, finalExam;

    // Constructors
    public UndergraduateUnit() {
        super();
    }
    public UndergraduateUnit(String unitId, int unitLevel, int assignment1, int assignment2, int practicalWork, int finalExam) {
        super('U');
        this.unitId = unitId;
        this.unitLevel = unitLevel;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.practicalWork = practicalWork;
        this.finalExam = finalExam;
    }

    // Setter
    /** 
     * Sets UnitId of unit with given string
     * @param unitId
     */
    public void SetUnitId(String unitId) {
        this.unitId = unitId;
    }
    /** 
     * Sets unitLevel of unit with given int
     * @param unitLevel
     */
    public void SetUnitLevel(int unitLevel) {
        this.unitLevel = unitLevel;
    }
    /** 
     * Sets Assignment1 score of student with given int
     * @param assignment1
     */
    public void SetAssignment1(int assignment1) {
        this.assignment1 = assignment1;
    }
    /** 
     * Set assignment2 score of student with given int
     * @param assignment2
     */
    public void SetAssignment2(int assignment2) {
        this.assignment2 = assignment2;
    }
    /** 
     * Set practicalWork score of student with given int
     * @param practicalWork
     */
    public void SetPracticalWork(int practicalWork) {
        this.practicalWork = practicalWork;
    }
    /** 
     * Set fincalExame score of student with given int
     * @param finalExam
     */
    public void SetFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    // Getter
    /** 
     * Returns unitId of unit
     * @return String
     */
    public String GetUnitId() {
        return unitId;
    }
    /** 
     * Returns unitLevel of unit
     * @return int
     */
    public int GetUnitLevel() {
        return unitLevel;
    }
    /** 
     * Return assignment1 of unit
     * @return int
     */
    public int GetAssignment1() {
        return assignment1;
    }
    /** 
     * Return assignment2 of unit
     * @return int
     */
    public int GetAssignment2() {
        return assignment2;
    }
    /** 
     * Returns PracticalWork of unit
     * @return int
     */
    public int GetPracticalWork() {
        return practicalWork;
    }
    /** 
     * Returns finalExam of unit
     * @return int
     */
    public int GetFinalExam() {
        return finalExam;
    }

    // Other method
    /** 
     * A method that will calculate overallMark based on the weighted average of assignment1,assignment2, practicalWork and finalExam and returns a double
     * 25% each for assignment1 and assignment2
     * 20% for practicalWork
     * 30% for finalExam
     * @return double
     */
    public double CalOverallMark() {
        double overallMark;

        overallMark = (assignment1 / 4) + (assignment2 / 4) + (practicalWork / 5) + (finalExam * 0.3);

        return overallMark;
    }

    
    /** 
     * A method that will determine the final grade based on overallMarks
     * HD: 80 - 100
     * D : 70 - 79
     * C : 60 - 69
     * P : 50 - 59
     * N : 0  - 49
     * @return String
     */
    public String CalFinalGrade() {
        double overallMark = CalOverallMark();
        if (overallMark >= 80) {
            return "HD";
        } else if (overallMark >= 70 && overallMark < 80) {
            return "D";
        } else if (overallMark >= 60 && overallMark < 70) {
            return "C";
        } else if (overallMark >= 50 && overallMark < 60) {
            return "P";
        } else {
            return "N";
        }
    }

}
