package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;

public abstract class Gadget extends Nameable {
    private String description;
    private EnhancedBeing owner;

    public Gadget(String name, String description, EnhancedBeing owner) {
        super(name);

        this.description = description;
        this.owner = owner;
    }

    private boolean isOwner(EnhancedBeing enhancedBeing) {
        return this.owner.equals(enhancedBeing);
    }

    /* GETTERS & SETTERS */

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
