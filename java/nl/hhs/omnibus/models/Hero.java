package java.nl.hhs.omnibus.models;


import java.nl.hhs.omnibus.models.EnhancedBeing;
import java.util.HashMap;
import java.util.Map;

/**
 * Hero is a child claas of the abstract class EnhancesBeing,
 * therefore in inherits all the attributes and behavior of it parent class.
 * The behavior can be accepted as it is or overwritten.
 */

public class Hero extends EnhancedBeing {

    /**
     * if a hero does not have his own phrase, then the program will assign a default phrase to the Hero.
     */
    private static final String defaultPhrase = "Default onliner Hero";

    /**
     * real name is the actual name of a hero.
     */
    private String realName;

    /**
     * The map that later on will be used as place to extract valuable information about the hero's rival and archrivals.
     */
    //private Map<Villain, Boolean> rivals;  // not sure if this is right, please check.

    /**
     * The set will be used to compose teams of heroes.
     */
    //private Set<HeroTeam> teams;

    public Hero(String name, String mostActiveLocation, int powerLevel, String phrase, String realName) {
        super(name, mostActiveLocation, powerLevel, phrase);
        this.realName = realName;
    }

    public Hero(String name, String mostActiveLocation, int powerLevel, String realName) {
        super(name, mostActiveLocation, powerLevel, defaultPhrase);
        this.realName = realName;
    }

}
