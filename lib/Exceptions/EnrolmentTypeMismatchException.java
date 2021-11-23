//SGS
//Lim Wen Chao
//23.11.2021
//EnrolmentTypeMismatchException.java
//This is a class that allow EnrolmentTypeMismatchException to be thrown

package Exceptions;

public class EnrolmentTypeMismatchException extends Exception {
    public EnrolmentTypeMismatchException() {
    }

    public EnrolmentTypeMismatchException(String message) {
        super(message);
    }
}