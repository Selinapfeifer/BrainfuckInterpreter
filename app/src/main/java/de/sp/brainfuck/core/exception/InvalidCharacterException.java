package de.sp.brainfuck.core.exception;

public class InvalidCharacterException extends Exception{
    public InvalidCharacterException(char invalidChar) {
        super("" + invalidChar);
    }
}
