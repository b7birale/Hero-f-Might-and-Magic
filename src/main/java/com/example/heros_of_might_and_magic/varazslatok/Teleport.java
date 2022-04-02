
package com.example.heros_of_might_and_magic.varazslatok;

import com.example.heros_of_might_and_magic.Egyseg;
import com.example.heros_of_might_and_magic.Hos;
import com.example.heros_of_might_and_magic.Varazslat;

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


