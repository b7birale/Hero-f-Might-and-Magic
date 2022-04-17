package com.example.game.hos;

import com.example.game.exception.NincsAdottTipusuVarazslatException;
import com.example.game.exception.NincsElegMannaException;
import com.example.game.exception.VarazslatokCsakEgysegekreAlkalmazhatoakException;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.varazslatok.Varazslat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ez a Hos oszály, ami egy hőst valósít meg.
 * Absztrakt osztály. A GepiHos és az EmberiHos osztályok őseként szolgál.
 */


public abstract class Hos {

    protected int tamadas;
    protected int tudas;
    protected int vedekezes;
    protected int moral;
    protected int szerencse;
    protected int varazsero;
    protected int manna;
    protected boolean akciotVegrehajtott;
    protected String keretSzin;

    public List<Varazslat> varazslatok;
    public List<Egyseg> egysegek;

    public Hos() {
        this.tamadas = 1;
        this.vedekezes = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.manna = 10;
        this.akciotVegrehajtott = false;
        this.keretSzin = keretSzin;
        varazslatok = new ArrayList<>();
        egysegek = new ArrayList<>();
    }

    public Hos(int tamadas, int tudas, int vedekezes, int moral, int szerencse, int varazsero, int manna, String keretSzin) {
        this.tamadas = tamadas;
        this.tudas = tudas;
        this.vedekezes = vedekezes;
        this.moral = moral;
        this.szerencse = szerencse;
        this.varazsero = varazsero;
        this.manna = manna;
        this.akciotVegrehajtott = false;
        this.keretSzin = keretSzin;
        varazslatok = new ArrayList<>();
        egysegek = new ArrayList<>();
    }

    public void fizet(int mennyit){
        this.manna -= mennyit;
    }

    /**
     * Megtámadunk egy ellenséges egységet a hőssel.
     * Kiszámítjuk a sebzést. A sebzés mértéke függ a hős támadás tulajdonságától.
     * Csökkentjük a megtámadott egység életerejét annyival, amennyi a sebzés.
     * @param tamadottEgyseg Az egység, amit megtámad a hősünk.
     */
    public void tamad(Egyseg tamadottEgyseg){
        int sebzes = this.tamadas * 10;
        tamadottEgyseg.sebez(sebzes);
        akciotVegrehajtott = true;
    }

    /**
     * Hozzáadunk egy varázslatot a hős varazslatok listájához.
     * @param varazslat A varázslat, amit hozzáadunk a listához.
     */
    public void addVarazslatok(Varazslat varazslat) {
        varazslatok.add(varazslat);
    }

    /**
     * Hozzáadunk egy egységet a hős egysegek listájához.
     * @param egyseg Az egység, amit hozzáadunk a listához.
     */
    public void addEgysegek(Egyseg egyseg) {
        egysegek.add(egyseg);
    }

    public void varazsol(Varazslat varazslat, List<Egyseg> egysegek) throws NincsElegMannaException,
            VarazslatokCsakEgysegekreAlkalmazhatoakException {
        varazslat.vegrehajt(egysegek);
        akciotVegrehajtott = true;
    }

    public Varazslat getVarazslat(String nev) throws NincsAdottTipusuVarazslatException {
        return varazslatok.stream()
                .filter(varazslat -> nev.equals(varazslat.getNev()))
                .findFirst()
                .orElseThrow(NincsAdottTipusuVarazslatException::new);
    }

    public boolean halottE(){
        return egysegek
                .stream()
                .allMatch(Egyseg::halottE);
    }


    /**
     * Eldönti egy egységről, hogy az ellenséges egység-e vagy a sajátunk.
     * @param egyseg Az egység, amiről el kell dönteni, hogy melyik hőshöz tartozik.
     * @return true, ha az ellenfél hős egysége és false, ha a mi hősünk egysége
     */
    public boolean isEllenfelEgysegE(Egyseg egyseg){
        return this != egyseg.getHos();
    }

    public boolean isSajatEgysegE(Egyseg egyseg){
        return this == egyseg.getHos();
    }

    public abstract boolean isGep();

    public abstract void automatanVegrehajt();




    //GETTEREK ÉS SETTEREK ------------------------------------------------------------------------------

    public boolean isAkciotVegrehajtott() {
        return akciotVegrehajtott;
    }

    public void setAkciotVegrehajtott(boolean akciotVegrehajtott) {
        this.akciotVegrehajtott = akciotVegrehajtott;
    }

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
        return egysegek
                .stream()
                .filter(Egyseg :: eloE)
                .collect(Collectors.toList());
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

    public String getKeretSzin() {
        return keretSzin;
    }

    public void setKeretSzin(String keretSzin) {
        this.keretSzin = keretSzin;
    }
}
