package com.example.heros_of_might_and_magic;

import java.util.List;

import static java.lang.Math.ceil;

public class Hos {

    public int tamadas;
    public int tudas;
    public int vedekezes;
    public int moral;
    public int szerencse;
    public int varazsero;
    public int manna;

    private List<Varazslat> varazslatok;
    private List<Egyseg> egysegek;


    public Hos() {
        this.tamadas = 1;
        this.vedekezes = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.manna = 0;
    }

    /*
    public void setHos(int tamadas, int vedekezes, int moral, int szerencse, int varazsero, int tudas, int manna) {
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
        this.moral = moral;
        this.szerencse = szerencse;
        this.varazsero = varazsero;
        this.tudas = tudas;
        this.manna = manna;
    }

     */

    public int getTamadas() {
        return tamadas;
    }
    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    public int getTudas() {
        return tudas;
    }

    public int getVedekezes() {
        return vedekezes;
    }

    public int getMoral() {
        return moral;
    }

    public int getSzerencse() {
        return szerencse;
    }

    public int getVarazsero() {
        return varazsero;
    }


    public void setTamadas(int tamadas) {
        this.tamadas = tamadas;
    }

    public void setTudas(int tudas) {
        this.tudas = tudas;
    }

    public void setVedekezes(int vedekezes) {
        this.vedekezes = vedekezes;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public void setSzerencse(int szerencse) {
        this.szerencse = szerencse;
    }

    public void setVarazsero(int varazsero) {
        this.varazsero = varazsero;
    }
}
