package nl.hhs.omnibus.models.teams;

import nl.hhs.omnibus.models.Nameable;
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
        return null;
    }

    /* GETTER & SETTERS */

    public void addAllMembers(Villain... members){
       this.members.addAll(Arrays.asList(members));
    }

    public void addMember(Villain member){
        this.members.add(member);
    }
}
