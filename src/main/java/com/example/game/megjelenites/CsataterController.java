package com.example.game.megjelenites;

import com.example.game.hos.EllenfelHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;


public class CsataterController {
    private Palya palya;
    private EllenfelHos ellenfelHos;
    private Pozicio pozicio;

    public CsataterController(){
        palya = new Palya();
    }

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

    public Palya getPalya() {
        return palya;
    }

}