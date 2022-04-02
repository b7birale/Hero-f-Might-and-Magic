
package com.example.game.hos.varazslatok;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

public class Tuzlabda extends Varazslat {

    //Egy kivalasztott mezo koruli 3x3-as területen
    // levo osszes (sajat, illetve ellenseges) egysegre (varazsero * 20) sebzes okozasa

    public Tuzlabda(Hos hos) {

        super(120, 9, hos);

    }

    @Override
    public int getMannaAr() {
        return 9;
    }

    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        for(Egyseg egyseg: egysegek){       //végig megy az egysegek listán
            egyseg.sebez(hos.varazsero*20);
        }
    }

}


