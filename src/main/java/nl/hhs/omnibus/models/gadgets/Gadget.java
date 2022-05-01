package nl.hhs.omnibus.models.gadgets;

import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;

/** Gadgets are items that would aid a Hero or Villain into accomplishing their actions. */
public abstract class Gadget extends Nameable {
    /** A statement that tells users a little more about a Gadget. */
    private final String description;

    /** The owner of a Gadget. There must always be 1 owner. A Gadget cannot be used by other Characters. */
    private EnhancedBeing owner;

    public Gadget(String name, String description, EnhancedBeing owner) {
        super(name);

        this.description = description;
        this.setOwner(owner);
    }

    /* GETTERS & SETTERS */

    public String getDescription() {
        return this.description;
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
