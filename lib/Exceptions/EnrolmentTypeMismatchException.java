package Exceptions;

public class EnrolmentTypeMismatchException extends Exception {
    public EnrolmentTypeMismatchException(){}
    public EnrolmentTypeMismatchException(String message)
    {
        super(message);
    }
}