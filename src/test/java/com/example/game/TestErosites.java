package com.example.game;

import com.example.game.hos.FelhasznaloHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Verfarkas;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Grof;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.Erosites;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestErosites {

    @Test
    public void testAlkalmazHaromElemuListara(){
        Hos hos = new FelhasznaloHos();
        Hos ellenfel = new FelhasznaloHos();
        Erosites erosites = new Erosites(hos);
        Pozicio verfarkasPozicio = new Pozicio(3,4);
        Pozicio demonPozicio = new Pozicio(6,6);
        Pozicio zombiPozicio = new Pozicio(7,1);
        Verfarkas verfarkas = new Verfarkas(ellenfel, 10, verfarkasPozicio);
        Demon demon = new Demon(hos, 12, demonPozicio);
        Zombi zombi = new Zombi(hos, 300, zombiPozicio);
        erosites.hasznal(List.of(verfarkas, demon, zombi));
        //nem szabadna, hogy lefusson, mert ervenytelen bemenetet adtunk meg
        assertEquals(verfarkas.getMaxSebzes(), 11, "sajnos itt hiba van :( ");
        assertEquals(demon.getMaxSebzes(), 3, "sajnos itt hiba van :( ");
        assertEquals(zombi.getMaxSebzes(), 4, "sajnos itt hiba van :( ");

    }

    @Test
    public void testAlkalmazUresListara(){
        Hos hos = new FelhasznaloHos();
        Erosites erosites = new Erosites(hos);
        Pozicio sarkanyPozicio = new Pozicio(4, 4);
        Sarkany sarkany = new Sarkany(hos, 100, sarkanyPozicio);
        erosites.hasznal(List.of());
        assertEquals(sarkany.getMaxSebzes(), 12, "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazHelyesBemenetreEmberre(){
        Hos hos = new FelhasznaloHos();
        Erosites erosites = new Erosites(hos);
        Pozicio grofPozicio = new Pozicio(1, 2);
        Grof grof = new Grof(hos, 3, grofPozicio);
        erosites.hasznal(List.of(grof));
        assertEquals(grof.getMaxSebzes(), 5, "sajnos itt hiba van :( ");
    }


}
