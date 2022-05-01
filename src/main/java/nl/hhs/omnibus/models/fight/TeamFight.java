package nl.hhs.omnibus.models.fight;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.ItemSelector;
import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.common.UserInputParsing;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.exceptions.MissingOpponentException;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.persons.Villain;
import nl.hhs.omnibus.models.teams.HeroTeam;
import nl.hhs.omnibus.models.teams.VillainTeam;

/** A Fight between Teams of Heroes and Villains. */
public class TeamFight extends Nameable {
    /** The winners of a Fight. */
    private Nameable winners;

    /** The losers of a Fight. */
    private Nameable losers;

    /**
     * Creates a new Fight. Lets a user select the opponents and allows
     * them to determine the winners and losers of the Fight.
     */
    public TeamFight() {
        super(null);

        // Select a Team of Heroes as opponent for a new Fight
        ItemSelector.showItems(Omnibus.database.getHeroicTeams().toArray(new Nameable[0]), "Heroic Teams:", true);
        HeroTeam heroes = (HeroTeam) ItemSelector.chooseItem(Omnibus.database.getHeroicTeams().toArray(new Nameable[0]));

        // Select a Team of Villains as opponent for a new Fight
        ItemSelector.showItems(Omnibus.database.getVillainousTeams().toArray(new Nameable[0]), "Villainous Teams:", true);
        VillainTeam villains = (VillainTeam) ItemSelector.chooseItem(Omnibus.database.getVillainousTeams().toArray(new Nameable[0]));

        // When something went wrong with selecting an opponent, stops creating the new Fight
        if (heroes == null || villains == null) {
            throw new MissingOpponentException();
        }

        // Update the name of the Fight
        this.setName(String.format(Constants.FIGHT_NAME_PATTERN, heroes.getName(), villains.getName()));

        // Determine how and who the winner should be for this Fight
        String hasFightWinnerResult = UserInputParsing.processUserInputWithOptions(
            Constants.MANUALLY_DETERMINE_FIGHT,
            Constants.FIGHT_WINNER_ANSWERS
        );

        if (hasFightWinnerResult.equals(Constants.RANDOM_FIGHT_WINNER_ANSWER)) {
            this.determineOutcomeFight(heroes, villains);
            return;
        }
        this.determineWinnersAndLosers(heroes, villains, hasFightWinnerResult.equals(Constants.HERO_FIGHT_WINNER_ANSWER));
    }

    /**
     * Creates a new Fight in which the application determines the outcome of the Fight.
     * Only used during application start-up and data initialization.
     */
    public TeamFight(HeroTeam heroes, VillainTeam villains, boolean heroesHaveWon) {
        this(heroes, villains);

        // Manually override the calculated winners and losers
        this.determineWinnersAndLosers(heroes, villains, heroesHaveWon);
    }

    /**
     * Creates a new Fight with a pre-determined outcome of the Fight.
     * Only used during application start-up and data initialization.
     */
    public TeamFight(HeroTeam heroes, VillainTeam villains) {
        super(String.format(Constants.FIGHT_NAME_PATTERN, heroes.getName(), villains.getName()));

        // Manually override the calculated winners and losers
        this.determineOutcomeFight(heroes, villains);
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%s%-14s#%03d\n", Constants.SEPARATOR, Constants.ID, this.getId()));
        details.append(String.format("%-14s%s\n", Constants.NAME, this.getName()));
        details.append(String.format("%s\n%s", Constants.TEAM_1, this.winners.getDetails(true)));
        details.append(String.format("%s\n%s", Constants.TEAM_2, this.losers.getDetails(true)));
        details.append(String.format(Constants.FIGHT_HAS_BEEN_WON_PATTERN, this.winners.getName()));
        details.append(String.format("\n%s", Constants.SEPARATOR));

        return details.toString();
    }

    /** Determines the winner and loser for a based on the power level of the opponents. */
    private void determineOutcomeFight(HeroTeam heroes, VillainTeam villains) {
        int powerLevelHeroes = 0;
        int powerLevelVillains = 0;

        for (Hero hero: heroes.getMembers()) {
            Villain potentialArchEnemy = villains.getArchRivalOfHero(hero);

            powerLevelHeroes += (int) Math.round(Math.random() * hero.getPowerLevel(potentialArchEnemy));
        }
        for (Villain villain: villains.getMembers()) {
            Hero potentialArchEnemy = heroes.getArchRivalOfVillain(villain);

            powerLevelVillains += (int) Math.round(Math.random() * villain.getPowerLevel(potentialArchEnemy));
        }
        this.determineWinnersAndLosers(heroes, villains, powerLevelHeroes > powerLevelVillains);
    }

    /** Sets the winner and loser for a fight. */
    private void determineWinnersAndLosers(HeroTeam heroes, VillainTeam villains, boolean heroHasWon) {
        if (heroHasWon) {
            this.winners = heroes;
            this.losers = villains;
            return;
        }
        this.winners = villains;
        this.losers = heroes;
    }
}
