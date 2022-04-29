package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

public class Base extends Gadget {
    private String location;



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
        details.append(String.format("%-14s%s\n", Constants.TYPE, this.getClass().getSimpleName()));
        details.append(String.format("%-14s%s\n%s", Constants.LOCATION, this.getLocation(), Constants.SEPARATOR));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
