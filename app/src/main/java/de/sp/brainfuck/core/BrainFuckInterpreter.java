package de.sp.brainfuck.core;


import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.List;

import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;
import de.sp.brainfuck.core.validation.BrainFuckValidator;
import de.sp.brainfuck.core.validation.ValidCharacters;

public class BrainFuckInterpreter {

    public String interpret(String code) throws InvalidCharacterException, MalformedBracketsException {
        char[] chars = code.toCharArray();
        char[] memory = new char[30];
        int index = 0;
        List<Pair<Integer, Integer>> bracketPairs;
        bracketPairs = BrainFuckValidator.validateAndDetermineBracketPairs(chars);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ValidCharacters.INCREASE.getCharacter()) {
                memory[index]++;
            } else if (chars[i] == ValidCharacters.DECREASE.getCharacter()) {
                memory[index]--;
            } else if (chars[i] == ValidCharacters.SHIFT_RIGHT.getCharacter()) {
                index++;
            } else if (chars[i] == ValidCharacters.SHIFT_LEFT.getCharacter()) {
                index--;
            } else if (chars[i] == ValidCharacters.PRINT.getCharacter()) {
                result.append(memory[index]);
            } else if (chars[i] == ValidCharacters.TODO_COMMA.getCharacter()) {
                // todo
            } else if (chars[i] == ValidCharacters.OPEN_BRACKET.getCharacter()) {
                if (memory[index] == 0) {
                    i = indexOfMatchingClosingBracket(bracketPairs, i);
                }
            } else if (chars[i] == ValidCharacters.CLOSING_BRACKET.getCharacter()) {
                if (memory[index] != 0) {
                    i = indexOfMatchingOpenBracket(bracketPairs,i);
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
