
package com.example.game.hos.varazslatok;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

/**
 * A mágikus nyílvessző varázslatot valósítja meg. A Varazslat-ból öröklődik.
 */
public class MagicArrow extends Varazslat {

    public MagicArrow(Hos hos) {

        super("MagikusNyilvesszo", 50, 15, hos);
    }

    @Override
    public int getMannaAr() {
        return 15;
    }

    @Override
    public void hasznal(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            Egyseg egyseg = egysegek.get(0);
            egyseg.sebez(10 + hos.getVarazsero()*10);
        }
    }

    @Override
    public int hatosugar() {
        return 100;
    }

    public String billentyuKombinacio() {
        return "' N ' lenyomva + bal klikk";
    }
}


