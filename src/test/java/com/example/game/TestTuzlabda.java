package com.example.game;

import com.example.game.hos.EmberiHos;
import com.example.game.hos.GepiHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
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
        Hos hos = new EmberiHos();
        hos.setVarazsero(8);
        Hos ellenfel = new EmberiHos();
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Pozicio griffPozicio = new Pozicio(2, 2);
        Pozicio sarkanyPozicio = new Pozicio(4, 2);
        Griff griff = new Griff(ellenfel, 10, griffPozicio);
        Sarkany sarkany = new Sarkany(hos, 100, sarkanyPozicio);
        tuzlabda.alkalmaz(List.of(sarkany, griff));
        assertEquals(140, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1340, sarkany.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazEgyDemonra(){
        //demon eletero: 30*93 = 2790
        //sebzes: 2*20 = 40
        Hos hos = new EmberiHos();
        hos.setVarazsero(2);
        Hos ellenfel = new EmberiHos();
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Pozicio demonPozicio = new Pozicio(2, 2);
        Demon demon = new Demon(ellenfel, 93, demonPozicio);
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
        Hos hos = new EmberiHos();
        hos.setVarazsero(5);
        Hos ellenfel = new EmberiHos();
        Tuzlabda tuzlabda = new Tuzlabda(hos);

        Pozicio ijaszPozicio = new Pozicio(2, 2);
        Pozicio grofPozicio = new Pozicio(3, 2);
        Pozicio lovagPozicio = new Pozicio(3, 3);
        Pozicio foldmuvesPozicio = new Pozicio(2, 1);

        Ijasz ijasz = new Ijasz(ellenfel, 7, ijaszPozicio);
        Grof grof = new Grof(ellenfel, 40, grofPozicio);
        Lovag lovag = new Lovag(hos, 221, lovagPozicio);
        Foldmuves foldmuves = new Foldmuves(ellenfel, 112, foldmuvesPozicio);

        tuzlabda.alkalmaz(List.of(ijasz, grof, lovag, foldmuves));

        assertEquals(0, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
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
        Hos hos = new EmberiHos();
        hos.setVarazsero(1);
        Hos ellenfel = new EmberiHos();
        Tuzlabda tuzlabda = new Tuzlabda(hos);

        Pozicio vampirPozicio = new Pozicio(2, 2);
        Vampir vampir = new Vampir(hos, 2, vampirPozicio);

        Pozicio verfarkasPozicio = new Pozicio(3, 2);
        Verfarkas verfarkas = new Verfarkas(ellenfel, 341, verfarkasPozicio);

        Pozicio zombiPozicio = new Pozicio(2, 3);
        Zombi zombi = new Zombi(hos, 73, zombiPozicio);

        tuzlabda.alkalmaz(List.of(vampir, verfarkas, zombi));

        assertEquals(0, vampir.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(2026, verfarkas.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(637, zombi.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazUresListara(){
        //vampir eletereje: 9*2 = 18
        Hos hos = new EmberiHos();
        hos.setVarazsero(10);
        Hos ellenfel = new EmberiHos();
        Tuzlabda tuzlabda = new Tuzlabda(hos);
        Pozicio vampirPozicio = new Pozicio(2, 2);
        Vampir vampir = new Vampir(ellenfel, 2, vampirPozicio);
        tuzlabda.alkalmaz(List.of());
        assertEquals(18, vampir.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
