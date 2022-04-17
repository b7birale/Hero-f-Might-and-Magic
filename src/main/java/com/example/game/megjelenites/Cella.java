package com.example.game.megjelenites;


import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;

/**
 * A csatatér egy celláját valósítja meg.
 */
public class Cella {

    private Egyseg egyseg;
    private Pozicio pozicio;

    public Cella(final Pozicio pozicio) {
        this.pozicio = pozicio;
    }

    public boolean ures() {
        return egyseg == null;
    }

    public Egyseg getEgyseg() {
        return egyseg;
    }

    public void lerakEgyseg(final Egyseg egyseg) {
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
