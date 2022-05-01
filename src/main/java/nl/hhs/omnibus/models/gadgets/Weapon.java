package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

/** A Weapon is used by a Hero or Villain to increase its power in combat. */
public class Weapon extends Gadget {
    private final int powerLevel;

    public Weapon(String name, String description, EnhancedBeing owner, int powerLevel) {
        super(name, description, owner);

        this.powerLevel = powerLevel;
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
        details.append(String.format("%-14s%d\n%s", Constants.POWER_LEVEL, this.getPowerLevel(), Constants.SEPARATOR));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public int getPowerLevel() {
        return this.powerLevel;
    }
}
