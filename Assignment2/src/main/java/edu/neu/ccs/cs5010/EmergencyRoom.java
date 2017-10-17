package edu.neu.ccs.cs5010;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Emergency Room is a container with busy examination rooms, empty examination
 * rooms, patients waiting queue, list of all the patients and list of all the
 * examination rooms.
 */
public class EmergencyRoom implements IEmergencyRoom {
  private final int numberOfRooms;
  private IPriorityQueue<Patient> waitingQueue;
  private IPriorityQueue<ExamRoom> emptyRooms;
  private IPriorityQueue<ExamRoom> busyRooms;
  private List<Patient> patientList;
  private List<ExamRoom> examRoomList;

  /**
   * Constructor for EmergencyRoom object
   *
   * @param numberOfRooms total number of examination rooms in emergency room
   */
  @SuppressWarnings("unchecked")
  public EmergencyRoom(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
    waitingQueue = new MyPriorityQueue<>();
    emptyRooms = new MyPriorityQueue<>();
    busyRooms = new MyPriorityQueue<>((o1, o2) -> {
      if (o1.getDepartureTime().isBefore(o2.getDepartureTime())) {
        return -1;
      } else {
        return 1;
      }
    });
    patientList = new LinkedList<>();
    examRoomList = new LinkedList<>();
    for (int i = 0; i < numberOfRooms; i++) {
      ExamRoom room = new ExamRoom(i);
      examRoomList.add(room);
      insertEmptyRooms(room);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void insertWaitingQueue(Patient patient) {
    waitingQueue.insert(patient);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Patient removeWaitingQueue() {
    return waitingQueue.remove();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Patient peekWaitingQueue() {
    return waitingQueue.front();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void insertEmptyRooms(ExamRoom room) {
    emptyRooms.insert(room);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ExamRoom removeEmptyRooms() {
    return emptyRooms.remove();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ExamRoom peekEmptyRooms() {
    return emptyRooms.front();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void insertBusyRooms(ExamRoom room) {
    busyRooms.insert(room);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ExamRoom removeBusyRooms() {
    return busyRooms.remove();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ExamRoom peekBusyRooms() {
    return busyRooms.front();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<ExamRoom> getExamRoomList() {
    return examRoomList;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Patient> getPatientList() {
    return patientList;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addPatientList(Patient patient) {
    patientList.add(patient);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean emptyWaitingQueue() {
    return waitingQueue.isEmpty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean noEmptyRooms() {
    return emptyRooms.isEmpty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean noBusyRooms() {
    return busyRooms.isEmpty();
  }
}
