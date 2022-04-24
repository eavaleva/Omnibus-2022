package nl.hhs.omnibus.models.teams;

import nl.hhs.omnibus.persons.Hero;
import nl.hhs.omnibus.models.Nameable;

import java.util.Arrays;
import java.util.HashSet;

public class HeroTeam extends Nameable {
    private HashSet<Hero> members = new HashSet<>();

    public HeroTeam(String name) {
        super(name);
    }

    public boolean isMemberOf(Hero hero) {
        return members.contains(hero);
    }

    public void addAllMembers(Hero... members) {
        this.members.addAll(Arrays.asList(members));

    }
    public void addMember(Hero member) {
        this.members.add(member);
    }

}
