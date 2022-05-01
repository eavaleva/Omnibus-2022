package nl.hhs.omnibus.models;

import nl.hhs.omnibus.models.gadgets.Gadget;
import nl.hhs.omnibus.models.gadgets.Weapon;
import nl.hhs.omnibus.models.persons.Fan;

import java.util.HashSet;
import java.util.Set;

/** The EnhancedBeing is the Base class for the Hero and Villain classes. */
public abstract class EnhancedBeing extends Nameable {
    /** The location of which an individual Hero or Villain is known for to be most active in. */
    private final String mostActiveLocation;

    /** How strong a Hero or Villain is in a fight. */
    private final int powerLevel;

    /** A word or sentence an individual Hero or Villain is known for saying. */
    private final String phrase;

    private final Set<Gadget> gadgets = new HashSet<>();
    private final Set<Fan> fans = new HashSet<>();

    protected EnhancedBeing(String name, String mostActiveLocation, int powerLevel, String phrase) {
        super(name);

        this.mostActiveLocation = mostActiveLocation;
        this.powerLevel = powerLevel;
        this.phrase = phrase;
    }

    /* GETTERS AND SETTERS */

    public String getMostActiveLocation() {
        return this.mostActiveLocation;
    }

    public int getPowerLevel() {
        int gadgetPowerLevel = 0;

        for (Gadget gadget : gadgets) {
            if (!(gadget instanceof Weapon)) {
                continue;
            }
            gadgetPowerLevel += ((Weapon) gadget).getPowerLevel();
        }
        return this.powerLevel + this.fans.size() + gadgetPowerLevel;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public Set<Gadget> getGadgets() {
        return this.gadgets;
    }

    public void addGadget(Gadget gadget) {
        this.gadgets.add(gadget);
    }

    public void removeGadget(Gadget gadget) {
        this.gadgets.remove(gadget);
    }

    public Set<Fan> getFans() {
        return this.fans;
    }

    public Fan getFanByIndex(int index) {
        return this.fans.toArray(new Fan[0])[index];
    }

    public void addFan(Fan fan) {
        this.fans.add(fan);
    }

    public void removeFan(Fan fan) {
        this.fans.remove(fan);
    }
}
