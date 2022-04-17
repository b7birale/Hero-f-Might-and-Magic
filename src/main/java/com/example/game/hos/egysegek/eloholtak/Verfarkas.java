package com.example.game.hos.egysegek.eloholtak;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Eloholt;

/**
 * Egy vérfarkas egységet valósít meg. Az Eloholt gyerekosztálya. (Az Eloholt pedig az Egyseg gyerekosztálya.)
 */
public class Verfarkas extends Eloholt {

    public Verfarkas(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Verfarkas",15,9,11,6,10,4,
                "nincs", hanyDb*6, "blue", pozicio);

    }
}
