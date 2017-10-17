package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;
import java.util.List;

public interface IAnalyser {
  /**
   * Calculate average waiting time for the patients with urgency level 1-4.
   */
  double countHighestUrgencyWaitingTime(List<Patient> patients);

  /**
   * Calculate average waiting time for the patients with urgency level 9-10.
   */
  double countLowestUrgencyWaitingTime(List<Patient> patients);

  /**
   * Calculate average waiting time for all the patients
   */
  double countAverageWaitingTime(List<Patient> patients);

  /**
   * Calculate average treatment duration for all the patients
   */
  double countAverageDuration(List<Patient> patients);

  /**
   * Calculate minutes interval between two time
   */
  double countMinutesBetween(LocalDateTime t1, LocalDateTime t2);
}
