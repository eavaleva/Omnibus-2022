package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;

import java.util.HashMap;
import java.util.Map;

public class Hero extends EnhancedBeing {
    private final String realName;
    private final Map<Villain, Boolean> rivals = new HashMap<>();

    public Hero(String name, String mostActiveLocation, int powerLevel, String realName) {
        super(name, mostActiveLocation, powerLevel, String.format(Constants.DEFAULT_ONE_LINER, Hero.class.getSimpleName()));

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
        StringBuilder details = new StringBuilder(String.format("%s%-14s#%03d\n", Constants.SEPARATOR, Constants.ID, this.getId()));
        details.append(String.format("%-14s%s\n", Constants.HERO, this.getName()));
        details.append(String.format("%-14s%s\n", Constants.LOCATION, this.getMostActiveLocation()));
        details.append(String.format("%-14s%s\n", Constants.REAL_NAME, this.realName));
        details.append(String.format("\n%-14s\"%s\"\n", Constants.ONE_LINER, this.getPhrase()));

        StringBuilder rivals = new StringBuilder(String.format("\n%s\n", Constants.RIVALS_HEADER));
        StringBuilder archRival = new StringBuilder(String.format("\n%s\n", Constants.ARCH_RIVALS_HEADER));

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
            rivals.append(String.format("\t%s\n", Constants.NO_RIVALS));
            archRival.append(String.format("\t%s\n", Constants.NO_ARCH_RIVALS));
        }

        // When a Hero has no arch rival
        if (!this.rivals.containsValue(true) && !archRival.toString().contains(Constants.NO_ARCH_RIVALS)) {
            archRival.append(String.format("\t%s\n", Constants.NO_ARCH_RIVALS));
        }

        // When a Hero has no regular rivals (but does have an arch rival)
        if (!this.rivals.containsValue(false) && !rivals.toString().contains(Constants.NO_RIVALS)) {
            rivals.append(String.format("\t%s\n", Constants.NO_RIVALS));
        }
        details.append(rivals);
        details.append(archRival);
        details.append(Constants.SEPARATOR);

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public void addAllRivals(Map<Villain, Boolean> rivals) {
        rivals.forEach(this::addRival);
    }

    public void addRival(Villain rival, boolean isArchRival) {
        this.rivals.put(rival, isArchRival);
    }
}
