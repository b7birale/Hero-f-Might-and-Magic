package com.example.game.hos.egysegek.repulol_lenyek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.RepuloLeny;

/**
 * Egy griff egységet valósít meg. A RepuloLeny gyerekosztálya. (A RepuloLeny pedig az Egyseg gyerekosztálya.)
 */
public class Griff extends RepuloLeny {

    public Griff(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Griff",15,5,10,30,7,
                15,"vegtelen visszatamadas", hanyDb*30, "yellow", pozicio);

    }


}
