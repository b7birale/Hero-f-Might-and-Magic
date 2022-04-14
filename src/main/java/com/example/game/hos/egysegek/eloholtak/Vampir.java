package com.example.game.hos.egysegek.eloholtak;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Eloholt;

public class Vampir extends Eloholt {

    public Vampir(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Vampir",7,2,2,9,30,20,
                "verszivas", hanyDb*9, "red", pozicio);

    }
}
