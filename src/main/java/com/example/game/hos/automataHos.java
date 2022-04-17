package com.example.game.hos;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.*;
import com.example.game.hos.egysegek.emberek.*;
import com.example.game.hos.egysegek.repulol_lenyek.*;
import com.example.game.hos.varazslatok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Egy a program által irányított hőst valósít meg.
 * Tulajdonságait, egységeit és varázslatait a program határozza meg/generálja le.
 */
public class automataHos extends Hos {

    private final Random rand = new Random();
    private double aranyInverz;

    private double ar;
    private int tulajdonsagpontokSzama;

    List<Pozicio> foglaltPoziciok;
    List<Egyseg> lehetsegesEgysegek;
    List<Varazslat> lehetsegesVarazslatok;

    public automataHos(String frakcio) {

        super(1,1,1,1,1,1,10, "red");
        this.aranyInverz = 0;
        this.ar = 5.0;

        egysegek = new ArrayList<>();
        varazslatok = new ArrayList<>();
        foglaltPoziciok = new ArrayList<>();
        lehetsegesEgysegek = new ArrayList<>();
        lehetsegesVarazslatok = new ArrayList<>();


        if(frakcio.equals("ember")){
            lehetsegesEgysegek.add(new Ijasz(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Foldmuves(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Grof(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Polgar(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Lovag(this, generalVeletlenDarabszam(), generalRandomPozicio()));
        }
        if(frakcio.equals("eloholt")){
            lehetsegesEgysegek.add(new Demon(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Szellem(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Vampir(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Zombi(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Verfarkas(this, generalVeletlenDarabszam(), generalRandomPozicio()));

        }
        if(frakcio.equals("repuloLeny")){
            lehetsegesEgysegek.add(new Griff(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Sarkany(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Pteranodon(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Fonix(this, generalVeletlenDarabszam(), generalRandomPozicio()));
            lehetsegesEgysegek.add(new Pegazus(this, generalVeletlenDarabszam(), generalRandomPozicio()));
        }


        lehetsegesVarazslatok.add(new Villamcsapas(this));
        lehetsegesVarazslatok.add(new Feltamasztas(this));
        lehetsegesVarazslatok.add(new Tuzlabda(this));
        lehetsegesVarazslatok.add(new MagicArrow(this));
        lehetsegesVarazslatok.add(new Erosites(this));


        valasztRandomEgysegeket();
        valasztRandomVarazslatokat();
        vasarolTulajdonsagpontokatVeletlenszeruen();
    }

    @Override
    public boolean gepIranyitja() {
        return true;
    }


    /**
     * Egységeket generál magának random pozíciókon. A lehetséges egységek közül random választ.
     */
    private void valasztRandomEgysegeket() {
        for (int i = 0; i < lehetsegesEgysegek.size(); i++) {
            if (aranyInverz < 700) {
                int randomSzam = rand.nextInt(0, lehetsegesEgysegek.size());
                if (!egysegek.contains(lehetsegesEgysegek.get(randomSzam))) {
                    egysegek.add(lehetsegesEgysegek.get(randomSzam));
                    aranyInverz = aranyInverz + lehetsegesEgysegek.get(randomSzam).getAr() * lehetsegesEgysegek.get(randomSzam).hanyDb();
                }
            }
        }
    }

    /**
     * A varázslatok közül is választ magának néhányat véletlenszerűen.
     */
    private void valasztRandomVarazslatokat() {
        for (int i = 0; i < lehetsegesVarazslatok.size(); i++) {
            if (aranyInverz < 200) {
                int randomSzam = rand.nextInt(0, lehetsegesVarazslatok.size());
                if (!varazslatok.contains(lehetsegesVarazslatok.get(randomSzam))) {
                    varazslatok.add(lehetsegesVarazslatok.get(randomSzam));
                    aranyInverz = aranyInverz + lehetsegesVarazslatok.get(randomSzam).getAr();
                }
            }
        }
    }

    /**
     * Legenerál egy véletlen számot 10 és 25 között, melyek majd a legenerált egységek elemszámai/darabszámai lesznek.
     * @return EGy véletlen egész szám.
     */
    private int generalVeletlenDarabszam() {
        return rand.nextInt(10, 25);
    }

    /**
     * Random poziciot generalo metodus
     * Ellenorzi, hogy azonos poziciora nem tehet ket kulonbozo egyseget
     *
     * @return a legeneralt pozicioval ter vissza
     */
    private Pozicio generalRandomPozicio() {
        Pozicio pozicio = new Pozicio(rand.nextInt(0, 10), rand.nextInt(10, 12));
        while (foglaltPoziciok.contains(pozicio)) {
            pozicio = new Pozicio(rand.nextInt(0, 10), rand.nextInt(10, 12));
        }
        foglaltPoziciok.add(pozicio);
        return pozicio;
    }

    private double arSzamitas(){
        if(tulajdonsagpontokSzama == 1){
            ar = 5.0;
            tulajdonsagpontokSzama++;
            return 5.0;
        } else {
            ar = ar * 1.1;
            tulajdonsagpontokSzama++;
            return Math.ceil(ar);
        }
    }

    private void vasarolTulajdonsagpontokatVeletlenszeruen() {
        while (aranyInverz <= 1000 - ar) {
            int generalRandomSzam = rand.nextInt(0, 7);

            switch (generalRandomSzam) {
                case 1:
                    if(this.getTamadas() < 10){
                        this.setTamadas(getTamadas() + 1);
                        aranyInverz = aranyInverz + arSzamitas();
                        break;
                    }
                case 2:
                    if(this.getVedekezes() < 10) {
                        this.setVedekezes(getVedekezes() + 1);
                        aranyInverz = aranyInverz + arSzamitas();
                        break;
                    }
                case 3:
                    if(this.getVarazsero() < 10) {
                        this.setVarazsero(getVarazsero() + 1);
                        aranyInverz = aranyInverz + arSzamitas();
                        break;
                    }
                case 4:
                    if(this.getTudas() < 10) {
                        this.setTudas(getTudas() + 1);
                        aranyInverz = aranyInverz + arSzamitas();
                        break;
                    }
                case 5:
                    if(this.getMoral() < 10) {
                        this.setMoral(getMoral() + 1);
                        aranyInverz = aranyInverz + arSzamitas();
                        break;
                    }
                case 6:
                    if(this.getSzerencse() < 10) {
                        this.setSzerencse(getSzerencse() + 1);
                        aranyInverz = aranyInverz + arSzamitas();
                        break;
                    }
            }
        }
    }

}
