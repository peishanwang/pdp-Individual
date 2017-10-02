package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

/**
 * EmergencyRoomTest checks whether Emergency Room works well.
 *
 * @see EmergencyRoom
 */
public class EmergencyRoomTest {
    private EmergencyRoom emr = new EmergencyRoom(3);

    @Test
    //test waiting queue
    public void test1() {
        Patient p1 = new Patient();
        Patient p2 = new Patient();
        Patient p3 = new Patient();
        p1.setUrgency(3);
        p2.setUrgency(1);
        p3.setUrgency(2);
        emr.insertWaitingQueue(p1);
        Assert.assertEquals(false, emr.emptyWaitingQueue());
        emr.insertWaitingQueue(p2);
        emr.insertWaitingQueue(p3);
        Assert.assertEquals(p2, emr.removeWaitingQueue());
        Assert.assertEquals(p3, emr.peekWaitingQueue());
        Assert.assertEquals(p3, emr.removeWaitingQueue());
        Assert.assertEquals(p1, emr.removeWaitingQueue());
        Assert.assertEquals(true, emr.emptyWaitingQueue());
    }

    @Test
    //test busyRooms
    public void test2() {
        ExamRoom er1 = new ExamRoom(1);
        ExamRoom er2 = new ExamRoom(2);
        ExamRoom er3 = new ExamRoom(3);
        LocalDateTime current = LocalDateTime.now();
        er1.setDepartureTime(current);
        er3.setDepartureTime(current.plusSeconds(1));
        er2.setDepartureTime(current.plusSeconds(2));
        emr.insertBusyRooms(er1);
        Assert.assertEquals(false, emr.noBusyRooms());
        emr.insertBusyRooms(er2);
        emr.insertBusyRooms(er3);
        Assert.assertEquals(er1, emr.removeBusyRooms());
        Assert.assertEquals(er3, emr.peekBusyRooms());
        Assert.assertEquals(er3, emr.removeBusyRooms());
        Assert.assertEquals(er2, emr.removeBusyRooms());
        Assert.assertEquals(true, emr.noBusyRooms());
    }

    @Test
    //test emptyRooms
    public void test3() {
        ExamRoom eer1 = emr.removeEmptyRooms();
        ExamRoom eer2 = emr.removeEmptyRooms();
        ExamRoom eer3 = emr.removeEmptyRooms();
        Assert.assertEquals(true, emr.noEmptyRooms());
        eer1.addTotalBusyMinutes(10);
        eer2.addTotalBusyMinutes(3);
        eer3.addTotalBusyMinutes(20);
        emr.insertEmptyRooms(eer1);
        Assert.assertEquals(false, emr.noEmptyRooms());
        emr.insertEmptyRooms(eer2);
        emr.insertEmptyRooms(eer3);
        Assert.assertEquals(eer2, emr.removeEmptyRooms());
        Assert.assertEquals(eer1, emr.peekEmptyRooms());
        Assert.assertEquals(eer1, emr.removeEmptyRooms());
    }

    @Test
    //test room list
    public void test4() {
        Assert.assertEquals(3, emr.getNumberOfRooms());
        List<ExamRoom> roomList= new MyLinkedList();
        ExamRoom eer1 = emr.removeEmptyRooms();
        ExamRoom eer2 = emr.removeEmptyRooms();
        ExamRoom eer3 = emr.removeEmptyRooms();
        roomList.add(eer1);
        roomList.add(eer2);
        roomList.add(eer3);
        Assert.assertEquals(roomList, emr.getExamRoomList());
    }

    @Test
    //test patient list
    public void test5() {
        List<Patient> patientList = new MyLinkedList<>();
        Patient p1 = new Patient();
        Patient p2 = new Patient();
        Patient p3 = new Patient();
        emr.addPatientList(p1);
        emr.addPatientList(p2);
        emr.addPatientList(p3);
        patientList.add(p1);
        patientList.add(p2);
        patientList.add(p3);
        Assert.assertEquals(patientList, emr.getPatientList());
    }
}
