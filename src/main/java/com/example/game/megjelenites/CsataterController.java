package com.example.game.megjelenites;

import com.example.game.exception.NemTamadhatodMegASajatEgysegedException;
import com.example.game.exception.NemTudMozogniException;
import com.example.game.exception.NincsAdottTipusuVarazslatException;
import com.example.game.exception.NincsElegMannaException;
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

    public CsataterController(Hos hos, Hos ellenfel){
        palya = new Palya();
        osszesEgyseg = new ArrayList<>();
        osszesEgyseg.addAll(hos.getEgysegek());
        osszesEgyseg.addAll(ellenfel.getEgysegek());
        jelenlegiEgysegIndex = 0;
        this.hos = hos;
        this.ellenfel = ellenfel;
        Collections.sort(osszesEgyseg);
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
        if (!hos.isEllenfelEgysegE(palya.getMezo(pozicio).getEgyseg())) {
            throw new NemTamadhatodMegASajatEgysegedException();
        }
        Varazslat varazslat = hos.getVarazslat(nev);
        List<Egyseg> egysegek = palya.getEgysegekNxNesTeruleten(pozicio, varazslat.hatoKor());
        hos.varazsol(varazslat, egysegek);
        kovetkezoLepes();
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

    private void kovetkezoLepes(){
        if(hos.halottE() || ellenfel.halottE()){
            System.out.println("Nyert");
        }
        jelenlegiEgysegIndex = (jelenlegiEgysegIndex + 1) %osszesEgyseg.size();
        while(osszesEgyseg.get(jelenlegiEgysegIndex).isGep()){
            Egyseg egyseg = osszesEgyseg.get(jelenlegiEgysegIndex);
            if(egyseg.isGep()){
                Pozicio pozicio = egyseg.getPozicio();
                //try {
                //      palya.mozgatEgyseg(egyseg,new Pozicio(pozicio.getSor(),pozicio.getOszlop() - 1));
                //} catch (NemTudMozogniException e) {
                //    e.printStackTrace();
                //}
            }
            jelenlegiEgysegIndex = (jelenlegiEgysegIndex + 1) %osszesEgyseg.size();
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