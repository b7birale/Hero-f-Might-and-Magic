package com.example.game.megjelenites;

import com.example.game.exception.*;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.varazslatok.Varazslat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    private boolean lose, win, draw;

    public CsataterController(Hos hos, Hos ellenfel){
        palya = new Palya();

        osszesEgyseg = new ArrayList<>();
        osszesEgyseg.addAll(hos.getEgysegek());
        osszesEgyseg.addAll(ellenfel.getEgysegek());
        Collections.sort(osszesEgyseg);
        osszesEgyseg.forEach(this::lerakEgyseg);

        this.hos = hos;
        this.ellenfel = ellenfel;
        this.kor = 0;
        this.lose = false;
        this.win = false;
        this.draw = false;

        //Minusz egyrol indulunk, mert az jelenlegi egyseg indexet egybol noveljuk az elejen
        jelenlegiEgysegIndex = -1;

        nextStep();
    }

    public void mozogEgyseg(Pozicio pozicio) throws OdaNemLephetszException {
        palya.lepEgyseg(jelenlegiEgyseg(), pozicio);
        nextStep();
    }


    public void tamad(Egyseg tamadandoEgyseg){
        if (!jelenlegiEgyseg().hatosugaronBelulVanE(tamadandoEgyseg)) {
            throw new OlyanEgysegetProbalszTamadniAmiNincsAKozvetlenKozeledbenException();
        }
        if (palya.vanEllensegesEgysegAKozvetlenKornyezeteben(jelenlegiEgyseg())
                && jelenlegiEgyseg().tavolsagiTamadasE(tamadandoEgyseg)) { //Itt kell megnézni, hogy csak ha íjász
            throw new TavolsagiTamadastProbalszInditaniPedigVanEllensegesEgysegAKozeledbenException();
        }
        jelenlegiEgyseg().tamad(tamadandoEgyseg);
        nextStep();
    }


    public void lerakEgyseg(Egyseg egyseg) {
        palya.lerakEgyseg(egyseg);
    }

    public void hasznalVarazslat(String nev, Pozicio pozicio) throws EzzelAVarazslattalNemRendelkezelException, NincsElegMannadAVarazslathozException {
        if(hos.isCselekedettAKorben()){
            throw new KoronkentCsakEgyszerCselekedhetszAHosselException();
        }
        Varazslat varazslat = hos.getVarazslat(nev);
        List<Egyseg> egysegek = palya.getEgysegekNxNesTeruleten(pozicio, varazslat.hatosugar());
        hos.hasznalVarazslat(varazslat, egysegek);
    }

    public void passzol(){
        nextStep();
    }

    public void tamadHossel(Egyseg tamadandoEgyseg) {
        if (hos.isCselekedettAKorben()) {
            throw new KoronkentCsakEgyszerCselekedhetszAHosselException();
        }
        hos.tamad(tamadandoEgyseg);
    }

    public void hanyadikKor() {
        if (jelenlegiEgysegIndex == 0) {
            kor++;
        }
    }

    Egyseg jelenlegiEgyseg() {
        return getOsszesEgyseg().get(jelenlegiEgysegIndex);
    }

    public void leveszHalottEgysegeket(){
        for (int sor = 0; sor < SOROK_SZAMA; sor++) {
            for (int oszlop = 0; oszlop < OSZLOPOK_SZAMA; oszlop++) {
                Cella cella = palya.getCella(new Pozicio(sor,oszlop));
                if(!cella.ures() && cella.getEgyseg().halott()){
                    cella.leveszEgyseg();
                }
            }
        }
    }


    private void nextStep(){
        if (hos.vajonHalott()) {
            lose = true;
            return;
        } else if (ellenfel.vajonHalott()) {
            win = true;
            return;
        } else if (hos.vajonHalott() && ellenfel.vajonHalott()) {
            draw = true;
            return;
        }
        novelEgysegIndex();
        while (jelenlegiEgyseg().gepIranyitja()) {
            Egyseg egyseg = jelenlegiEgyseg();
            if (egyseg.gepIranyitja()) {
                palya.getBarmelySzomszedosEllenfel(egyseg).ifPresentOrElse(egyseg::tamad, () -> gepiEllenfelEgysegMozog(egyseg));
            }
            if (hos.vajonHalott()) {
                lose = true;
                return;
            } else if (ellenfel.vajonHalott()) {
                win = true;
                return;
            } else if (hos.vajonHalott() && ellenfel.vajonHalott()) {
                draw = true;
                return;
            }
            hanyadikKor();
            novelEgysegIndex();
        }
        hanyadikKor();
    }

    private void gepiEllenfelEgysegMozog(Egyseg egyseg) {
        Pozicio randomPozicio = egyseg.generalRandomPoziciot(egyseg.getPozicio());
        while (!palya.letezikIlyenPozicio(randomPozicio) || !palya.getCella(randomPozicio).ures()) {
            randomPozicio = egyseg.generalRandomPoziciot(egyseg.getPozicio());
        }
        palya.lepEgyseg(egyseg, randomPozicio);
    }

    private void novelEgysegIndex() {

        if(jelenlegiEgysegIndex + 1 < getOsszesEgyseg().size()){
            jelenlegiEgysegIndex++;
        }
        else{
            jelenlegiEgysegIndex = 0;
        }

        if(jelenlegiEgysegIndex == 0){
            hos.setCselekedettAKorben(false);
            ellenfel.setCselekedettAKorben(false);
        }

    }


    //GETTEREK ÉS SETTEREK

    public boolean isLose() {
        return lose;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isDraw() {
        return draw;
    }

    public Palya getPalya() {
        return palya;
    }

    public Cella getMezo(Pozicio pozicio){
        return palya.getCella(pozicio);
    }

    public List<Egyseg> getOsszesEgyseg() {
        return osszesEgyseg
                .stream()
                .filter(Egyseg ::elMeg)
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