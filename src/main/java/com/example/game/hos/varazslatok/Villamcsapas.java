
package com.example.game.hos.varazslatok;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

public class Villamcsapas extends Varazslat {

    //Egy kivalasztott ellenseges egysegre (varazsero * 30) sebzes okozasa

    public Villamcsapas(Hos hos) {
        super(60, 5, hos);
    }


    @Override
    public int getMannaAr() {
        return 5;
    }


    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            Egyseg egyseg = egysegek.get(0);
            egyseg.sebez(hos.varazsero*30);
        }
    }


}




