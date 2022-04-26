package nl.hhs.omnibus.models.teams;

import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.Nameable;

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
        return null;
    }

    public boolean isMemberOf(Hero hero) {
        return this.members.contains(hero);
    }

    /* GETTERS & SETTERS */

    public void addAllMembers(Hero... members) {
        this.members.addAll(Arrays.asList(members));
    }

    public void addMember(Hero member) {
        this.members.add(member);
    }
}
