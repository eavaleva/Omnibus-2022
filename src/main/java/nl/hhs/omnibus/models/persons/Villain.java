package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.models.EnhancedBeing;

import java.util.HashMap;
import java.util.Map;

public class Villain extends EnhancedBeing {
    private final String evilPlan;
    private final Map<Hero, Boolean> rivals = new HashMap<>();

    public Villain(String name, String mostActiveLocation, int powerLevel, String evilPlan) {
        super(name, mostActiveLocation, powerLevel, "Oneliner Villain!");

        this.evilPlan = evilPlan;
    }

    public Villain(String name, String mostActiveLocation, int powerLevel, String evilPlan, String phrase) {
        super(name, mostActiveLocation, powerLevel, phrase);

        this.evilPlan = evilPlan;
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

        public static Villain[] VILLAINS = { THE_JOKER, RIDDLER, BLACK_MANTA, DARKSEID, MISTER_FREEZE, BASILISK, ABRA_KADABRA, BLACK_RACER, KILLER_MOTH, MIDAS, THE_DROWNED, DAWNBREAKER, ZUMBADO, DESPERO, LEX_LUTHER, GRID, CAPTAIN_COLD, CHARNN, HUMAN_FLAME, DESAAD, STEPPENWOLF };
    }
}
