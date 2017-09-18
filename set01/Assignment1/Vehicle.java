/**
 * This is part of Assignment 1: Environment Setup and Review of Java for PDP, Fall 2017.
 */
package Assignment1;

/**
 * Vehicle is a simple object that has a velocity and a direction.
 */
// You may not make Ball implement the Comparable interface.
public class Vehicle {

   private double velocity;
   private int direction;
   
    /**
     * Constructor that creates a new vehicle object with the specified velocity and direction.
     * @param velocity Velocity of the new object.
     * @param direction Direction of the new object, where 1 represents eastbound direction, and 2 westbound direction.
     */
    public Vehicle() throws IllegalArgumentException {
        throw new IllegalArgumentException("This constructor has two arguments");
    }

    public Vehicle(double num) throws IllegalArgumentException {
        throw new IllegalArgumentException("Your argument is in wrong format");
    }
    public Vehicle(double velocity, int direction) throws IllegalArgumentException {
        if (direction != 1 && direction != 2) {
            throw  new IllegalArgumentException("direction must be 1 or 2");
        }
        if (velocity < 0.0) {
            this.direction = direction == 1 ? 2 : 1;
            this.velocity = Math.abs(velocity);
        } else {
            this.velocity = velocity;
            this.direction = direction;
        }
    }

    /**
     * Returns the velocity of the Vehicle.
     * @return the velocity of the Vehicle.
     */
    public double getVelocity() {
        return velocity;
    }
    public void setVelocity(double v) {
        velocity = v;
    }

    /**
     * Returns the direction of the Vehicle.
     * @return the direction of the Vehicle.
     */
    public int getDirection() {
        return direction;
    }

}

