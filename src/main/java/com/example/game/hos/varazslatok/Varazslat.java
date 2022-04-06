package com.example.game.hos.varazslatok;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.Hos;

import java.util.List;

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

    public void vegrehajt(List<Egyseg> egysegek){
        if(vanElegManna()){
            alkalmaz(egysegek);
            hos.fizet(getMannaAr());
        }
    }

    public boolean vanElegManna(){
        return hos.manna >= getMannaAr();
    }

    public abstract int getMannaAr();

    public abstract void alkalmaz(List<Egyseg> egysegek);




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