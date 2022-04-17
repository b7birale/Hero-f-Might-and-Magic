package com.example.game.megjelenites;

import com.example.game.exception.*;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.varazslatok.Varazslat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.example.game.megjelenites.Palya.OSZLOPOK_SZAMA;
import static com.example.game.megjelenites.Palya.SOROK_SZAMA;

/**
 * A Csatater kontroller osztálya. A csatatér megjelenítésében segít elsősorban.
 */
public class CsataterController {

    private final Palya palya;
    private final List<Egyseg> osszesEgyseg;
    private int jelenlegiEgysegIndex;
    private final Hos hos;
    private final Hos ellenfel;
    private int kor;
    private boolean vesztettel, nyertel, dontetlen;

    public CsataterController(Hos hos, Hos ellenfel){
        palya = new Palya();

        osszesEgyseg = new ArrayList<>();
        osszesEgyseg.addAll(hos.getEgysegek());
        osszesEgyseg.addAll(ellenfel.getEgysegek());
        Collections.sort(osszesEgyseg);
        osszesEgyseg.forEach(this::lehelyez);

        this.hos = hos;
        this.ellenfel = ellenfel;
        this.kor = 0;
        this.vesztettel = false;
        this.nyertel = false;
        this.dontetlen = false;

        //Minusz egyrol indulunk, mert az jelenlegi egyseg indexet egybol noveljuk az elejen
        jelenlegiEgysegIndex = -1;

        kovetkezoLepes();
    }

    public void mozgatEgyseg(Pozicio pozicio) throws NemTudMozogniException {
        palya.mozgatEgyseg(jelenlegiEgyseg(), pozicio);
        kovetkezoLepes();
    }


    public boolean vajonKritikusSebzes(int szerencse){
        Random random = new Random();
        int chance = 0;
        chance += szerencse*5;
        chance = 100/chance;
        return random.nextInt(chance) == 0;
    }

    public void tamad(Egyseg ellenfelEgyseg){
        if (!jelenlegiEgyseg().isHatokoronBelul(ellenfelEgyseg)) {
            throw new HatokoronKivuliTamadasException();
        }
        if (palya.vanEllensegesSzomszed(jelenlegiEgyseg())
                && jelenlegiEgyseg().isTavTamadas(ellenfelEgyseg)) { //Itt kell megnézni, hogy csak ha íjász
            throw new TavolsagiTamadasEllenseggelAKozelbenTamadasException();
        }
        jelenlegiEgyseg().tamad(ellenfelEgyseg);
        kovetkezoLepes();
    }


    public void lehelyez(Egyseg egyseg) {
        palya.lehelyezEgyseg(egyseg);
    }

    public void varazsol(String nev, Pozicio pozicio) throws NincsAdottTipusuVarazslatException, NincsElegMannaException {
        if(hos.isAkciotVegrehajtott()){
            throw new MarEgyAkciotVegrehajtottalAHosselEbbenAKorbenException();
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
        if (hos.isAkciotVegrehajtott()) {
            throw new MarEgyAkciotVegrehajtottalAHosselEbbenAKorbenException();
        }
        hos.tamad(tamadottEgyseg);
    }

    public void korszamlalo() {
        if (jelenlegiEgysegIndex == 0) {
            kor++;
            /*
            for(int i=0; i< osszesEgyseg.size(); i++){
                osszesEgyseg.get(i).setVisszaTamadtEMarAKorben(false);
            }

             */
        }
    }

    Egyseg jelenlegiEgyseg() {
        return osszesEgyseg.get(jelenlegiEgysegIndex);
    }

    public void leveszHalottakatPalyarol(){
        for (int sor = 0; sor < SOROK_SZAMA; sor++) {
            for (int oszlop = 0; oszlop < OSZLOPOK_SZAMA; oszlop++) {
                Mezo mezo = palya.getMezo(new Pozicio(sor,oszlop));
                if(!mezo.ures() && mezo.getEgyseg().halottE()){
                    mezo.leveszEgyseg();
                }
            }
        }
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
            korszamlalo();
            novelEgysegIndex();
        }
        korszamlalo();
    }

    private void gepMozog(Egyseg egyseg) {
        Pozicio kovPozicio = egyseg.randomKovetkezoPozicio(egyseg.getPozicio());
        while (!palya.palyanVanE(kovPozicio) || !palya.getMezo(kovPozicio).ures()) {
            kovPozicio = egyseg.randomKovetkezoPozicio(egyseg.getPozicio());
        }
        palya.mozgatEgyseg(egyseg, kovPozicio);
    }

    private void novelEgysegIndex() {
        //jelenlegiEgysegIndex = (jelenlegiEgysegIndex + 1) % osszesEgyseg.size();

        if(jelenlegiEgysegIndex + 1 < osszesEgyseg.size()){
            jelenlegiEgysegIndex++;
        }
        else{
            jelenlegiEgysegIndex = 0;
        }

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
        return osszesEgyseg
                .stream()
                .filter(Egyseg :: eloE)
                .collect(Collectors.toList());
    }

    public void setJelenlegiEgysegIndex(int jelenlegiEgysegIndex) {
        this.jelenlegiEgysegIndex = jelenlegiEgysegIndex;
    }

    public int getJelenlegiEgysegIndex() {
        return jelenlegiEgysegIndex;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }


}