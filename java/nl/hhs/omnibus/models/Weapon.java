package java.nl.hhs.omnibus.models;

public class Weapon extends Gadget {
    private int powerLevel;

    Weapon(String name, String description, EnhancedBeing owner, int powerLevel) {
        super(name, description, owner);
        this.powerLevel = powerLevel;
    }

    public void setPowerLevel() {
        this.powerLevel = powerLevel;
    }

}
