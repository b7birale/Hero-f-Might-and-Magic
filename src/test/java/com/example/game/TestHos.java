package com.example.game;

import com.example.game.hos.EmberiHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Vampir;
import com.example.game.hos.egysegek.eloholtak.Zombi;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.egysegek.emberek.Grof;
import com.example.game.hos.egysegek.emberek.Lovag;
import com.example.game.hos.egysegek.emberek.Polgar;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestHos {

    //************** fizet() metódus tesztelése ***************

    @Test
    public void testFizetMannaElso(){
        Hos ijaszHos = new EmberiHos();
        ijaszHos.setManna(80);
        ijaszHos.fizet(10);
        assertEquals(ijaszHos.getManna(), 70, "sajnos itt hiba van :( ");
    }

    @Test
    public void testFizetMannaMasodik(){
        Hos hos = new EmberiHos();
        hos.setManna(65);
        hos.fizet(15);
        assertEquals(hos.getManna(), 50, "sajnos itt hiba van :( ");
    }

    @Test
    public void testFizetMannaHarmadik(){
        Hos hos = new EmberiHos();
        hos.setManna(25);
        hos.fizet(5);
        assertEquals(hos.getManna(), 20, "sajnos itt hiba van :( ");
    }




    //************** tamad() metódus tesztelése ***************

    @Test
    public void testTamadPolgart(){
        //sebzés: 30
        //polgár életerő: 31 * 6 = 186
        //186-30 = 156
        Hos hos = new EmberiHos();
        hos.setTamadas(3);
        Hos ellenfel = new EmberiHos();
        Pozicio polgarPozicio = new Pozicio(2, 4);
        Polgar polgar = new Polgar(ellenfel, 31, polgarPozicio);

        hos.tamad(polgar);

        assertEquals(polgar.getJelenlegiEletero(), 156, "sajnos itt hiba van :( ");
    }

    @Test
    public void testTamadVampirt(){
        //sebzés: 70
        //vámpír életerő: 9 * 10 = 90
        //20

        Hos hos = new EmberiHos();
        hos.setTamadas(7);
        Hos ellenfel = new EmberiHos();
        Pozicio vampirPozicio = new Pozicio(8, 9);
        Vampir vampir = new Vampir(ellenfel, 10, vampirPozicio);

        hos.tamad(vampir);

        assertEquals(vampir.getJelenlegiEletero(), 20, "sajnos itt hiba van :( ");
    }

    @Test
    public void testTamadSarkanyt(){
        //sebzés: 100
        //sarkany életerő: 15*45 = 675
        //575

        Hos hos = new EmberiHos();
        hos.setTamadas(10);
        Hos ellenfel = new EmberiHos();
        Pozicio sarkanyPozicio = new Pozicio(6, 4);
        Sarkany sarkany = new Sarkany(ellenfel, 45, sarkanyPozicio);

        hos.tamad(sarkany);

        assertEquals(sarkany.getJelenlegiEletero(), 575, "sajnos itt hiba van :( ");
    }



    //***************** isEllenfelEgysegE() tesztelése ********************

    @Test
    public void testIsEllenfelEgysegERepuloLenyekre(){
        Hos hos = new EmberiHos();
        Pozicio sarkanyPozicio = new Pozicio(3, 3);
        Sarkany sarkany = new Sarkany(hos, 2, sarkanyPozicio);

        assertFalse(hos.isEllenfelEgysegE(sarkany), "sajnos itt hiba van :( ");
    }

    @Test
    public void testIsEllenfelEgysegEEmberekre(){
        Hos hos = new EmberiHos();
        Hos ellenfelHos = new EmberiHos();
        Pozicio grofPozicio = new Pozicio(5, 6);
        Grof grof = new Grof(ellenfelHos, 9, grofPozicio);

        assertTrue(hos.isEllenfelEgysegE(grof), "sajnos itt hiba van :( ");
    }

    @Test
    public void testIsEllenfelEgysegEEloholtakra(){
        Hos hos = new EmberiHos();
        Hos ellenfelHos = new EmberiHos();
        Pozicio zombiPozicio = new Pozicio(5, 6);
        Zombi zombi = new Zombi(ellenfelHos, 9, zombiPozicio);

        assertTrue(hos.isEllenfelEgysegE(zombi), "sajnos itt hiba van :( ");
    }


    //***************** isSajatEgysegE() tesztelése ********************

    @Test
    public void testIsSajatEgysegERepuloLenyekre(){
        Hos hos = new EmberiHos();
        Hos ellenfelHos = new EmberiHos();
        Pozicio griffPozicio = new Pozicio(5, 6);
        Griff griff = new Griff(ellenfelHos, 9, griffPozicio);

        assertFalse(hos.isSajatEgysegE(griff), "sajnos itt hiba van :( ");
    }

    @Test
    public void testIsSajatEgysegEEmberre(){
        Hos hos = new EmberiHos();
        Hos ellenfelHos = new EmberiHos();
        Pozicio foldmuvesPozicio = new Pozicio(5, 6);
        Foldmuves foldmuves = new Foldmuves(hos, 9, foldmuvesPozicio);

        assertTrue(hos.isSajatEgysegE(foldmuves), "sajnos itt hiba van :( ");
    }

    @Test
    public void testIsSajatEgysegEEloholtra(){
        Hos hos = new EmberiHos();
        Hos ellenfelHos = new EmberiHos();
        Pozicio zombiPozicio = new Pozicio(5, 6);
        Zombi zombi = new Zombi(ellenfelHos, 9, zombiPozicio);

        assertFalse(hos.isSajatEgysegE(zombi), "sajnos itt hiba van :( ");
    }



}
