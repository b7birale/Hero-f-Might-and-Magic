package com.example.game.megjelenites;


import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.emberek.Foldmuves;

import java.util.Objects;

/**
 * A csatatér egy mezőjét valósítja meg.
 */
public class Mezo {

    private Egyseg egyseg;
    private Pozicio pozicio;

    public Mezo(final Pozicio pozicio) {
        this.pozicio = pozicio;
    }

    public boolean ures() {
        return egyseg == null;
    }


    public Egyseg getEgyseg() {
        return egyseg;
    }

    public void lehelyezEgyseg(final Egyseg egyseg) {
        egyseg.setPozicio(pozicio);
        this.egyseg = egyseg;
    }

    public void leveszEgyseg() {
        this.egyseg.setPozicio(null);
        this.egyseg = null;
    }

    @Override
    public String toString() {
        return "Mezo{" +
                "egyseg=" + egyseg +
                '}';
    }
}
