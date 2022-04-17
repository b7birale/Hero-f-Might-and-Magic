package com.example.game.hos.egysegek;

import java.util.Objects;

import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * Egy pozíciót valósít meg a csatatéren oszlop- és sorszám segítségével.
 */
public class Pozicio {
    private int sor;
    private int oszlop;

    public Pozicio(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
    }

    public  Pozicio osszead(Pozicio pozicio){
        return new Pozicio(sor + pozicio.sor, oszlop + pozicio.oszlop);
    }

    public  Pozicio osszead(int sor, int oszlop){
        return new Pozicio(this.sor + sor, this.oszlop + oszlop);
    }


    public void csokkentOszlop(){
        this.setOszlop(this.getOszlop()-1);
    }
    public void csokkentSor(){
        this.setSor(this.getSor()-1);
    }
    public void novelOszlop(){
        this.setOszlop(this.getOszlop()+1);
    }
    public void novelSor(){
        this.setSor(this.getSor()+1);
    }


    public int tavolsag(Pozicio pozicio) {
        return max(
                abs(this.sor - pozicio.getSor()),
                abs(this.oszlop - pozicio.getOszlop())
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Pozicio pozicio = (Pozicio) o;
        return sor == pozicio.sor && oszlop == pozicio.oszlop;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sor, oszlop);
    }

    //GETTEREK ÉS SETTEREK -------------------------------------------------------------------------------------------

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
