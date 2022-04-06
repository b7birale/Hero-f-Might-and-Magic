package com.example.game.hos.egysegek.eloholtak;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.frakciok.modell.Eloholt;

public class Zombi extends Eloholt {

    public Zombi(Hos hos, int hanyDb) {

        super(hos, "Zombi",12,1,4,9,1,6,"nincs", hanyDb*9);

    }
}
