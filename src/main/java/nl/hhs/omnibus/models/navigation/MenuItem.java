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

        public static final NavigableMenuItem MI_PEOPLE_TEAMS = new NavigableMenuItem("Menu People & Teams");
        public static final NavigableMenuItem MI_GADGETS = new NavigableMenuItem("Menu Gadgets");
        public static final NavigableMenuItem MI_FIGHTS = new NavigableMenuItem("Menu Fights");

        public static final ListableMenuItem MI_LIST_HEROES = new ListableMenuItem("List Heroes", "Heroes:");
        public static final ListableMenuItem MI_LIST_VILLAINS = new ListableMenuItem("List Villains", "Villains:");
        public static final ListableMenuItem MI_LIST_FANS = new ListableMenuItem("List Fans", "Fans:");

        public static final ListableMenuItem MI_LIST_GADGETS = new ListableMenuItem("List Gadgets", "Gadgets:");
    }
}
