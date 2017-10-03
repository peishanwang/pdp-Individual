package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * PatientTest tests whether Patient.class works well.
 *
 * @see Patient
 */
public class PatientTest {
    private IPatient presetPatient = new Patient(10);
    private IPatient randomPatient = new Patient();

    //test preset patient
    @Test
    public void testPreset() {
        Assert.assertEquals(1, presetPatient.getUrgency());
        Assert.assertEquals(10, presetPatient.getTreatmentMinutes());
        Assert.assertEquals(LocalDateTime.MIN, presetPatient.getTreatmentStart());
        Assert.assertEquals(LocalDateTime.MIN.plusSeconds(10), presetPatient.getTreatmentEnd());
        LocalDateTime current = LocalDateTime.now();
        presetPatient.setTreatmentStart(current);
        Assert.assertEquals(current.toString(), presetPatient.getTreatmentStart().toString());
        Assert.assertEquals(current.plusSeconds(10), presetPatient.getTreatmentEnd());
    }

    //test randomly generated patient
    @Test
    public void testRandom() {
        int urgency = randomPatient.getUrgency();
        Assert.assertEquals(urgency, randomPatient.getUrgency());
    }


}
