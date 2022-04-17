package com.example.game.hos.egysegek.frakciok.modell;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;

/**
 * Az Egyseg gyerekosztálya és az öt élőholt egység szülőosztálya.
 * A frakciók elkülönítésében segédkezik.
 */
public class Eloholt extends Egyseg {

    public Eloholt(Hos hos, String nev, int ar, int minSebzes, int maxSebzes, int eletero, int sebesseg,
                   int kezdemenyezes, String specialisKepesseg, int jelenlegiEletero, String szin, Pozicio pozicio) {
        super(hos, nev, ar, minSebzes, maxSebzes, eletero, sebesseg,
                kezdemenyezes + hos.getMoral(), specialisKepesseg, jelenlegiEletero, szin, pozicio);
    }


}
