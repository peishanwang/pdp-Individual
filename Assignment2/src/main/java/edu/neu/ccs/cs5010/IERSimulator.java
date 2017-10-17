package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * Interface of ERSimulator contains methods to run simulation.
 */
public interface IERSimulator {
  /**
   * Run simulation will choose to generate patients randomly or generate preset
   * patients according the simulation type provided by client.
   */
  void runSimulation();

  /**
   * Returns emergencyRoom of the simulation.
   * @return emergencyRoomof the simulation.
   */
  IEmergencyRoom getEmergencyRoom();

  /**
   * Returns end time of the simulation.
   * @return end time of the simulation.
   */
  LocalDateTime getSimEndTime();

  /**
   * Returns start time of the simulation.
   * @return start time of the simulation.
   */
  LocalDateTime getSimStartTime();
}
