package java.nl.hhs.omnibus.models;

public abstract class Gadget extends Nameable {
    private String description;
    private EnhancedBeing owner;

    public void setDescription(){
        this.description = description;
    }
    public void setOwner(){
        this.owner = owner;
    }

    Gadget (String name,String description, EnhancedBeing owner){
        super(name);
        this.description = description;
        this.owner = owner;
    }

    private boolean isOwner(java.nl.hhs.omnibus.models.EnhancedBeing enhancedBeing){
        //This has to return an actual value but I need the EnhancedBeing class first\\
        return true;
    }

    public java.nl.hhs.omnibus.models.EnhancedBeing getOwner(){
        //Has an error because of the EnhancedBeing class not being there\\
        return owner;
    }

}
