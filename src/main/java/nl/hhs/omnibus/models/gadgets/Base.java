package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;

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
        StringBuilder details = new StringBuilder(super.toString());
        details.append(String.format("%14s%s\n", "Type:", this.getClass().getSimpleName()));
        details.append(String.format("%14s%s\n", "Location:", this.getLocation()));

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
