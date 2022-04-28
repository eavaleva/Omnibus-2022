package nl.hhs.omnibus;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.navigation.Menu;

import java.util.Scanner;

public class Omnibus {
    public static final Scanner USER_INPUT = new Scanner(System.in);
    public static Menu currentMenu;

    public static void main(String[] args) {
        System.out.println(Constants.LAUNCHING_APPLICATION_MESSAGE);


    }

    /** Navigates to the provided Menu, shows that Menu and awaits further instructions from the User. */
    public static void goToMenu(Menu nextMenu) {
        Omnibus.currentMenu = nextMenu;

        System.out.println(Omnibus.currentMenu);

        Omnibus.currentMenu.awaitMenuItemSelection();
    }
}
