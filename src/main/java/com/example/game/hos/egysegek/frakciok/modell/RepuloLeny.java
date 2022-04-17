package com.example.game.hos.egysegek.frakciok.modell;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;

/**
 * Az Egyseg gyerekosztálya és az öt repülő lény egységnek a szülőosztálya.
 * A frakciók elkülönítésében segédkezik.
 */

public class RepuloLeny extends Egyseg {

    public RepuloLeny(Hos hos, String nev, int ar, int minSebzes, int maxSebzes, int eletero, int sebesseg,
                      int kezdemenyezes, String specialisKepesseg, int jelenlegiEletero, String szin, Pozicio pozicio) {
        this.hos = hos;
        this.nev = nev;
        this.ar = ar;
        this.minSebzes = minSebzes;
        this.maxSebzes = maxSebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes + hos.getMoral();
        this.specialisKepesseg = specialisKepesseg;
        this.jelenlegiEletero = jelenlegiEletero;
        this.eredetiEletero = jelenlegiEletero;
        this.szin = szin;
        this.pozicio = pozicio;
    }



}