package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;

public class Base extends Gadget {
    private String location;

  public Base(String name, String description, EnhancedBeing owner, String location) {
        super(name, description, owner);

        this.location = location;
    }

    public void setLocation(String actualLocation) {
        this.location = actualLocation;
    }
}
