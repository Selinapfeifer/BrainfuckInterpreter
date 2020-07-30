package de.sp.brainfuck.core.exception;

public class MalformedBracketsException extends Exception{
    public MalformedBracketsException(int pos) {
        super("Schlechtgeformte Klammer an der Position " + pos);
    }
}