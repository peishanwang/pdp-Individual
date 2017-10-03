package edu.neu.ccs.cs5010;
import java.util.List;

/**
 * Interface of EmergencyRoom
 */
public interface IEmergencyRoom {
    int getNumberOfRooms();
    void insertWaitingQueue(Patient patient);
    Patient removeWaitingQueue();
    Patient peekWaitingQueue();
    void insertEmptyRooms(ExamRoom room);
    ExamRoom removeEmptyRooms();
    ExamRoom peekEmptyRooms();
    void insertBusyRooms(ExamRoom room);
    ExamRoom removeBusyRooms();
    ExamRoom peekBusyRooms();
    List<ExamRoom> getExamRoomList();
    List<Patient> getPatientList();
    void addPatientList(Patient patient);
    boolean emptyWaitingQueue();
    boolean noEmptyRooms();
    boolean noBusyRooms();
}
