package de.sp.brainfuck.core.validation;

public enum ValidCharacters {
    PRINT('.'),
    SHIFT_LEFT('<'),
    SHIFT_RIGHT('>'),
    INCREASE('+'),
    DECREASE('-'),
    OPEN_BRACKET('['),
    CLOSING_BRACKET(']'),
    TODO_COMMA(',');

    char character;

    ValidCharacters(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
