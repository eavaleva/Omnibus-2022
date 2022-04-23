package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

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
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("\n%14s:%03d\n", Constants.ID, this.getId()));
        details.append(String.format("%14s:%s\n", Constants.NAME, this.getName()));
        details.append(String.format("%14s:%s\n", Constants.OWNER, this.getOwner().getName()));
        details.append(String.format("%14s:%s\n", Constants.TYPE, this.getClass().getSimpleName()));
        details.append(String.format("%14s:%s\n", Constants.SPEED, this.getSpeed()));
        details.append(String.format("%14s:%d\n", Constants.CAPACITY, this.getCapacity()));

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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
