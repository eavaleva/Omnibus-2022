package java.nl.hhs.omnibus.models;
import java.util.HashMap;
import java.util.HashSet;


public class Villain extends EnhancedBeing {
    private static final String defaultPhrase = "Oneliner Villain";
    private String evilPlan;

    private HashMap<Hero, Boolean> rivals = new HashMap<Hero, Boolean>();
    private HashSet<VillainTeam> teams = new HashSet<VillainTeam>();

    public Villain(String name, String mostActiveLocation, int powerLevel, String evilPlan, String phrase){
        super(name, mostActiveLocation, powerLevel, phrase);
        this.evilPlan = evilPlan;
    }
    public Villain(String name, String mostActiveLocation, int powerLevel, String evilPlan){
        super(name, mostActiveLocation, powerLevel, defaultPhrase);
        this.evilPlan = evilPlan;
    }
    // TODO: Methods need to be created for the class

}
