package com.example.game.hos.egysegek.eloholtak;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Eloholt;

/**
 * Egy démon egységet valósít meg. Az Eloholt gyerekosztálya. (Az Eloholt pedig az Egyseg gyerekosztálya.)
 */
public class Demon extends Eloholt {

    public Demon(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Demon",6,2,3,30,5,9,
                "nincs", hanyDb*30, "yellow", pozicio);


    }


}
