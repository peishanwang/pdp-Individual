package Assignment1.test;
import Assignment1.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * ScenicRoadTest tests the correctness of the functions in ScenicRoad.
 *
 * @see Assignment1.ScenicRoad
 * @author Peishan Wang
 */

/**
 * We use only one ScenicRoad object in the whole HighwayTest, thus we need to specify the test order.
 * We cannot predict the result if we don't know the order of tests execution.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScenicRoadTest {
    private static ScenicRoad scenicroad = null;

    @BeforeClass
    public static void setupBeforeTests() throws Exception {
        scenicroad = new ScenicRoad(2);
    }

    @Test
    /**
     * Test the function add(), getVelocityEastbound(), getVelocityWestbound(),
     * numberVehiclesEastbound(), numberVehiclesWestbound().
     */
    public void test1() {
        scenicroad.add(new Vehicle(18.00, 2));
        scenicroad.add(new Vehicle(-18.00, 2));
        scenicroad.add(new Vehicle(9.00, 1));
        scenicroad.add(new Vehicle(11.00, 2));
        assertEquals("get east bound velocity", 9, scenicroad.getVelocityEastbound(), 0.00);
        assertEquals("get west bound velocity", 11, scenicroad.getVelocityWestbound(), 0.00);
        assertEquals("get east bound number", 2, scenicroad.numberVehiclesEastbound());
        assertEquals("get west bound number", 2, scenicroad.numberVehiclesWestbound());
    }

    @Test
    /**
     * Test the function add() when number of east/west bound vehicles is over bandwidth after adding the vehicle
     * Test the function remove(), contains().
     */
    public void test2() {
        scenicroad.add(new Vehicle(18.00, 2));
        scenicroad.add(new Vehicle(-18.00, 2));
        assertEquals("get east bound velocity", 5, scenicroad.getVelocityEastbound(), 0.00);
        assertEquals("get west bound velocity", 5, scenicroad.getVelocityWestbound(), 0.00);
        Vehicle v = new Vehicle(25, 1);
        scenicroad.add(v);
        assertEquals("contains v", true, scenicroad.contains(v));
        assertEquals("get v velocity", 5, v.getVelocity(), 0.00);
        scenicroad.remove(v);
        assertEquals("contains v after remove", false, scenicroad.contains(v));
    }
}
