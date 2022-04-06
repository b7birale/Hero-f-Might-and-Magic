package com.example.game;

import com.example.game.hos.Hos;
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
        Hos hos = new Hos();
        hos.setVarazsero(8);
        MagicArrow magicArrow = new MagicArrow(hos);
        Griff griff = new Griff(hos, 10);
        magicArrow.alkalmaz(List.of(griff));
        assertEquals(210, griff.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazSarkanyra(){
        //sarkany eletero: 15*12 = 180
        //sebzes: 10*1 +10 = 20
        //180-20 = 160
        Hos hos = new Hos();
        hos.setVarazsero(1);
        MagicArrow magicArrow = new MagicArrow(hos);
        Sarkany aithusa = new Sarkany(hos,12);
        magicArrow.alkalmaz(List.of(aithusa));
        assertEquals(160, aithusa.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazDemonra(){
        //demon eletero: 30*93 = 2790
        //sebzes: 10*10 +10 = 110
        //2790-110 = 2680
        Hos hos = new Hos();
        hos.setVarazsero(10);
        MagicArrow magicArrow = new MagicArrow(hos);
        Demon demon = new Demon(hos, 93);
        magicArrow.alkalmaz(List.of(demon));
        assertEquals(2680, demon.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazVerfarkasra(){
        //verfarkas eletero: 6*100 = 600
        //sebzes: 10*2 +10 = 30
        Hos hos = new Hos();
        hos.setVarazsero(2);
        MagicArrow magicArrow = new MagicArrow(hos);
        Verfarkas verfarkas = new Verfarkas(hos, 100);
        magicArrow.alkalmaz(List.of(verfarkas));
        assertEquals(570, verfarkas.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazPolgarra(){
        //polgar eletero: 6*23 = 138
        //sebzes: 10*10 +10 = 110
        Hos hos = new Hos();
        hos.setVarazsero(10);
        MagicArrow magicArrow = new MagicArrow(hos);
        Polgar polgar = new Polgar(hos, 23);
        magicArrow.alkalmaz(List.of(polgar));
        assertEquals(28, polgar.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazTobbElemuListara(){
        //ijasz eletero: 7*93 = 651
        //pegazus: 30*49 = 1470
        Hos hos = new Hos();
        hos.setVarazsero(7);
        MagicArrow magicArrow = new MagicArrow(hos);
        Ijasz ijasz = new Ijasz(hos, 93);
        Pegazus pegazus = new Pegazus(hos,49);
        magicArrow.alkalmaz(List.of(ijasz, pegazus));
        assertEquals(651, ijasz.getJelenlegiEletero(), "sajnos itt hiba van :( ");
        assertEquals(1470, pegazus.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }

    @Test
    public void testAlkalmazUresListara(){
        //lovag eletero: 8*3 = 24
        Hos hos = new Hos();
        hos.setVarazsero(4);
        MagicArrow magicArrow = new MagicArrow(hos);
        Lovag lovag = new Lovag(hos, 3);
        magicArrow.alkalmaz(List.of());
        assertEquals(24, lovag.getJelenlegiEletero(), "sajnos itt hiba van :( ");
    }
}
