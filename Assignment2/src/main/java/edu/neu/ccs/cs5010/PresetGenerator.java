package edu.neu.ccs.cs5010;

public class PresetGenerator implements IPatientGenerator{
  int duration;

  public PresetGenerator(int duration) {
    this.duration = duration;
  }

  @Override
  public Patient generatePatient() {
    return new Patient(duration);
  }
}
