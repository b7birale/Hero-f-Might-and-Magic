package com.example.game.hos;

import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.megjelenites.Palya;

import java.util.ArrayList;

public class EllenfelHos extends Hos{

    private Palya palya;

    public EllenfelHos(){

        egysegek = new ArrayList<>();
        varazslatok = new ArrayList<>();
        this.tamadas = 4;
        this.vedekezes = 5;
        this.tudas = 3;
        this.moral = 2;
        this.varazsero = 4;
        this.szerencse = 1;
        this.manna = 0;

        egysegek.add(new Griff(new Hos(), 100));
        egysegek.add(new Griff(new Hos(), 100));
        egysegek.add(new Griff(new Hos(), 100));
        egysegek.add(new Griff(new Hos(), 100));

    }
    public void leHelyez(Pozicio pozicio) {

    }
}