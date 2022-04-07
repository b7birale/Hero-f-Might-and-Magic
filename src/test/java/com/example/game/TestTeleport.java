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
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTeleport {

    @Test
    public void testAlkalmazHaromElemuListara(){
        Hos hos = new Hos();
        Hos ellenfel = new Hos();
        Teleport teleport = new Teleport(hos);
        Pozicio griffPozicio = new Pozicio(3,4);
        Pozicio demonPozicio = new Pozicio(6,6);
        Pozicio zombiPozicio = new Pozicio(7,1);
        Griff griff = new Griff(ellenfel, 10);
        griff.setPozicio(griffPozicio);
        Demon demon = new Demon(hos, 12);
        demon.setPozicio(demonPozicio);
        Zombi zombi = new Zombi(hos, 300);
        zombi.setPozicio(zombiPozicio);
        teleport.alkalmaz(List.of(griff, demon, zombi));
        assertEquals(griffPozicio, griff.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(demonPozicio, demon.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(zombiPozicio, zombi.getPozicio(), "sajnos itt hiba van :( ");

    }

    @Test
    public void testAlkalmazEgyElemuListara(){
        Hos hos = new Hos();
        Teleport teleport = new Teleport(hos);
        Sarkany sarkany = new Sarkany(hos, 100);
        Pozicio sarkanyPozicio = new Pozicio(4, 4);
        sarkany.setPozicio(sarkanyPozicio);
        teleport.alkalmaz(List.of(sarkany));
        assertEquals(sarkanyPozicio, sarkany.getPozicio(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazHelyesBemenetre(){
        Hos hos = new Hos();
        Teleport teleport = new Teleport(hos);
        Ijasz ijasz = new Ijasz(hos, 121);
        Pozicio ijaszPozicio = new Pozicio(8, 10);
        ijasz.setPozicio(ijaszPozicio);
        Pegazus pegazus = new Pegazus(hos, 3);
        Pozicio pegazusPozicio = new Pozicio(1, 2);
        pegazus.setPozicio(pegazusPozicio);
        teleport.alkalmaz(List.of(ijasz, pegazus));
        assertEquals(pegazusPozicio, ijasz.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(ijaszPozicio, pegazus.getPozicio(), "sajnos itt hiba van :( ");
    }
}
