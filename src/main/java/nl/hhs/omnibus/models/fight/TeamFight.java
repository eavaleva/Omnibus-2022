package nl.hhs.omnibus.models.fight;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.ChooseOpponent;
import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.common.UserInputParsing;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.exceptions.MissingOpponentException;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.persons.Villain;
import nl.hhs.omnibus.models.teams.HeroTeam;
import nl.hhs.omnibus.models.teams.VillainTeam;

public class TeamFight extends Nameable {
    private Nameable winners;
    private Nameable losers;

    public TeamFight() {
        super(null);

        ChooseOpponent.showOptions(Omnibus.database.getHeroicTeams().toArray(new Nameable[0]), "Heroic Teams:", true);
        HeroTeam heroes = (HeroTeam) ChooseOpponent.chooseItem(Omnibus.database.getHeroicTeams().toArray(new Nameable[0]));

        ChooseOpponent.showOptions(Omnibus.database.getVillainousTeams().toArray(new Nameable[0]), "Villainous Teams:", true);
        VillainTeam villains = (VillainTeam) ChooseOpponent.chooseItem(Omnibus.database.getVillainousTeams().toArray(new Nameable[0]));

        if (heroes == null || villains == null) {
            throw new MissingOpponentException();
        }
        this.setName(String.format("%s vs. %s", heroes.getName(), villains.getName()));

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

    public TeamFight(HeroTeam heroes, VillainTeam villains) {
        super(String.format("%s vs. %s", heroes.getName(), villains.getName()));

        this.determineOutcomeFight(heroes, villains);
    }

    public TeamFight(HeroTeam heroes, VillainTeam villains, boolean heroesHaveWon) {
        this(heroes, villains);

        // Manually override the calculated winners and losers
        this.determineWinnersAndLosers(heroes, villains, heroesHaveWon);
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(this.winners.getDetails(true));
        details.append(this.losers.getDetails(true));
        details.append(String.format(Constants.FIGHT_HAS_BEEN_WON_PATTERN, this.winners.getName()));
        details.append(String.format("\n%s", Constants.SEPARATOR));

        return details.toString();
    }

    /** Determines the winner and loser for a based on the power level of the opponents. */
    private void determineOutcomeFight(HeroTeam heroes, VillainTeam villains) {
        int powerLevelHeroes = 0;
        int powerLevelVillains = 0;

        for (Hero hero: heroes.getMembers()) {
            Villain potentialArchEnemy = villains.getArhRivalOfHero(hero);

            powerLevelHeroes += (int) Math.round(Math.random() * hero.getPowerLevel(potentialArchEnemy));
        }
        for (Villain villain: villains.getMembers()) {
            Hero potentialArchEnemy = heroes.getArhRivalOfVillain(villain);

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
