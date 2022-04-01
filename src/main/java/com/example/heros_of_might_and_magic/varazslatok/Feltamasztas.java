
package com.example.heros_of_might_and_magic.varazslatok;

import com.example.heros_of_might_and_magic.Egyseg;
import com.example.heros_of_might_and_magic.Hos;
import com.example.heros_of_might_and_magic.Varazslat;

import java.util.List;

public class Feltamasztas extends Varazslat {

    //Egy kivalasztott sajat egyseg feltamasztasa. Maximalis gyogyitas merteke: (varazsero * 50),
    //de az eredeti egysegszamnal több nem lehet;

    public Feltamasztas(Hos hos) {
        super(120, 6, hos);
    }

    @Override
    public int getMannaAr() {
        return 6;
    }

    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            Egyseg egyseg = egysegek.get(0);
            egyseg.gyogyit(hos.varazsero*50);
        }
    }


    /*
    @Override
    public void hasznal(int varazsero){     //parameterbe majd a hos.varazsero jon
        max_gyogyitas = varazsero*50
    }

     */

}


