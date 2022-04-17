package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

/**
 * Egy polgár egységet valósít meg. Az Ember gyerekosztálya. (Az Ember pedig az Egyseg gyerekosztálya.)
 */
public class Polgar extends Ember {

    public Polgar(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Polgar",6,7,9,6,9,
                3,"nincs", hanyDb*6, "pink", pozicio);

    }

}
