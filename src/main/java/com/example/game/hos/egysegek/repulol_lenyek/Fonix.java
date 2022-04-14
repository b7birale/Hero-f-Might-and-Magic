package com.example.game.hos.egysegek.repulol_lenyek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.RepuloLeny;

public class Fonix extends RepuloLeny {

    public Fonix(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Fonix",12,15,25,40,6,
                4,"nincs", hanyDb*40, "red", pozicio);

    }

}
