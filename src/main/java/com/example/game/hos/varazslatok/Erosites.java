package com.example.game.hos.varazslatok;

import com.example.game.exception.EztAVarazslatotCsakASajatEgysegeidreHasznalhatodException;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

/**
 * Az erősítés varázslatot valósítja meg. A Varazslat-ból öröklődik.
 */
public class Erosites extends Varazslat {

    public Erosites(Hos hos) {

        super("Erosites", 100, 4, hos);
    }

    @Override
    public int getMannaAr() {
        return 4;
    }


    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            if (hos.isEllenfelEgysegE(egysegek.get(0))) {
                throw new EztAVarazslatotCsakASajatEgysegeidreHasznalhatodException();
            }
            egysegek.get(0).setMaxSebzes(egysegek.get(0).getMaxSebzes() + 1);
        }

    }

    @Override
    public int hatoKor() {
        return 0;
    }

}


