package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;

public abstract class Gadget extends Nameable {
    private String description;
    private EnhancedBeing owner;

    Gadget(String name, String description, EnhancedBeing owner) {
        super(name);
        this.description = description;
        this.owner = owner;
    }

    public void setDescription(String actualDescription) {
        this.description = actualDescription;
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("\n%14s%03d\n", "ID:", this.getId()));
        details.append(String.format("%14s%s\n", "Name:", this.getName()));
        details.append(String.format("%14s%s\n", "Owner:", this.owner.getName()));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public String getDescription() {
        return description;
    }

    public void setOwner(EnhancedBeing actualOwner) {
        this.owner = actualOwner;
    }

    private boolean isOwner(EnhancedBeing enhancedBeing) {
        return this.owner == enhancedBeing;
    }

    public EnhancedBeing getOwner() {
        return owner;
    }
}
