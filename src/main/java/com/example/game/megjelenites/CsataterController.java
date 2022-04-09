package com.example.game.megjelenites;

import com.example.game.hos.EllenfelHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;

import java.util.ArrayList;
import java.util.List;


public class CsataterController {
    private final Palya palya;
    //private EllenfelHos ellenfelHos;
    //private Pozicio pozicio;
    private List<Egyseg> osszesEgyseg;
    private int jelenlegiEgysegIndex;

    public CsataterController(Hos hos){
        palya = new Palya();
        osszesEgyseg = new ArrayList<>();
        osszesEgyseg.addAll(hos.getEgysegek());
        jelenlegiEgysegIndex = 0;
    }

    public void mozgatEgyseg(Pozicio pozicio){
        palya.mozgatEgyseg(osszesEgyseg.get(jelenlegiEgysegIndex), pozicio);
    }

    public void tamad(Egyseg ellenfelEgyseg){
        osszesEgyseg.get(jelenlegiEgysegIndex).tamad(ellenfelEgyseg);
    }

    public void lehelyez(Egyseg egyseg) {
        palya.lehelyezEgyseg(egyseg);
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

    public Palya getPalya() {
        return palya;
    }

    public Mezo getMezo(Pozicio pozicio){
        return palya.getMezo(pozicio);
    }

}