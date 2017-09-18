package Assignment1.test;
import Assignment1.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * VehicleTest tests whether Vehicle works well. To successfully create a Vehicle
 * object, the constructor needs two parameter. And the second parameter "direction"
 * must be either 1 or 2. When the velocity of a Vehicle is negative, we regard it as
 * opposite direction bounding, and set its velocity to the absolute value;
 *
 * @see Assignment1.Vehicle
 *
 * @author Peishan Wang
 */
public class VehicleTest {
    private static Vehicle vehicle = null;

    /**
     * Tests that Vehicle throws an IllegalArgumentException
     * when providing no parameter the constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void noArgsConstructorException() {
        vehicle = new Vehicle();
    }

    /**
     * Tests that Vehicle throws an IllegalArgumentException
     * when providing only one double parameter the constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void wrongFormatException() {
        vehicle = new Vehicle(4.08);
    }

    /**
     * Tests that Vehicle throws an IllegalArgumentException
     * if the provided direction is of illegal value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void illegalDirectionException() {
        vehicle = new Vehicle(10.5, 3);
    }

    /**
     * Tests that Vehicle's variable value accords with the parameter given to
     * the constructor when the provided velocity is non-negative.
     */
    @Test
    public void negativeVelocity() {
        vehicle = new Vehicle(-15.00, 1);
        assertEquals(15.00, vehicle.getVelocity(), 0.00);
        assertEquals(2, vehicle.getDirection());
    }

    /**
     * Tests that Vehicle's variable value equals to the parameter given to
     * the constructor when the provided velocity is non-negative.
     */
    @Test
    public void testSetter() {
        vehicle = new Vehicle(15.00, 1);
        vehicle.setVelocity(10.00);
        assertEquals(10.0, vehicle.getVelocity(), 0.00);
    }
}
