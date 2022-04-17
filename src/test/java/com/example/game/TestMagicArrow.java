package com.example.game;

import com.example.game.hos.FelhasznaloHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.Demon;
import com.example.game.hos.egysegek.eloholtak.Verfarkas;
import com.example.game.hos.egysegek.emberek.Ijasz;
import com.example.game.hos.egysegek.emberek.Lovag;
import com.example.game.hos.egysegek.emberek.Polgar;
import com.example.game.hos.egysegek.repulol_lenyek.Griff;
import com.example.game.hos.egysegek.repulol_lenyek.Pegazus;
import com.example.game.hos.egysegek.repulol_lenyek.Sarkany;
import com.example.game.hos.varazslatok.MagicArrow;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMagicArrow {

    @Test
    public void testAlkalmazGriffre(){
        //griff eletero: 30*10 = 300
        //sebzes = 10+ 10*8 = 90
        //300-90 = 210
        Hos hos = new FelhasznaloHos();
        hos.setVarazsero(8);
        Hos ellenfel = new FelhasznaloHos();
        MagicArrow magicArrow = new MagicArrow(hos);
        Pozicio griffPozicio = new Pozicio(2, 2);
        Griff griff = new Griff(ellenfel, 10, griffPozicio);
        magicArrow.hasznal(List.of(griff));
        assertEquals(210, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazSarkanyra(){
        //sarkany eletero: 15*12 = 180
        //sebzes: 10*1 +10 = 20
        //180-20 = 160
        Hos hos = new FelhasznaloHos();
        hos.setVarazsero(1);
        Hos ellenfel = new FelhasznaloHos();
        MagicArrow magicArrow = new MagicArrow(hos);
        Pozicio aithusaPozicio = new Pozicio(2, 2);
        Sarkany aithusa = new Sarkany(ellenfel,12, aithusaPozicio);
        magicArrow.hasznal(List.of(aithusa));
        assertEquals(160, aithusa.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazDemonra(){
        //demon eletero: 30*93 = 2790
        //sebzes: 10*10 +10 = 110
        //2790-110 = 2680
        Hos hos = new FelhasznaloHos();
        hos.setVarazsero(10);
        Hos ellenfel = new FelhasznaloHos();
        MagicArrow magicArrow = new MagicArrow(hos);
        Pozicio demonPozicio = new Pozicio(2, 2);
        Demon demon = new Demon(ellenfel, 93, demonPozicio);
        magicArrow.hasznal(List.of(demon));
        assertEquals(2680, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazVerfarkasra(){
        //verfarkas eletero: 6*100 = 600
        //sebzes: 10*2 +10 = 30
        Hos hos = new FelhasznaloHos();
        hos.setVarazsero(2);
        Hos ellenfel = new FelhasznaloHos();
        MagicArrow magicArrow = new MagicArrow(hos);
        Pozicio verfarkasPozicio = new Pozicio(2, 2);
        Verfarkas verfarkas = new Verfarkas(ellenfel, 100, verfarkasPozicio);
        magicArrow.hasznal(List.of(verfarkas));
        assertEquals(570, verfarkas.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazPolgarra(){
        //polgar eletero: 6*23 = 138
        //sebzes: 10*10 +10 = 110
        Hos hos = new FelhasznaloHos();
        hos.setVarazsero(10);
        Hos ellenfel = new FelhasznaloHos();
        MagicArrow magicArrow = new MagicArrow(hos);
        Pozicio polgarPozicio = new Pozicio(2, 2);
        Polgar polgar = new Polgar(ellenfel, 23, polgarPozicio);
        magicArrow.hasznal(List.of(polgar));
        assertEquals(28, polgar.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazTobbElemuListara(){
        //ijasz eletero: 7*93 = 651
        //pegazus: 30*49 = 1470
        Hos hos = new FelhasznaloHos();
        hos.setVarazsero(7);
        Hos ellenfel = new FelhasznaloHos();
        MagicArrow magicArrow = new MagicArrow(hos);
        Pozicio ijaszPozicio = new Pozicio(2, 2);
        Pozicio pegazusPozicio = new Pozicio(2, 2);
        Ijasz ijasz = new Ijasz(ellenfel, 93, ijaszPozicio);
        Pegazus pegazus = new Pegazus(ellenfel,49, pegazusPozicio);
        magicArrow.hasznal(List.of(ijasz, pegazus));
        assertEquals(651, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1470, pegazus.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazUresListara(){
        //lovag eletero: 8*3 = 24
        Hos hos = new FelhasznaloHos();
        hos.setVarazsero(4);
        Hos ellenfel = new FelhasznaloHos();
        MagicArrow magicArrow = new MagicArrow(hos);
        Pozicio lovagPozicio = new Pozicio(2, 2);
        Lovag lovag = new Lovag(ellenfel, 3, lovagPozicio);
        magicArrow.hasznal(List.of());
        assertEquals(24, lovag.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
