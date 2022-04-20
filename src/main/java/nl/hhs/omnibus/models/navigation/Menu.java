package nl.hhs.omnibus.models.navigation;

import nl.hhs.omnibus.Omnibus;
import nl.hhs.omnibus.common.UserInputParsing;

import java.util.*;

/**
 * A Menu provides a user with options to select which on themselves will do certain actions
 * depending on the type of option that they are.
 */
public class Menu {
    private final String label;
    private final List<MenuItem> options = new ArrayList<>();

    public Menu(String label) {
        this.label = label;
    }

    /** Returns the number of available options to choose from in this Menu. */
    public int numberOfOptions() {
        return this.options.size();
    }

    /**
     * Asks a User to select a MenuItem to make use of the application.
     * Retries when the provided input value is outside the range of provided options.
     */
    public void awaitMenuItemSelection() {
        int selectedOptionIndex = -1;

        try {
            String nextActionQuestion = String.format("Please select a an option [0-%d]: ", Omnibus.currentMenu.numberOfOptions() - 1);
            selectedOptionIndex = UserInputParsing.processUserInputToInt(nextActionQuestion);

            Omnibus.currentMenu.selectOptionByIndex(selectedOptionIndex);
        }
        catch (IndexOutOfBoundsException exception) {
            System.out.printf(
                "\tYour selection (%d) is outside of the accepted range. Please, make another selection within the following range [0-%d]\n\n",
                selectedOptionIndex,
                Omnibus.currentMenu.numberOfOptions() - 1
            );

            this.awaitMenuItemSelection();
        }
    }

    /** Selects an option by its index in the list and executes its action. */
    public void selectOptionByIndex(int index) {
        this.options.get(index).executeAction();
    }

    /** Adds multiple MenuItems as options to a Menu. */
    public void addAllOptions(MenuItem... options) {
        Arrays.stream(options).forEach(this::addOption);
    }

    /** Adds a single MenuItem as option to a Menu when it is not already an option of the same Menu. */
    public void addOption(MenuItem option) {
        if (this.options.contains(option)) return;

        this.options.add(option);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("\n%s:\n", this.label));

        // List all the available options, starting at the second option (index 1).
        for (int index = 1; index < this.options.size(); index++) {
            MenuItem option = this.options.get(index);

            stringBuilder.append(String.format(" (%d)\t%s\n", index, option.getLabel()));
        }
        // End the list of available options, with the first option (index 0) which typically will be the `exit` command.
        stringBuilder.append(String.format(" (%d)\t%s\n", 0, this.options.get(0).getLabel()));

        return stringBuilder.toString();
    }

    /* DATA */

    public static class Menus {
        public static final Menu MENU_MAIN = new Menu("Main Menu");
        public static final Menu MENU_PEOPLE = new Menu("Menu People");
        public static final Menu MENU_GADGETS = new Menu("Menu Gadgets");
        public static final Menu MENU_FIGHTS = new Menu("Menu Fights");
    }
}
