package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Patient is a simple object which has a patient's information, including
 * patient arrival time, treatment start time, treatment duration(minutes) and
 * urgency level.
 */
public class Patient implements Comparable, IPatient {
    private LocalDateTime arrivalTime;
    private LocalDateTime treatmentStart;
    private int treatmentMinutes;
    private int urgency;
    private static Random random = new Random();


    /**
     * Constructor for generating preset patient
     * @param duration client preset treatment duration
     */
    public Patient(int duration) {
        arrivalTime = LocalDateTime.now();
        treatmentMinutes = duration;
        treatmentStart = LocalDateTime.MIN;
        //set all preset urgency degree equals 1
        urgency = 1;
    }

    /**
     * Constructor for generating patient randomly
     */
    public Patient() {
        //treatment duration: from 5 minutes to 35 minutes
        this(5 + random.nextInt(31));
        //urgency level: 1 to 10
        urgency = 1 + random.nextInt(10);
    }

    /**
     * Compare patients according to their injury urgency level.
     * The patient with higher urgency level(small number) has higher priority.
     * If urgency is the same, compare them according to their arrival time.
     * @param o another object to be compared to
     */
    @Override
    public int compareTo(Object o) {
        Patient p = (Patient) o;
        if (this.getUrgency() < p.getUrgency()) {
            return -1;
        } else if (this.getUrgency() > p.getUrgency()) {
            return 1;
        } else {
            if (this.getArrivalTime().isBefore(p.getArrivalTime())) {
                return -1;
            } else if (this.getArrivalTime().isAfter(p.getArrivalTime()))
                return 1;
        }
        return 0;
    }



    /**
     * Returns the patient's urgency
     * @return patient's urgency
     */
    public int getUrgency() {
        return urgency;
    }

    /**
     * Returns the patient's arrival time
     * @return patient's arrival time
     */
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Returns the patient's treatment duration in minutes
     * @return patient's treatment duration in minutes
     */
    public int getTreatmentMinutes() {
        return treatmentMinutes;
    }

    /**
     * Returns the time when patient's treatment ends
     * @return patient's treatment ending time
     */
    public LocalDateTime getTreatmentEnd() {
        return treatmentStart.plusSeconds(treatmentMinutes);
    }

    /**
     * Returns the time when patient's treatment starts
     * @return patient's treatment start time
     */
    public LocalDateTime getTreatmentStart() {
        return treatmentStart;
    }

    /**
     * Set the time when patient's treatment starts
     * @param time patient's treatment start time
     */
    public void setTreatmentStart(LocalDateTime time) {
        treatmentStart = time;
    }

    /**
     * Set the patient's urgency
     * @param num patient's urgency level
     */
    public void setUrgency(int num) {
        urgency = num;
    }

}
