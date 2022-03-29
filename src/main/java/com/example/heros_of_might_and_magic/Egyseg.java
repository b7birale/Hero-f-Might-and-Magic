package com.example.heros_of_might_and_magic;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Egyseg {

    protected String nev;
    protected int ar;   //itt minden protected!
    protected int minSebzes;
    protected int maxSebzes;
    protected int eletero;
    protected int sebesseg;
    protected int kezdemenyezes;
    protected int hanyDb;   //!
    protected String specialisKepesseg;


    public Egyseg() {
        this.nev = "egyseg";
        this.ar = 0;
        this.minSebzes = 0;
        this.maxSebzes = 0;
        this.eletero = 0;
        this.sebesseg = 0;
        this.kezdemenyezes = 0;
        this.specialisKepesseg = "nincs";
    }
    //?
    public Egyseg(String nev, int ar, int minSebzes, int maxSebzes, int eletero, int sebesseg, int kezdemenyezes, String specialisKepesseg) {
        this.nev = nev;
        this.ar = ar;
        this.minSebzes = minSebzes;
        this.maxSebzes = maxSebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
        this.specialisKepesseg = specialisKepesseg;
    }




    public void tamad(Egyseg tamadottEgyseg){
        int sebzes = this.minSebzes*10*this.hanyDb;
        csokkentEletero(sebzes);
    }

    private void csokkentEletero(int sebzes){
        setEletero(eletero*hanyDb - sebzes);
    }




    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getMinSebzes() {
        return minSebzes;
    }

    public void setMinSebzes(int sebzes) {
        this.minSebzes = sebzes;
    }

    public int getMaxSebzes() {
        return maxSebzes;
    }

    public void setMaxSebzes(int sebzes) {
        this.maxSebzes = sebzes;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }

    public void setKezdemenyezes(int kezdemenyezes) {
        this.kezdemenyezes = kezdemenyezes;
    }

    public String getSpecialisKepesseg() {
        return specialisKepesseg;
    }

    public void setSpecialisKepesseg(String specialisKepesseg) {
        this.specialisKepesseg = specialisKepesseg;
    }

}
