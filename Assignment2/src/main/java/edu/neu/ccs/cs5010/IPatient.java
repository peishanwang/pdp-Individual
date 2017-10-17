package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * Interface of Patient
 */
public interface IPatient {
  /**
   * Returns the patient's urgency
   *
   * @return patient's urgency
   */
  Urgency getUrgency();

  /**
   * Returns the patient's arrival time
   *
   * @return patient's arrival time
   */
  LocalDateTime getArrivalTime();

  /**
   * Returns the patient's treatment duration in minutes
   *
   * @return patient's treatment duration in minutes
   */
  int getTreatmentMinutes();

  /**
   * Returns the time when patient's treatment ends
   *
   * @return patient's treatment ending time
   */
  LocalDateTime getTreatmentEnd();

  /**
   * Returns the time when patient's treatment starts
   *
   * @return patient's treatment start time
   */
  LocalDateTime getTreatmentStart();

  /**
   * Set the time when patient's treatment starts
   *
   * @param time patient's treatment start time
   */
  void setTreatmentStart(LocalDateTime time);

  /**
   * Set the patient's urgency
   *
   * @param num patient's urgency level
   */
  void setUrgency(int num);
}
