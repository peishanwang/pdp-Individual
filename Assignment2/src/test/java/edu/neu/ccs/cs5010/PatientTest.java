package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * PatientTest tests whether Patient.class works well.
 *
 * @see Patient
 */
public class PatientTest {

  @Test(expected = NullPointerException.class)
  public void testException() {
    Patient p1 = new Patient();
    p1.compareTo(null);
  }

}
