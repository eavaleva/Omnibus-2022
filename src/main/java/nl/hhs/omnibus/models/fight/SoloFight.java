package nl.hhs.omnibus.models.fight;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.ChooseOpponent;
import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.common.UserInputParsing;
import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.exceptions.MissingOpponentException;
import nl.hhs.omnibus.models.persons.Fan;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.persons.Villain;

public class SoloFight extends Nameable {
    private EnhancedBeing winner;
    private EnhancedBeing loser;

    public SoloFight() {
        super(null);

        ChooseOpponent.showOptions(Omnibus.database.getHeroes().toArray(new Nameable[0]), "Heroes:", true);
        Hero hero = (Hero) ChooseOpponent.chooseItem(Omnibus.database.getHeroes().toArray(new Nameable[0]));

        ChooseOpponent.showOptions(Omnibus.database.getVillains().toArray(new Nameable[0]), "Villains:", true);
        Villain villain = (Villain) ChooseOpponent.chooseItem(Omnibus.database.getVillains().toArray(new Nameable[0]));

        if (hero == null || villain == null) {
            throw new MissingOpponentException();
        }
        this.setName(String.format("%s vs. %s", hero.getName(), villain.getName()));

        String hasFightWinnerResult = UserInputParsing.processUserInputWithOptions(
            Constants.MANUALLY_DETERMINE_FIGHT,
            Constants.FIGHT_WINNER_ANSWERS
        );

        if (hasFightWinnerResult.equals(Constants.RANDOM_FIGHT_WINNER_ANSWER)) {
            this.determineOutcomeFight(hero, villain);
        }
        else {
            this.determineWinnerAndLoser(hero, villain, hasFightWinnerResult.equals(Constants.HERO_FIGHT_WINNER_ANSWER));
        }
        this.transferFans();
    }

    public SoloFight(Hero hero, Villain villain) {
        super(String.format("%s vs. %s", hero.getName(), villain.getName()));

        this.determineOutcomeFight(hero, villain);
    }

    public SoloFight(Hero hero, Villain villain, boolean heroHasWon) {
        this(hero, villain);

        // Manually override the calculated winner and loser
        this.determineWinnerAndLoser(hero, villain, heroHasWon);
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%s%s - %s\n", Constants.SEPARATOR, this.winner.getName(), this.winner.getPhrase()));
        details.append(String.format("%s - %s\n", this.loser.getName(), this.loser.getPhrase()));
        details.append(String.format("%s\n%s", String.format(Constants.FIGHT_HAS_BEEN_WON_PATTERN, this.winner.getName()), Constants.SEPARATOR));

        return details.toString();
    }

    /** Determines the winner and loser for a based on the power level of the opponents. */
    private void determineOutcomeFight(Hero hero, Villain villain) {
        int powerLevelHero = (int) Math.round(Math.random() * hero.getPowerLevel(villain));
        int powerLevelVillain = (int) Math.round(Math.random() * villain.getPowerLevel(hero));

        this.determineWinnerAndLoser(hero, villain, powerLevelHero > powerLevelVillain);
    }

    /** Sets the winner and loser for a fight. */
    private void determineWinnerAndLoser(Hero hero, Villain villain, boolean heroHasWon) {
        if (heroHasWon) {
            this.winner = hero;
            this.loser = villain;
            return;
        }
        this.winner = villain;
        this.loser = hero;
    }

    /** Transfer the Fans of the losing party to the winning party. */
    private void transferFans() {
        // If there are no Fans to remove, don't bother to try to remove Fans
        if (this.loser.getFans().size() == 0) return;

        // Make sure to remove at least 1 Fan
        int numberOfFansToTransfer = (int) Math.round(Math.random() * this.loser.getFans().size() + 1);

        // If there are Fans to remove, but there are going to be too many Fans remove,
        // reduce the amount of Fans to be removed
        if (this.loser.getFans().size() < numberOfFansToTransfer) {
            numberOfFansToTransfer--;
        }

        for(int idx = 0; idx < numberOfFansToTransfer; idx++) {
            Fan fan = this.loser.getFanByIndex(idx);

            fan.removeFavorite(this.loser);
            fan.addFavorite(this.winner);
        }
    }
}
