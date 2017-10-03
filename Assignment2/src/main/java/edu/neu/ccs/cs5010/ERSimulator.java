package edu.neu.ccs.cs5010;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * ERSimulator simulate the treatment of patients in a hospital emergency room.
 */
public class ERSimulator {

    private IEmergencyRoom er;
    private LocalDateTime startTime;
    private LocalDateTime genEndTime;
    private LocalDateTime simEndTime;
    private int type;
    private int simulationHours;
    private int numberOfRooms;
    private int preIntervalMins;
    private int preDurationMins;
    private Random random;

    /**
     * Generate patients randomly
     */
    private void generateRandomPatients() {
        while (LocalDateTime.now().isBefore(genEndTime)) {
            int gapMinutes = 1 + random.nextInt(20);
            try{
                Thread.sleep(gapMinutes * 1000);
            }catch(InterruptedException e){
                System.out.println("got interrupted!");
            }
            System.out.println("A patient created!");
            Patient patient = new Patient();
            er.addPatientList(patient);
            handleNewPatient(patient);
        }
    }

    /**
     * Generate preset patients
     */
    private void generatePresetPatients(int preIntervalMins, int preDurationMins) {
        while (LocalDateTime.now().isBefore(genEndTime)) {
            try{
                Thread.sleep(preIntervalMins * 1000);
            }catch(InterruptedException e){
                System.out.println("got interrupted!");
            }
            System.out.println("A patient created!");
            Patient patient = new Patient(preDurationMins);
            er.addPatientList(patient);
            handleNewPatient(patient);
        }
    }

    /**
     * Run simulation will choose to generate patients randomly or generate preset
     * patients according the simulation type provided by client.
     */
    public void runSimulation() {
        System.out.println("\n\t*** Start Simulation ***\n");
        startTime = LocalDateTime.now();
        genEndTime = startTime.plusMinutes(simulationHours);
        if (type == 1) {
            generatePresetPatients(preIntervalMins, preDurationMins);
        } else {
            generateRandomPatients();
        }
    }

    /**
     * When a new patient comes, we first deal with the departure and current patients.
     * If there is still an empty examination room, we can allocate it to the new patient.
     * Otherwise, the new patient have to wait in the waiting queue.
     */
    public void handleNewPatient(Patient patient) {
        if (checkDeparture()) {
            addPatientToEmptyRoom(patient, er.removeEmptyRooms(), patient.getArrivalTime());
        } else {
            er.insertWaitingQueue(patient);
        }
    }

    /**
     * Check whether it is time for a patient in busy room to depart.
     * And return whether there is an empty room left after dealing with all the departure
     * and insert patients currently in waiting queue to available room.
     */
    public boolean checkDeparture() {
        while (!er.noBusyRooms() && er.peekBusyRooms().getDepartureTime().isBefore(LocalDateTime.now())) {
            LocalDateTime departureTime = er.peekBusyRooms().getDepartureTime();
            ExamRoom currRoom = er.removeBusyRooms();
            er.insertEmptyRooms(currRoom);
            if (!er.emptyWaitingQueue()) {
                Patient patient = er.removeWaitingQueue();
                LocalDateTime startTime;
                if (departureTime.isBefore(patient.getArrivalTime())) {
                    startTime = patient.getArrivalTime();
                } else {
                    startTime = departureTime;
                }
                addPatientToEmptyRoom(patient, er.removeEmptyRooms(), startTime);
            }
        }
        return !er.noEmptyRooms();
    }

    /**
     * Add a patient to the empty room with least total busy time.
     */
    public void addPatientToEmptyRoom(Patient patient, ExamRoom room, LocalDateTime time) {
        patient.setTreatmentStart(time);
        room.setDepartureTime(patient.getTreatmentEnd());
        room.addTotalBusyMinutes(patient.getTreatmentMinutes());
        room.addTotalPatients();
        er.insertBusyRooms(room);
    }

