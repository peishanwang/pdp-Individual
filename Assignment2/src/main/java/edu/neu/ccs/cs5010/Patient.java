package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Patient is a simple object which has a patient's information, including
 * patient arrival time, treatment start time, treatment duration(minutes) and
 * urgency level.
 */
public class Patient implements Comparable<Patient>, IPatient {
  private LocalDateTime arrivalTime;
  private LocalDateTime treatmentStart;
  private Urgency urgency;
  private int treatmentMinutes;
  private static Random random = new Random();
  private final static int PRESET_URGENCY = 1;
  private final static int SHORTEST_DURATION = 5;
  private final static int LONGEST_DURATION = 35;
  private final static int MAX_URGENCY = 10;


  /**
   * Constructor for generating preset patient
   *
   * @param duration client preset treatment duration
   */
  public Patient(int duration) {
    arrivalTime = LocalDateTime.now();
    treatmentMinutes = duration;
    treatmentStart = LocalDateTime.MIN;
    //set all preset urgency degree equals 1
    urgency = new Urgency(PRESET_URGENCY);
  }

  /**
   * Constructor for generating patient randomly
   */
  public Patient() {
    this(SHORTEST_DURATION + random.nextInt(LONGEST_DURATION - SHORTEST_DURATION + 1));
    //urgency level: 1 to 10
    urgency = new Urgency(1 + random.nextInt(MAX_URGENCY));
  }

  /**
   * Compare patients according to their injury urgency level.
   * The patient with higher urgency level(small number) has higher priority.
   * If urgency is the same, compare them according to their arrival time.
   *
   * @param other another object to be compared to
   */
  @Override
  public int compareTo(Patient other) {
    if (other == null) {
      throw new NullPointerException();
    }
    if (this.getUrgency().moreUrgentThan(other.getUrgency())) {
      return -1;
    } else if (this.getUrgency().lessUrgentThan(other.getUrgency())) {
      return 1;
    } else {
      if (this.getArrivalTime().isBefore(other.getArrivalTime())) {
        return -1;
      } else if (this.getArrivalTime().isAfter(other.getArrivalTime()))
        return 1;
    }
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Urgency getUrgency() {
    return urgency;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getArrivalTime() {
    return arrivalTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getTreatmentMinutes() {
    return treatmentMinutes;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getTreatmentEnd() {
    return treatmentStart.plusSeconds(treatmentMinutes);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getTreatmentStart() {
    return treatmentStart;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTreatmentStart(LocalDateTime time) {
    treatmentStart = time;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setUrgency(int num) {
    urgency = new Urgency(num);
  }

}
