package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * ExamRoomTest tests whether ExamRoom.class works well.
 *
 * @see ExamRoom
 */
public class ExamRoomTest {

  @Test
  public void testCompareTo() {
    ExamRoom er1 = new ExamRoom(1);
    ExamRoom er2 = new ExamRoom(2);
    ExamRoom er3 = new ExamRoom(3);
    ExamRoom er4 = new ExamRoom(3);
    er1.addTotalBusyMinutes(4);
    Assert.assertEquals(er1.compareTo(er2), 1);
    Assert.assertEquals(er2.compareTo(er1), -1);
    Assert.assertEquals(er4.compareTo(er3), 0);
    Assert.assertEquals(er2.compareTo(er3), -1);
    Assert.assertEquals(er3.compareTo(er2), 1);
  }

  @Test(expected = NullPointerException.class)
  public void testException() {
    ExamRoom er1 = new ExamRoom(1);
    er1.compareTo(null);
  }
}