    /**
     * After the MAX_TIME, there is no new patients will be generated.
     * We only need to deal with the patients who wait in the waiting queue.
     */
    public void afterGeneration() {
        while (!er.emptyWaitingQueue()) {
            long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), er.peekBusyRooms().getDepartureTime());
            try{
                Thread.sleep(seconds * 1000);
            }catch(InterruptedException e){
                System.out.println("got interrupted!");
            }
            checkDeparture();
        }
        while (!er.noBusyRooms()) {
            simEndTime = er.removeBusyRooms().getDepartureTime();
        }

    }

    /**
     * Print readable simulation report
     */
    public void printResult() {
        System.out.println("\n============== Simulation Ends ==============\n\n");
        System.out.println("\t*** Simulation Report ***\n");

        List<ExamRoom> examRooms = er.getExamRoomList();
        List<Patient> patients = er.getPatientList();
        double totalMinutes = ChronoUnit.MILLIS.between(startTime, simEndTime) / 1000.0;
        //1.total examination rooms
        System.out.println("1.Total examination rooms: " + er.getNumberOfRooms());
        //2.total simulation running time
        System.out.print("2.Total simulation running time: ");
        System.out.println(totalMinutes / 60.00 + " hours");
        //3.total treated patients
        System.out.println("3.Total treated patients: " + patients.size());
        //4.Overall average waiting time
        System.out.println("4.Overall average waiting time: " + countAverageWaitingTime(patients) + " minutes");
        //4.1.Average waiting time for highest priority patients(urgency level 1-4)
        System.out.print("\tAverage waiting time for highest priority patients(urgency level 1-4): ");
        System.out.println(countHighestUrgencyWaitingTime(patients) + " minutes");
        //4.2.Average waiting time for highest priority patients(urgency level 1-4)
        System.out.print("\tAverage waiting time for lowest priority patients(urgency level 9-10): ");
        System.out.println(countLowestUrgencyWaitingTime(patients) + " minutes");
        //5.Overall average treatment duration
        System.out.println("5.Average treatment duration: " + countAverageDuration(patients) + " minutes");
        //6.Amount of patients treated in each examination room
        System.out.println("6.Amount of patients treated in each examination room: ");
        printAmountEachRoom(examRooms);
        //7.Busy time percentage of each examination room
        System.out.println("7.Busy time percentage of each examination room: ");
        printBusyEachRoom(examRooms, totalMinutes);
    }

    public static void main(String[] args) {
        ERSimulator ers = new ERSimulator();
        ers.setUpParameter();
        ers.runSimulation();
        ers.afterGeneration();
        ers.printResult();
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

    /**
     * Calculate average waiting time for the patients with urgency level 1-4.
     */
    private double countHighestUrgencyWaitingTime(List<Patient> patients) {
        int size = patients.size();
        if (size == 0) return 0.00;
        List<Patient> hList = new MyLinkedList<>();
        for (int i = 0; i < size; i++) {
            if (patients.get(i).getUrgency() > 4) {
                continue;
            }
            hList.add(patients.get(i));
        }
        return countAverageWaitingTime(hList);
    }

    /**
     * Calculate average waiting time for the patients with urgency level 9-10.
     */
    private double countLowestUrgencyWaitingTime(List<Patient> patients) {
        int size = patients.size();
        if (size == 0) return 0.00;
        List<Patient> lList = new MyLinkedList<>();
        for (int i = 0; i < size; i++) {
            if (patients.get(i).getUrgency() < 9) {
                continue;
            }
            lList.add(patients.get(i));
        }
        return countAverageWaitingTime(lList);
    }

    /**
     * Calculate average waiting time for all the patients
     */
    private double countAverageWaitingTime(List<Patient> patients) {
        long sum = 0;
        int size = patients.size();
        if (size == 0) return 0.00;
        for (int i = 0; i < size; i++) {
            Patient patient = patients.get(i);
            sum += ChronoUnit.MILLIS.between(patient.getArrivalTime(), patient.getTreatmentStart());
        }
        return sum / size / 1000.00;
    }

    /**
     * Calculate average treatment duration for all the patients
     */
    private double countAverageDuration(List<Patient> patients) {
        long sum = 0;
        int size = patients.size();
        for (int i = 0; i < size; i++) {
            Patient patient = patients.get(i);
            sum += patient.getTreatmentMinutes();
        }
        return sum * 1.0 / size;
    }

    /**
     * Set up the simulation parameters before running it
     */
    public void setUpParameter() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t***  Get Simulation Parameters  ***\n");
        do {
            System.out.print("Enter 0/1 to choose simulation type(random/preset): ");
            type = input.nextInt();
        } while (type != 0 && type != 1);
        do {
            System.out.print("Enter number of examination rooms: ");
            numberOfRooms = input.nextInt();
        } while (numberOfRooms <= 0);
        do {
            System.out.print("Enter MAX_TIME(hours) to generate patient(max is 10): ");
            simulationHours = input.nextInt();
        } while (simulationHours <= 0|| simulationHours > 10);

        if (type == 1) {
            do {
                System.out.print("Enter Interval between patients generation: ");
                preIntervalMins = input.nextInt();
            } while (numberOfRooms <= 0);
            do {
                System.out.print("Enter patients treatment duration: ");
                preDurationMins = input.nextInt();
            } while (preDurationMins <= 0);
        }
        input.close();
        er = new EmergencyRoom(numberOfRooms);
        random = new Random();
    }
}
