package java.nl.hhs.omnibus.models;

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

    //This is an example, do check if I've made a mistake somewhere :)\\
    Gadget Batmobile = new Vehicle("The Bat-mobile", "The Bat-mobile is Batman's personal automobile and primary mode of transportation.", Batman, 563, 2);
}
