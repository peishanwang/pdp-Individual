package edu.neu.ccs.cs5010;

public class RandomGenerator implements IPatientGenerator{

  @Override
  public Patient generatePatient() {
    return new Patient();
  }
}
