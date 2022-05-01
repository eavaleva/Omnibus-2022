package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

/**
 * A Hero or Villain sometimes needs a hideout or base of operation to organize.
 * This he could do in a Base, also known as a Lair.
 */
public class Base extends Gadget {
    /** The location of a Base. */
    private final String location;

    public Base(String name, String description, EnhancedBeing owner, String location) {
        super(name, description, owner);

        this.location = location;
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
        details.append(String.format("%-14s%s\n%s", Constants.LOCATION, this.getLocation(), Constants.SEPARATOR));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public String getLocation() {
        return this.location;
    }
}
