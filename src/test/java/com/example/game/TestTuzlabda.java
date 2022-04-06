package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Vampir;
import com.example.game.hos.egysegek.eloholtak.Verfarkas;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.egysegek.emberek.Grof;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.emberek.Lovag;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Tuzlabda;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTuzlabda {

    @Test
    public void testAlkalmazKettoRepuloLenyre(){

        //griff eletero: 30*10 = 300
        //sebzes = 20*8 = 160
        //300-160 = 140
        //sarkany eletero: 100*15 = 1500
        //1500-160 = 1340
        Hos hos = new Hos();
        hos.setVarazsero(8);
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Griff griff = new Griff(10);
        Sarkany sarkany = new Sarkany(100);
        tuzlabda.alkalmaz(List.of(sarkany, griff));
        assertEquals(140, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1340, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazEgyDemonra(){
        //demon eletero: 30*93 = 2790
        //sebzes: 2*20 = 40
        Hos hos = new Hos();
        hos.setVarazsero(2);
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Demon demon = new Demon(93);
        tuzlabda.alkalmaz(List.of(demon));
        assertEquals(2750, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazNegyEmberre(){
        //ijasz eletero: 7*7 = 49
        //grof eletero: 5*40 = 200
        //lovag eletero: 8*221 = 1768
        //foldmuves eletero: 3*112 = 336
        //sebzes: 5*20 = 100
        //-51, 100, 1668, 236
        Hos hos = new Hos();
        hos.setVarazsero(5);
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Ijasz ijasz = new Ijasz(7);
        Grof grof = new Grof(40);
        Lovag lovag = new Lovag(221);
        Foldmuves foldmuves = new Foldmuves(112);
        tuzlabda.alkalmaz(List.of(ijasz, grof, lovag, foldmuves));
        assertEquals(-51, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(100, grof.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1668, lovag.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(236, foldmuves.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazHaromEloholtra(){
        //EBBEN VAN MINUSZ IS!!
        //zombi eletero: 9*73 = 657
        //verfarkas eletero: 6*341 = 2046
        //vampir eletereje: 9*2 = 18
        //sebzes: 1*20
        Hos hos = new Hos();
        hos.setVarazsero(1);
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Vampir vampir = new Vampir(2);
        Verfarkas verfarkas = new Verfarkas(341);
        Zombi zombi = new Zombi(73);
        tuzlabda.alkalmaz(List.of(vampir, verfarkas, zombi));
        assertEquals(-2, vampir.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(2026, verfarkas.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(637, zombi.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazUresListara(){
        //vampir eletereje: 9*2 = 18
        Hos hos = new Hos();
        hos.setVarazsero(10);
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Vampir vampir = new Vampir(2);
        tuzlabda.alkalmaz(List.of());
        assertEquals(18, vampir.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
