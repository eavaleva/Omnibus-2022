package java.nl.hhs.omnibus.models;
import java.util.HashMap;
import java.util.HashSet;


public class Villain extends EnhancedBeing {
    private static final String defaultPhrase = "Oneliner Villain";
    private String evilPlan;

    // This will be added once the VillainTeam & Heroes are added to the project\\
    //private HashMap<Hero, Boolean> rivals = new HashMap<Hero, Boolean>();
    //private HashSet<VillainTeam> teams = new HashSet<HashSet>();


    //mostActiveLocation has private access and can not be resolved in the super?\\

    public Villain(String name, String activeLocation, int powerLevel, String evilPlan, String phrase){
        super(name, mostActiveLocation, powerLevel, phrase);
        this.evilPlan = evilPlan;
    }
    public Villain(String name, String activeLocation, int powerLevel, String evilPlan){
        super(name, mostActiveLocation, powerLevel, defaultPhrase);
        this.evilPlan = evilPlan;
    }
    //It will still need methods but as the HashMap & HashSet haven't been incorporated yet, the only thing I'll incorporate are errors by creating methods for them.\\


}
