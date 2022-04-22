package nl.hhs.omnibus.models;

public class Vehicle extends Gadget {
    private int speed;
    private int capacity;

    Vehicle(String name, String description, EnhancedBeing owner, int speed, int capacity) {
        super(name, description, owner);
        this.speed = speed;
        this.capacity = capacity;
    }

    public void setSpeed(int actualSpeed) {
        this.speed = actualSpeed;
    }

    public void setCapacity(int actualCapacity) {
        this.capacity = actualCapacity;
    }
}
