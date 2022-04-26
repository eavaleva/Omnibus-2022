package nl.hhs.omnibus.models.navigation;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.Nameable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This MenuItem prints a list of items upon selection and after that
 * it navigates back to the Menu from where it was selected.
 */
public class ListableMenuItem extends NavigableMenuItem {
    /** The Label that is printed above the list. */
    private final String listHeader;

    /** The list of items to print. */
    private Nameable[] items;

    /** Whether the selecting process is active on this ListableMenuItem. */
    private boolean makeSelection;

    public ListableMenuItem(String label, String listHeader) {
        super(label);

        this.listHeader = listHeader;
        this.makeSelection = false;
    }

    /**
     * Prints the list header and the simple details of all the items in the list,
     * and then goes back to the menu.
     */
    protected void printList() {
        StringBuilder listString = new StringBuilder(String.format("\n%s\n", this.listHeader));

        Arrays.stream(this.items).forEach(item -> listString.append(String.format("%s\n", item.getDetails())));

        // Show an alternative message when there are no items in the list
        if (this.items.length == 0) {
            listString.append(String.format(Constants.NO_ITEMS_ACTIONABLE, this.makeSelection ? Constants.SELECT_ACTION : Constants.SHOW_ACTION));
        }
        System.out.print(listString);
    }

    @Override
    public ListableMenuItem withPreviousMenu(Menu previousMenu) {
        ListableMenuItem menuItem = new ListableMenuItem(this.getLabel(), this.listHeader);
        menuItem.setItems(this.items);
        menuItem.setNextMenu(previousMenu);

        return menuItem;
    }

    /** Creates a duplicate of the ListableMenuItem and activates the selection process for that MenuItem. */
    public NavigableMenuItem makeSelectable(Menu previousMenu, Nameable[] items) {
        ListableMenuItem menuItem = withPreviousMenu(previousMenu);
        menuItem.setLabel(Constants.SEARCH_LABEL);
        menuItem.setItems(items);
        menuItem.makeSelection = true;

        return menuItem;
    }

    @Override
    public void executeAction() {
        this.printList();

        if (this.makeSelection) {
            this.makeSelection();
        }
        this.navigateBack();
    }

    /** Selects an item from the list to print the full details of. */
    private void makeSelection() {
        // When no items are in the list, skip the selection process
        if (this.items.length == 0) return;

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
        List<Nameable> foundItems = Arrays.stream(this.getItems())
            .filter(item -> inputInteger == Integer.MAX_VALUE ? item.getName().toLowerCase().contains(input.toLowerCase()) : item.getId() == inputInteger)
            .collect(Collectors.toList());

        String itemDetails = this.determineSearchResults(foundItems, input, parsedInputValue != Integer.MAX_VALUE);

        System.out.printf("%s", itemDetails);
    }

    /** Prints either the full details out when 1 item is found by ID or name, and otherwise shows a warning to a user. */
    private String determineSearchResults(List<Nameable> items, String query, boolean selectedById) {
        String itemFoundBy = selectedById ? "ID" : "Name";

        // When there is exactly 1 search result
        if (items.size() == 1) {
            return items.get(0).getDetails(true);
        }

        // When there are too many search results (more than 1)
        if (items.size() > 1) {
            return String.format(Constants.TO_MANY_SEARCH_RESULTS, items.size(), itemFoundBy, query);
        }

        // When there are no search results
        return String.format(Constants.NO_SEARCH_RESULTS, itemFoundBy, query);
    }

    /* GETTERS & SETTERS */

    public Nameable[] getItems() {
        return items;
    }

    public void setItems(Nameable[] items) {
        if (items == null) {
            this.items = new Nameable[] {};
            return;
        }
        this.items = items.clone();
    }
}
