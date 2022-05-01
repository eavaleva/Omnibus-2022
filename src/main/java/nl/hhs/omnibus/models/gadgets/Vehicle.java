package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

/** A Hero of Villain uses a Vehicle to move around quickly and to optionally transport other people as well. */
public class Vehicle extends Gadget {
    private final String speed;
    private final int capacity;


    public Vehicle(String name, String description, EnhancedBeing owner, String speed, int capacity) {
        super(name, description, owner);

        this.speed = speed;
        this.capacity = capacity;
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%s%-14s%03d\n", Constants.SEPARATOR, Constants.ID, this.getId()));
        details.append(String.format("%-14s%s\n", Constants.NAME, this.getName()));
        details.append(String.format("%-14s%s\n", Constants.OWNER, this.getOwner().getName()));
        details.append(String.format("%-14s%s\n", Constants.DESCRIPTION, this.getDescription()));
        details.append(String.format("%-14s%s\n", Constants.TYPE, this.getClass().getSimpleName()));
        details.append(String.format("%-14s%s\n", Constants.SPEED, this.getSpeed()));
        details.append(String.format("%-14s%d\n%s", Constants.CAPACITY, this.getCapacity(), Constants.SEPARATOR));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public String getSpeed() {
        return speed;
    }

    public int getCapacity() {
        return capacity;
    }
}
