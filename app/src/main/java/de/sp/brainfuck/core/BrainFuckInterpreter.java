package de.sp.brainfuck.core;

import de.sp.brainfuck.core.exception.InvalidCharacterException;

public class BrainFuckInterpreter {

    public String interpret(String code) throws InvalidCharacterException {
        char[] chars = code.toCharArray();
        char[] memory = new char[30];
        int index = 0;
        checkCodeIsValid(chars);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                memory[index]++;
            } else if (chars[i] == '-') {
                memory[index]--;
            } else if (chars[i] == '>') {
                index++;
            } else if (chars[i] == '<') {
                index--;
            } else if (chars[i] == '.') {
                result.append(memory[index]);
            }
        }
        return result.toString();
    }

    private void checkCodeIsValid(char[] chars) throws InvalidCharacterException {

        for (int i = 0; i < chars.length; i++) {
            checkCharIsValid(chars[i]);
        }
    }

    private void checkCharIsValid(char chars) throws InvalidCharacterException {
        char[] validChars = {'>', '<', '+', '-', '[', ']', '.', ','};

        for (int j = 0; j < validChars.length; j++) {
            if (chars == validChars[j]) {
                return;
            }
        }
        throw new InvalidCharacterException(chars);
    }
}
