package java.nl.hhs.omnibus.models;

public class Nameable extends Identifiable {
    /** The name of an individual object. */
    private String name;

    public Nameable(String name) {
        super();

        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s", this.getId(), this.name);
    }
}
