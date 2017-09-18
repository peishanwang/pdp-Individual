package Assignment1.test;

import Assignment1.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


/**
 * Created by peishan on 2017/9/13.
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
    public void expectedIllegalArgumentException() {
        rn.getRevNum(new ByteArrayInputStream("\n".getBytes()));
    }

    /**
     * Tests that ReverseNumber throws an IllegalArgumentException
     * for wrong-format input.
     */

    @Test(expected = InputMismatchException.class)
    public void expectedWrongFormatException() {
        rn.getRevNum(new ByteArrayInputStream("abc".getBytes()));
        //System.setIn(System.in);
    }

    /**
     * Tests that ReverseNumber throws no IllegalArgumentException
     * for Integer input.
     */
    @Test
    public void testThrowsIllegalArgumentException() {
        try {
            rn.getRevNum(new ByteArrayInputStream("12345".getBytes()));
        } catch (IllegalArgumentException ex) {
            fail("Threw IllegalArgumentException for 12345 but 12345 is legal input: "
                    + ex);
        }
    }

    @Test
    public void testNegativeInput() {
        assertEquals("getRevNum(-5200)", -25, rn.getRevNum(new ByteArrayInputStream("-5200".getBytes())));
        assertEquals("getRevNum(-10086)", -68001, rn.getRevNum(new ByteArrayInputStream("-10086".getBytes())));
    }

    @Test
    public void testNonnegativeInput() {
        assertEquals("getRevNum(2147483647)", 7463847412L, rn.getRevNum(new ByteArrayInputStream("2147483647".getBytes())));
        assertEquals("getRevNum(98105)", 50189, rn.getRevNum(new ByteArrayInputStream("98105".getBytes())));
        assertEquals("getRevNum(0)", 0, rn.getRevNum(new ByteArrayInputStream("0".getBytes())));
    }
}
