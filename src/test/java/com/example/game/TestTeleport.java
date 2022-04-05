package com.example.game;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Pegazus;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Teleport;
import com.example.game.hos.varazslatok.Villamcsapas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTeleport {

    @Test
    public void testAlkalmaz(){

        Pozicio griffPozicio = new Pozicio(3,4);
        Pozicio demonPozicio = new Pozicio(6,6);
        Pozicio zombiPozicio = new Pozicio(7,1);
        Hos hos = new Hos();
        Teleport teleport = new Teleport(hos);
        Griff griff = new Griff(10);
        griff.setPozicio(griffPozicio);
        hos.egysegek.add(griff);
        Demon demon = new Demon(12);
        demon.setPozicio(demonPozicio);
        hos.egysegek.add(demon);
        Zombi zombi = new Zombi(300);
        zombi.setPozicio(zombiPozicio);
        hos.egysegek.add(zombi);
        teleport.alkalmaz(hos.egysegek);
        assertEquals(griffPozicio, griff.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(demonPozicio, demon.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(zombiPozicio, zombi.getPozicio(), "sajnos itt hiba van :( ");


        hos.egysegek.clear();
        Sarkany sarkany = new Sarkany(100);
        Pozicio sarkanyPozicio = new Pozicio(4, 4);
        sarkany.setPozicio(sarkanyPozicio);
        hos.egysegek.add(sarkany);
        teleport.alkalmaz(hos.egysegek);
        assertEquals(sarkanyPozicio, sarkany.getPozicio(), "sajnos itt hiba van :( ");


        hos.egysegek.clear();
        Ijasz ijasz = new Ijasz(121);
        Pozicio ijaszPozicio = new Pozicio(8, 10);
        ijasz.setPozicio(ijaszPozicio);
        hos.egysegek.add(ijasz);
        Pegazus pegazus = new Pegazus(3);
        Pozicio pegazusPozicio = new Pozicio(1, 2);
        pegazus.setPozicio(pegazusPozicio);
        hos.egysegek.add(pegazus);
        teleport.alkalmaz(hos.egysegek);
        assertEquals(pegazusPozicio, ijasz.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(ijaszPozicio, pegazus.getPozicio(), "sajnos itt hiba van :( ");

    }
}
