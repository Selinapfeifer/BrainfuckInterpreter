package de.sp.brainfuck.core;

import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.List;

import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;

public class BrainFuckParser {

    public static List<Pair<Integer, Integer>> parse(char[] chars) throws MalformedBracketsException, InvalidCharacterException {
        List<Pair<Integer, Integer>> bracketPairs = new ArrayList<>();
        List<Integer> openBrackets = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            checkCharIsValid(chars[i]);
            if (chars[i] == ValidCharacters.OPEN_BRACKET.getCharacter()) {
                openBrackets.add(i);
            } else if (chars[i] == ValidCharacters.CLOSING_BRACKET.getCharacter()) {
                if (!openBrackets.isEmpty()) {
                    int indexOfMatchingOpenBracket = openBrackets.size() - 1;
                    Pair<Integer, Integer> pair = new Pair<>(openBrackets.get(indexOfMatchingOpenBracket), i);
                    bracketPairs.add(pair);
                    openBrackets.remove(indexOfMatchingOpenBracket);
                } else {
                    throw new MalformedBracketsException(i);
                }
            }
        }

        if (!openBrackets.isEmpty()) {
            throw new MalformedBracketsException(openBrackets.get(0));
        }

        return bracketPairs;
    }

    private static void checkCharIsValid(char character) throws InvalidCharacterException {
        for (ValidCharacters validChar : ValidCharacters.values()) {
            if (character == validChar.getCharacter()) {
                return;
            }
        }
        throw new InvalidCharacterException(character);
    }
}
