package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Pegazus;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.MagicArrow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMagicArrow {

    @Test
    public void testAlkalmaz(){

        //griff eletero: 30*10 = 300
        //sebzes = 10+ 10*8 = 90
        //300-90 = 210

        Hos hos = new Hos();
        hos.setVarazsero(8);
        MagicArrow magicArrow = new MagicArrow(hos);
        Griff griff = new Griff(10);
        hos.egysegek.add(griff);
        magicArrow.alkalmaz(hos.egysegek);
        assertEquals(210, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //sarkany eletero: 100*15 = 1500
        //sebzes: 10*2 +10 = 30
        hos.egysegek.clear();
        hos.setVarazsero(2);
        Sarkany sarkany = new Sarkany(100);
        hos.egysegek.add(sarkany);
        magicArrow.alkalmaz(hos.egysegek);
        assertEquals(1470, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //sarkany eletero: 15*12 = 180
        //sebzes: 10*1 +10 = 20
        //180-20 = 160
        hos.egysegek.clear();
        hos.setVarazsero(1);
        Sarkany aithusa = new Sarkany(12);
        hos.egysegek.add(aithusa);
        magicArrow.alkalmaz(hos.egysegek);
        assertEquals(160, aithusa.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //demon eletero: 30*93 = 2790
        //sebzes: 10*10 +10 = 110
        //2790-110 = 2680
        hos.egysegek.clear();
        hos.setVarazsero(10);
        Demon demon = new Demon(93);
        hos.egysegek.add(demon);
        magicArrow.alkalmaz(hos.egysegek);
        assertEquals(2680, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //ijasz eletero: 7*93 = 651
        //pegazus: 30*49 = 1470
        hos.egysegek.clear();
        hos.setVarazsero(7);
        Ijasz ijasz = new Ijasz(93);
        hos.egysegek.add(ijasz);
        Pegazus pegazus = new Pegazus(49);
        hos.egysegek.add(pegazus);
        magicArrow.alkalmaz(hos.egysegek);
        assertEquals(651, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1470, pegazus.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
