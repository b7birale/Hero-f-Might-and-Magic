
package com.example.game.hos.varazslatok;

import com.example.game.hos.EmberiHos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

/**
 * A villámcsapás varázslatot valósítja meg. A Varazslat osztály gyerekosztálya.
 */
public class Villamcsapas extends Varazslat {

    //Egy kivalasztott ellenseges egysegre (varazsero * 30) sebzes okozasa

    public Villamcsapas(Hos hos) {
        super("Villamcsapas", 60, 5, hos);
    }

    /**
     * Visszaadja mennyi mannába kerül a villámcsapás varázslat.
     * @return A villámcsapás varázslat manna ára.
     */
    @Override
    public int getMannaAr() {
        return 5;
    }

    /**
     * Alkalmazza a villámcsapás varázslatot a paraméterben kapott egységen.
     * Adott mértékű sebzést mér a kiválasztott egységre.
     * A sebzés mértéke függ a hős varázserő tulajdonságától.
     * Csak abban az esetben történik meg ténylegesen a sebzés,
     *   ha a paraméterben kapott egységlistában pontosan egy egység szerepel.
     * @param egysegek Azon egységek listája, amin alkalmazni szándékozzuk a villámcsapást.
     */
    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        if(egysegek.size() == 1){
            Egyseg egyseg = egysegek.get(0);
            egyseg.sebez(hos.getVarazsero()*30);
        }
    }

    @Override
    public int hatoKor() {
        return 0;
    }



}




