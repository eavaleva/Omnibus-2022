package nl.hhs.omnibus.models.gadgets;

public class Vehicle extends Gadget {
    private String speed;
    private int capacity;

    public Vehicle(String name, String description, String speed, int capacity) {
        super(name, description);

        this.speed = speed;
        this.capacity = capacity;
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        if (!getFullDetails) return super.toString();

        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(super.toString());
        details.append(String.format("%14s%s\n", "Type:", this.getClass().getSimpleName()));
        details.append(String.format("%14s%s\n", "Speed:", this.getSpeed()));
        details.append(String.format("%14s%d\n", "Capacity:", this.getCapacity()));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int actualCapacity) {
        this.capacity = actualCapacity;
    }
}
