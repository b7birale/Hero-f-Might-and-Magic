
package com.example.game.hos.varazslatok;

import com.example.game.hos.EmberiHos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

/**
 * A tűzlabda varázslatot valósítja meg. A Varazslat osztály gyerekosztálya.
 */
public class Tuzlabda extends Varazslat {

    //Egy kivalasztott mezo koruli 3x3-as területen
    // levo osszes (sajat, illetve ellenseges) egysegre (varazsero * 20) sebzes okozasa

    public Tuzlabda(Hos hos) {

        super("Tuzlabda", 120, 9, hos);

    }

    /**
     * Visszaadja mennyi mannába kerül a tűzlabda varázslat.
     * @return A tűzlabda varázslat manna ára.
     */
    @Override
    public int getMannaAr() {
        return 9;
    }

    /**
     * Alkalmazza a tűzlabda varázslatot a paraméterben kapott egységeken.
     * Adott mértékű sebzést mér a kiválasztott egységekre.
     * A sebzés mértéke függ a hős varázserő tulajdonságától.
     * A paraméterben kapott egységlistában több egység is szerepelhet.
     * @param egysegek Azon egységek listája, amin alkalmazni szándékozzuk a tűzlabdát.
     */
    @Override
    public void alkalmaz(List<Egyseg> egysegek) {
        for(Egyseg egyseg: egysegek){       //végig megy az egysegek listán
            egyseg.sebez(hos.getVarazsero()*20);
        }
    }

    @Override
    public int hatoKor() {
        return 1;
    }

}


