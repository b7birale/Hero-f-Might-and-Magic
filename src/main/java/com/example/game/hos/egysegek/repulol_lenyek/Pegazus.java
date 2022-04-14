package com.example.game.hos.egysegek.repulol_lenyek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.RepuloLeny;

public class Pegazus extends RepuloLeny {

    public Pegazus(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Pegazus",7,2,2,30,7,
                8,"nincs", hanyDb*30, "pink", pozicio);

    }

}
