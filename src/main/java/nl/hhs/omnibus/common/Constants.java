package nl.hhs.omnibus.common;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String SEPARATOR = "----------------------------------------\n";
    public static final String ID = "ID:";
    public static final String NAME = "Name:";
    public static final String LOCATION = "Location:";
    public static final String POWER_LEVEL = "Power level:";

    public static final String DEFAULT_ONE_LINER = "One-liner %s!";
    public static final String ONE_LINER = "One-liner:";
    public static final String FANS_HEADER = "\nFans:\n";
    public static final String GADGETS_HEADER = "\nGadgets:\n";
    public static final String RIVALS_HEADER = "Rivals:";
    public static final String ARCH_RIVAL_HEADER = "Arch rival:";
    public static final String REAL_NAME = "Real name:";
    public static final String EVIL_PLAN = "Evil plan:";
    public static final String HERO = "Hero:";
    public static final String VILLAIN = "Villain:";

    public static final String OWNER = "Owner:";
    public static final String DESCRIPTION = "Description:";
    public static final String TYPE = "Type:";
    public static final String SPEED = "Speed:";
    public static final String CAPACITY = "Capacity:";

    public static final String FAVORITE_CHARACTERS_HEADER = "Fan of:";

    public static final String MEMBERS_HEADER = "Members:";

    public static final String FIGHT_NAME_PATTERN = "%s vs. %s";

    public static final String HERO_FIGHT_WINNER_ANSWER = "Hero";
    public static final String VILLAIN_FIGHT_WINNER_ANSWER = "Villain";
    public static final String RANDOM_FIGHT_WINNER_ANSWER = "Let the application determine the outcome";
    public static final List<String> FIGHT_WINNER_ANSWERS = Arrays.asList(HERO_FIGHT_WINNER_ANSWER, VILLAIN_FIGHT_WINNER_ANSWER, RANDOM_FIGHT_WINNER_ANSWER);
    public static final String MANUALLY_DETERMINE_FIGHT = "\nDoes this fight have a winner?\n";
    public static final String FIGHT_HAS_BEEN_WON_PATTERN = "\nThis fight has been won by '%s'!";

    public static final String NO_FAVORITE_CHARACTERS = "CURRENTLY DOESN'T FAVOR ANY HERO OR VILLAIN.";
    public static final String NO_RIVALS = "NO RIVALS";
    public static final String NO_FANS = "NO FANS";
    public static final String NO_GADGETS = "NO GADGETS";
    public static final String NO_ARCH_RIVAL = "NO ARCH RIVAL";
    public static final String NO_TEAM_MEMBERS = "CURRENTLY HAS NO MEMBERS.";

    public static final String LAUNCHING_APPLICATION_MESSAGE = "\nWelcome to Omnibus...";
    public static final String MAKE_OPTION_SELECTION_MESSAGE = "Please select an option [0-%d]: ";
    public static final String MAKE_LIST_SELECTION_MESSAGE = "\nPlease select an item from the list by providing the ID or the name of the item: ";
    public static final String CLOSING_APPLICATION_MESSAGE = "\nClosing Omnibus...";
    public static final String SEARCH_LABEL = "Search...";
    public static final String SELECTED_OPTION_LINE = "Selected option: ";

    public static final String SOLO_FIGHT_OPTION = "Individuals";
    public static final String TEAM_FIGHT_OPTION = "Teams";
    public static final List<String> SOLO_OR_TEAM_FIGHT_OPTIONS = Arrays.asList(SOLO_FIGHT_OPTION, TEAM_FIGHT_OPTION);
    public static final String CREATE_SOLO_OR_TEAM_FIGHT = "\nWould you like to create a Fight between Teams or individual Heroes or Villains?\n";
    public static final String TEAM_1 = "Team 1:";
    public static final String TEAM_2 = "Team 2:";

    public static final String SELECTION_OUTSIDE_RANGE_EXCEPTION_MESSAGE = "\tYour selection (%d) is outside of the accepted range. Please, make another selection within the following range [0-%d]\n\n";

    public static final String NO_ITEMS_ACTIONABLE = "\tNo items %s.\n";
    public static final String SELECT_ACTION = "select";
    public static final String SHOW_ACTION = "show";
    public static final String NO_SEARCH_RESULTS = "\tNo result were found for searching by %s: '%s'\n";
    public static final String TO_MANY_SEARCH_RESULTS = "\tTo many results (%d) were found by searching by %s: '%s'. Please, try to narrow down your search query.\n";
    public static final String MISSING_OPPONENT_EXCEPTION_MESSAGE = "\tOne or more opponents are not determined in this Fight. Please, try again.";
}
