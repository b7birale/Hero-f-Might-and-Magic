package com.example.game.hos;

import com.example.game.exception.EzzelAVarazslattalNemRendelkezelException;
import com.example.game.exception.NincsElegMannadAVarazslathozException;
import com.example.game.exception.NemEgysegreProbalodVegrehajtaniAVarazslatotException;
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
    protected boolean cselekedettAKorben;
    protected String keretSzin;

    public List<Varazslat> varazslatok;
    public List<Egyseg> egysegek;


    public Hos(int tamadas, int tudas, int vedekezes, int moral, int szerencse, int varazsero, int manna, String keretSzin) {
        this.tamadas = tamadas;
        this.tudas = tudas;
        this.vedekezes = vedekezes;
        this.moral = moral;
        this.szerencse = szerencse;
        this.varazsero = varazsero;
        this.manna = manna;
        this.cselekedettAKorben = false;
        this.keretSzin = keretSzin;
        varazslatok = new ArrayList<>();
        egysegek = new ArrayList<>();
    }

    /**
     * Varázslat használata esetén levonja a varázslat mannaárát a hős meglévő mannájából.
     * @param manna A varázslat mannaköltsége.
     */
    public void levonManna(int manna){
        this.manna = this.manna - manna;
    }

    /**
     * Megtámadunk egy ellenséges egységet a hőssel.
     * Kiszámítjuk a sebzést. A sebzés mértéke függ a hős támadás tulajdonságától.
     * Csökkentjük a megtámadott egység életerejét annyival, amennyi a sebzés.
     * @param tamadandoEgyseg Az egység, amit megtámad a hősünk.
     */
    public void tamad(Egyseg tamadandoEgyseg){
        int sebzes = this.tamadas * 10;
        tamadandoEgyseg.sebez(sebzes);
        cselekedettAKorben = true;
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

    /**
     * Detektálja, hogy ebben a körben már cselekedtünk a hőssel és meghívja a Varazlsat osztály végrahajt
     *  metódusát, ami meghívja az adott varázslat alkalmaz metódusát, így végrahajtódik a varázslat.
     * @param varazslat A varázslat, amit végre akarunk hajtani.
     * @param egysegek Azon egység vagy egységek, amiken végre szeretnénk hajtani az adott varázslatot.
     * @throws NincsElegMannadAVarazslathozException ha nincs elég mannánk az adott varázslathoz
     * @throws NemEgysegreProbalodVegrehajtaniAVarazslatotException ha üres mezőre vagy pályán kívülre próbáljuk végrehajtani a varázslatot
     */
    public void hasznalVarazslat(Varazslat varazslat, List<Egyseg> egysegek) throws NincsElegMannadAVarazslathozException, NemEgysegreProbalodVegrehajtaniAVarazslatotException {
        varazslat.varazslatVegrehajt(egysegek);
        cselekedettAKorben = true;
    }

    public Varazslat getVarazslat(String nev) throws EzzelAVarazslattalNemRendelkezelException {
        return varazslatok.stream().filter(varazslat -> nev.equals(varazslat.getNev())).findFirst().orElseThrow(EzzelAVarazslattalNemRendelkezelException::new);
    }

    public boolean vajonHalott(){
        return egysegek.stream().allMatch(Egyseg::halott);
    }


    /**
     * Eldönti egy egységről, hogy az ellenséges egység-e vagy a sajátunk.
     * @param egyseg Az egység, amiről el kell dönteni, hogy melyik hőshöz tartozik.
     * @return true, ha az ellenfél hős egysége és false, ha a mi hősünk egysége
     */
    public boolean ezEllenfelEgyseg(Egyseg egyseg){
        boolean kimenet = false;
        if(this != egyseg.getHos()){
            kimenet = true;
        }
        else{
            kimenet = false;
        }
        return kimenet;
    }

    /**
     * Eldönti egy egységről, hogy az saját egység-e vagy az ellenfelé.
     * @param egyseg Az egység, amiről el kell dönteni, hogy melyik hőshöz tartozik.
     * @return true, ha a mi hősünk egysége és false, ha az ellenfél hős egysége
     */
    public boolean ezSajatEgyseg(Egyseg egyseg){
        boolean kimenet;
        if(this == egyseg.getHos()){
            kimenet = true;
        }
        else{
            kimenet = false;
        }
        return kimenet;
    }


    public abstract boolean gepIranyitja();





    //GETTEREK ÉS SETTEREK ------------------------------------------------------------------------------

    public boolean isCselekedettAKorben() {
        return cselekedettAKorben;
    }

    public void setCselekedettAKorben(boolean cselekedettAKorben) {
        this.cselekedettAKorben = cselekedettAKorben;
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
        return egysegek.stream().filter(Egyseg ::elMeg).collect(Collectors.toList());
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
