package Assignment1;

import java.util.Iterator;

/**
 * Created by peishan on 2017/9/14.
 */
public class ScenicRoad {
    private int bandwidth;
    private Highway highway;

    public ScenicRoad (int bandwidth) {
        this.bandwidth = bandwidth;
        highway = new Highway();
    }

    public Iterator<Vehicle> iterator() {
        return highway.iterator();
    }

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

    public boolean remove(Vehicle v) {
        return highway.remove(v);
    }

    public double getVelocityEastbound() {
        return highway.getVelocityEastbound();
    }

    /**
     * Each Vehicle has a velocity. This method returns the velocity of the slowest vehicle in the Westbound direction of the highway.
     * @return the velocity of the slowest westbound vehicle
     */
    public double getVelocityWestbound() {
        return highway.getVelocityWestbound();
    }

    /**
     * Returns the number of Vehicles headed Eastbound.
     * @return the number of Vehicles headed Eastbound on the highway
     */
    public int numberVehiclesEastbound() {
        return  highway.numberVehiclesEastbound();
    }

    /**
     * Returns the number of Vehicles headed Westbound.
     * @return the number of Vehicles headed Westbound on the highway
     */
    public int numberVehiclesWestbound() {
        return highway.numberVehiclesWestbound();
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
        return highway.contains(v);
    }
}
