/**
 * This is part of Assignment 1: Environment Setup and Review of Java for PDP, Fall 2017
 */
package Assignment1;

import java.lang.Iterable;
import java.util.*;

/**
 * This is a container that can be used to contain Vehicles.
 * A given Vehicle may only appear on a Highway once.
 */
public class Highway implements Iterable<Vehicle> {

    // Contents of the Highway.
    private Set<Vehicle> contents;
    private int eastBound, westBound;

    /**
     * Constructor that creates a new Highway.
     */
    public Highway() {
            contents = new LinkedHashSet<Vehicle>();
            eastBound = 0;
            westBound = 0;
    }

   /**
     * Implements the Iterable interface for this container.
          * @return an Iterator over the Vehicle objects contained
     * in this container.
     */
    public Iterator<Vehicle> iterator() {
           // If we just returned the iterator of "contents", a client
        // could call the remove() method on the iterator and modify
        // it behind our backs.  Instead, we wrap contents in an
        // "unmodifiable set"; calling remove() on this iterator
        // throws an exception.  This is an example of avoiding
        // "representation exposure."  
        return Collections.unmodifiableSet(contents).iterator();
    }

    /**
     * Adds a vehicle on the Highway. This method returns <tt>true</tt>
     * if a Vehicle was successfully added on the Highway, i.e. vehicle is
     * not already on the Highway. (You are allowed to put
     * a Vehicle on a Highway only once. Hence, this method returns
     * <tt>false</tt>, if a Vehicle is already on the Highway).
     * @param v Vehicle to be added.
     * @requires v != null.
     * @return true if vehicle was successfully added on the highway,
     * i.e. vehicle is not already on the highway. Returns false, if vehicle is
     * already on the highway.
     */
    public boolean add(Vehicle v) {
        if (contents.contains(v)) return false;
        contents.add(v);
        if (v.getDirection() == 1) {
            eastBound++;
        } else {
            westBound++;
        }
        return true;
    }

    /**
     * Removes a vehicle from the highway. This method returns
     * <tt>true</tt> if vehicle was successfully removed from the
     * highway, i.e. vehicle is actually on the highway. You cannot
     * remove a Vehicle if it is not already on the Highway, and so ths
     * method will return <tt>false</tt>, otherwise.
     * @param v Vehicle to be removed.
     * @requires v != null.
     * @return true if vehicle was successfully removed from the Highway,
     * i.e. vehicle is actually on the highway. Returns false, if vehicle is not
     * on the highway.
     */
    public boolean remove(Vehicle v) {
        if (!contents.contains(v)) return false;
        contents.remove(v);
        if (v.getDirection() == 1) {
            eastBound--;
        } else {
            westBound--;
        }
        return true;
    }

    /**
     * Each Vehicle has a velocity. This method returns the velocity of the slowest vehicle in the Eastbound direction of the highway.
     * @return the velocity of the slowest eastbound vehicle
     */
    public double getVelocityEastbound() {
        if (eastBound == 0) return 0.0;
        return findSlowest(1);
    }
    
    /**
     * Each Vehicle has a velocity. This method returns the velocity of the slowest vehicle in the Westbound direction of the highway.
     * @return the velocity of the slowest westbound vehicle
     */
    public double getVelocityWestbound() {
        if (westBound == 0) return 0.0;
        return findSlowest(2);
    }

    /**
     * Returns the number of Vehicles headed Eastbound.
     * @return the number of Vehicles headed Eastbound on the highway
     */
    public int numberVehiclesEastbound() {
        return  eastBound;
    }
    
     /**
     * Returns the number of Vehicles headed Westbound.
     * @return the number of Vehicles headed Westbound on the highway
     */
    public int numberVehiclesWestbound() {
        return westBound;
    }

    /**
     * This method returns <tt>true</tt> if a specific Vehicle is on the Highway. 
	 * It will return <tt>false</tt> otherwise.
	 * @param v Vehicle to be checked if its on the Highway
     * @requires v != null.
     * @return true if this vehicle is on the Highway. Returns
     * false, otherwise.
     */
    public boolean contains(Vehicle v) {
       return contents.contains(v);
    }

    /**
     * This method returns the lowest velocity of vehicles in the input direction.
     * @param direction 1 means east bounding, 2 means west bounding
     * @requires dirction == 1 or direction == 2.
     * @return the lowest velocity of vehicles in the input direction
     */
    private Double findSlowest(int direction) {
        List<Vehicle> list = new ArrayList<>(contents);
        Collections.sort(list, (a, b) -> Double.compare(a.getVelocity(),b.getVelocity()));
        int index = 0;
        while (list.get(index).getDirection() != direction) index++;
        return list.get(index).getVelocity();
    }

}