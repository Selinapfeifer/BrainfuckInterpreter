package de.sp.brainfuck.core;


import androidx.core.util.Pair;

import java.util.List;

import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;

public class BrainFuckInterpreter {

    public static final int MEMORY_SIZE = 1000;

    public String interpret(String code, String input) throws InvalidCharacterException, MalformedBracketsException {
        char[] chars = code.toCharArray();
        char[] memory = new char[MEMORY_SIZE];
        int memory_index = 50;
        int input_index = 0;
        List<Pair<Integer, Integer>> bracketPairs;
        bracketPairs = BrainFuckParser.parse(chars);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ValidCharacters.INCREASE.getCharacter()) {
                memory[memory_index]++;
            } else if (chars[i] == ValidCharacters.DECREASE.getCharacter()) {
                memory[memory_index]--;
            } else if (chars[i] == ValidCharacters.SHIFT_RIGHT.getCharacter()) {
                memory_index++;
            } else if (chars[i] == ValidCharacters.SHIFT_LEFT.getCharacter()) {
                memory_index--;
            } else if (chars[i] == ValidCharacters.PRINT.getCharacter()) {
                result.append(memory[memory_index]);
            } else if (chars[i] == ValidCharacters.READ_INPUT.getCharacter()) {
                if (input.length() > input_index) {
                    memory[memory_index] = input.charAt(input_index);
                } else {
                    //todo
                }
            } else if (chars[i] == ValidCharacters.OPEN_BRACKET.getCharacter()) {
                if (memory[memory_index] == 0) {
                    i = indexOfMatchingClosingBracket(bracketPairs, i);
                }
            } else if (chars[i] == ValidCharacters.CLOSING_BRACKET.getCharacter()) {
                if (memory[memory_index] != 0) {
                    i = indexOfMatchingOpenBracket(bracketPairs, i);
                }
            }
        }
        return result.toString();
    }

    private int indexOfMatchingClosingBracket(List<Pair<Integer, Integer>> bracketPairs, int indexOfOpenBracket) {
        for (int i = 0; i < bracketPairs.size(); i++) {
            if (bracketPairs.get(i).first == indexOfOpenBracket) {
                return bracketPairs.get(i).second;
            }
        }
        return -1;
    }

    private int indexOfMatchingOpenBracket(List<Pair<Integer, Integer>> bracketPairs, int indexOfClosedBracket) {
        for (int i = 0; i < bracketPairs.size(); i++) {
            if (bracketPairs.get(i).second == indexOfClosedBracket) {
                return bracketPairs.get(i).first;
            }
        }
        return -1;
    }

}
