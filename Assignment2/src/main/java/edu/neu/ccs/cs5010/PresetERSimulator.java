package edu.neu.ccs.cs5010;

/**
 * PresetERSimulator is used to generate in preset mode.
 */
public class PresetERSimulator extends ERSimulator {

  /**
   * Constructor of PresetERSimulator
   * @param parameters input information
   */
  public PresetERSimulator(IInputScanner parameters) {
    super(parameters);
    patientGenerator = new PresetGenerator(parameters.getPreDurationMins());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void sleep() {
    try {
        Thread.sleep(parameters.getPreIntervalMins() * 1000);
      } catch (InterruptedException e) {
        System.out.println("got interrupted!");
    }
  }
}
