package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Szellem;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Villamcsapas;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVillamcsapas {

    @Test
    public void testAlkalmazGriffre(){

        //griff eletero: 30*10 = 300
        //sebzes = 30*8 = 240
        //300-240 = 60
        Hos hos = new Hos();
        hos.setVarazsero(8);
        Villamcsapas villamcsapas = new Villamcsapas(hos);
        Griff griff = new Griff(hos, 10);
        villamcsapas.alkalmaz(List.of(griff));
        assertEquals(60, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazFoldmuvesre(){
        //foldmuves eletero: 3*125 = 375
        //sebzes: 30*7 = 210
        //375-210 = 165
        Hos hos = new Hos();
        hos.setVarazsero(7);
        Villamcsapas villamcsapas = new Villamcsapas(hos);
        Foldmuves foldmuves = new Foldmuves(hos, 125);
        villamcsapas.alkalmaz(List.of(foldmuves));
        assertEquals(165, foldmuves.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazSzellemre(){
        //szellem eletero: 30*12 = 360
        //sebzes: 30*1 = 30
        //360-30 = 330
        Hos hos = new Hos();
        hos.setVarazsero(1);
        Villamcsapas villamcsapas = new Villamcsapas(hos);
        Szellem szellem = new Szellem(hos, 12);
        villamcsapas.alkalmaz(List.of(szellem));
        assertEquals(330, szellem.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazTobbElemuListara(){
        //sarkany eletero: 100*15 = 1500
        //zombi eletero: 9*300 = 2700
        Hos hos = new Hos();
        hos.setVarazsero(2);
        Villamcsapas villamcsapas = new Villamcsapas(hos);
        Sarkany sarkany = new Sarkany(hos, 100);
        Zombi zombi = new Zombi(hos, 300);
        villamcsapas.alkalmaz(List.of(sarkany, zombi));
        assertEquals(1500, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(2700, zombi.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazUresListara(){
        //demon eletero: 30*93 = 2790
        //sebzes: 10*30 = 300
        //2790-300 = 2490
        Hos hos = new Hos();
        hos.setVarazsero(10);
        Villamcsapas villamcsapas = new Villamcsapas(hos);
        Demon demon = new Demon(hos, 93);
        villamcsapas.alkalmaz(List.of());   //szándékosan üres listát kap
        assertEquals(2790, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }


}
