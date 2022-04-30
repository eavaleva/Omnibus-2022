package nl.hhs.omnibus.models.teams;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.persons.Villain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HeroTeam extends Nameable {
    private final Set<Hero> members = new HashSet<>();

    public HeroTeam(String name) {
        super(name);
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    public Hero getArhRivalOfVillain(Villain villain) {
        return this.members.stream()
                .filter(member -> villain.getArchRival().equals(member))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%s%-14s%03d\n", Constants.SEPARATOR, Constants.ID, this.getId()));
        details.append(String.format("%-14s%s\n", Constants.NAME, this.getName()));
        details.append(String.format("%s\n", Constants.MEMBERS_HEADER));

        this.members.forEach(member -> details.append(String.format("%s\n", member.getDetails())));

        if (this.members.isEmpty()) {
            details.append(String.format("\t%s\n", Constants.NO_TEAM_MEMBERS));
        }
        details.append(Constants.SEPARATOR);

        return details.toString();
    }

    public boolean isMemberOf(Hero hero) {
        return this.members.contains(hero);
    }

    /* GETTERS & SETTERS */

    public Set<Hero> getMembers() {
        return this.members;
    }

    public void addAllMembers(Hero... members) {
        this.members.addAll(Arrays.asList(members));
    }

    public void addMember(Hero member) {
        this.members.add(member);
    }
}
