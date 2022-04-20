public class Vehicle extends Gadget {
    private int speed;
    private int capacity;

    public void setSpeed(){
        this.speed = speed;
    }

    public void setCapacity(){
        this.capacity = capacity;
    }

    Vehicle(String name, String description, EnhancedBeing owner, int speed, int capacity){
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.speed = speed;
        this.capacity = capacity;
    }
}
