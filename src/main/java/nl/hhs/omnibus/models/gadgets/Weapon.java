package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

public class Weapon extends Gadget {
    private int powerLevel;

    public Weapon(String name, String description, int powerLevel) {
        super(name, description);

        this.powerLevel = powerLevel;
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("\n%14s:%03d\n", Constants.ID, this.getId()));
        details.append(String.format("%14s:%s\n", Constants.NAME, this.getName()));
        details.append(String.format("%14s:%s\n", Constants.OWNER, this.getOwner().getName()));
        details.append(String.format("%14s:%s\n", Constants.TYPE, this.getClass().getSimpleName()));
        details.append(String.format("%14s:%d\n", Constants.POWER_LEVEL, this.getPowerLevel()));

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
