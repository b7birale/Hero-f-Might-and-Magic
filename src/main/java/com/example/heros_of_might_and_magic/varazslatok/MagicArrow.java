
package com.example.heros_of_might_and_magic.varazslatok;

import com.example.heros_of_might_and_magic.Egyseg;
import com.example.heros_of_might_and_magic.Hos;
import com.example.heros_of_might_and_magic.Varazslat;

import java.util.List;

public class MagicArrow extends Varazslat {

    //(10/20/30 + (varazsero x 10)) sebzést végez egy kiválasztott ellenséges egységen

    public MagicArrow(Hos hos) {

        super(50, 15, hos);
    }

    @Override
    public int getMannaAr() {
        return 15;
    }

    @Override
    public void alkalmaz(List<Egyseg> egysegek) {

    }

}


