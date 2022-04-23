package java.nl.hhs.omnibus.models;

import nl.hhs.omnibus.models.EnhancedBeing;
import nl.hhs.omnibus.models.Nameable;

import java.util.*;


public class Fan extends Nameable {
    private final Set<EnhancedBeing> favoriteCharacters = new HashSet<>();

    public Fan(String name) {
        super(name);
    }

    public boolean isFanOF(EnhancedBeing enhancedBeing){
        return true;
    }

    public Set<EnhancedBeing> getAllFavoriteCharacters(){
        return this.favoriteCharacters;
    }

    public void addAllFavorites(EnhancedBeing... characters){
        for(EnhancedBeing favorite : characters){
            this.addFavorite(favorite);
        }
    }

    public void addFavorite(EnhancedBeing character){
        this.favoriteCharacters.add(character);
    }

    public void removeAllFavorites(EnhancedBeing... characters){
        for(EnhancedBeing character : characters){
            this.removeAllFavorites(character);
        }
    }

    public void removeFavorite(EnhancedBeing character){
        this.favoriteCharacters.remove(character);
    }
}
