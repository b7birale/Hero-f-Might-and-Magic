package com.example.game.hos.egysegek.repulol_lenyek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.RepuloLeny;

import static com.example.game.megjelenites.Palya.OSZLOPOK_SZAMA;
import static com.example.game.megjelenites.Palya.SOROK_SZAMA;
import static java.lang.Math.max;

/**
 * Egy sárkány egységet valósít meg. A RepuloLeny gyerekosztálya. (A RepuloLeny pedig az Egyseg gyerekosztálya.)
 */
public class Sarkany extends RepuloLeny {

    public Sarkany(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Sarkany",10,8,12,15,5,3,
                "tuzokadas", hanyDb*15, "blue", pozicio);

    }

    //tuzokadas, ugyanaz mint a lövés == távolsági támadás

    @Override
    public int hatosugar() {
        return max(OSZLOPOK_SZAMA-1, SOROK_SZAMA-1);
    }

}
