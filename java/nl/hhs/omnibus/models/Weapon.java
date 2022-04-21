package java.nl.hhs.omnibus.models;

public class Weapon extends Gadget {
    private int powerLevel;

    Weapon(String name, String description, EnhancedBeing owner, int powerLevel) {
        super(name, description, owner);
        this.powerLevel = powerLevel;
    }

    public void setPowerLevel(int actualPowerLevel) {
        this.powerLevel = actualPowerLevel;
    }

    //This is an example, do check if I've made a mistake somewhere\\
    Gadget batarang = new Weapon("The Batarang", "This weapon is used by Batman to hit his enemies from far distances.", Batman, 20);
}
