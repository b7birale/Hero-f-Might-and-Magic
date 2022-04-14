package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

public class Grof extends Ember {

    public Grof(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Grof",8,3,4,5,7,
                15,"nincs", hanyDb*5, "red", pozicio);

    }

}
