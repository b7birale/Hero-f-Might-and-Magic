package com.example.game.hos.egysegek;

public class Pozicio {
    private int sor;
    private int oszlop;

    public Pozicio(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
    }

    /*
    public void csokkentOszlop(){

    }

     */



    public int getSor() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }

    public int getOszlop() {
        return oszlop;
    }

    public void setOszlop(int oszlop) {
        this.oszlop = oszlop;
    }
}
