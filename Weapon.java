public class Weapon extends Gadget{
    private int powerLevel;

    public void setPowerLevel(){
        this.powerLevel = powerLevel;
    }
    Weapon(String name, String description, EnhancedBeing owner, int powerLevel){
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.powerLevel = powerLevel;
    }

}
