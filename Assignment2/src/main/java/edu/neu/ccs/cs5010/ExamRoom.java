package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * ExamRoom is a simple object which has property including total busy time,
 * total number of treating patients, current patient departure time and
 * roomNumber.
 */
public class ExamRoom implements Comparable<ExamRoom>, IExamRoom  {
  private int totalBusyMinutes;
  private int totalPatients;
  private LocalDateTime departureTime;
  final private int roomNumber;

  /**
   * Compare ExamRooms according to their total busy time.
   * The ExamRoom with less busy time has higher priority.
   *
   * @param other another object to be compared to
   */
  @Override
  public int compareTo(ExamRoom other) {
    if (other == null) {
      throw new NullPointerException();
    }
    if (this.getTotalBusyMinutes() < other.getTotalBusyMinutes()) {
      return -1;
    } else if (this.getTotalBusyMinutes() > other.getTotalBusyMinutes()) {
      return 1;
    } else {
      if (this.getRoomNumber() < other.getRoomNumber()) {
        return -1;
      } else if (this.getRoomNumber() > other.getRoomNumber())
        return 1;
    }
    return 0;
  }

  /**
   * Constructor for ExamRoom
   *
   * @param roomNumber the specified room number
   */
  public ExamRoom(int roomNumber) {
    this.roomNumber = roomNumber;
    totalBusyMinutes = 0;
    totalPatients = 0;
    departureTime = LocalDateTime.MAX;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getDepartureTime() {
    return departureTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getRoomNumber() {
    return roomNumber;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getTotalBusyMinutes() {
    return totalBusyMinutes;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getTotalPatients() {
    return totalPatients;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addTotalBusyMinutes(int minutes) {
    totalBusyMinutes += minutes;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDepartureTime(LocalDateTime time) {
    departureTime = time;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addTotalPatients() {
    totalPatients++;
  }
}
