package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * Interface of ExamRoom.
 *
 * @see ExamRoom
 */
public interface IExamRoom {

  /**
   * Returns departure time of current patient in ExamRoom.
   * @return departure time of current patient
   */
  LocalDateTime getDepartureTime();

  /**
   * Returns the number of ExamRoom
   * @return the number of ExamRoom
   */
  int getRoomNumber();

  /**
   * Returns total busy time in minutes of the ExamRoom
   * @return total busy time in minutes
   */
  int getTotalBusyMinutes();

  /**
   * Returns total treated patients in the ExamRoom
   * @return number of total treated patients
   */
  int getTotalPatients();

  /**
   * Add current patient's treatment time to total busy time
   * @param minutes current patient's treatment time
   */
  void addTotalBusyMinutes(int minutes);

  /**
   * Set current patient's departure time
   * @param time current patient's departure time
   */
  void setDepartureTime(LocalDateTime time);

  /**
   * Add one to total patients
   */
  void addTotalPatients();
}
