package edu.neu.ccs.cs5010;


import java.io.InputStream;

public interface IInputScanner {
  void handleInput(InputStream stream);
  int getSimulationHours();
  String getType();
  int getPreIntervalMins();
  int getPreDurationMins();
  int getNumberofRooms();
}
