package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;

public class UrgencyTest {

  @Test
  public void testSame() {
    Urgency urg1 = new Urgency(1);
    Urgency urg2 = new Urgency(1);
    Assert.assertEquals(true, urg1.asUrgentAs(urg2));
  }

  @Test(expected = NullPointerException.class)
  public void testException() {
    Urgency urgency = new Urgency(1);
    urgency.compareTo(null);
  }

}
