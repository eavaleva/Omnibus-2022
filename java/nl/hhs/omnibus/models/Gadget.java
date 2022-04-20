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

    public void setOwner() {
        this.owner = owner;
    }

    private boolean isOwner(EnhancedBeing enhancedBeing) {
        //This has to return an actual value but I need the EnhancedBeing class first\\
        return true;
    }

    public EnhancedBeing getOwner() {
        //Has an error because of the EnhancedBeing class not being there\\
        return owner;
    }

}
