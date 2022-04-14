package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

public class Polgar extends Ember {

    public Polgar(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Polgar",6,7,9,6,9,
                3,"nincs", hanyDb*6, "pink", pozicio);

    }

}
