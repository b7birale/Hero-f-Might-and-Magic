package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.egysegek.emberek.Grof;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.emberek.Lovag;
import com.example.game.hos.egysegek.repulol_lenyek.Fonix;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Tuzlabda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTuzlabda {

    @Test
    public void testAlkalmaz(){

        //griff eletero: 30*10 = 300
        //sebzes = 20*8 = 160
        //300-160 = 140
        //sarkany eletero: 100*15 = 1500
        //1500-160 = 1340

        Hos hos = new Hos();
        hos.setVarazsero(8);
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Griff griff = new Griff(10);
        hos.egysegek.add(griff);
        Sarkany sarkany = new Sarkany(100);
        hos.egysegek.add(sarkany);
        tuzlabda.alkalmaz(hos.egysegek);
        assertEquals(140, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1340, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //demon eletero: 30*93 = 2790
        hos.egysegek.clear();
        hos.setVarazsero(2);
        Demon demon = new Demon(93);
        tuzlabda.alkalmaz(hos.egysegek);
        assertEquals(2790, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //sarkany eletero: 15*12 = 180
        //sebzes: 20*1 = 20
        //180-30 = 160
        //15*1 = 15
        //15-20 = -5
        //fonix eletero: 40*33 = 1320
        //1320-20 = 1300
        hos.egysegek.clear();
        hos.setVarazsero(1);
        Sarkany aithusa = new Sarkany(12);
        hos.egysegek.add(aithusa);
        Sarkany kilgara = new Sarkany(1);
        hos.egysegek.add(kilgara);
        Fonix fonix = new Fonix(33);
        hos.egysegek.add(fonix);
        tuzlabda.alkalmaz(hos.egysegek);
        assertEquals(160, aithusa.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(-5, kilgara.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1300, fonix.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //ijasz eletero: 7*7 = 49
        //grof eletero: 5*40 = 200
        //lovag eletero: 8*221 = 1768
        //foldmuves eletero: 3*112 = 336
        //sebzes: 5*20 = 100
        //-51, 100, 1668, 236
        hos.egysegek.clear();
        Ijasz ijasz = new Ijasz(7);
        hos.egysegek.add(ijasz);
        Grof grof = new Grof(40);
        hos.egysegek.add(grof);
        Lovag lovag = new Lovag(221);
        hos.egysegek.add(lovag);
        Foldmuves foldmuves = new Foldmuves(112);
        hos.egysegek.add(foldmuves);
        hos.setVarazsero(5);
        tuzlabda.alkalmaz(hos.egysegek);
        assertEquals(-51, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(100, grof.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1668, lovag.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(236, foldmuves.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
