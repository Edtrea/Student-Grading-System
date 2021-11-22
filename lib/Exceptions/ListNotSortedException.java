package Exceptions;

public class ListNotSortedException extends Exception {
    public ListNotSortedException(){}
    public ListNotSortedException(String message)
    {
        super(message);
    }
}