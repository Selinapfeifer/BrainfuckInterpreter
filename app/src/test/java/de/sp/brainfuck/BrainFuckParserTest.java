package de.sp.brainfuck;

import org.junit.Test;

import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;
import de.sp.brainfuck.core.BrainFuckParser;


public class BrainFuckParserTest {

    @Test(expected = InvalidCharacterException.class)
    public void testInvalidCharacterExceptionIsThrown() throws InvalidCharacterException, MalformedBracketsException {
        BrainFuckParser.parse(new char[]{'c'});
    }

    @Test(expected = MalformedBracketsException.class)
    public void testMalformedBracketsExceptionIsThrownIfBracketsAreInWrongOrder() throws InvalidCharacterException, MalformedBracketsException {
        BrainFuckParser.parse(new char[]{']', '['});
    }
}
