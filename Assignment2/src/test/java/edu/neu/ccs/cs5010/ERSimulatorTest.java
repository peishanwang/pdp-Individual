package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;

/**
 * ERSimulatorTest is to check whether ERSimulator works well.
 *
 * @see ERSimulator
 */
public class ERSimulatorTest {
    private ERSimulator ers = new ERSimulator();

    @Test
    public void test() {
        ers.runSimulation();
    }

}
