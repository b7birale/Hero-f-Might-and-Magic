package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

public class Foldmuves extends Ember {

    public Foldmuves(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Foldmuves",2,1,1,3,4,
                8,"nincs", hanyDb*3, "green", pozicio);

    }

}
