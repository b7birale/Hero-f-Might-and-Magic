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
import com.example.game.hos.varazslatok.Feltamasztas;
import com.example.game.hos.varazslatok.Tuzlabda;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFeltamasztas {

    @Test
    public void testAlkalmaz(){

        //griff eletero: 30*10 = 300
        //sarkany eletero: 100*15 = 1500

        Hos hos = new Hos();
        hos.setVarazsero(8);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Griff griff = new Griff(10);
        Sarkany sarkany = new Sarkany(100);
        griff.setJelenlegiEletero(120);
        sarkany.setJelenlegiEletero(1100);
        hos.egysegek.add(griff);
        hos.egysegek.add(sarkany);
        feltamasztas.alkalmaz(hos.egysegek);
        assertEquals(120, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1100, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //demon eletero: 30*93 = 2790
        //felt.: 2*50 = 100
        hos.egysegek.clear();
        hos.setVarazsero(2);
        Demon demon = new Demon(93);
        demon.setJelenlegiEletero(2600);
        hos.egysegek.add(demon);
        feltamasztas.alkalmaz(hos.egysegek);
        assertEquals(2700, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        hos.egysegek.clear();




        /*

        //ijasz eletero: 7*7 = 49
        hos.egysegek.clear();
        Ijasz ijasz = new Ijasz(7);
        ijasz.setJelenlegiEletero(24);
        hos.egysegek.add(ijasz);
        feltamasztas.alkalmaz(hos.egysegek);
        assertEquals(49, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        hos.egysegek.clear();


        //grof eletero: 5*40 = 200
        hos.setVarazsero(1);
        Grof grof = new Grof(40);
        grof.setJelenlegiEletero(20);
        hos.egysegek.add(grof);
        feltamasztas.alkalmaz(hos.egysegek);
        assertEquals(70, grof.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        hos.egysegek.clear();



        //foldmuves eletero: 3*112 = 336
        //felt.: 3*50 = 150
        hos.setVarazsero(3);
        Foldmuves foldmuves = new Foldmuves(112);
        foldmuves.setJelenlegiEletero(150);
        hos.egysegek.add(foldmuves);
        feltamasztas.alkalmaz(hos.egysegek);
        assertEquals(300, foldmuves.getJelenlegiEletero(), "sajnos itt hiba van :( ");

        //lovag eletero: 8*221 = 1768
        //felt.: 7*50 = 350
        hos.setVarazsero(7);
        Lovag lovag = new Lovag(221);
        lovag.setJelenlegiEletero(1500);
        hos.egysegek.add(lovag);
        feltamasztas.alkalmaz(hos.egysegek);
        assertEquals(1768, lovag.getJelenlegiEletero(), "sajnos itt hiba van :( ");

         */


    }


    //fonix eletero: 40*33 = 1320
    //felt.: 1*50 = 50

    @Test
    public void testAlkalmaz2(){
        Hos hos = new Hos();
        hos.setVarazsero(1);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Fonix fonix = new Fonix(33);
        fonix.setJelenlegiEletero(1300);
        feltamasztas.alkalmaz(List.of(fonix));
        assertEquals(1320, fonix.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
