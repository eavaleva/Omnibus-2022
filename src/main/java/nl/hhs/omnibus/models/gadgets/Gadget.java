package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;

public abstract class Gadget extends Nameable {
    private String description;
    private EnhancedBeing owner;

    public Gadget(String name, String description) {
        super(name);

        this.description = description;
    }

    private boolean isOwner(EnhancedBeing enhancedBeing) {
        return this.owner.equals(enhancedBeing);
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("\n%14s%03d\n", "ID:", this.getId()));
        details.append(String.format("%14s%s\n", "Name:", this.getName()));
        details.append(String.format("%14s%s\n", "Owner:", this.getOwner().getName()));

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String actualDescription) {
        this.description = actualDescription;
    }

    public EnhancedBeing getOwner() {
        return this.owner;
    }

    public void setOwner(EnhancedBeing owner) {
        if (this.owner != null) {
            this.owner.removeGadget(this);
        }
        this.owner = owner;
        this.owner.addGadget(this);
    }
}
