package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * Interface of EmergencyRoom
 *
 * @see EmergencyRoom
 */
public interface IEmergencyRoom {
  /**
   * Returns amount of examination rooms in emergency room
   *
   * @return amount of examination rooms in emergency room
   */
  int getNumberOfRooms();

  /**
   * Add a patient to patients' waiting queue
   *
   * @param patient A patient to be added
   */
  void insertWaitingQueue(Patient patient);

  /**
   * Removes the patient with highest priority in patients' waiting queue
   * and returns it
   *
   * @return the patient with highest priority in patients' waiting queue
   */
  Patient removeWaitingQueue();

  /**
   * Returns the patient with highest priority in patients' waiting queue
   * without removing it
   *
   * @return the patient with highest priority in patients' waiting queue
   */
  Patient peekWaitingQueue();

  /**
   * Add an examination room to empty rooms queue
   *
   * @param room A examination room to be added
   */
  void insertEmptyRooms(ExamRoom room);

  /**
   * Removes the examination room with highest priority in empty room queue
   * and returns it
   *
   * @return the examination room with highest priority in empty room queue
   */
  ExamRoom removeEmptyRooms();

  /**
   * Returns the examination room with highest priority in empty room queue
   * without removing it
   *
   * @return the examination room with highest priority in empty room queue
   */
  ExamRoom peekEmptyRooms();

  /**
   * Add an examination room to busy rooms queue
   *
   * @param room A examination room to be added
   */
  void insertBusyRooms(ExamRoom room);

  /**
   * Removes the examination room with highest priority in busy room queue
   * and returns it
   *
   * @return the examination room with highest priority in busy room queue
   */
  ExamRoom removeBusyRooms();

  /**
   * Returns the examination room with highest priority in busy room queue
   * without removing it
   *
   * @return the examination room with highest priority in busy room queue
   */
  ExamRoom peekBusyRooms();

  /**
   * Returns the examination room list
   *
   * @return the examination room list
   */
  List<ExamRoom> getExamRoomList();

  /**
   * Returns the patient list
   *
   * @return the patient list
   */
  List<Patient> getPatientList();

  /**
   * Add a patient to patients' list
   *
   * @param patient A patient to be added
   */
  void addPatientList(Patient patient);

  /**
   * Returns whether patients' waiting queue is empty
   *
   * @return true if patients' waiting queue is empty, otherwise false
   */
  boolean emptyWaitingQueue();

  /**
   * Returns whether empty examination room queue is empty
   *
   * @return true if empty examination room queue is empty, otherwise false
   */
  boolean noEmptyRooms();

  /**
   * Returns whether busy examination room queue is empty
   *
   * @return true if busy examination room queue is empty, otherwise false
   */
  boolean noBusyRooms();
}
