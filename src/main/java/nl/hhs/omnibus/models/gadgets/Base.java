package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.common.Constants;

public class Base extends Gadget {
    private String location;

    public Base(String name, String description, String location) {
        super(name, description);

        this.location = location;
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        if (!getFullDetails) return super.toString();

        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("\n%14s:%03d\n", Constants.ID, this.getId()));
        details.append(String.format("%14s:%s\n", Constants.NAME, this.getName()));
        details.append(String.format("%14s:%s\n", Constants.OWNER, this.getOwner().getName()));
        details.append(String.format("%14s:%s\n", Constants.TYPE, this.getClass().getSimpleName()));
        details.append(String.format("%14s:%s\n", Constants.LOCATION, this.getLocation()));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String actualLocation) {
        this.location = actualLocation;
    }
}
