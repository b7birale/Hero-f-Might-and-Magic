package com.example.game;

import com.example.game.hos.EmberiHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Pegazus;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Erosites;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestErosites {

    @Test
    public void testAlkalmazHaromElemuListara(){
        Hos hos = new EmberiHos();
        Hos ellenfel = new EmberiHos();
        Erosites erosites = new Erosites(hos);
        Pozicio griffPozicio = new Pozicio(3,4);
        Pozicio demonPozicio = new Pozicio(6,6);
        Pozicio zombiPozicio = new Pozicio(7,1);
        Griff griff = new Griff(ellenfel, 10, griffPozicio);
        Demon demon = new Demon(hos, 12, demonPozicio);
        Zombi zombi = new Zombi(hos, 300, zombiPozicio);
        erosites.alkalmaz(List.of(griff, demon, zombi));
        assertEquals(griffPozicio, griff.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(demonPozicio, demon.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(zombiPozicio, zombi.getPozicio(), "sajnos itt hiba van :( ");

    }

    @Test
    public void testAlkalmazEgyElemuListara(){
        Hos hos = new EmberiHos();
        Erosites erosites = new Erosites(hos);
        Pozicio sarkanyPozicio = new Pozicio(4, 4);
        Sarkany sarkany = new Sarkany(hos, 100, sarkanyPozicio);
        erosites.alkalmaz(List.of(sarkany));
        assertEquals(sarkanyPozicio, sarkany.getPozicio(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazHelyesBemenetre(){
        Hos hos = new EmberiHos();
        Erosites erosites = new Erosites(hos);
        Pozicio ijaszPozicio = new Pozicio(8, 10);
        Ijasz ijasz = new Ijasz(hos, 121, ijaszPozicio);
        Pozicio pegazusPozicio = new Pozicio(1, 2);
        Pegazus pegazus = new Pegazus(hos, 3, pegazusPozicio);
        erosites.alkalmaz(List.of(ijasz, pegazus));
        assertEquals(pegazusPozicio, ijasz.getPozicio(), "sajnos itt hiba van :( ");
        assertEquals(ijaszPozicio, pegazus.getPozicio(), "sajnos itt hiba van :( ");
    }
}
