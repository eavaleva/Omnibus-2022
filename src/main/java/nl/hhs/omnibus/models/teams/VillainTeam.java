package nl.hhs.omnibus.models.teams;
import nl.hhs.omnibus.Villain;
import nl.hhs.omnibus.models.Nameable;

import java.util.Arrays;
import java.util.HashSet;

public class VillainTeam extends Nameable {
    private HashSet<Villain> members = new HashSet<>();

    public VillainTeam(String name) {
        super(name);
    }


    public boolean isMemberOf(Villain villain) {
        return members.contains(villain);
    }



    public void addAllMembers(Villain... members){
       this.members.addAll(Arrays.asList(members));

    }

    public void addMember(Villain member){
        this.members.add(member);
    }

}
