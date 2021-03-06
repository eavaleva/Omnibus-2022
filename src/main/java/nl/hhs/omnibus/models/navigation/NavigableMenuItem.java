package nl.hhs.omnibus.models.navigation;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.Constants;

/**
 * A MenuItem which provides navigational abilities.
 * This MenuItem can be used to allow a user to navigate from
 * one menu to another within the application, or to close the application.
 */
public class NavigableMenuItem extends MenuItem {
    /** The Menu that is navigated to after selecting this MenuItem. */
    private Menu nextMenu;

    public NavigableMenuItem(String label) {
        super(label);
    }

    public NavigableMenuItem(String label, Menu menu) {
        super(label);

        this.nextMenu = menu;
    }

    /** Creates a clone of a NavigableMenuItem with a Menu to reference back to. */
    public NavigableMenuItem withPreviousMenu(Menu previousMenu) {
        NavigableMenuItem menuItem = new NavigableMenuItem(this.getLabel());
        menuItem.nextMenu = previousMenu;

        return menuItem;
    }

    @Override
    public void executeAction() {
        this.navigateBack();
    }

    /** Navigates to the provided Menu or closes the application of no Menu is provided. */
    protected void navigateBack() {
        // When the next Menu is not specified, close the application
        if (this.nextMenu == null) {
            System.out.println(Constants.CLOSING_APPLICATION_MESSAGE);

            System.exit(0);
            return;
        }
        Omnibus.goToMenu(this.nextMenu);
    }

    /* GETTERS & SETTERS */

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }
}
