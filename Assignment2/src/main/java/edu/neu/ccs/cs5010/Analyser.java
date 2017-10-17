package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Analyser implements IAnalyser{
  private static final int HIGH_URGENCY = 4;
  private static final int LOW_URGENCY = 9;

  /**
   * {@inheritDoc}
   */
  @Override
  public double countHighestUrgencyWaitingTime(List<Patient> patients) {
    int size = patients.size();
    if (size == 0) return 0.00;
    List<Patient> hList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      if (patients.get(i).getUrgency().getValue() > HIGH_URGENCY) {
        continue;
      }
      hList.add(patients.get(i));
    }
    return countAverageWaitingTime(hList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double countLowestUrgencyWaitingTime(List<Patient> patients) {
    int size = patients.size();
    if (size == 0) return 0.00;
    List<Patient> lList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      if (patients.get(i).getUrgency().getValue() < LOW_URGENCY) {
        continue;
      }
      lList.add(patients.get(i));
    }
    return countAverageWaitingTime(lList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double countAverageWaitingTime(List<Patient> patients) {
    long sum = 0;
    int size = patients.size();
    if (size == 0) return 0.00;
    for (int i = 0; i < size; i++) {
      Patient patient = patients.get(i);
      sum += ChronoUnit.MILLIS.between(patient.getArrivalTime(), patient.getTreatmentStart());
    }
    return (double) (sum / size) / 1000.00;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double countAverageDuration(List<Patient> patients) {
    long sum = 0;
    int size = patients.size();
    for (int i = 0; i < size; i++) {
      Patient patient = patients.get(i);
      sum += patient.getTreatmentMinutes();
    }
    return sum * 1.0 / size;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double countMinutesBetween(LocalDateTime t1, LocalDateTime t2) {
    return ChronoUnit.MILLIS.between(t1, t2) / 1000.0;
  }
}
