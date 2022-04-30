package nl.hhs.omnibus.common;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.exceptions.NoResultsException;
import nl.hhs.omnibus.models.exceptions.TooManyResultsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChooseOpponent {
    public static Nameable chooseItem(Nameable[] choices) {
        // When no items are in the list, skip the selection process
        if (choices.length == 0) {
            return null;
        }
        System.out.print(Constants.MAKE_LIST_SELECTION_MESSAGE);

        String input = Omnibus.USER_INPUT.nextLine();
        int parsedInputValue;

        // Try to parse the input into an integer for selecting an item based on id
        try {
            parsedInputValue = Integer.parseInt(input);
        }
        catch (NumberFormatException exception) {
            parsedInputValue = Integer.MAX_VALUE;
        }
        int inputInteger = parsedInputValue;

        // Find an item in the list that either matches the given name or ID,
        // based on whether the parsing of the ID to an Integer was successful
        List<Nameable> foundItems = Arrays.stream(choices)
                .filter(item -> inputInteger == Integer.MAX_VALUE ? item.getName().toLowerCase().contains(input.toLowerCase()) : item.getId() == inputInteger)
                .collect(Collectors.toList());

        return determineSearchResults(foundItems, input, inputInteger != Integer.MAX_VALUE);
    }

    /** Return an item whether it has been found by ID or name, and otherwise shows a warning to a user. */
    private static Nameable determineSearchResults(List<Nameable> items, String query, boolean selectedById) {
        String itemFoundBy = selectedById ? "ID" : "Name";

        // When there is exactly 1 search result
        if (items.size() == 1) {
            return items.get(0);
        }

        // When there are too many search results (more than 1)
        if (items.size() > 1) {
            throw new TooManyResultsException(items.size(), itemFoundBy, query);
        }

        // When there are no search results
        throw new NoResultsException(itemFoundBy, query);
    }

    /** Prints a list header and the simple details of all the items in the list. */
    public static void showOptions(Nameable[] options, String listHeader, boolean isSelecting) {
        StringBuilder listString = new StringBuilder(String.format("\n%s\n", listHeader));

        Arrays.stream(options).forEach(item -> listString.append(String.format("%s\n", item.getDetails())));

        // Show an alternative message when there are no items in the list
        if (options.length == 0) {
            listString.append(String.format(Constants.NO_ITEMS_ACTIONABLE, isSelecting ? Constants.SELECT_ACTION : Constants.SHOW_ACTION));
        }
        System.out.print(listString);
    }
}
