package nl.hhs.omnibus;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.data.Database;
import nl.hhs.omnibus.models.navigation.Menu;

import java.util.Scanner;

public class Omnibus {
    public static final Scanner USER_INPUT = new Scanner(System.in);
    public static Database database;
    public static Menu currentMenu;

    public static void main(String[] args) {
        System.out.println(Constants.LAUNCHING_APPLICATION_MESSAGE);

        Omnibus.database = new Database();

        goToMenu(Omnibus.database.getMainMenu());
    }

    /** Navigates to the provided Menu, shows that Menu and awaits further instructions from the User. */
    public static void goToMenu(Menu nextMenu) {
        Omnibus.currentMenu = nextMenu;

        System.out.println(Omnibus.currentMenu);

        Omnibus.currentMenu.awaitMenuItemSelection();
    }
}
