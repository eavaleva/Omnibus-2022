package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.models.EnhancedBeing;

public class Hero extends EnhancedBeing {
    /**
     * if a hero does not have his own phrase, then the program will assign a default phrase to the Hero.
     */
    private static final String defaultPhrase = "Default onliner Hero";

    /**
     * real name is the actual name of a hero.
     */
    private String realName;

    public Hero(String name, String mostActiveLocation, int powerLevel, String phrase, String realName) {
        super(name, mostActiveLocation, powerLevel, phrase);
        this.realName = realName;
    }

    public Hero(String name, String mostActiveLocation, int powerLevel, String realName) {
        super(name, mostActiveLocation, powerLevel, defaultPhrase);
        this.realName = realName;
    }

}
