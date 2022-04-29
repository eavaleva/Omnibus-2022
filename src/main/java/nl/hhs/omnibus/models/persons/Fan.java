package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;

import java.util.*;

public class Fan extends Nameable {
    private final Set<EnhancedBeing> favoriteCharacters = new HashSet<>();

    public Fan(String name) {
        super(name);
    }

    public boolean isFanOF(EnhancedBeing enhancedBeing) {
        return this.favoriteCharacters.contains(enhancedBeing);
    }

    @Override
    public String getDetails(boolean getFullDetails) {
        return !getFullDetails ? super.toString() : this.toString();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder(String.format("%s%-14s#%03d\n", Constants.SEPARATOR, Constants.ID, this.getId()));
        details.append(String.format("%-14s%s\n", Constants.NAME, this.getName()));
        details.append(String.format("\n%s\n", Constants.FAVORITE_CHARACTERS_HEADER));

        this.favoriteCharacters.forEach(character -> {
            details.append("\t");
            details.append(character.getDetails(false));
            details.append("\n");
        });

        if (this.favoriteCharacters.isEmpty()) {
            details.append(String.format("\t%s\n", Constants.NO_FAVORITE_CHARACTERS));
        }
        details.append(Constants.SEPARATOR);

        return details.toString();
    }

    /* GETTER & SETTERS */

    public Set<EnhancedBeing> getAllFavoriteCharacters() {
        return this.favoriteCharacters;
    }

    public void addAllFavorites(EnhancedBeing... characters) {
        Arrays.stream(characters).forEach(this::addFavorite);
    }

    public void addFavorite(EnhancedBeing character) {
        this.favoriteCharacters.add(character);
    }

    public void removeAllFavorites(EnhancedBeing... characters) {
        Arrays.stream(characters).forEach(this::removeFavorite);
    }

    public void removeFavorite(EnhancedBeing character) {
        this.favoriteCharacters.remove(character);
    }
}
