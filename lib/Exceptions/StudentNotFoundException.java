package Exceptions;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(){}
    public StudentNotFoundException(String message)
    {
        super(message);
    }
}