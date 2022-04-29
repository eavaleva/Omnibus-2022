package nl.hhs.omnibus.common;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.exceptions.NoResultsException;
import nl.hhs.omnibus.models.exceptions.TooManyResultsException;

import java.util.List;
import java.util.stream.Collectors;

public class ChooseOpponent {
    //TODO: List might need to be changed to Array
    public static Nameable chooseItem(List<Nameable> choices) {
        // When no items are in the list, skip the selection process
        if (choices.size() == 0) {
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
        List<Nameable> foundItems = choices.stream()
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
}
