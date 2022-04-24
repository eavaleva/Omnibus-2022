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

    public static class Gadgets {
        public static Base BAT_CAVE = new Base("Batcave", "Batman's base of operation", "Gotham City");
        public static Base UNDERWATER_BASE = new Base("Underwater base", "A well designed underwater base", "Under the see");
        public static Base JOKERS_FUNHOUSE = new Base("Joker's funhouse", "Located at the center of Amusement Mile in Otisburg district", "Gotham City");
        public static Base LOKIS_PALACE = new Base("Loki's palace", "An underground palace hideout located in the void", "The void");
        public static Base BANNER_HIDEHOUT = new Base("Banner Hideout B-733", "An underground grotto located beneath a lake in the Chihuahuan Desert", "New Mexico");

        public static Gadget[] GADGETS = { BAT_CAVE, UNDERWATER_BASE, JOKERS_FUNHOUSE, LOKIS_PALACE, BANNER_HIDEHOUT };
    }
}
