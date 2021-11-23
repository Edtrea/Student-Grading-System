//SGS
//Lim Wen Chao
//23.11.2021
//CheckUnit.java
//This is a helper class that will help check Undergraduate and graduate unit data inputs

package Helper;

public class CheckUnit {
    
    /** 
     * A method that will check the undergraduate unit level data.
     * It will check if it is integer
     * @param level The Undergraduate UnitLevel
     * @return  boolean true/false depending on whether data passes the check
     */
    // Check Undergraduate data
    public static boolean CheckLevel(String level) {
        if (CheckType.IsInt(level) == true) {
            return true;
        }
        return false;
    }

    
    /** 
     * A method that will check the undergraduate unit assignment1, assignment2 and finalExam score.
     * It will check that it is integer and falls between 0 - 100 inclusive
     * @param score The score obtained by student
     * @return boolean  boolean true/false depending on whether data passes the check
     */
    public static boolean CheckAssignmentExam(String score) {
        if (CheckType.IsInt(score) == true) {
            if (Integer.parseInt(score) <= 100 && Integer.parseInt(score) >= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    
    /** 
     * A method that will help check the undergraduate unit practical work score.
     * It will check if it is integer and falls between 0 - 20 inclusive
     * @param score The practical work score
     * @return boolean  boolean true/false depending on whether data passes the check
     */
    public static boolean CheckPractical(String score) {
        if (CheckType.IsInt(score) == true) {
            if (Integer.parseInt(score) <= 20 && Integer.parseInt(score) >= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    
    /** 
     * A method that will help check the graduate unit enrolment type
     * It will check that it must be either 'Master' or 'PhD' only
     * @param type  The graduate enrolment type
     * @return boolean  true/false depending on whether data passes the check
     */
    // Check Graduate Data
    public static boolean CheckGradEnrolmentType(String type) {
        if (type.equals("Master") == true || type.equals("PhD") == true) {
            return true;
        }
        return false;
    }

    
    /** 
     * A method that will help check the graduate unit years required.
     * It will check if it is integer
     * @param year  The years required to complete graduate unit
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean CheckYears(String year) {
        if (CheckType.IsInt(year) == true) {
            return true;
        }
        return false;
    }

    
    /** 
     * A method that will help check the graduate unit grade.
     * It will check that it is a char and that it is either 'C', 'N' or 'S' only
     * @param grade
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean CheckGrade(String grade) {
        if (grade.length() == 1 && (grade.equals("C") == true || grade.equals("N") || grade.equals("S"))) {
            return true;
        }
        return false;
    }
}
