//SGS
//Lim Wen Chao
//23.11.2021
//InvalidDateException.java
//This is a class that allow InvalidDateException to be thrown

package Exceptions;

public class InvalidDateException extends Exception {
    public InvalidDateException() {
    }

    public InvalidDateException(String message) {
        super(message);
    }
}