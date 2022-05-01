package nl.hhs.omnibus.models.navigation;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.common.UserInputParsing;
import nl.hhs.omnibus.models.fight.SoloFight;
import nl.hhs.omnibus.models.fight.TeamFight;

public class FightMenuItem extends NavigableMenuItem {
    public FightMenuItem(String label, Menu nextMenu) {
        super(label, nextMenu);
    }

    @Override
    public void executeAction() {
        this.initializeFight();
        this.navigateBack();
    }

    /** Creates a new Fight, and prints its details when it has been created. */
    private void initializeFight() {
        String resultTeamOrSoloFight = UserInputParsing.processUserInputWithOptions(
            String.format(Constants.CREATE_SOLO_OR_TEAM_FIGHT, Constants.SOLO_OR_TEAM_FIGHT_OPTIONS),
            Constants.SOLO_OR_TEAM_FIGHT_OPTIONS
        );

        if (resultTeamOrSoloFight.equals(Constants.SOLO_FIGHT_OPTION)) {
            SoloFight fight = new SoloFight();
            Omnibus.database.addSoloFight(fight);
        }
        else {
            TeamFight fight = new TeamFight();
            Omnibus.database.addTeamFight(fight);
        }
        Omnibus.database.updateFightsList();

        int indexLastFight = Omnibus.database.fights().size() - 1;

        System.out.print(Omnibus.database.fights().get(indexLastFight).getDetails(true));
    }
}
