package nl.hhs.omnibus.models;

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
