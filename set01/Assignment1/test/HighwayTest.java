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
public class HighwayTest {
    private static Highway highway = null;

    @BeforeClass
    public static void setupBeforeTests() throws Exception {
        highway = new Highway();
    }

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
