package Assignment1.test;

import Assignment1.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


/**
 * ReverseNumberTest is a glassbox test of the ReverseNumber class.
 *
 * Using ReverseNumber we can reverse an integer. And the output might not be an integer. Thus, the
 * output is a Long.
 *
 * When the input is negative, output must be negative too. The same rule applies for non-negative input.
 * When the input integer have trailing zeros, we eliminate the leading zeros after reverse it.
 *
 * @see Assignment1.ReverseNumber
 */
public class ReverseNumberTest {
    private static ReverseNumber rn = null;


    @BeforeClass
    public static void setupBeforeTests() throws Exception {
        rn = new ReverseNumber();
    }

    /**
     * Tests that ReverseNumber throws an IllegalArgumentException
     * for no input.
     */
    @Test(expected = NoSuchElementException.class)
    public void expectedNoElementException() {
        rn.getRevNum(new ByteArrayInputStream("\n".getBytes()));
    }

    /**
     * Tests that ReverseNumber throws an IllegalArgumentException
     * for wrong-format input.
     */
    @Test(expected = InputMismatchException.class)
    public void expectedInputMismatchException() {
        rn.getRevNum(new ByteArrayInputStream("abc".getBytes()));
        //System.setIn(System.in);
    }

    /**
     * Tests to see ReverseNumber returns the correct value for negative integer input.
     */
    @Test
    public void testNegativeInput() {
        assertEquals("getRevNum(-5200)", -25, rn.getRevNum(new ByteArrayInputStream("-5200".getBytes())));
        assertEquals("getRevNum(-10086)", -68001, rn.getRevNum(new ByteArrayInputStream("-10086".getBytes())));
    }

    /**
     * Tests to see ReverseNumber returns the correct value for non-negative integer input.
     */
    @Test
    public void testNonnegativeInput() {
        assertEquals("getRevNum(2147483647)", 7463847412L, rn.getRevNum(new ByteArrayInputStream("2147483647".getBytes())));
        assertEquals("getRevNum(98105)", 50189, rn.getRevNum(new ByteArrayInputStream("98105".getBytes())));
        assertEquals("getRevNum(0)", 0, rn.getRevNum(new ByteArrayInputStream("0".getBytes())));
    }
}
