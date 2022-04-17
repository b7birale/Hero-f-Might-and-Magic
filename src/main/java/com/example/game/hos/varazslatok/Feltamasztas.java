
package com.example.game.hos.varazslatok;

import com.example.game.exception.EllensegesEgysegreProbalszOlyanVarazslatotHasznalniAmitCsakSajatraTudszException;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;

import java.util.List;

/**
 * A feltámasztás varázslatot valósít meg. A Varazslat-ból öröklődik.
 */
public class Feltamasztas extends Varazslat {

    public Feltamasztas(Hos hos) {
        super("Feltamasztas", 120, 6, hos);
    }

    @Override
    public int getMannaAr() {
        return 6;
    }

    @Override
    public void hasznal(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            Egyseg egyseg = egysegek.get(0);
            if (hos.ezEllenfelEgyseg(egyseg)) {
                throw new EllensegesEgysegreProbalszOlyanVarazslatotHasznalniAmitCsakSajatraTudszException();
            }
            egyseg.gyogyit(hos.getVarazsero()*50);
        }
    }

    @Override
    public int hatosugar() {
        return 0;
    }

    public String billentyuKombinacio() {
        return "' F ' lenyomva + bal klikk";
    }

}


