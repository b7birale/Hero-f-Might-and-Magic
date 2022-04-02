package com.example.game.hos.egysegek.frakciok.modell;

import com.example.game.hos.egysegek.Egyseg;

public class Ember extends Egyseg {

    public Ember(String nev, int ar, int minSebzes, int maxSebzes, int eletero, int sebesseg, int kezdemenyezes, String specialisKepesseg, int jelenlegiEletero) {
        this.nev = nev;
        this.ar = ar;
        this.minSebzes = minSebzes;
        this.maxSebzes = maxSebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
        this.specialisKepesseg = specialisKepesseg;
        this.jelenlegiEletero = jelenlegiEletero;
    }

}
