package com.example.game;

import com.example.game.hos.FelhasznaloHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Szellem;
import com.example.game.hos.egysegek.eloholtak.Vampir;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.repulol_lenyek.Fonix;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Pegazus;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestEgyseg {

    //************** HányDb() metódus tesztelése **************

    @Test
    public void testHanyDbMaradekkalOsszes(){
        //griff eletero/db: 30
        //griff osszeletero: 3*30 = 90
        //66%30= 6
        //66/30=2
        Hos hos = new FelhasznaloHos();
        Pozicio griffPozicio = new Pozicio(2, 2);
        Griff griff = new Griff(hos, 3, griffPozicio);
        griff.setJelenlegiEletero(66);
        assertEquals(3, griff.hanyDb(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testHanyDbMaradekNelkulOsszes(){
        //ijasz eletero/db: 7
        //ijasz osszeletero: 10*7 = 70
        //70%7 = 0
        //70/7 = 10
        Hos hos = new FelhasznaloHos();
        Pozicio ijaszPozicio = new Pozicio(2, 2);
        Ijasz ijasz = new Ijasz(hos, 10, ijaszPozicio);
        assertEquals(10, ijasz.hanyDb(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testHanyDbMaradekkal(){
        //zombi eletero/db: 9
        //zombi osszeletero: 9*27 = 243
        //4%9 = 4
        //4/9 = 0
        Hos hos = new FelhasznaloHos();
        Pozicio zombiPozicio = new Pozicio(2, 2);
        Zombi zombi = new Zombi(hos, 27, zombiPozicio);
        zombi.setJelenlegiEletero(4);
        assertEquals(1, zombi.hanyDb(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testHanyDbMaradekNelkul(){
        //fonix eletero/db: 40
        //zombi osszeletero: 40*6 = 240
        //200%40 = 0
        //200/40 = 5
        Hos hos = new FelhasznaloHos();
        Pozicio fonixPozicio = new Pozicio(2, 2);
        Fonix fonix = new Fonix(hos,6, fonixPozicio);
        fonix.setJelenlegiEletero(200);
        assertEquals(5, fonix.hanyDb(), "sajnos itt hiba van :( ");
    }


    //************** szamolSebzes() metódus tesztelése **************

    /*
    public int szamolSebzesTeszthez(int tamadas, Hos ellenfel, int randomSzam, int hanyDb){
        double alapsebzes = randomSzam * hanyDb;
        double sebzes = alapsebzes + alapsebzes*((double)tamadas/10);
        sebzes = sebzes * ((double)ellenfel.vedekezes/10);
        return (int) ceil(sebzes);
    }
    //a mock-hoz külső könyvtár kell!!!

     */

    /*
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
        Griff griff = new Griff(en, 10);
        en.egysegek.add(griff);
        ellenfel.setVedekezes(4);
        Sarkany sarkany = new Sarkany(ellenfel, 8);
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
        Pegazus pegazus = new Pegazus(en, 34);
        en.egysegek.add(pegazus);
        ellenfel.setVedekezes(10);
        Pteranodon pteranodon = new Pteranodon(ellenfel, 9);
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
        Grof grof = new Grof(en, 100);
        en.egysegek.add(grof);
        ellenfel.setVedekezes(2);
        Lovag lovag = new Lovag(ellenfel, 28);
        ellenfel.egysegek.add(lovag);
        assertEquals(72, szamolSebzesTeszthez(en.getTamadas(), ellenfel, 3, 100), "sajnos itt hiba van :( ");

    }

     */


    //************** sebez() metódus tesztelése **************

    @Test
    public void testSebezPegazust(){
        //pegazus eletero: 30*44 = 1320
        Hos ellenfel = new FelhasznaloHos();
        Pozicio pegazusPozicio = new Pozicio(2, 2);
        Pegazus pegazus = new Pegazus(ellenfel, 44, pegazusPozicio);
        pegazus.sebez(20);
        assertEquals(1300, pegazus.jelenlegiEletero, "sajnos itt hiba van :( ");
    }

    @Test
    public void testSebezVampirt(){
        //vampir eletero: 9*50 = 450
        Hos ellenfel = new FelhasznaloHos();
        Pozicio vampirPozicio = new Pozicio(2, 2);
        Vampir vampir = new Vampir(ellenfel, 50, vampirPozicio);
        vampir.setJelenlegiEletero(400);
        vampir.sebez(100);
        assertEquals(300, vampir.jelenlegiEletero, "sajnos itt hiba van :( ");
    }

    @Test
    public void testSebezFoldmuvest(){
        //foldmuves eletero: 7 * 3 = 21
        Hos ellenfel = new FelhasznaloHos();
        Pozicio foldmuvesPozicio = new Pozicio(2, 2);
        Foldmuves foldmuves = new Foldmuves(ellenfel, 7, foldmuvesPozicio);
        foldmuves.setJelenlegiEletero(20);
        foldmuves.sebez(34);
        assertEquals(0, foldmuves.jelenlegiEletero, "sajnos itt hiba van :( ");
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

    /*
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
        Demon demon = new Demon(superman, 32);
        superman.egysegek.add(demon);
        Polgar polgar = new Polgar(batman, 19);
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
        Demon demon = new Demon(superman, 32);
        superman.egysegek.add(demon);
        superman.setTamadas(10);
        superman.setVedekezes(7);

        Hos batman = new Hos();
        Polgar polgar = new Polgar(batman, 19);
        batman.egysegek.add(polgar);
        batman.setTamadas(6);
        batman.setVedekezes(5);
        //superman tamadja meg batmant
        kritikusSebzesTeszthez(superman.getTamadas(), batman, polgar, 3, 32);
        assertEquals(0, polgar.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    //************** vajonKritikusSebzes() metódus tesztelése **************

    //??? nem tudom

     */


    //************** kozelharciTamadas() metódus tesztelése **************

    @Test
    public void testKozelharciTamadasIgazEmberre(){
        Pozicio ijaszPozicio = new Pozicio(5,9);
        Pozicio foldmuvesPozicio = new Pozicio(5,8);
        Hos ijaszHos = new FelhasznaloHos();
        Hos foldmuvesHos = new FelhasznaloHos();
        Ijasz ijasz = new Ijasz(ijaszHos, 83, ijaszPozicio);
        Foldmuves foldmuves = new Foldmuves(foldmuvesHos, 57, foldmuvesPozicio);
        assertTrue(ijasz.kozelharciTamadasE(foldmuves), "sajnos itt hiba van :( ");
    }

    @Test
    public void testKozelharciTamadasHamisRepuloEgysegre(){
        Hos sarkanyHos = new FelhasznaloHos();
        Hos fonixHos = new FelhasznaloHos();
        Pozicio sarkanyPozicio = new Pozicio(5,9);
        Pozicio fonixPozicio = new Pozicio(2,9);
        Sarkany sarkany = new Sarkany(sarkanyHos, 83, sarkanyPozicio);
        Fonix fonix = new Fonix(fonixHos,57, fonixPozicio);
        assertFalse(sarkany.kozelharciTamadasE(fonix), "sajnos itt hiba van :( ");
    }

    @Test
    public void testKozelharciTamadasIgazEloholtra(){
        Hos demonHos = new FelhasznaloHos();
        Hos szellemHos = new FelhasznaloHos();
        Pozicio demonPozicio = new Pozicio(5,9);
        Pozicio szellemPozicio = new Pozicio(4,9);
        Demon demon = new Demon(demonHos, 83, demonPozicio);
        Szellem szellem = new Szellem(szellemHos,57, szellemPozicio);
        assertTrue(demon.kozelharciTamadasE(szellem), "sajnos itt hiba van :( ");
    }

    //************ kezdemenyezes tesztelese ****************-

    /*
    @Test
    public void testKezdemenyezes(){

        Hos hos = new EmberiHos();
        hos.setMoral(9);

        Hos ellenfel = new GepiHos();
        ellenfel.setMoral(1);

        //griff kezdemenyezese: 15
        //15 + 1 = 16
        Pozicio griffPozicio = new Pozicio(3, 4);
        Griff griff = new Griff(ellenfel, 10, griffPozicio);

        //fonix kezdemnyezese: 4
        //4 + 1 = 5
        Pozicio fonixPozicio = new Pozicio(2, 2);
        Griff fonix = new Griff(ellenfel, 10, fonixPozicio);

        //pegazus kezdemenyezese: 8
        //8 + 8 = 17
        Pozicio pegazusPozicio = new Pozicio(3, 3);
        Griff pegazus = new Griff(hos, 10, pegazusPozicio);

        //??
    }

     */

}
