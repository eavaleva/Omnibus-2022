package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;

public class Weapon extends Gadget {
    private int powerLevel;

   public Weapon(String name, String description, EnhancedBeing owner, int powerLevel) {
        super(name, description, owner);
        this.powerLevel = powerLevel;
    }

    public void setPowerLevel(int actualPowerLevel) {
        this.powerLevel = actualPowerLevel;
    }
}
