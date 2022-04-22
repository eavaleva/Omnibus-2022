package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.models.EnhancedBeing;

import java.util.HashMap;
import java.util.Map;

public class Hero extends EnhancedBeing {
    private final String realName;
    private final Map<Villain, Boolean> rivals = new HashMap<>();

    public Hero(String name, String mostActiveLocation, int powerLevel, String realName) {
        super(name, mostActiveLocation, powerLevel, "Oneline Hero!");

        this.realName = realName;
    }

    public Hero(String name, String mostActiveLocation, int powerLevel, String realName, String phrase) {
        super(name, mostActiveLocation, powerLevel, phrase);

        this.realName = realName;
    }


    public void addAllRivals(Map<Villain, Boolean> rivals) {
        rivals.forEach(this::addRival);
    }

    public void addRival(Villain rival, boolean isArchRival) {
        this.rivals.put(rival, isArchRival);
    }

    /* DATA */

    public static class Heroes {
        public final static Hero BATMAN = new Hero("Batman", "Gotham City", -1, "Bruce Thomas Wayne");
        public final static Hero GREEN_LANTERN = new Hero("Green Lantern", "Coast City", -1, "Hal Jordan");
        public final static Hero THE_FLASH = new Hero("The Flash", "Keystone City", -1, "Wallace Rudolph \"Wally\" West");
        public final static Hero SUPERMAN = new Hero("Superman", "Metropolis", -1, "Kal-el");
        public final static Hero WONDER_WOMAN = new Hero("Wonder Woman", "Washington, D.C.", -1, "Diana of Themyscira");
        public final static Hero AQUAMAN = new Hero("Aquaman", "Amnesty Bay", -1, "Arthur Curry");
        public final static Hero CYBORG = new Hero("Cyborg", "Justice League Watchtower", -1, "Victor \"Vic\" Stone");

        public final static Hero MARTIAN_MANHUNTER = new Hero("Martian Manhunter", "Earth", -1, "J'onn J'onzz");
        public final static Hero GREEN_ARROW = new Hero("Green Arrow", "Seattle", -1, "Oliver Jonas \"Ollie\" Queen");
        public final static Hero BLACK_CANARY = new Hero("Black Canary", "Mobile", -1, "Dinah Drake Lance");
        public final static Hero BLACK_ADAM = new Hero("Black Adam", "Shiruta", -1, "Teth-Adam");
        public final static Hero HAWKGIRL = new Hero("Hawkgirl", "Blackhawk Island", -1 , "Kendra Saunders");
        public final static Hero NAOMI = new Hero("Naomi", "Post Oswego", -1, "Naomi McDuffe");

        public final static Hero[] HEROES = { BATMAN, GREEN_LANTERN, THE_FLASH, SUPERMAN, WONDER_WOMAN, AQUAMAN, CYBORG, MARTIAN_MANHUNTER, GREEN_ARROW, BLACK_CANARY, BLACK_ADAM, HAWKGIRL, NAOMI };
    }
}
