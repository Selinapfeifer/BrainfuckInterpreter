package de.sp.brainfuck.core.validation;

public enum ValidCharacters {
    PRINT('.'),
    SHIFT_LEFT('<'),
    SHIFT_RIGHT('>'),
    INCREASE('+'),
    DECREASE('-'),
    OPEN_BRACKET('['),
    CLOSING_BRACKET(']'),
    READ_INPUT(',');

    char character;

    ValidCharacters(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
