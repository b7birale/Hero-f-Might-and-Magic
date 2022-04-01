
package com.example.heros_of_might_and_magic.varazslatok;

import com.example.heros_of_might_and_magic.Egyseg;
import com.example.heros_of_might_and_magic.Hos;
import com.example.heros_of_might_and_magic.Varazslat;

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


    /*
    @Override
    public void hasznal(int varazsero){     //parameterbe majd a hos.varazsero jon
        sebzes = varazsero*30;
    }

     */

}




