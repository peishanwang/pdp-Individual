package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * ExamRoom is a simple object which has property including total busy time,
 * total number of treating patients, current patient departure time and
 * roomNumber.
 */
public class ExamRoom implements Comparable{
    private int totalBusyMinutes;
    private int totalPatients;
    private LocalDateTime departureTime;
    final private int roomNumber;

    /**
     * Compare ExamRooms according to their total busy time.
     * The ExamRoom with less busy time has higher priority.
     * @param o another object to be compared to
     */
    @Override
    public int compareTo(Object o) {
        if (this.getTotalBusyMinutes() < ((ExamRoom) o).getTotalBusyMinutes()) {
            return -1;
        } else if (this.getTotalBusyMinutes() > ((ExamRoom) o).getTotalBusyMinutes()) {
            return 1;
        } else {
            if (this.getRoomNumber() < ((ExamRoom) o).getRoomNumber()) {
                return -1;
            } else if (this.getRoomNumber() > ((ExamRoom) o).getRoomNumber())
                return 1;
        }
        return 0;
    }

    /**
     * Constructor for ExamRoom
     * @param roomNumber the specified room number
     */
    public ExamRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        totalBusyMinutes = 0;
        totalPatients = 0;
        departureTime = LocalDateTime.MAX;
    }

    /**
     * Returns departure time of current patient in ExamRoom.
     * @return departure time of current patient
     */
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    /**
     * Returns the number of ExamRoom
     * @return the number of ExamRoom
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns total busy time in minutes of the ExamRoom
     * @return total busy time in minutes
     */
    public int getTotalBusyMinutes() {
        return totalBusyMinutes;
    }

    /**
     * Returns total treated patients in the ExamRoom
     * @return number of total treated patients
     */
    public int getTotalPatients() {
        return totalPatients;
    }

    /**
     * Add current patient's treatment time to total busy time
     * @param minutes current patient's treatment time
     */
    public void addTotalBusyMinutes(int minutes) {
        totalBusyMinutes += minutes;
    }

    /**
     * Set current patient's departure time
     * @param time current patient's departure time
     */
    public void setDepartureTime(LocalDateTime time) {
        departureTime = time;
    }

    /**
     * Add one to total patients
     */
    public void addTotalPatients() {
        totalPatients++;
    }
}
