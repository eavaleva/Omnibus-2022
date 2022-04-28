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
}
