package com.example.game.hos.varazslatok;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;

import java.util.List;

public class Teleport extends Varazslat {

    //helycsere egy saját vagy ellenséges egységgel

    public Teleport(Hos hos) {

        super(100, 4, hos);
    }

    @Override
    public int getMannaAr() {
        return 4;
    }


    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        if(egysegek.size() == 2){
            Egyseg elsoEgyseg = egysegek.get(0);
            Egyseg masodikEgyseg = egysegek.get(1);
            Pozicio puffer = masodikEgyseg.pozicio;
            masodikEgyseg.pozicio = elsoEgyseg.pozicio;
            elsoEgyseg.pozicio = puffer;
        }
    }

}


