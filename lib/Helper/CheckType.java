package Helper;

public class CheckType {
    public static boolean IsInt(String s)
    {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static boolean IsLong(String s)
    {
        try { 
            Long.parseLong(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static boolean IsChar(String s)
    {
        if (s.length() == 1)
        {
            return true;
        }
        return false;
    }
}
