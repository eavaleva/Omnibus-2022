package java.nl.hhs.omnibus.models;

/**
 * The EnhancedBeing is the src.java.nl.hhs.omnibus.models.Base class for the Hero and Villain classes.
 */
public class EnhancedBeing extends Nameable {
    /** The location of which an individual Hero or Villain is known for to be most active in. */
    private String mostActiveLocation;

    /** How strong a Hero or Villain is in a fight. */
    private int powerLevel;

    /** A word or sentence an individual Hero or Villain is known for saying. */
    private String phrase;

    public EnhancedBeing(String name, String mostActiveLocation, int powerLevel, String phrase) {
        super(name);

        this.mostActiveLocation = mostActiveLocation;
        this.powerLevel = powerLevel;
        this.phrase = phrase;
    }

    /** Prints the phrase of an EnhancedBeing to the terminal. */
    public void speakPhrase() {
        System.out.println(phrase);
    }

    /* GETTERS AND SETTERS */

    public int getPowerLevel() {
        // TODO: Should actually return a calculated value which is the powerLevel of an Hero or Villain +
        //  any Gadgets that can contribute to a fight
        return this.powerLevel;
    }

    public String getPhrase() {
        return this.phrase;
    }
}
