//SGS
//Lim Wen Chao
//23.11.2021
//DuplicateStudentException.java
//This is a class that allow DuplicateStudentException to be thrown

package Exceptions;

public class DuplicateStudentException extends Exception {
    public DuplicateStudentException() {
    }

    public DuplicateStudentException(String message) {
        super(message);
    }
}