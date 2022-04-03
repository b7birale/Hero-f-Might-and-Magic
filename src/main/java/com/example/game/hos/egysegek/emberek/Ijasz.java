package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

public class Ijasz extends Ember {

    public Ijasz(int hanyDb) {
        super("Ijasz",6,2,4,7,4,9,"loves", hanyDb*7);
    }

    public void loves(Egyseg tamadottEgyseg, int tamadas, Hos ellenfel){
        if(tavolsagiTamadas()){
            tamad(tamadottEgyseg, tamadas, ellenfel);
        }
    }

}
