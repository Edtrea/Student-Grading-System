//SGS
//Lim Wen Chao
//23.11.2021
//CheckType.java
//This is a helper class that will help check if a string can be converted to other types

package Helper;

public class CheckType {
    
    /** 
     * A method that will check if string is convertable to integer
     * @param s A string
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean IsInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    
    /** 
     * A method that will check if string is convertable to Long
     * @param s a string
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean IsLong(String s) {
        try {
            Long.parseLong(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    
    /** 
     * A method that checks if string ony has one character
     * @param s a string
     * @return boolean  true/false depending on whether data passes the check
     */
    public static boolean IsChar(String s) {
        if (s.length() == 1) {
            return true;
        }
        return false;
    }
}
