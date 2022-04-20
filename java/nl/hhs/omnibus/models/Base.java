package java.nl.hhs.omnibus.models;

public class Base extends Gadget {
    private String location;

    public void setLocation(){
        this.location = location;
    }

    Base(String name, String description, EnhancedBeing owner, String location){
        super(name, description, owner);
        this.location = location;
    }
}
