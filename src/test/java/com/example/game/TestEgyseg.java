package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Vampir;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Grof;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.emberek.Lovag;
import com.example.game.hos.egysegek.emberek.Polgar;
import com.example.game.hos.egysegek.repulol_lenyek.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Math.ceil;
import static org.junit.jupiter.api.Assertions.*;


public class TestEgyseg {

    //************** HányDb() metódus tesztelése **************

    @Test
    public void testHanyDbMaradekkalOsszes(){
        //griff eletero/db: 30
        //griff osszeletero: 3*30 = 90
        //66%30= 6
        //66/30=2
        Griff griff = new Griff(3);
        griff.setJelenlegiEletero(66);
        assertEquals(3, griff.hanyDb(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testHanyDbMaradekNelkulOsszes(){
        //ijasz eletero/db: 7
        //ijasz osszeletero: 10*7 = 70
        //70%7 = 0
        //70/7 = 10
        Ijasz ijasz = new Ijasz(10);
        assertEquals(10, ijasz.hanyDb(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testHanyDbMaradekkal(){
        //zombi eletero/db: 9
        //zombi osszeletero: 9*27 = 243
        //4%9 = 4
        //4/9 = 0
        Zombi zombi = new Zombi(27);
        zombi.setJelenlegiEletero(4);
        assertEquals(1, zombi.hanyDb(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testHanyDbMaradekNelkul(){
        //fonix eletero/db: 40
        //zombi osszeletero: 40*6 = 240
        //200%40 = 0
        //200/40 = 5
        Fonix fonix = new Fonix(6);
        fonix.setJelenlegiEletero(200);
        assertEquals(5, fonix.hanyDb(), "sajnos itt hiba van :( ");
    }


    //************** szamolSebzes() metódus tesztelése **************

    public int szamolSebzesTeszthez(int tamadas, Hos ellenfel, int randomSzam, int hanyDb){
        double alapsebzes = randomSzam * hanyDb;
        double sebzes = alapsebzes + alapsebzes*((double)tamadas/10);
        sebzes = sebzes * ((double)ellenfel.vedekezes/10);
        return (int) ceil(sebzes);
    }
    //a mock-hoz külső könyvtár kell!!!


    @Test
    public void testSzamolSebzes1(){
        //alapsebzes: 7*10 = 70
        //5.0/10 = 0.5
        //70*0.5 = 35
        //70+35 = 105
        //4.0/10 = 0.4
        //105*0.4 = 42 = sebzes

        Hos ellenfel = new Hos();
        Hos en = new Hos();
        en.setTamadas(5);
        Griff griff = new Griff(10);
        en.egysegek.add(griff);
        ellenfel.setVedekezes(4);
        Sarkany sarkany = new Sarkany(8);
        ellenfel.egysegek.add(sarkany);
        assertEquals(42, szamolSebzesTeszthez(en.getTamadas(), ellenfel, 7, 10), "sajnos itt hiba van :( ");

    }

    @Test
    public void testSzamolSebzesRepuloLennyel(){
        //alapsebzes: 2*34 = 68
        //68*1.7 = 115,6
        //115,6*1
        //116

        Hos ellenfel = new Hos();
        Hos en = new Hos();
        en.setTamadas(7);
        Pegazus pegazus = new Pegazus(34);
        en.egysegek.add(pegazus);
        ellenfel.setVedekezes(10);
        Pteranodon pteranodon = new Pteranodon(9);
        ellenfel.egysegek.add(pteranodon);
        assertEquals(116, szamolSebzesTeszthez(en.getTamadas(), ellenfel, 2, 34), "sajnos itt hiba van :( ");
    }

    @Test
    public void testSzamolSebzesEmberrel(){
        //alapsebzes: 3*100 = 300
        //300*0.2 = 60
        //60+300 = 360
        //360*0.2 = 72 = sebzes

        Hos ellenfel = new Hos();
        Hos en = new Hos();
        en.setTamadas(2);
        Grof grof = new Grof(100);
        en.egysegek.add(grof);
        ellenfel.setVedekezes(2);
        Lovag lovag = new Lovag(28);
        ellenfel.egysegek.add(lovag);
        assertEquals(72, szamolSebzesTeszthez(en.getTamadas(), ellenfel, 3, 100), "sajnos itt hiba van :( ");

    }


    //************** sebez() metódus tesztelése **************

    @Test
    public void testSebezPegazust(){
        //pegazus eletero: 30*44 = 1320
        Pegazus pegazus = new Pegazus(44);
        pegazus.sebez(20);
        assertEquals(1300, pegazus.jelenlegiEletero, "sajnos itt hiba van :( ");
    }

    @Test
    public void testSebezVampirt(){
        //vampir eletero: 9*50 = 450
        Vampir vampir = new Vampir(50);
        vampir.setJelenlegiEletero(400);
        vampir.sebez(100);
        assertEquals(300, vampir.jelenlegiEletero, "sajnos itt hiba van :( ");
    }


    //************** tamad() metódus tesztelése **************
    //ehhez már kéne az a mock
    /*
    @Test
    public void testTamadZombivalSarkanyt(){
        Hos en = new Hos();
        en.setTamadas(6);
        Hos ellenfel = new Hos();
        Zombi zombi = new Zombi(22);
        en.egysegek.add(zombi);
        Sarkany sarkany = new Sarkany(4);
        ellenfel.egysegek.add(sarkany);
        zombi.tamad(en.getTamadas(), ellenfel, sarkany);
    }

     */



    //************** visszaTamad() metódus tesztelése **************

    public void visszaTamadTeszthez(int tamadas, Hos ellenfel, Egyseg tamadottEgyseg, int randomSzam, int hanyDb){
        double alapsebzes = randomSzam * hanyDb;
        double sebzes = alapsebzes + alapsebzes*((double)tamadas/10);
        sebzes = sebzes * ((double)ellenfel.vedekezes/10);
        int vegeredmeny = (int) ceil(sebzes/2);
        tamadottEgyseg.sebez(vegeredmeny);
    }

    @Test
    public void testVisszaTamad(){
        //alapsebzes: 8*19 = 152
        //1.3*152 = 197,6
        //197,6*0.2 = 39,52
        //19,76 -> 20
        //demon eletero: 30*32 = 960
        Hos superman = new Hos();
        Hos batman = new Hos();
        Demon demon = new Demon(32);
        superman.egysegek.add(demon);
        Polgar polgar = new Polgar(19);
        batman.egysegek.add(polgar);
        batman.setTamadas(3);
        batman.setVedekezes(7);
        superman.setTamadas(8);
        superman.setVedekezes(2);
        //batman tamad vissza supermanre
        visszaTamadTeszthez(batman.getTamadas(), superman, demon, 8, 19);
        assertEquals(940, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }


    //************** kritikusSebzes() metódus tesztelése **************

    public void kritikusSebzesTeszthez(int tamadas, Hos ellenfel, Egyseg tamadottEgyseg, int randomSzam, int hanyDb){
        double alapsebzes = randomSzam * hanyDb;
        double sebzes = alapsebzes + alapsebzes*((double)tamadas/10);
        sebzes = sebzes * ((double)ellenfel.vedekezes/10);
        int vegeredmeny = (int) ceil(sebzes*2);
        tamadottEgyseg.sebez(vegeredmeny);
    }

    @Test
    public void testKritikusSebzes(){
        //polgar eletero: 6*19 = 114
        //alapsebzes: 96
        //96+96*1 = 192
        //192*0.5 = 96
        //sebzes = 192
        //114 - 192 = -78
        Hos superman = new Hos();
        Demon demon = new Demon(32);
        superman.egysegek.add(demon);
        superman.setTamadas(10);
        superman.setVedekezes(7);

        Hos batman = new Hos();
        Polgar polgar = new Polgar(19);
        batman.egysegek.add(polgar);
        batman.setTamadas(6);
        batman.setVedekezes(5);
        //superman tamadja meg batmant
        kritikusSebzesTeszthez(superman.getTamadas(), batman, polgar, 3, 32);
        assertEquals(-78, polgar.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    //************** vajonKritikusSebzes() metódus tesztelése **************

    //??? nem tudom


    //************** kozelharciTamadas() metódus tesztelése **************

    @Test
    public void testKozelharciTamadasIgaz(){
        Ijasz ijasz = new Ijasz(83);
        Fonix fonix = new Fonix(57);
        Pozicio ijaszPozicio = new Pozicio(5,9);
        Pozicio fonixPozicio = new Pozicio(5,8);
        ijasz.setPozicio(ijaszPozicio);
        fonix.setPozicio(fonixPozicio);
        assertTrue(ijasz.kozelharciTamadas(fonix), "sajnos itt hiba van :( ");
    }

    @Test
    public void testKozelharciTamadasHamis(){
        Ijasz ijasz = new Ijasz(83);
        Fonix fonix = new Fonix(57);
        Pozicio ijaszPozicio = new Pozicio(5,9);
        Pozicio fonixPozicio = new Pozicio(2,9);
        ijasz.setPozicio(ijaszPozicio);
        fonix.setPozicio(fonixPozicio);
        assertFalse(ijasz.kozelharciTamadas(fonix), "sajnos itt hiba van :( ");
    }

}
