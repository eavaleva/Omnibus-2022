package nl.hhs.omnibus.models.teams;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.persons.Villain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** A group or collection of Heroes that fight together. */
public class HeroTeam extends Nameable {
    /** The Heroes that take part in this group. */
    private final Set<Hero> members = new HashSet<>();

    public HeroTeam(String name) {
        super(name);
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    /** Tries to find the arch rival from a Villain within the members of a Team of Heroes. */
    public Hero getArchRivalOfVillain(Villain villain) {
        if (villain.getArchRival() == null) return null;

        return this.members.stream()
                .filter(member -> villain.getArchRival().equals(member))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%s%-14s#%03d\n", Constants.SEPARATOR, Constants.ID, this.getId()));
        details.append(String.format("%-14s%s\n", Constants.NAME, this.getName()));
        details.append(String.format("%s\n", Constants.MEMBERS_HEADER));

        this.members.forEach(member -> details.append(String.format("%s\n", member.getDetails())));

        if (this.members.isEmpty()) {
            details.append(String.format("\t%s\n", Constants.NO_TEAM_MEMBERS));
        }
        details.append(Constants.SEPARATOR);

        return details.toString();
    }

    /* GETTERS & SETTERS */

    public Set<Hero> getMembers() {
        return this.members;
    }

    public void addAllMembers(Hero... members) {
        Arrays.stream(members).forEach(this::addMember);
    }

    public void addMember(Hero member) {
        this.members.add(member);
    }
}
