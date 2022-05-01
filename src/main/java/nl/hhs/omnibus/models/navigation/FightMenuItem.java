package nl.hhs.omnibus.models.navigation;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.common.UserInputParsing;
import nl.hhs.omnibus.models.fight.SoloFight;
import nl.hhs.omnibus.models.fight.TeamFight;

/** Menu Items for creating new Fights. */
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
            Constants.CREATE_SOLO_OR_TEAM_FIGHT,
            Constants.SOLO_OR_TEAM_FIGHT_OPTIONS
        );

        // Create either a Team- or SoloFight and update the fights list in the database
        if (resultTeamOrSoloFight.equals(Constants.SOLO_FIGHT_OPTION)) {
            SoloFight fight = new SoloFight();
            Omnibus.database.addSoloFight(fight);
        }
        else {
            TeamFight fight = new TeamFight();
            Omnibus.database.addTeamFight(fight);
        }
        Omnibus.database.updateFightsList();

        // Get the last created Fight and print its details
        int indexLastFight = Omnibus.database.fights().size() - 1;

        System.out.print(Omnibus.database.fights().get(indexLastFight).getDetails(true));
    }
}
