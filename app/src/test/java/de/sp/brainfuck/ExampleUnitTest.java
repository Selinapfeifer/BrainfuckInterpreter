package de.sp.brainfuck;

import org.junit.Test;

import de.sp.brainfuck.core.BrainFuckInterpreter;
import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testOneLoop() throws InvalidCharacterException, MalformedBracketsException {
        BrainFuckInterpreter cut = new BrainFuckInterpreter();
        String result = cut.interpret(">+++++++++[<++++++++>-]<.");
        assertEquals("H", result);
    }

    @Test
    public void testTwoSeparateLoops() throws InvalidCharacterException, MalformedBracketsException {
        BrainFuckInterpreter cut = new BrainFuckInterpreter();
        String result = cut.interpret(">+++++++++[<++++++++>-]<.>>+++++++++[<++++++++>-]<.");
        assertEquals("HH", result);
    }

    @Test
    public void testOutputSize() throws InvalidCharacterException, MalformedBracketsException {
        BrainFuckInterpreter cut = new BrainFuckInterpreter();
        String result = cut.interpret(".....");
        assertEquals(5, result.length());
    }
}