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

        throw new RuntimeException();
    }

    public boolean remove(Vehicle v) {

        throw new RuntimeException();
    }

    private void setVelocityInJam() {
        Iterator<Vehicle> ite = this.iterator();
        // add setVelocity in Vehicle;
        while (ite.hasNext()) {
            ite.next().setVelocity(5.00);
        }
    }







}
