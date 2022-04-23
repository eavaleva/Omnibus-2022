package nl.hhs.omnibus.models.teams;

import nl.hhs.omnibus.models.Nameable;

import java.util.HashSet;

public class VillainTeam extends Nameable {
    private HashSet<Villain> members = new HashSet<Villain>();

    public VillainTeam() {
        super(name);
    }
    //Is asking for an object. Am I doing something wrong with this method?\\
    public boolean isMemberOf(Villain villain){
        if (members.contains(villain)) {
            return true;
        }
        else{
            return false;
        }
    }

    public void addAllMembers(Villain member){
       member.addAll(members);
       //Is this the right way to do it? \\
    }

    public void addMember(Villain member){
        //Not quite sure what to put here\\
    }

}
