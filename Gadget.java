public class Gadget extends EnhancedBeing {
    private String description;
    private EnhancedBeing owner;

    public void setDescription(){
        this.description = description;
    }
    public void setOwner(){
        this.owner = owner;
    }

    Gadget (String name,String description, EnhancedBeing owner){
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    private boolean isOwner(EnhancedBeing enhancedBeing){
        //This has to return an actual value but I need the EnhancedBeing class first\\
        return true;
    }

    public void getOwner(){
        //Has an error because of the EnhancedBeing class not being there\\
        return isOwner();
    }

}
