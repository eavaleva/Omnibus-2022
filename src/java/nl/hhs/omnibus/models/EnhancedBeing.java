package java.nl.hhs.omnibus.models;

import java.nl.hhs.omnibus.interfaces.Identifiable;
import java.util.Objects;

/**
 * The EnhancedBeing is the Base class for the Hero and Villain classes.
 */
public class EnhancedBeing implements Identifiable {
    private static int nextId = 0;

    /** An internal identifier which is used in the system to identify a unique Hero or Villain. */
    private int id;

    /** The name of an individual Hero or Villain. */
    private String name;

    /** The location of which an individual Hero or Villain is known for to be most active in. */
    private String mostActiveLocation;

    /** How strong a Hero or Villain is in a fight. */
    private int powerLevel;

    /** A word or sentence an individual Hero or Villain is known for saying. */
    private String phrase;

    public EnhancedBeing(String name, String mostActiveLocation, int powerLevel, String phrase) {
        this.id = ++EnhancedBeing.nextId;

        this.name = name;
        this.mostActiveLocation = mostActiveLocation;
        this.powerLevel = powerLevel;
        this.phrase = phrase;
    }

    public void speakPhrase() {
        System.out.println(phrase);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) return false;
        if (this == object) return true;

        EnhancedBeing that = (EnhancedBeing) object;

        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        // TODO: Needs more formatting to be inline with how the details of one EnhancedBeing should be printed
        return String.format("EnhancedBeing{ id: '%s', name: '%s' }", this.id, this.name);
    }

    /* GETTERS AND SETTERS */

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getPowerLevel() {
        // TODO: Should actually return a calculated value which is the powerLevel of an Hero or Villain +
        //  any Gadgets that can contribute to a fight
        return this.powerLevel;
    }

    public String getPhrase() {
        return this.phrase;
    }
}
