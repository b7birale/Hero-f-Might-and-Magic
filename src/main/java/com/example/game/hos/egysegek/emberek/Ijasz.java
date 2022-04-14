package com.example.game.hos.egysegek.emberek;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.frakciok.modell.Ember;

public class Ijasz extends Ember {

    public Ijasz(Hos hos, int hanyDb, Pozicio pozicio) {
        super(hos, "Ijasz",6,2,4,7,
                4,9,"loves", hanyDb*7, "yellow", pozicio);
    }

    /*
    public void loves(Egyseg tamadottEgyseg){
        if(tavolsagiTamadas()){
            tamad(tamadottEgyseg);
        }
    }

     */

}
