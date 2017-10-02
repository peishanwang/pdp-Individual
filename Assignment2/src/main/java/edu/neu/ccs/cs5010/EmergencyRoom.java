package edu.neu.ccs.cs5010;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Emergency Room is a container with busy examination rooms, empty examination
 * rooms, patients waiting queue, list of all the patients and list of all the
 * examination rooms.
 *
 */
public class EmergencyRoom {
    private final int numberOfRooms;
    private IPriorityQueue<Patient> waitingQueue;
    private IPriorityQueue<ExamRoom> emptyRooms;
    private IPriorityQueue<ExamRoom> busyRooms;
    private List<Patient> patientList;
    private List<ExamRoom> examRoomList;

    /**
     * Constructor for EmergencyRoom object
     * @param numberOfRooms total number of examination rooms in emergency room
     */
    public EmergencyRoom(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        waitingQueue = new MyPriorityQueue<>();
        emptyRooms = new MyPriorityQueue<>();
        busyRooms = new MyPriorityQueue<>(new Comparator<ExamRoom>() {
            @Override
            public int compare(ExamRoom o1, ExamRoom o2) {
                if (o1.getDepartureTime().isBefore(o2.getDepartureTime())) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        patientList = new LinkedList<>();
        examRoomList = new LinkedList<>();
        for (int i = 0; i < numberOfRooms; i++) {
            ExamRoom room = new ExamRoom(i);
            examRoomList.add(room);
            insertEmptyRooms(room);
        }
    }

    /**
     * Returns amount of examination rooms in emergency room
     * @return amount of examination rooms in emergency room
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Add a patient to patients' waiting queue
     * @param patient A patient to be added
     */
    public void insertWaitingQueue(Patient patient) {
        waitingQueue.insert(patient);
    }

    /**
     * Removes the patient with highest priority in patients' waiting queue
     * and returns it
     * @return the patient with highest priority in patients' waiting queue
     */
    public Patient removeWaitingQueue() {
        return waitingQueue.remove();
    }

    /**
     * Returns the patient with highest priority in patients' waiting queue
     * without removing it
     * @return the patient with highest priority in patients' waiting queue
     */
    public Patient peekWaitingQueue() {
        return waitingQueue.front();
    }

    /**
     * Add an examination room to empty rooms queue
     * @param room A examination room to be added
     */
    public void insertEmptyRooms(ExamRoom room) {
        emptyRooms.insert(room);
    }

    /**
     * Removes the examination room with highest priority in empty room queue
     * and returns it
     * @return the examination room with highest priority in empty room queue
     */
    public ExamRoom removeEmptyRooms() {
        return emptyRooms.remove();
    }

    /**
     * Returns the examination room with highest priority in empty room queue
     * without removing it
     * @return the examination room with highest priority in empty room queue
     */
    public ExamRoom peekEmptyRooms() {
        return emptyRooms.front();
    }

    /**
     * Add an examination room to busy rooms queue
     * @param room A examination room to be added
     */
    public void insertBusyRooms(ExamRoom room) {
        busyRooms.insert(room);
    }

    /**
     * Removes the examination room with highest priority in busy room queue
     * and returns it
     * @return the examination room with highest priority in busy room queue
     */
    public ExamRoom removeBusyRooms() {
        return busyRooms.remove();
    }

    /**
     * Returns the examination room with highest priority in busy room queue
     * without removing it
     * @return the examination room with highest priority in busy room queue
     */
    public ExamRoom peekBusyRooms() {
        return busyRooms.front();
    }

    /**
     * Returns the examination room list
     * @return the examination room list
     */
    public List<ExamRoom> getExamRoomList() {
        return  examRoomList;
    }

    /**
     * Returns the patient list
     * @return the patient list
     */
    public List<Patient> getPatientList() {
        return patientList;
    }

    /**
     * Add a patient to patients' list
     * @param patient A patient to be added
     */
    public void addPatientList(Patient patient) {
        patientList.add(patient);
    }

    /**
     * Returns whether patients' waiting queue is empty
     * @return true if patients' waiting queue is empty, otherwise false
     */
    public boolean emptyWaitingQueue() {
        return waitingQueue.isEmpty();
    }

    /**
     * Returns whether empty examination room queue is empty
     * @return true if empty examination room queue is empty, otherwise false
     */
    public boolean noEmptyRooms() {
        return emptyRooms.isEmpty();
    }

    /**
     * Returns whether busy examination room queue is empty
     * @return true if busy examination room queue is empty, otherwise false
     */
    public boolean noBusyRooms() {
        return busyRooms.isEmpty();
    }
}
