package com.example.game.megjelenites;


import com.example.game.exception.OdaNemLephetszException;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

/**
 * A csatatérnek maga a pálya részét (12x10-es négyzetrács) valósítja meg.
 */
public class Palya {

    public static final int SOROK_SZAMA = 10;
    public static final int OSZLOPOK_SZAMA = 12;

    private Cella[][] cellak = new Cella[SOROK_SZAMA][OSZLOPOK_SZAMA];


    public Palya() {
        for (int i = 0; i < SOROK_SZAMA; i++) {
            for (int j = 0; j < OSZLOPOK_SZAMA; j++) {
                cellak[i][j] = new Cella(new Pozicio(i, j));
            }
        }

    }

    public void lerakEgyseg(final Egyseg egyseg) {
        getCella(egyseg.getPozicio()).lerakEgyseg(egyseg);
    }


    private boolean vajonLephetE(Egyseg egyseg, Pozicio cel){
        return Math.abs(egyseg.getPozicio().getSor() - cel.getSor()) <= egyseg.getSebesseg()
                && Math.abs(egyseg.getPozicio().getOszlop() - cel.getOszlop()) <= egyseg.getSebesseg();
    }

    public void lepEgyseg(final Egyseg egyseg, final Pozicio pozicio) throws OdaNemLephetszException {
        if(!vajonLephetE(egyseg, pozicio)) {
            throw new OdaNemLephetszException();
        }
        getCella(egyseg.getPozicio()).leveszEgyseg();
        getCella(pozicio).lerakEgyseg(egyseg);
    }

    public List<Egyseg> getEgysegekNxNesTeruleten(final Pozicio pozicio, int n) {
        return getPoziciokAdottPozicioKorul(pozicio, n).stream().filter(this::letezikIlyenPozicio).map(this::getCella).filter(not(Cella::ures)).map(Cella::getEgyseg).collect(toList());
    }

    public List<Egyseg> getSzomszedosEgysegek(Pozicio pozicio) {
        return getPoziciokAdottPozicioKorul(pozicio, 1).stream().filter(this::letezikIlyenPozicio).filter(not(pozicio::equals)).map(this::getCella).filter(not(Cella::ures)).map(Cella::getEgyseg).collect(toList());
    }


    public Optional<Egyseg> getBarmelySzomszedosEllenfel(Egyseg egyseg){
        return getSzomszedosEgysegek(egyseg.getPozicio()).stream().filter(egyseg::ezEllenfelEgyseg).findFirst();
    }

    public boolean vanEllensegesEgysegAKozvetlenKornyezeteben(Egyseg egyseg) {
        return getBarmelySzomszedosEllenfel(egyseg).isPresent();
    }


    private List<Pozicio> getPoziciokAdottPozicioKorul(final Pozicio pozicio, int n) {
        List<Pozicio> poziciok = new ArrayList<>();
        for (int i = pozicio.getSor()-n; i <= pozicio.getSor()+n; i++) {
            for (int j = pozicio.getOszlop()-n; j <= pozicio.getOszlop()+n; j++) {
                poziciok.add(new Pozicio(i, j));
            }
        }
        return poziciok;
    }

    public boolean letezikIlyenPozicio(final Pozicio pozicio) {
        return pozicio.getSor() >= 0 && pozicio.getSor() < SOROK_SZAMA && pozicio.getOszlop() >= 0 && pozicio.getOszlop() < OSZLOPOK_SZAMA;
    }

    public Cella getCella(Pozicio pozicio) {
        return cellak[pozicio.getSor()][pozicio.getOszlop()];
    }

}