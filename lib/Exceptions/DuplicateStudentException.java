package Exceptions;

public class DuplicateStudentException extends Exception {
    public DuplicateStudentException(){}
    public DuplicateStudentException(String message)
    {
        super(message);
    }
}