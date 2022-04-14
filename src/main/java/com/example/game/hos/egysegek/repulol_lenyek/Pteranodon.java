package com.example.game.hos.egysegek.repulol_lenyek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.RepuloLeny;

public class Pteranodon extends RepuloLeny {

    public Pteranodon(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Pteranodon",15,5,30,7,9,10,
                "nincs", hanyDb*7, "green", pozicio);


    }

}
