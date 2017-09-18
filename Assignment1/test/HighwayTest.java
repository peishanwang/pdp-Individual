package Assignment1.test;
import Assignment1.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * HighwayTest tests the correctness of the functions in Highway.
 *
 * @see Assignment1.Highway
 *
 * @author Peishan Wang
 */


/**
 * We use only one Highway object in the whole HighwayTest, thus we need to specify the test order.
 * We cannot predict the result if we don't know the order of tests execution.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HighwayTest {
    private static Highway highway = null;

    @BeforeClass
    public static void setupBeforeTests() throws Exception {
        highway = new Highway();
    }

    /**
     * Test the function add(), getVelocityEastbound(), getVelocityWestbound(),
     * numberVehiclesEastbound(), numberVehiclesWestbound().
     */
    @Test
    public void test1() {
        highway.add(new Vehicle(18.00, 2));
        highway.add(new Vehicle(-18.00, 2));
        highway.add(new Vehicle(9.00, 1));
        highway.add(new Vehicle(11.00, 2));
        assertEquals("get east bound velocity", 9, highway.getVelocityEastbound(), 0.00);
        assertEquals("get west bound velocity", 11, highway.getVelocityWestbound(), 0.00);
        assertEquals("get east bound number", 2, highway.numberVehiclesEastbound());
        assertEquals("get west bound number", 2, highway.numberVehiclesWestbound());
    }

    /**
     * Test the function add(), remove(), contains().
     */
    @Test
    public void test2() {
        Vehicle v = new Vehicle(25, 1);
        highway.add(v);
        assertEquals("contains v", true, highway.contains(v));
        assertEquals("add v", false, highway.add(v));
        assertEquals("remove v", true, highway.remove(v));
        assertEquals("contains v", false, highway.contains(v));
    }
}
