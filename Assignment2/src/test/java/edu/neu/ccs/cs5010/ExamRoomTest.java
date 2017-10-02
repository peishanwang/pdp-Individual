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
    private ExamRoom er = new ExamRoom(1);

    //test ExamRoom
    @Test
    public void testExamRoom() {
        Assert.assertEquals(LocalDateTime.MAX, er.getDepartureTime());
        Assert.assertEquals(1, er.getRoomNumber());
        Assert.assertEquals(0, er.getTotalBusyMinutes());
        Assert.assertEquals(0, er.getTotalPatients());
        er.addTotalPatients();
        er.addTotalBusyMinutes(10);
        LocalDateTime current = LocalDateTime.now();
        er.setDepartureTime(current);
        Assert.assertEquals(current, er.getDepartureTime());
        Assert.assertEquals(10, er.getTotalBusyMinutes());
        Assert.assertEquals(1, er.getTotalPatients());
    }
}
