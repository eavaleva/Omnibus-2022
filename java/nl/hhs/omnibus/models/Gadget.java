package java.nl.hhs.omnibus.models;

public abstract class Gadget extends Nameable {
    private String description;
    private EnhancedBeing owner;

    Gadget(String name, String description, EnhancedBeing owner) {
        super(name);
        this.description = description;
        this.owner = owner;
    }

    public void setDescription() {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setOwner() {
        this.owner = owner;
    }

    private boolean isOwner(EnhancedBeing enhancedBeing) {

        return this.owner == enhancedBeing;
    }

    public EnhancedBeing getOwner() {
        return owner;
    }

}
