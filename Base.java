public class Base extends Gadget{
    private String location;

    public void setLocation(){
        this.location = location;
    }

    Base(String name, String description, EnhancedBeing owner, String location){
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.location = location;
    }
}
