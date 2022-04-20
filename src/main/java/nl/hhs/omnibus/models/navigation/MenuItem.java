package nl.hhs.omnibus.models.navigation;

/** A basic MenuItem with a label. */
public abstract class MenuItem {
    private final String label;

    public MenuItem(String label) {
        this.label = label;
    }

    public abstract void executeAction();

    /* GETTERS & SETTERS */

    public String getLabel() {
        return label;
    }

    /* DATA */

    public static class MenuItems {
        public static final NavigableMenuItem MI_EXIT = new NavigableMenuItem("Exit");
//        public static final MenuItem MI_SEARCH = new MenuItem("Search...");

        public static final NavigableMenuItem MI_PEOPLE_TEAMS = new NavigableMenuItem("Menu People & Teams");
        public static final NavigableMenuItem MI_GADGETS = new NavigableMenuItem("Menu Gadgets");
        public static final NavigableMenuItem MI_FIGHTS = new NavigableMenuItem("Menu Fights");

//        public static final MenuItem MI_LIST_HEROES = new MenuItem("List Heroes");
//        public static final MenuItem MI_LIST_VILLAINS = new MenuItem("List Villains");
//        public static final MenuItem MI_LIST_FANS = new MenuItem("List Fans");
//        public static final MenuItem MI_LIST_TEAMS = new MenuItem("List Teams");

//        public static final MenuItem MI_LIST_GADGETS = new MenuItem("List Gadgets");

//        public static final MenuItem MI_LIST_FIGHTS = new MenuItem("List Fights");
//        public static final MenuItem MI_CREATE_FIGHT = new MenuItem("New Fight...");
    }
}
