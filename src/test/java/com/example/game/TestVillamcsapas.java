package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Villamcsapas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVillamcsapas {

    @Test
    public void testAlkalmaz(){

        //griff eletero: 30*10 = 300
        //sebzes = 30*8 = 240
        //300-240 = 60

        Hos hos = new Hos();
        hos.setVarazsero(8);
        Villamcsapas villamcsapas = new Villamcsapas(hos);
        Griff griff = new Griff(10);
        //hos.egysegek.add(griff);
        villamcsapas.alkalmaz(List.of(griff));
        assertEquals(60, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //sarkany eletero: 100*15 = 1500
        hos.egysegek.clear();
        hos.setVarazsero(2);
        Sarkany sarkany = new Sarkany(100);
        hos.egysegek.add(sarkany);
        villamcsapas.alkalmaz(hos.egysegek);
        assertEquals(1500, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //sarkany eletero: 15*12 = 180
        //sebzes: 30*1 = 30
        //180-30 = 150
        hos.egysegek.clear();
        hos.setVarazsero(1);
        Sarkany aithusa = new Sarkany(12);
        hos.egysegek.add(aithusa);
        villamcsapas.alkalmaz(hos.egysegek);
        assertEquals(150, aithusa.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //demon eletero: 30*93 = 2790
        //sebzes: 10*30 = 300
        //2790-300 = 2490
        hos.egysegek.clear();
        hos.setVarazsero(10);
        Demon demon = new Demon(93);
        hos.egysegek.add(demon);
        villamcsapas.alkalmaz(hos.egysegek);
        assertEquals(2490, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
