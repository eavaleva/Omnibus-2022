package nl.hhs.omnibus.models.navigation;

import nl.hhs.omnibus.common.ChooseOpponent;
import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.exceptions.NoResultsException;
import nl.hhs.omnibus.models.exceptions.TooManyResultsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public ListableMenuItem(String label, String listHeader, List items, boolean selectable) {
        this(label, listHeader, items);

        this.makeSelection = selectable;
    }

    public ListableMenuItem(String label, String listHeader, List items) {
        this(label, listHeader);

        List<Nameable> itemsList = new ArrayList<Nameable>(items);

        this.items = itemsList.toArray(new Nameable[0]);
    }

    public ListableMenuItem(String label, String listHeader) {
        super(label);

        this.listHeader = listHeader;
        this.makeSelection = false;
    }

    @Override
    public ListableMenuItem withPreviousMenu(Menu previousMenu) {
        ListableMenuItem menuItem = new ListableMenuItem(this.getLabel(), this.listHeader, Arrays.asList(this.items), this.makeSelection);
        menuItem.setNextMenu(previousMenu);

        return menuItem;
    }

    public ListableMenuItem makeSelectable(Menu previousMenu) {
        return this.makeSelectable(previousMenu, this.items);
    }

    /** Creates a duplicate of the ListableMenuItem and activates the selection process for that MenuItem. */
    public ListableMenuItem makeSelectable(Menu previousMenu, Nameable[] items) {
        ListableMenuItem menuItem = withPreviousMenu(previousMenu);
        menuItem.setLabel(Constants.SEARCH_LABEL);
        menuItem.setItems(items);
        menuItem.makeSelection = true;

        return menuItem;
    }

    @Override
    public void executeAction() {
        ChooseOpponent.showOptions(this.items, this.listHeader, this.makeSelection);

        if (this.makeSelection) {
            this.makeSelection();
        }
        this.navigateBack();
    }

    /** Selects an item from the list to print the full details of. */
    private void makeSelection() {
        try {
            Nameable item = ChooseOpponent.chooseItem(this.items);

            if (item == null){
                return;
            }

            System.out.print(item);
        }
        catch (NoResultsException | TooManyResultsException exception){
            System.out.print(exception.getMessage());
        }
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
