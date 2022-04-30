package nl.hhs.omnibus.models.teams;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.persons.Villain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VillainTeam extends Nameable {
    private final Set<Villain> members = new HashSet<>();

    public VillainTeam(String name) {
        super(name);
    }

    public boolean isMemberOf(Villain villain) {
        return members.contains(villain);
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    public Villain getArhRivalOfHero(Hero hero) {
        return this.members.stream()
            .filter(member -> hero.getArchRival().equals(member))
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

    /* GETTER & SETTERS */

    public Set<Villain> getMembers() {
        return this.members;
    }

    public void addAllMembers(Villain... members){
       this.members.addAll(Arrays.asList(members));
    }

    public void addMember(Villain member){
        this.members.add(member);
    }
}
