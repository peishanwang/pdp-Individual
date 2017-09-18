package Assignment1;

import java.util.Iterator;

/**
 * ScenicRoad is a Vehicle container similar to Highway. Compared to Highway, it can take on a
 * significantly smaller number of vehicles at once. Bandwidth is the maximum number of Vehicles
 * in a single direction that a ScenicRoad can take on without getting jammed. When there is a
 * jam, the velocity of all of the vehicles on the road typically decreases to 5mph.
 *
 * @see Assignment1.Highway
 *
 * @author Peishan Wang
 */
public class ScenicRoad {
    private int bandwidth;
    private Highway highway;

    /**
     * Constructor that creates a new ScenicRoad with its bandwidth.
     */
    public ScenicRoad (int bandwidth) {
        this.bandwidth = bandwidth;
        highway = new Highway();
    }

    /**
     * Implements the Iterable interface for this container.
     * @return an Iterator over the Vehicle objects contained
     * in this container.
     */
    public Iterator<Vehicle> iterator() {
        return highway.iterator();
    }

    /**
     * Adds a vehicle on the ScenicRoad. This method returns <tt>true</tt>
     * if a Vehicle was successfully added on the ScenicRoad. After adding
     * the new vehicle v to the ScenicRoad, if the number of vehicles on
     * either east or west bound is over bandwidth, set the velocity of all
     * the vehicles on the ScenicRoad to 5.00 mph.
     * @param v Vehicle to be added.
     * @requires v != null.
     * @return true if vehicle was successfully added on the ScenicRoad,
     * i.e. vehicle is not already on the ScenicRoad. Returns false, if vehicle is
     * already on the ScenicRoad.
     */
    public boolean add(Vehicle v) {
        boolean flag = highway.add(v);
        if (flag) {
            int eastNum = highway.numberVehiclesEastbound();
            int westNum = highway.numberVehiclesWestbound();
            if (eastNum > bandwidth || westNum > bandwidth) {
                Iterator<Vehicle> ite = highway.iterator();
                while (ite.hasNext()) {
                    ite.next().setVelocity(5.00);
                }
            }
        }
        return flag;
    }

    /**
     * Removes a vehicle from the ScenicRoad. This method returns
     * <tt>true</tt> if vehicle was successfully removed from the
     * ScenicRoad.
     * @param v Vehicle to be removed.
     * @requires v != null.
     * @return true if vehicle was successfully removed from the ScenicRoad,
     * i.e. vehicle is actually on the ScenicRoad. Returns false, if vehicle is not
     * on the ScenicRoad.
     */
    public boolean remove(Vehicle v) {
        return highway.remove(v);
    }

    /**
     * Each Vehicle has a velocity. This method returns the velocity of the
     * slowest vehicle in the Eastbound direction of the ScenicRoad.
     * @return the velocity of the slowest westbound vehicle
     */
    public double getVelocityEastbound() {
        return highway.getVelocityEastbound();
    }

    /**
     * Each Vehicle has a velocity. This method returns the velocity of the
     * slowest vehicle in the Westbound direction of the ScenicRoad.
     * @return the velocity of the slowest westbound vehicle
     */
    public double getVelocityWestbound() {
        return highway.getVelocityWestbound();
    }

    /**
     * Returns the number of Vehicles headed Eastbound.
     * @return the number of Vehicles headed Eastbound on the ScenicRoad
     */
    public int numberVehiclesEastbound() {
        return  highway.numberVehiclesEastbound();
    }

    /**
     * Returns the number of Vehicles headed Westbound.
     * @return the number of Vehicles headed Westbound on the ScenicRoad
     */
    public int numberVehiclesWestbound() {
        return highway.numberVehiclesWestbound();
    }

    /**
     * This method returns <tt>true</tt> if a specific Vehicle is on the ScenicRoad.
     * It will return <tt>false</tt> otherwise.
     * @param v Vehicle to be checked if its on the ScenicRoad
     * @requires v != null.
     * @return true if this vehicle is on the ScenicRoad. Returns
     * false, otherwise.
     */
    public boolean contains(Vehicle v) {
        return highway.contains(v);
    }
}
