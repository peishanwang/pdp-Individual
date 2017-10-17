package edu.neu.ccs.cs5010;


import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;


public class InputScanner implements IInputScanner {
  private String type;
  private int simulationHours;
  private int preIntervalMins;
  private int preDurationMins;
  private int numberOfRooms;
  private final static int ZERO = 0;
  private final static int MAX_HOURS = 10;
  private final static String PRESET = "preset";
  private final static String RANDOM = "random";
  private final static String ENCODING = "UTF-8";

  public InputScanner() {
    handleInput(System.in);
  }

  public void handleInput(InputStream stream) {
    Scanner input = new Scanner(stream, ENCODING);
    System.out.println("\n\t***  Get Simulation Parameters  ***\n");
    do {
      System.out.print("Enter word \"" + RANDOM + "\" or \"" + PRESET +
          "\" to choose simulation type: ");
      type = input.nextLine();
      if (!type.equals(PRESET) && !type.equals(RANDOM)) {
        System.out.println("You need to enter \"random\" or \"preset\".");
      }
    } while (!type.equals(PRESET) && !type.equals(RANDOM));

    do {
      System.out.print("Enter number of examination rooms: ");
      try {
        numberOfRooms = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("You need to enter an integer.");
      }
    } while (numberOfRooms <= ZERO);

    do {
      System.out.print("Enter MAX_TIME(hours) to generate patient(max is 10): ");
      try {
        simulationHours = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("You need to enter an integer not larger than 10.");
      }
    } while (simulationHours <= ZERO || simulationHours > MAX_HOURS);

    if (type.equals(PRESET)) {
      do {
        System.out.print("Enter Interval between patients generation: ");
        try {
          preIntervalMins = input.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("You need to enter an positive integer.");
        }
      } while (preIntervalMins <= ZERO);
      do {
        System.out.print("Enter patients treatment duration: ");
        try {
          preDurationMins = input.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("You need to enter an positive integer.");
        }
      } while (preDurationMins <= ZERO);
    }
    input.close();
  }

  public int getSimulationHours() {
    return simulationHours;
  }

  public String getType() {
    return type;
  }

  public int getPreIntervalMins() {
    return preIntervalMins;
  }

  public int getPreDurationMins() {
    return preDurationMins;
  }

  public int getNumberofRooms() {
    return numberOfRooms;
  }

}
