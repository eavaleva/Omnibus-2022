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

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%14s#%03d\n", "ID:", this.getId()));
        details.append(String.format("%14s%s\n", "Hero:", this.getName()));
        details.append(String.format("%14s%s\n", "Location:", this.getMostActiveLocation()));
        details.append(String.format("%14s%s\n", "Name:", this.realName));
        details.append(String.format("\n%14s\"%s\"\n", "One-liner:", this.getPhrase()));

        StringBuilder rivals = new StringBuilder("\nRivals:\n");
        StringBuilder archRival = new StringBuilder("\nArch rival:\n");

        // Add all rivals and the arch rival to their own lists
        for (Map.Entry<Villain, Boolean> entry : this.rivals.entrySet()) {
            Villain rival = entry.getKey();
            boolean isArchRival = entry.getValue();

            if (isArchRival) {
                archRival.append(String.format("\t%s\n", rival.getName()));

                continue;
            }
            rivals.append(String.format("\t%s\n", rival.getName()));
        }

        // When a Hero has rivals no
        if (this.rivals.size() == 0) {
            rivals.append("\tNone\n");
            archRival.append("\tNone\n");
        }

        // When a Hero has no arch rival
        if (!this.rivals.containsValue(true) && !archRival.toString().contains("None")) {
            archRival.append("\tNone\n");
        }

        // When a Hero has no regular rivals (but does have an arch rival)
        if (!this.rivals.containsValue(false) && !archRival.toString().contains("None")) {
            rivals.append("\tNone\n");
        }
        details.append(rivals);
        details.append(archRival);

        return details.toString();
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
