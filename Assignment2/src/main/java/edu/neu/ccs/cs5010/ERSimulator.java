package edu.neu.ccs.cs5010;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * ERSimulator simulate the treatment of patients in a hospital emergency room.
 */
public abstract class ERSimulator implements IERSimulator{
  private IEmergencyRoom emerRoom;
  private LocalDateTime simEndTime;
  private LocalDateTime simStartTime;
  private final static String PRESET = "preset";
  IPatientGenerator patientGenerator;
  IInputScanner parameters;

  /**
   * Constructor of ERSimulator
   * @param parameters input information
   */
  public ERSimulator(IInputScanner parameters) {
    this.parameters = parameters;
    emerRoom = new EmergencyRoom(parameters.getNumberofRooms());
  }

  /**
   * abstract method sleep.
   */
  abstract void sleep();

  /**
   * Main method of ERSimulator.
   * @param args input arguments
   */
  public static void main(String[] args) {
    IInputScanner parameters = new InputScanner();
    IERSimulator simulator;
    if (parameters.getType().equals(PRESET)) {
      simulator = new PresetERSimulator(parameters);
    } else {
      simulator = new RandomERSimulator(parameters);
    }
    simulator.runSimulation();
    Printer printer = new Printer(
        simulator.getEmergencyRoom(),
        simulator.getSimStartTime(),
        simulator.getSimEndTime());
    printer.print();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IEmergencyRoom getEmergencyRoom() {
    return emerRoom;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getSimEndTime() {
    return simEndTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getSimStartTime() {
    return simStartTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void runSimulation() {
    System.out.println("\n\t*** Start Simulation ***\n");
    simStartTime = LocalDateTime.now();
    LocalDateTime genEndTime = simStartTime.plusMinutes(parameters.getSimulationHours());
    while (LocalDateTime.now().isBefore(genEndTime)) {
      sleep();
      System.out.println("A patient created!");
      Patient patient = patientGenerator.generatePatient();
      emerRoom.addPatientList(patient);
      handleNewPatient(patient);
    }
    afterGeneration();
  }

  /**
   * When a new patient comes, we first deal with the departure and current patients.
   * If there is still an empty examination room, we can allocate it to the new patient.
   * Otherwise, the new patient have to wait in the waiting queue.
   */
  private void handleNewPatient(Patient patient) {
    if (checkDeparture()) {
      addPatientToEmptyRoom(patient, emerRoom.removeEmptyRooms(), patient.getArrivalTime());
    } else {
      emerRoom.insertWaitingQueue(patient);
    }
  }

  /**
   * Check whether it is time for a patient in busy room to depart.
   * And return whether there is an empty room left after dealing with all the departure
   * and insert patients currently in waiting queue to available room.
   */
  private boolean checkDeparture() {
    while (!emerRoom.noBusyRooms() && emerRoom.peekBusyRooms().getDepartureTime().isBefore(LocalDateTime.now())) {
      LocalDateTime departureTime = emerRoom.peekBusyRooms().getDepartureTime();
      ExamRoom currRoom = emerRoom.removeBusyRooms();
      emerRoom.insertEmptyRooms(currRoom);
      if (!emerRoom.emptyWaitingQueue()) {
        Patient patient = emerRoom.removeWaitingQueue();
        LocalDateTime startTime;
        if (departureTime.isBefore(patient.getArrivalTime())) {
          startTime = patient.getArrivalTime();
        } else {
          startTime = departureTime;
        }
        addPatientToEmptyRoom(patient, emerRoom.removeEmptyRooms(), startTime);
      }
    }
    return !emerRoom.noEmptyRooms();
  }

  /**
   * Add a patient to the empty room with least total busy time.
   */
  private void addPatientToEmptyRoom(Patient patient, ExamRoom room, LocalDateTime time) {
    patient.setTreatmentStart(time);
    room.setDepartureTime(patient.getTreatmentEnd());
    room.addTotalBusyMinutes(patient.getTreatmentMinutes());
    room.addTotalPatients();
    emerRoom.insertBusyRooms(room);
  }

  /**
   * After the MAX_TIME, there is no new patients will be generated.
   * We only need to deal with the patients who wait in the waiting queue.
   */
  private void afterGeneration() {
    while (!emerRoom.emptyWaitingQueue()) {
      long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), emerRoom.peekBusyRooms().getDepartureTime());
      try {
        Thread.sleep(seconds * 1000);
      } catch (InterruptedException e) {
        System.out.println("got interrupted!");
      }
      checkDeparture();
    }
    while (!emerRoom.noBusyRooms()) {
      simEndTime = emerRoom.removeBusyRooms().getDepartureTime();
    }

  }

}
