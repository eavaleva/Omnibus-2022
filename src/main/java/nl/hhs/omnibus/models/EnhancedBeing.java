package nl.hhs.omnibus.models;

import nl.hhs.omnibus.data.Database;
import nl.hhs.omnibus.models.gadgets.Gadget;
import nl.hhs.omnibus.models.gadgets.Weapon;
import nl.hhs.omnibus.models.persons.Fan;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The EnhancedBeing is the Base class for the Hero and Villain classes.
 */
public abstract class EnhancedBeing extends Nameable {
    /**
     * The location of which an individual Hero or Villain is known for to be most active in.
     */
    private String mostActiveLocation;

    /**
     * How strong a Hero or Villain is in a fight.
     */
    private int powerLevel;

    /**
     * A word or sentence an individual Hero or Villain is known for saying.
     */
    private String phrase;

    private final Set<Gadget> gadgets = new HashSet<>();
    private final Set<Fan> fans = new HashSet<>();

    protected EnhancedBeing(String name, String mostActiveLocation, int powerLevel, String phrase) {
        super(name);

        this.mostActiveLocation = mostActiveLocation;
        this.powerLevel = powerLevel;
        this.phrase = phrase;
    }

    /**
     * Prints the phrase of an EnhancedBeing to the terminal.
     */
    public void speakPhrase() {
        System.out.println(this.phrase);
    }

    /* GETTERS AND SETTERS */

    public String getMostActiveLocation() {
        return this.mostActiveLocation;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public Set<Gadget> getGadgets() {
        return this.gadgets;
    }

    public void addAllGadgets(Gadget... gadgets) {
        Arrays.stream(gadgets).forEach(this::addGadget);
    }

    public void addGadget(Gadget gadget) {
        this.gadgets.add(gadget);
    }

    public void removeGadget(Gadget gadget) {
        this.gadgets.remove(gadget);
    }

    public int getPowerLevel() {
        int gadgetPowerlevel = 0;

        for (Gadget gadget : gadgets) {
            if (!(gadget instanceof Weapon)) {
                continue;
            }
            gadgetPowerlevel += ((Weapon) gadget).getPowerLevel();
        }
        return powerLevel + gadgetPowerlevel + this.fans.size();
    }

    public Fan getFanByIndex(int index) {
        return this.fans.toArray(new Fan[0])[index];
    }

    public Set<Fan> getFans() {
        return this.fans;
    }

    public void addFan(Fan fan) {
        this.fans.add(fan);
    }

    public void removeFan(Fan fan) {
        this.fans.remove(fan);
    }
}
