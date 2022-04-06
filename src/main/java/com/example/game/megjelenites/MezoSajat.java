package com.example.game.megjelenites;

import java.util.Random;

public class MezoSajat {
    private int egyseg = (new Random()).nextInt(10);

    public MezoSajat() {
    }

    public String toString() {
        return "Mezo{egyseg=" + this.egyseg + "}";
    }
}
