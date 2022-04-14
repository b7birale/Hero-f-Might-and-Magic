
package com.example.game.hos.varazslatok;

import com.example.game.hos.EmberiHos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;


public class MagicArrow extends Varazslat {

    //(10/20/30 + (varazsero x 10)) sebzést végez egy kiválasztott ellenséges egységen

    public MagicArrow(Hos hos) {

        super("MagikusNyilvesszo", 50, 15, hos);
    }

    @Override
    public int getMannaAr() {
        return 15;
    }

    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            Egyseg egyseg = egysegek.get(0);
            egyseg.sebez(10 + hos.varazsero*10);
        }
    }

    @Override
    public int hatoKor() {
        return 100;
    }
}


