
package com.example.game.hos.varazslatok;

import com.example.game.exception.EztAVarazslatotCsakASajatEgysegeidreHasznalhatodException;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;

import java.util.List;

/**
 * A feltámasztás varázslatot valósít meg. A Varazslat-ból öröklődik.
 */
public class Feltamasztas extends Varazslat {

    //Egy kivalasztott sajat egyseg feltamasztasa. Maximalis gyogyitas merteke: (varazsero * 50),
    //de az eredeti egysegszamnal több nem lehet;

    public Feltamasztas(Hos hos) {
        super("Feltamasztas", 120, 6, hos);
    }

    @Override
    public int getMannaAr() {
        return 6;
    }

    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            Egyseg egyseg = egysegek.get(0);
            if (hos.isEllenfelEgysegE(egyseg)) {
                throw new EztAVarazslatotCsakASajatEgysegeidreHasznalhatodException();
            }
            egyseg.gyogyit(hos.getVarazsero()*50);
        }
    }

    @Override
    public int hatoKor() {
        return 0;
    }



}


