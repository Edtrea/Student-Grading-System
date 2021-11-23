//SGS
//Lim Wen Chao
//23.11.2021
//WrongDataTypeException.java
//This is a class that allow WrongDataTypeException to be thrown

package Exceptions;

public class WrongDataTypeException extends Exception {
    public WrongDataTypeException() {
    }

    public WrongDataTypeException(String message) {
        super(message);
    }
}
