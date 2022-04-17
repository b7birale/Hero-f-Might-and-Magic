package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

/**
 * Egy lovag egységet valósít meg. Az Ember gyerekosztálya. (Az Ember pedig az Egyseg gyerekosztálya.)
 */
public class Lovag extends Ember {

    public Lovag(Hos hos, int hanyDb, Pozicio pozicio) {

        super(hos, "Lovag",10,6,8,8,2,
                1,"nincs", hanyDb*8, "blue", pozicio);

    }


}
