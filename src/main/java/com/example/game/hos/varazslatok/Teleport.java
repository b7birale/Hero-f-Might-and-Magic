
package com.example.game.hos.varazslatok;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

public class Teleport extends Varazslat {

    //Egy kivalasztott (sajat) egyseget barhova athelyezhet

    public Teleport(Hos hos) {

        super(100, 4, hos);
    }

    @Override
    public int getMannaAr() {
        return 4;
    }

    @Override
    public void alkalmaz(List<Egyseg> egysegek) {

    }

}


