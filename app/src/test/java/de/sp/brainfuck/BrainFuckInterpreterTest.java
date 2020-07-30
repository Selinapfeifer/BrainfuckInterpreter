package de.sp.brainfuck;

import org.junit.Before;
import org.junit.Test;

import de.sp.brainfuck.core.BrainFuckInterpreter;
import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;

import static org.junit.Assert.*;


public class BrainFuckInterpreterTest {

    private BrainFuckInterpreter cut;

    @Before
    public void setup() {
        cut = new BrainFuckInterpreter();
    }

    @Test
    public void testOneLoop() throws InvalidCharacterException, MalformedBracketsException {
        String result = cut.interpret(">+++++++[<+++++++>-]<.", "");
        assertEquals("1", result);
    }

    @Test
    public void testTwoSeparateLoops() throws InvalidCharacterException, MalformedBracketsException {
        String result = cut.interpret(">+++++++++[<++++++++>-]<.>>++++++++++[<+++++++>-]<.", "");
        assertEquals("HF", result);
    }

    @Test
    public void testOutputSize() throws InvalidCharacterException, MalformedBracketsException {
        String result = cut.interpret(".....", "");
        assertEquals(5, result.length());
    }
}