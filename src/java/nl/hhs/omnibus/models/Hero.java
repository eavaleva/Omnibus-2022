package java.nl.hhs.omnibus.models;


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
    private static String defaultPhrase = "Default onliner Hero";

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

    public Hero(String name, String mostActiveLocation, int powerLevel, String phrase, String realName, String defaultPhrase) {
        super(name, mostActiveLocation, powerLevel, phrase);
        this.realName = realName;
        this.defaultPhrase = defaultPhrase;
    }

    public Hero(String name, String mostActiveLocation, int powerLevel, String phrase, String realName) {
        super(name, mostActiveLocation, powerLevel, phrase);
        this.realName = realName;
    }


    public void addRivals(){
        /* TODO:  Here use the hashMap in order to add rivals to the hero.
            Also determine the parameters in sid addRivals */
    }

    public void addArchRival(){
        /* TODO: Same as with addRivals, use the hashMap to determine the hero's arch rival.
            Also determine the parameters in sid addArchRivals*/
    }


    //public void addTeam(Team team){
        /* TODO: Determine the information you need to loopt trough and compose a team. */
   // }
    //public void removeTeam(Team team){
        /* TODO: Determine the information you need to delete teams? . */
   // }
}
