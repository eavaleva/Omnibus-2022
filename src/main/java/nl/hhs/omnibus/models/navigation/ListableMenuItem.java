package nl.hhs.omnibus.models.navigation;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.Nameable;

import java.util.Arrays;

/**
 * This MenuItem prints a list of items upon selection and after that
 * it navigates back to the Menu from where it was selected.
 */
public class ListableMenuItem extends NavigableMenuItem {
    /** The Label that is printed above the list. */
    private final String listHeader;

    /** The list of items to print. */
    private Nameable[] items;

    public ListableMenuItem(String label, String listHeader) {
        super(label);

        this.listHeader = listHeader;
    }

    @Override
    public NavigableMenuItem withPreviousMenu(Menu previousMenu) {
        ListableMenuItem menuItem = new ListableMenuItem(this.getLabel(), this.listHeader);
        menuItem.setItems(this.items);
        menuItem.setNextMenu(previousMenu);

        return menuItem;
    }

    @Override
    public void executeAction() {
        /*
         * Prints the list header and the simple details of all the items in the list,
         * and then goes back to the menu.
         */
        StringBuilder listString = new StringBuilder(String.format("\n%s\n", this.listHeader));

        Arrays.stream(this.items).forEach(item -> listString.append(String.format("%s\n", item.getDetails())));

        if (this.items.length == 0) {
            listString.append(String.format("\t%s\n", Constants.NO_ITEMS));
        }
        System.out.print(listString);

        super.executeAction();
    }

    /* GETTERS & SETTERS */

    public void setItems(Nameable[] items) {
        if (items == null) {
            this.items = new Nameable[] {};
            return;
        }
        this.items = items.clone();
    }
}
