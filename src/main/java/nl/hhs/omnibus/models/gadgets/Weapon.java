package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;

public class Weapon extends Gadget {
    private int powerLevel;

    Weapon(String name, String description, EnhancedBeing owner, int powerLevel) {
        super(name, description, owner);
        this.powerLevel = powerLevel;
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
        details.append(String.format("%14s%d\n", "Power level:", this.getPowerLevel()));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }
}
