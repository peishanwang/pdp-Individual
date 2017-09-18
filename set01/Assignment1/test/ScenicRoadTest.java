package Assignment1.test;
import Assignment1.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
/**
 * Created by peishan on 2017/9/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScenicRoadTest {
    private static ScenicRoad scenicroad = null;

    @BeforeClass
    public static void setupBeforeTests() throws Exception {
        scenicroad = new ScenicRoad(2);
    }

    @Test
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
    public void test2() {
        scenicroad.add(new Vehicle(18.00, 2));
        scenicroad.add(new Vehicle(-18.00, 2));
        assertEquals("get east bound velocity", 5, scenicroad.getVelocityEastbound(), 0.00);
        assertEquals("get west bound velocity", 5, scenicroad.getVelocityWestbound(), 0.00);
        Vehicle v = new Vehicle(25, 1);
        scenicroad.add(v);
        assertEquals("contains v", true, scenicroad.contains(v));
        assertEquals("get v velocity", 5, v.getVelocity(), 0.00);
    }
}
