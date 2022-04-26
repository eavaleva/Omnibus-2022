package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

import java.util.HashMap;
import java.util.Map;

public class Villain extends EnhancedBeing {
    private final String evilPlan;
    private final Map<Hero, Boolean> rivals = new HashMap<>();

    public Villain(String name, String mostActiveLocation, int powerLevel, String evilPlan) {
        super(name, mostActiveLocation, powerLevel, String.format(Constants.DEFAULT_ONE_LINER, Villain.class.getSimpleName()));

        this.evilPlan = evilPlan;
    }

    public Villain(String name, String mostActiveLocation, int powerLevel, String evilPlan, String phrase) {
        super(name, mostActiveLocation, powerLevel, phrase);

        this.evilPlan = evilPlan;
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%s%-14s#%03d\n", Constants.SEPARATOR, Constants.ID, this.getId()));
        details.append(String.format("%-14s%s\n", Constants.VILLAIN, this.getName()));
        details.append(String.format("%-14s%s\n", Constants.LOCATION, this.getMostActiveLocation()));
        details.append(String.format("%-14s%s\n", Constants.EVIL_PLAN, this.evilPlan));
        details.append(String.format("\n%-14s\"%s\"\n", Constants.ONE_LINER, this.getPhrase()));

        StringBuilder rivals = new StringBuilder(String.format("\n%s\n", Constants.RIVALS_HEADER));
        StringBuilder archRival = new StringBuilder(String.format("\n%s\n", Constants.ARCH_RIVALS_HEADER));

        // Add all rivals and the arch rival to their own lists
        for (Map.Entry<Hero, Boolean> entry : this.rivals.entrySet()) {
            Hero rival = entry.getKey();
            boolean isArchRival = entry.getValue();

            if (isArchRival) {
                archRival.append(String.format("\t%s\n", rival.getName()));

                continue;
            }
            rivals.append(String.format("\t%s\n", rival.getName()));
        }

        // When a Villain has rivals no
        if (this.rivals.size() == 0) {
            rivals.append(String.format("\t%s\n", Constants.NO_RIVALS));
            archRival.append(String.format("\t%s\n", Constants.NO_ARCH_RIVALS));
        }

        // When a Villain has no arch rival
        if (!this.rivals.containsValue(true) && !archRival.toString().contains(Constants.NO_ARCH_RIVALS)) {
            archRival.append(String.format("\t%s\n", Constants.NO_ARCH_RIVALS));
        }

        // When a Villain has no regular rivals (but does have an arch rival)
        if (!this.rivals.containsValue(false) && !rivals.toString().contains(Constants.NO_RIVALS)) {
            rivals.append(String.format("\t%s\n", Constants.NO_RIVALS));
        }
        details.append(rivals);
        details.append(archRival);
        details.append(Constants.SEPARATOR);

        return details.toString();
    }

    public void addAllRivals(Map<Hero, Boolean> rivals) {
        rivals.forEach(this::addRival);
    }

    public void addRival(Hero rival, boolean isArchRival) {
        this.rivals.put(rival, isArchRival);
    }

    /*  Data */

    public static class Villains {
        public static Villain THE_JOKER = new Villain("The Joker", "Gotham City", -1, "");
        public static Villain RIDDLER = new Villain("Riddler", "Gotham City", -1, "");
        public static Villain BLACK_MANTA = new Villain("Black Manta", "Mobile", -1, "");
        public static Villain DARKSEID = new Villain("Darkseid", "Apokolips", -1, "");
        public static Villain MISTER_FREEZE = new Villain("Mister Freeze", "Gotham City", -1, "");
        public static Villain BASILISK = new Villain("Basilisk", "The Masada", -1, "");
        public static Villain ABRA_KADABRA = new Villain("Abra Kadabra", "Keystone City", -1, "");
        public static Villain BLACK_RACER = new Villain("Black Racer", "Mobile", -1, "");
        public static Villain KILLER_MOTH = new Villain("Killer Moth", "Gotham City", -1, "");
        public static Villain MIDAS = new Villain("Midas", "Seattle", -1, "");
        public static Villain THE_DROWNED = new Villain("The Drowned", "Amnesty Bay", -1, "");
        public static Villain DAWNBREAKER = new Villain("Dawnbreaker", "Gotham City", -1, "");
        public static Villain ZUMBADO = new Villain("Zumbado", "Mobile", -1, "");
        public static Villain DESPERO = new Villain("Despero", "Mobile", -1, "");
        public static Villain LEX_LUTHER = new Villain("Lex Luther", "Metropolis", -1, "");
        public static Villain GRID = new Villain("Grid", "Mobile", -1, "");
        public static Villain CAPTAIN_COLD = new Villain("Caption Cold", "Centeral City", -1, "");
        public static Villain CHARNN = new Villain("Cha'rnn O'zzm", "Earth", -1, "");
        public static Villain HUMAN_FLAME = new Villain("Human Flame", "Metropolis", -1, "");
        public static Villain DESAAD = new Villain("Desaad", "Apokolips", -1, "");
        public static Villain STEPPENWOLF = new Villain("Steppenwolf", "Apokolips", -1, "");

        public static Villain LOKI = new Villain("Loki Laufeyson", "Mobile", -1, "");

        public static Villain[] VILLAINS = { THE_JOKER, RIDDLER, BLACK_MANTA, DARKSEID, MISTER_FREEZE, BASILISK, ABRA_KADABRA, BLACK_RACER, KILLER_MOTH, MIDAS, THE_DROWNED, DAWNBREAKER, ZUMBADO, DESPERO, LEX_LUTHER, GRID, CAPTAIN_COLD, CHARNN, HUMAN_FLAME, DESAAD, STEPPENWOLF, LOKI };
    }
}
