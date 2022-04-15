package java.nl.hhs.omnibus.interfaces;

/**
 * An Identifiable is something which where it should be able to be identified by an ID or a name.
 * Also updating of its name should be possible.
 */
public interface Identifiable {
    int getId();

    String getName();

    void setName(String name);
}
