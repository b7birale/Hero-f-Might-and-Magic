package com.example.game.hos;

/**
 * A felhasználó hősét valósítja meg.
 * A felhasználó maga választja ki a tulajdonságait, varázslatait és egységeit.
 */
public class EmberiHos extends Hos {

    public EmberiHos() {
        super(1,1,1,1,1,1,0);
    }

    @Override
    public boolean isGep() {
        return false;
    }

    @Override
    public void automatanVegrehajt() {
    }

}
