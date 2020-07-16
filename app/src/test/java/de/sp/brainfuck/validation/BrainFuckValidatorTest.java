package de.sp.brainfuck.validation;

import org.junit.Test;

import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;
import de.sp.brainfuck.core.validation.BrainFuckValidator;


public class BrainFuckValidatorTest {

    @Test(expected = InvalidCharacterException.class)
    public void testInvalidCharacterExceptionIsThrown() throws InvalidCharacterException, MalformedBracketsException {
        BrainFuckValidator.validateAndDetermineBracketPairs(new char[]{'c'});
    }

    @Test(expected = MalformedBracketsException.class)
    public void testMalformedBracketsExceptionIsThrownIfBracketsAreInWrongOrder() throws InvalidCharacterException, MalformedBracketsException {
        BrainFuckValidator.validateAndDetermineBracketPairs(new char[]{']', '['});
    }
}
