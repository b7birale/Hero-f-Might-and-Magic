package com.example.game.hos;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.varazslatok.Varazslat;

import java.util.ArrayList;
import java.util.List;

public class Hos {

    public int tamadas;     //mind private! vagy mégsem
    public int tudas;
    public int vedekezes;
    public int moral;
    public int szerencse;
    public int varazsero;
    public int manna;

    public int db; //Ez mire való itt?

    public List<Varazslat> varazslatok;
    public List<Egyseg> egysegek;

    public Hos() {
        this.tamadas = 1;
        this.vedekezes = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.manna = 0;
        varazslatok = new ArrayList<>();
        egysegek = new ArrayList<>();
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


    public void fizet(int mennyit){
        this.manna -= mennyit;
    }

    public void tamad(Egyseg tamadottEgyseg){
        int sebzes = tamadas * 10 * tamadottEgyseg.jelenlegiEletero;
        tamadottEgyseg.csokkentEletero(sebzes);
    }

    public void tamadEgyseggel(Egyseg tamadottEgyseg, Hos ellenfel){
        int egysegIndex = 0;
        egysegek.get(egysegIndex).tamad(tamadottEgyseg);
    }

    public void addVarazslatok(Varazslat varazslat) {
        varazslatok.add(varazslat);
    }

    public void addEgysegek(Egyseg egyseg) {
        egysegek.add(egyseg);
    }


    public void varazsol(String tipus, List<Egyseg> egysegek) {
        varazslatok.stream()
                .filter(varazslat -> tipus.equals(varazslat.getNev()))
                .findFirst()
                .ifPresent(varazslat -> varazslat.vegrehajt(egysegek));
    }




    //GETTEREK ÉS SETTEREK ------------------------------------------------------------------------------

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

    public List<Varazslat> getVarazslatok() {
        return varazslatok;
    }

    public List<Egyseg> getEgysegek() {
        return egysegek;
    }

    public void setVarazslatok(List<Varazslat> varazslatok) {
        this.varazslatok = varazslatok;
    }

    public void setEgysegek(List<Egyseg> egysegek) {
        this.egysegek = egysegek;
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


    //??
    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }
}
