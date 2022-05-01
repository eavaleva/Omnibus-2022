package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.gadgets.Gadget;

import java.util.*;

public class Villain extends EnhancedBeing {
    private final String evilPlan;
    private Hero archRival;
    private final Set<Hero> rivals = new HashSet<>();

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
        StringBuilder archRival = new StringBuilder(String.format("\n%s\n", Constants.ARCH_RIVAL_HEADER));
        StringBuilder fans = new StringBuilder(String.format("%s", Constants.FANS_HEADER));
        StringBuilder gadgets = new StringBuilder(String.format("%s", Constants.GADGETS_HEADER));

        // Add all rivals, fans, and gadgets
        for (Hero rival : this.rivals) {
            rivals.append(String.format("\t%s\n", rival.getName()));
        }
        for (Fan fan: this.getFans()) {
            fans.append(String.format("\t%s: %s\n", fan.getName(), fan.getQuoteFavoriteCharacter(this)));
        }
        for (Gadget gadget: this.getGadgets()) {
            gadgets.append(String.format("\t%s\n", gadget.getName()));
        }

        // When a Villain has no rivals, fans, or gadgets
        if (this.rivals.size() == 0) {
            rivals.append(String.format("\t%s\n", Constants.NO_RIVALS));
        }
        if (this.getFans().size() == 0) {
            fans.append(String.format("\t%s\n", Constants.NO_FANS));
        }
        if (this.getGadgets().size() == 0) {
            gadgets.append(String.format("\t%s\n", Constants.NO_GADGETS));
        }

        // When a Hero has no arch rival
        if (this.archRival == null) {
            archRival.append(String.format("\t%s\n", Constants.NO_ARCH_RIVAL));
        } else {
            archRival.append(String.format("\t%s\n", this.archRival.getName()));
        }
        details.append(rivals);
        details.append(archRival);
        details.append(fans);
        details.append(gadgets);
        details.append(Constants.SEPARATOR);

        return details.toString();
    }

    public int getPowerLevel(Hero potentialArchRival) {
        int powerLevel = super.getPowerLevel();
        int archRivalBonus = 0;

        if (Objects.equals(this.archRival, potentialArchRival)) {
            archRivalBonus = 30;
        }
        return powerLevel + archRivalBonus;
    }

    /* GETTERS & SETTERS */

    public Hero getArchRival() {
        return this.archRival;
    }

    public void setArchRival(Hero archRival) {
        this.archRival = archRival;
    }

    public void addAllRivals(Hero... rivals) {
        Arrays.stream(rivals).forEach(this::addRival);
    }

    public void addRival(Hero rival) {
        this.rivals.add(rival);
    }
}
