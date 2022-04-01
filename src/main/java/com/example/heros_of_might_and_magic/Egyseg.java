package com.example.heros_of_might_and_magic;

import static java.lang.Math.ceil;

public class Egyseg {

    protected String nev;
    protected int ar;   //itt minden protected!
    protected int jelenlegiEletero;
    protected int eredetiEletero;
    protected int minSebzes;
    protected int maxSebzes;
    protected int eletero;
    protected int sebesseg;
    protected int kezdemenyezes;
    protected String specialisKepesseg;
    protected Pozicio pozicio;


    public Egyseg() {
        this.nev = "egyseg";
        this.ar = 0;
        this.jelenlegiEletero = 0;
        this.minSebzes = 0;
        this.maxSebzes = 0;
        this.eletero = 0;
        this.sebesseg = 0;
        this.kezdemenyezes = 0;
        this.specialisKepesseg = "nincs";
    }
    //?
    public Egyseg(String nev, int ar, int minSebzes, int maxSebzes, int eletero, int sebesseg, int kezdemenyezes, String specialisKepesseg, int osszEletero) {
        this.nev = nev;
        this.ar = ar;
        this.minSebzes = minSebzes;
        this.maxSebzes = maxSebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
        this.specialisKepesseg = specialisKepesseg;
        this.jelenlegiEletero = osszEletero;
        this.eredetiEletero = osszEletero;      //osszEletero fogy, eredetiEletero nem változik
    }


    public void mozgas(){
        this.pozicio.setSor(this.pozicio.getSor()-1);
        this.pozicio.setOszlop(this.pozicio.getOszlop()+1);
    }

    public void sebez(int mennyivel){
        this.jelenlegiEletero -= mennyivel;
    }

    public void gyogyit(int mennyivel){
        this.jelenlegiEletero = Math.min(eredetiEletero, this.jelenlegiEletero + mennyivel);
    }

    public void csokkentEletero(int sebzes){
        setEletero(eletero* jelenlegiEletero - sebzes);
    }


    //random szám generátor
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    public void tamad(Egyseg tamadottEgyseg, int tamadas, Hos ellenfel){
        double alapsebzes = getRandomNumber(this.minSebzes, this.maxSebzes) * this.jelenlegiEletero;
        double sebzes = alapsebzes * tamadas; //hős támadástulajdonsága (%-ot ad meg) -> pl: tamadas=7 -> ... * 1.7
        sebzes = sebzes * ellenfel.vedekezes;    //ellenfelhos vedekezese (%) -> pl: vedekezes=5 -> sebzes * 0,5 (50%)
        int vegeredmeny = (int) ceil(sebzes);
    }






    //GETTEREK ÉS SETTEREK ---------------------------------------------------------------------------------------------

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
