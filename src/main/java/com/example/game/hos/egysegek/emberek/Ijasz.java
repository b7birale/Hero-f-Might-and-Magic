package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

import static com.example.game.megjelenites.Palya.OSZLOPOK_SZAMA;
import static com.example.game.megjelenites.Palya.SOROK_SZAMA;
import static java.lang.Math.max;

/**
 * Egy íjász egységet valósít meg. Az Ember gyerekosztálya. (Az Ember pedig az Egyseg gyerekosztálya.)
 */
public class Ijasz extends Ember {

    public Ijasz(Hos hos, int hanyDb, Pozicio pozicio) {
        super(hos, "Ijasz",6,2,4,7,
                4,9,"loves", hanyDb*7, "yellow", pozicio);
    }

    @Override
    public int hatokor() {
        return max(OSZLOPOK_SZAMA-1, SOROK_SZAMA-1);
    }

}
