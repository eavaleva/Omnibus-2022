package nl.hhs.omnibus.models.persons;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;

import java.util.*;

/** A Fan is a person who favors particular Heroes or Villains. */
public class Fan extends Nameable {
    /** A List of favored Characters with a quote why a Fan likes that Character. */
    private final Map<EnhancedBeing, String> favoriteCharacters = new HashMap<>();

    public Fan(String name) {
        super(name);
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

        this.favoriteCharacters.keySet().forEach(character -> {
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

    public String getQuoteFavoriteCharacter(EnhancedBeing character) {
        return this.favoriteCharacters.get(character);
    }

    public void addAllFavorites(Map<EnhancedBeing, String> characters) {
        characters.forEach(this::addFavorite);
    }

    public void addFavorite(EnhancedBeing character, String quote) {
        this.favoriteCharacters.put(character, quote);
        character.addFan(this);
    }

    public void removeFavorite(EnhancedBeing character) {
        this.favoriteCharacters.remove(character);
        character.removeFan(this);
    }
}
