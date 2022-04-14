package com.example.game.hos.egysegek.eloholtak;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Eloholt;

public class Szellem extends Eloholt {

    public Szellem(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Szellem",8,1,1,30,5,15,
                "nincs", hanyDb*30, "pink", pozicio);

    }
    
}
