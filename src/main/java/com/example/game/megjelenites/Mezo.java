package com.example.game.megjelenites;


import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.emberek.Foldmuves;

import java.util.Objects;

public class Mezo {

    private Foldmuves foldmuves;
    private Hos hos;
    private Egyseg egyseg;
    private Pozicio pozicio;

    public Mezo(final Pozicio pozicio) {
        this.pozicio = pozicio;
    }

    public boolean ures() {
        return egyseg == null;
    }

    public boolean foldmuvesVanRajta(){
        return Objects.equals(hos.getEgysegek().get(0).getNev(), "Foldmuves");
    }

    public Egyseg getEgyseg() {
        return egyseg;
    }

    public void lehelyezEgyseg(final Egyseg egyseg) {
        egyseg.setPozicio(pozicio);
        this.egyseg = egyseg;
    }

    public void leveszEgyseg() {
        this.egyseg.setPozicio(null);
        this.egyseg = null;
    }

    @Override
    public String toString() {
        return "Mezo{" +
                "egyseg=" + egyseg +
                '}';
    }
}
