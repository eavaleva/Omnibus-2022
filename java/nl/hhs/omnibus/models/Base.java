package java.nl.hhs.omnibus.models;

public class Base extends Gadget {
    private String location;

    Base(String name, String description, EnhancedBeing owner, String location) {
        super(name, description, owner);
        this.location = location;
    }

    public void setLocation(String actualLocation) {
        this.location = actualLocation;
    }

    //This is an example, do check if I've made a mistake somewhere :)\\
    Gadget basis = new Base("Joker's Lair", "Deep in the mountains.", Joker, "USA");
}


