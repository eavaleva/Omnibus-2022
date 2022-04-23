package nl.hhs.omnibus.models;

public class Nameable extends Identifiable {
    /** The name of an individual object. */
    private final String name;

    public Nameable(String name) {
        super();

        this.name = name;
    }

    /**
     * Gets simple details of an object in a String. In this case the ID and the name
     * of the object are fetched in a specific format.
     */
    public String getDetails() {
        return this.getDetails(false);
    }

    /**
     * Prints the details of an object in a String.
     * @param getFullDetails Determines if only the simple details (ID, name) will be fetched or all the
     * details of the object are fetched.
     */
    public abstract String getDetails(boolean getFullDetails);

    @Override
    public String toString() {
        return String.format(" -\t#%03d | %s", this.getId(), this.getName());
    }

    /* GETTER & SETTERS */

    public String getName() {
        return this.name;
    }
}
