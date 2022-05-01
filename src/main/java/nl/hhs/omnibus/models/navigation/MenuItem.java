package nl.hhs.omnibus.models.navigation;

/** A basic MenuItem with a label. */
public abstract class MenuItem {
    private String label;

    public MenuItem(String label) {
        this.label = label;
    }

    /** Executes a specific action (logic) depending on the implementation details of the sub classes. */
    public abstract void executeAction();

    /* GETTERS & SETTERS */

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
