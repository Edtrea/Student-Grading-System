//SGS
//Lim Wen Chao
//23.11.2021
//StudentNotFoundException.java
//This is a class that allow StudentNotFoundException to be thrown

package Exceptions;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}