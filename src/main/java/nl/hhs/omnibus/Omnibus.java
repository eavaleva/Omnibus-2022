package nl.hhs.omnibus;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.gadgets.Gadget.Gadgets;
import nl.hhs.omnibus.models.navigation.Menu;
import nl.hhs.omnibus.models.navigation.Menu.Menus;
import nl.hhs.omnibus.models.navigation.MenuItem.MenuItems;
import nl.hhs.omnibus.models.persons.Fan.Fans;

import java.util.Scanner;

public class Omnibus {
    public static final Scanner USER_INPUT = new Scanner(System.in);
    public static Menu currentMenu;

    public static void main(String[] args) {
        System.out.println(Constants.LAUNCHING_APPLICATION_MESSAGE);

        initializeMenus();

        goToMenu(Menus.MENU_MAIN);
    }

    /** Navigates to the provided Menu, shows that Menu and awaits further instructions from the User. */
    public static void goToMenu(Menu nextMenu) {
        Omnibus.currentMenu = nextMenu;

        System.out.println(Omnibus.currentMenu);

        Omnibus.currentMenu.awaitMenuItemSelection();
    }

    /** Ties the different Menus and the MenuItems within those Menus together. */
    private static void initializeMenus() {
        // Set up the main navigation
        MenuItems.MI_PEOPLE_TEAMS.setNextMenu(Menus.MENU_PEOPLE);
        MenuItems.MI_GADGETS.setNextMenu(Menus.MENU_GADGETS);
        MenuItems.MI_FIGHTS.setNextMenu(Menus.MENU_FIGHTS);

        // Set up listable menu items.
        MenuItems.MI_LIST_FANS.setItems(Fans.FANS);
        MenuItems.MI_LIST_GADGETS.setItems(Gadgets.GADGETS);

        Menus.MENU_MAIN.addAllOptions(
            MenuItems.MI_EXIT.withPreviousMenu(null),
            MenuItems.MI_PEOPLE_TEAMS,
            MenuItems.MI_GADGETS,
            MenuItems.MI_FIGHTS
        );
        Menus.MENU_PEOPLE.addAllOptions(
            MenuItems.MI_EXIT.withPreviousMenu(Menus.MENU_MAIN),
            MenuItems.MI_LIST_HEROES.withPreviousMenu(Menus.MENU_PEOPLE),
            MenuItems.MI_LIST_VILLAINS.withPreviousMenu(Menus.MENU_PEOPLE),
            MenuItems.MI_LIST_FANS.withPreviousMenu(Menus.MENU_PEOPLE)
        );
        Menus.MENU_GADGETS.addAllOptions(
            MenuItems.MI_EXIT.withPreviousMenu(Menus.MENU_MAIN),
            MenuItems.MI_LIST_GADGETS.withPreviousMenu(Menus.MENU_GADGETS)
        );
        Menus.MENU_FIGHTS.addOption(MenuItems.MI_EXIT.withPreviousMenu(Menus.MENU_MAIN));
    }
}
