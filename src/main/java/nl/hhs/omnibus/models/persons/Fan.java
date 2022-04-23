package nl.hhs.omnibus.models.persons;

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

    public Set<EnhancedBeing> getAllFavoriteCharacters() {
        return this.favoriteCharacters;
    }

    public void addAllFavorites(EnhancedBeing... characters) {
        for (EnhancedBeing favorite : characters) {
            this.addFavorite(favorite);
        }
    }

    public void addFavorite(EnhancedBeing character) {
        this.favoriteCharacters.add(character);
    }

    public void removeAllFavorites(EnhancedBeing... characters) {
        for (EnhancedBeing favorite : characters) {
            this.removeFavorite(favorite);
        }
    }

    public void removeFavorite(EnhancedBeing character) {
        this.favoriteCharacters.remove(character);
    }
}
