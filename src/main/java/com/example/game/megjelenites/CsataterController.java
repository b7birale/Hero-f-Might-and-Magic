package com.example.game.megjelenites;

import com.example.game.exception.*;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.varazslatok.Varazslat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CsataterController {

    private final Palya palya;
    private List<Egyseg> osszesEgyseg;
    private int jelenlegiEgysegIndex;
    private Hos hos;
    private Hos ellenfel;
    private int kor;
    private boolean vesztettel, nyertel, dontetlen;

    public CsataterController(Hos hos, Hos ellenfel){
        palya = new Palya();
        osszesEgyseg = new ArrayList<>();
        osszesEgyseg.addAll(hos.getEgysegek());
        osszesEgyseg.addAll(ellenfel.getEgysegek());
        jelenlegiEgysegIndex = 0;
        this.hos = hos;
        this.ellenfel = ellenfel;
        Collections.sort(osszesEgyseg);
        this.kor = 1;
        this.vesztettel = false;
        this.nyertel = false;
        this.dontetlen = false;
    }

    public void mozgatEgyseg(Pozicio pozicio) throws NemTudMozogniException {
        palya.mozgatEgyseg(osszesEgyseg.get(jelenlegiEgysegIndex), pozicio);
        kovetkezoLepes();
    }

    public void tamad(Egyseg ellenfelEgyseg){
        osszesEgyseg.get(jelenlegiEgysegIndex).tamad(ellenfelEgyseg);
        kovetkezoLepes();
    }


    public void lehelyez(Egyseg egyseg) {
        palya.lehelyezEgyseg(egyseg);
    }

    public void varazsol(String nev, Pozicio pozicio) throws NincsAdottTipusuVarazslatException, NincsElegMannaException {
        //todo Host kell finomitani
        if(hos.isAkciotVegrehajtott()){
            throw new MarEgyAkciotVegrehajtottalAHosselEbbenAKorbenException();
        }
        if (!hos.isEllenfelEgysegE(palya.getMezo(pozicio).getEgyseg())) {
            throw new NemTamadhatodMegASajatEgysegedException();
        }
        Varazslat varazslat = hos.getVarazslat(nev);
        List<Egyseg> egysegek = palya.getEgysegekNxNesTeruleten(pozicio, varazslat.hatoKor());
        hos.varazsol(varazslat, egysegek);
    }

    public void varakozik(){
        kovetkezoLepes();
    }

    public int JelenlegiEgysegSor() {
        if (!osszesEgyseg.get(jelenlegiEgysegIndex).isGep()) {
            return osszesEgyseg.get(jelenlegiEgysegIndex).getPozicio().getSor();
        } else return 0;
    }

    public int jelenlegiEgysegOSzlop() {
        if (!osszesEgyseg.get(jelenlegiEgysegIndex).isGep()) {
            return osszesEgyseg.get(jelenlegiEgysegIndex).getPozicio().getOszlop();
        } else return 0;
    }

    public void tamadHos(Egyseg tamadottEgyseg) {
        hos.tamad(tamadottEgyseg);
        kovetkezoLepes();
    }

    public int korszamlalo() {
        if (jelenlegiEgysegIndex == 0) {
            kor++;
        }
        return kor;
    }

    private Egyseg jelenlegiEgyseg() {
        return osszesEgyseg.get(jelenlegiEgysegIndex);
    }


    private void kovetkezoLepes(){

        if (hos.halottE()) {
            vesztettel = true;
        } else if (ellenfel.halottE()) {
            nyertel = true;
        } else if (hos.halottE() && ellenfel.halottE()) {
            dontetlen = true;
        }
        novelEgysegIndex();
        while (jelenlegiEgyseg().isGep()) {
            Egyseg egyseg = jelenlegiEgyseg();
            if (egyseg.isGep()) {
                palya.getBarmelySzomszedosEllenfel(egyseg)
                        .ifPresentOrElse(egyseg::tamad, () -> gepMozog(egyseg));
            }
            novelEgysegIndex();
        }
    }

    private void gepMozog(Egyseg egyseg) {
        Pozicio kovPozicio = egyseg.randomKovetkezoPozicio(egyseg.getPozicio());
        while (!palya.palyanVanE(kovPozicio) || !palya.getMezo(kovPozicio).ures()) {
            kovPozicio = egyseg.randomKovetkezoPozicio(egyseg.getPozicio());
        }
        palya.mozgatEgyseg(egyseg, kovPozicio);
    }

    private void novelEgysegIndex() {
        jelenlegiEgysegIndex = (jelenlegiEgysegIndex + 1) % osszesEgyseg.size();
        if(jelenlegiEgysegIndex == 0){
            hos.setAkciotVegrehajtott(false);
            ellenfel.setAkciotVegrehajtott(false);
        }
    }



    /*
    public void lehelyez(Pozicio pozicio){
        palya.lehelyezEgyseg(new Foldmuves(new Hos(), 100),pozicio);
        palya.lehelyezEgyseg(new Ijasz(new Hos(), 100),pozicio);
        palya.lehelyezEgyseg(new Griff(new Hos(), 100),pozicio);
        palya.lehelyezEgyseg(new Zombi(new Hos(), 100),pozicio);
        palya.lehelyezEgyseg(new Sarkany(new Hos(), 100),pozicio);

    }

    public void ellenfelLehelyez(Pozicio pozicio){
        palya.lehelyezEgyseg(new Ijasz(new Hos(), 100),pozicio);
        palya.lehelyezEgyseg(new Zombi(new Hos(), 100),pozicio);
        palya.lehelyezEgyseg(new Sarkany(new Hos(), 100),pozicio);
    }

     */

    //GETTEREK ÉS SETTEREK

    public boolean isVesztettel() {
        return vesztettel;
    }

    public boolean isNyertel() {
        return nyertel;
    }

    public boolean isDontetlen() {
        return dontetlen;
    }

    public Palya getPalya() {
        return palya;
    }

    public Mezo getMezo(Pozicio pozicio){
        return palya.getMezo(pozicio);
    }

    public List<Egyseg> getOsszesEgyseg() {
        return osszesEgyseg;
    }

    public void setJelenlegiEgysegIndex(int jelenlegiEgysegIndex) {
        this.jelenlegiEgysegIndex = jelenlegiEgysegIndex;
    }

    public int getJelenlegiEgysegIndex() {
        return jelenlegiEgysegIndex;
    }

}