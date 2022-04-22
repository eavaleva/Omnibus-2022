package java.nl.hhs.omnibus.models;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Collections;


public class Fan extends Nameable {
    private final ArrayList<EnhancedBeing> fanOf = new ArrayList<>();


    public Fan(String name) {
        super(name);
    }

    public boolean isFanOF(EnhancedBeing enhancedBeing){
        return true;
    }

    public ArrayList<EnhancedBeing> getFanOf() {
        return fanOf;
    }

    public void addAllFavorites(EnhancedBeing favorite){
        Collections.addAll(this.fanOf, favorite);
    }

    public void removeFromFavorite(EnhancedBeing favorite){

    }

    public void addMostFavorite(EnhancedBeing mostFavorite){

    }
    public void removeMostFavorite(EnhancedBeing mostFavorite){

    }
}
