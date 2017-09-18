package Assignment1.test;
import Assignment1.*;
import org.junit.Test;

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
    public void negativeVelocityException() {
        vehicle = new Vehicle(-1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalDirectionException() {
        vehicle = new Vehicle(10.5, 3);
    }
}
