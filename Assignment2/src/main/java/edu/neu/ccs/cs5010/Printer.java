package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Printer implements IPrinter{
  IAnalyser analyser;
  IEmergencyRoom emergencyRoom;
  LocalDateTime startTime;
  LocalDateTime endTime;
  private static final int MINS_PER_HOUR = 60;

  public Printer(IEmergencyRoom emergencyRoom, LocalDateTime startTime, LocalDateTime endTime) {
    this.emergencyRoom = emergencyRoom;
    this.startTime = startTime;
    this.endTime = endTime;
    analyser = new Analyser();
  }

  @Override
  public void print() {
    System.out.println("\n============== Simulation Ends ==============\n\n");
    System.out.println("\t*** Simulation Report ***\n");

    List<ExamRoom> examRooms = emergencyRoom.getExamRoomList();
    List<Patient> patients = emergencyRoom.getPatientList();
    double totalMinutes = analyser.countMinutesBetween(startTime, endTime);
    //1.total examination rooms
    System.out.println("1.Total examination rooms: " + emergencyRoom.getNumberOfRooms());
    //2.total simulation running time
    System.out.print("2.Total simulation running time: ");
    System.out.println(totalMinutes / MINS_PER_HOUR + " hours");
    //3.total treated patients
    System.out.println("3.Total treated patients: " + patients.size());
    //4.Overall average waiting time
    System.out.println("4.Overall average waiting time: " + analyser.countAverageWaitingTime(patients) + " minutes");
    //4.1.Average waiting time for highest priority patients(urgency level 1-4)
    System.out.print("\tAverage waiting time for highest priority patients(urgency level 1-4): ");
    System.out.println(analyser.countHighestUrgencyWaitingTime(patients) + " minutes");
    //4.2.Average waiting time for highest priority patients(urgency level 1-4)
    System.out.print("\tAverage waiting time for lowest priority patients(urgency level 9-10): ");
    System.out.println(analyser.countLowestUrgencyWaitingTime(patients) + " minutes");
    //5.Overall average treatment duration
    System.out.println("5.Average treatment duration: " + analyser.countAverageDuration(patients) + " minutes");
    //6.Amount of patients treated in each examination room
    System.out.println("6.Amount of patients treated in each examination room: ");
    printAmountEachRoom(examRooms);
    //7.Busy time percentage of each examination room
    System.out.println("7.Busy time percentage of each examination room: ");
    printBusyEachRoom(examRooms, totalMinutes);
  }

  private void printAmountEachRoom(List<ExamRoom> examRooms) {
    int size = examRooms.size();
    for (int i = 0; i < size; i++) {
      System.out.print("\t\tRoom" + (i + 1) +": ");
      System.out.println(examRooms.get(i).getTotalPatients());
    }
  }

  private void printBusyEachRoom(List<ExamRoom> examRooms, double totalTime) {
    int size = examRooms.size();
    for (int i = 0; i < size; i++) {
      System.out.print("\t\tRoom" + (i + 1) +": ");
      System.out.print(examRooms.get(i).getTotalBusyMinutes() * 100.00 / totalTime);
      System.out.println("%");
    }
  }

}
