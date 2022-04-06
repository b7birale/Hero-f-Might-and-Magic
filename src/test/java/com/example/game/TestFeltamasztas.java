package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Vampir;
import com.example.game.hos.egysegek.emberek.Grof;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.emberek.Lovag;
import com.example.game.hos.egysegek.repulol_lenyek.Fonix;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Pteranodon;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Feltamasztas;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFeltamasztas {

    @Test
    public void testAlkalmazTobbElemuListara(){
        //griff eletero: 30*10 = 300
        //sarkany eletero: 100*15 = 1500
        Hos hos = new Hos();
        hos.setVarazsero(8);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Griff griff = new Griff(10);
        Sarkany sarkany = new Sarkany(100);
        griff.setJelenlegiEletero(120);
        sarkany.setJelenlegiEletero(1100);
        feltamasztas.alkalmaz(List.of(griff, sarkany));
        assertEquals(120, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1100, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazUresListara(){
        //demon eletero: 30*93 = 2790
        //felt.: 2*50 = 100
        Hos hos = new Hos();
        hos.setVarazsero(3);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Demon demon = new Demon(93);
        demon.setJelenlegiEletero(2600);
        feltamasztas.alkalmaz(List.of());
        assertEquals(2600, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazEredetiEleteroFonixre(){
        //fonix eletero: 40*33 = 1320
        //felt.: 1*50 = 50
        Hos hos = new Hos();
        hos.setVarazsero(1);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Fonix fonix = new Fonix(33);
        fonix.setJelenlegiEletero(1300);
        feltamasztas.alkalmaz(List.of(fonix));
        assertEquals(1320, fonix.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazEredetiEleteroIjaszra(){
        //ijasz eletero: 7*7 = 49
        //felt.: 50*10 = 500
        Hos hos = new Hos();
        hos.setVarazsero(10);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Ijasz ijasz = new Ijasz(7);
        ijasz.setJelenlegiEletero(24);
        feltamasztas.alkalmaz(List.of(ijasz));
        assertEquals(49, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazEredetiEleteroLovagra(){
        //lovag eletero: 8*221 = 1768
        //felt.: 7*50 = 350
        Hos hos = new Hos();
        hos.setVarazsero(7);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Lovag lovag = new Lovag(221);
        lovag.setJelenlegiEletero(1500);
        feltamasztas.alkalmaz(List.of(lovag));
        assertEquals(1768, lovag.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazEredetiEleteroVampirra(){
        //vampir eletero: 13*9 = 117
        //felt.: 5*50 = 250
        Hos hos = new Hos();
        hos.setVarazsero(5);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Vampir vampir = new Vampir(13);
        vampir.setJelenlegiEletero(0);
        feltamasztas.alkalmaz(List.of(vampir));
        assertEquals(117, vampir.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazFeltamasztasPluszDemonra(){
        //demon eletero: 30*93 = 2790
        //felt.: 2*50 = 100
        Hos hos = new Hos();
        hos.setVarazsero(2);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Demon demon = new Demon(93);
        demon.setJelenlegiEletero(2600);
        feltamasztas.alkalmaz(List.of(demon));
        assertEquals(2700, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazFeltamasztasPluszGrofra(){
        //grof eletero: 5*40 = 200
        //felt.: 50*1 = 50
        Hos hos = new Hos();
        hos.setVarazsero(1);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Grof grof = new Grof(40);
        grof.setJelenlegiEletero(20);
        feltamasztas.alkalmaz(List.of(grof));
        assertEquals(70, grof.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazFeltamasztasPluszPteranodonra(){
        //pteranodon eletero: 7*112= 784
        //felt.: 3*50 = 150
        Hos hos = new Hos();
        hos.setVarazsero(3);
        Feltamasztas feltamasztas = new Feltamasztas(hos);
        Pteranodon ptera = new Pteranodon(112);
        ptera.setJelenlegiEletero(150);
        feltamasztas.alkalmaz(List.of(ptera));
        assertEquals(300, ptera.getJelenlegiEletero(), "sajnos itt hiba van :( ");

    }

}
