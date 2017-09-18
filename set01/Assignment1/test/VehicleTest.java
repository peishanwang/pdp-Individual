package Assignment1.test;
import Assignment1.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by peishan on 2017/9/13.
 */
public class VehicleTest {
    private static Vehicle vehicle = null;

    @Test(expected = IllegalArgumentException.class)
    public void noArgsConstructorException() {
        vehicle = new Vehicle();
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongFormatException() {
        vehicle = new Vehicle(4.08);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalDirectionException() {
        vehicle = new Vehicle(10.5, 3);
    }

    @Test
    public void negativeVelocity() {
        vehicle = new Vehicle(-15.00, 1);
        assertEquals(15.00, vehicle.getVelocity(), 0.00);
        assertEquals(2, vehicle.getDirection());
    }

    @Test
    public void testSetter() {
        vehicle = new Vehicle(15.00, 1);
        vehicle.setVelocity(10.00);
        assertEquals(10.0, vehicle.getVelocity(), 0.00);
    }
}
