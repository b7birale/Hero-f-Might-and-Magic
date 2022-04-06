package com.example.game.megjelenites;


import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

public class Palya {

    public static final int SOROK_SZAMA = 10;
    public static final int OSZLOPOK_SZAMA = 12;

    private Mezo[][] mezok = new Mezo[SOROK_SZAMA][OSZLOPOK_SZAMA];

    private List<Egyseg> osszesEgyseg;

    public Palya() {
        for (int i = 0; i < SOROK_SZAMA; i++) {
            for (int j = 0; j < OSZLOPOK_SZAMA; j++) {
                mezok[i][j] = new Mezo(new Pozicio(i, j));
            }
        }

        //  osszesEgyseg = new ArrayList<>();
        //  osszesEgyseg.addAll(egysegek);
    }

    public void lehelyezEgyseg(final Egyseg egyseg, final Pozicio pozicio) {
        getMezo(pozicio).lehelyezEgyseg(egyseg);
    }

    public void lehelyezEllenfel(final Egyseg egyseg, final Pozicio pozicio) {
        getMezo(pozicio).lehelyezEgyseg(egyseg);
    }

    public void mozgatEgyseg(final Egyseg egyseg, final Pozicio pozicio) {
        getMezo(egyseg.getPozicio()).leveszEgyseg();
        getMezo(pozicio).lehelyezEgyseg(egyseg);
    }

    public List<Egyseg> getEgysegek3x3asTeruleten(final Pozicio pozicio) {
        return getPoziciokAdottPozicioKorul(pozicio)
                .stream()
                .filter(this::palyanVanE)
                .map(this::getMezo)
                .filter(not(Mezo::ures))
                .map(Mezo::getEgyseg)
                .collect(toList());
    }

    private List<Mezo> getSzomszedosCellak(final Pozicio pozicio) {
        return getPoziciokAdottPozicioKorul(pozicio)
                .stream()
                .filter(this::palyanVanE)
                .filter(not(pozicio::equals))
                .map(this::getMezo)
                .collect(toList());
    }

    /**
     * megadott pozicio is benne van
     */
    private List<Pozicio> getPoziciokAdottPozicioKorul(final Pozicio pozicio) {
        List<Pozicio> poziciok = new ArrayList<>();
        for (int i = pozicio.getSor()-1; i <= pozicio.getSor()+1; i++) {
            for (int j = pozicio.getOszlop()-1; j <= pozicio.getOszlop()+1; j++) {
                poziciok.add(new Pozicio(i, j));
            }
        }
        return poziciok;
    }

    public boolean palyanVanE(final Pozicio pozicio) {
        return pozicio.getSor() >= 0 && pozicio.getSor() < SOROK_SZAMA
                && pozicio.getOszlop() >= 0 && pozicio.getOszlop() < OSZLOPOK_SZAMA;
    }

    public Mezo getMezo(Pozicio pozicio) {
        return mezok[pozicio.getSor()][pozicio.getOszlop()];
    }

}