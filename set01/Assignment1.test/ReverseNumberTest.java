package Assignment1.test;

import Assignment1.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
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
    @Test(expected = IllegalArgumentException.class)
    public void expectedIllegalArgumentException() {
        rn.getRevNum(new ByteArrayInputStream("\n".getBytes()));
    }

    /**
     * Tests that ReverseNumber throws an IllegalArgumentException
     * for wrong-format input.
     */

    @Test(expected = IllegalArgumentException.class)
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
        assertEquals("getRevNum(-12345)", "-54321", rn.getRevNum(new ByteArrayInputStream("-12345".getBytes())));
        assertEquals("getRevNum(-10086)", "-68001", rn.getRevNum(new ByteArrayInputStream("-10086".getBytes())));
    }

    @Test
    public void testNonnegativeInput() {
        assertEquals("getRevNum(12345)", "54321", rn.getRevNum(new ByteArrayInputStream("12345".getBytes())));
        assertEquals("getRevNum(61425999)", "99952416", rn.getRevNum(new ByteArrayInputStream("61425999".getBytes())));
        assertEquals("getRevNum(1)", "1", rn.getRevNum(new ByteArrayInputStream("1".getBytes())));
    }
}
