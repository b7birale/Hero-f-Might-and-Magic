package com.example.game.hos.varazslatok;

import com.example.game.exception.NemEgysegreProbalszAkciotVegrehajtaniException;
import com.example.game.exception.NincsElegMannadAVarazslathozException;
import com.example.game.exception.NemEgysegreProbalodVegrehajtaniAVarazslatotException;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

/**
 * Absztrakt osztály. Az egyes varázslatok ősosztályaként szolgál.
 */
public abstract class Varazslat {
    protected String nev;
    protected int ar;
    protected int manna;
    protected Hos hos;

    public Varazslat(String nev, int ar, int manna, Hos hos) {
        this.nev = nev;
        this.ar = ar;
        this.manna = manna;
        this.hos = hos;
    }

    /**
     * Amennyiben van elég mannánk, alkalmazza az adott varázslatot a paraméterben kapott egységen vagy egységeken
     *  és levonja a megfelelő mannaösszeget is.
     * @param egysegek Azon egységek listája, amin alkalmazni szándékozzuk az adott varázslatot.
     */
    public void varazslatVegrehajt(List<Egyseg> egysegek) throws NincsElegMannadAVarazslathozException, NemEgysegreProbalodVegrehajtaniAVarazslatotException {
        if(egysegek == null || egysegek.isEmpty()){
            throw new NemEgysegreProbalszAkciotVegrehajtaniException();
        } else if (!vanEElegManna()) {
            throw new NincsElegMannadAVarazslathozException();
        } else {
            hasznal(egysegek);
            hos.levonManna(getMannaAr());
        }
    }

    /**
     * Megvizsgálja, hogy van-e elég mannánk az adott varázslat végrehajtásához.
     * Ha nincs hamissal, ha van igazzal tér vissza.
     * @return Van-e elég mannánk a varázslat végrehajtásához.
     */
    public boolean vanEElegManna(){
        return hos.getManna() >= getMannaAr();
    }

    public abstract int getMannaAr();

    public abstract void hasznal(List<Egyseg> egysegek);

    public abstract int hatosugar();

    public abstract String billentyuKombinacio();

    //GETTEREK ÉS SETTEREK ---------------------------------------------------------------------------------------------

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }



}