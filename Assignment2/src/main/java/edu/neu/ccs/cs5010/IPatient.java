package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * Interface of Patient
 */
public interface IPatient {
    int getUrgency();
    LocalDateTime getArrivalTime();
    int getTreatmentMinutes();
    LocalDateTime getTreatmentEnd();
    LocalDateTime getTreatmentStart();
    void setTreatmentStart(LocalDateTime time);
    void setUrgency(int num);
}
