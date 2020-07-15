package de.sp.brainfuck.core.exception;

public class MalformedBracketsException extends Exception{
    public MalformedBracketsException(int pos) {
        super("Malformed brackets at pos " + pos);
    }
}