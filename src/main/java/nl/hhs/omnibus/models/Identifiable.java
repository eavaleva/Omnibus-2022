package nl.hhs.omnibus.models;

import java.util.Objects;

/**
 * An Identifiable is something which where it should be able to be identified by an ID.
 */
public class Identifiable {
    private static int nextId = 0;

    /** An internal identifier which is used in the system to identify an object. */
    private final int id;

    public Identifiable() {
        this.id = ++nextId;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (this == object) return true;

        Identifiable other = (Identifiable) object;

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
