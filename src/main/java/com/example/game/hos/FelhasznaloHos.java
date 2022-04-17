package com.example.game.hos;

/**
 * A felhasználó hősét valósítja meg.
 * A felhasználó maga választja ki a tulajdonságait, varázslatait és egységeit.
 */
public class FelhasznaloHos extends Hos {

    public FelhasznaloHos() {
        super(1,1,1,1,1,1,10, "yellow");
    }

    @Override
    public boolean gepIranyitja() {
        return false;
    }



}
