package com.example.game.hos;

import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.*;
import com.example.game.hos.egysegek.emberek.*;
import com.example.game.hos.egysegek.frakciok.controller.FrakcioController;
import com.example.game.hos.egysegek.repulol_lenyek.*;
import com.example.game.hos.varazslatok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Egy a program által irányított hőst valósít meg.
 * Tulajdonságait, egységeit és varázslatait a program határozza meg.
 */
public class GepiHos extends Hos {

    private final Random rand = new Random();
    private double arany;

    private double ar;
    private int kepessegszam;

    List<Pozicio> meglevoPoziciok;
    List<Egyseg> valaszthatoEgysegek;
    List<Varazslat> valaszthatoVarazslatok;

    public GepiHos(String frakcio) {

        super(1,1,1,1,1,1,10);
        this.arany = 0;
        this.ar = 5.0;

        egysegek = new ArrayList<>();
        varazslatok = new ArrayList<>();
        meglevoPoziciok = new ArrayList<>();
        valaszthatoEgysegek = new ArrayList<>();
        valaszthatoVarazslatok = new ArrayList<>();

        this.tamadas = rand.nextInt(1, 10);
        this.vedekezes = rand.nextInt(1, 10);
        this.tudas = rand.nextInt(1, 10);
        this.moral = rand.nextInt(1, 10);
        this.varazsero = rand.nextInt(1, 10);
        this.szerencse = rand.nextInt(1, 10);
        this.manna = 0;

        if(frakcio.equals("ember")){
            valaszthatoEgysegek.add(new Ijasz(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Foldmuves(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Grof(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Polgar(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Lovag(this, generalDarab(), generalPozicio()));
        }
        if(frakcio.equals("eloholt")){
            valaszthatoEgysegek.add(new Demon(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Szellem(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Vampir(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Zombi(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Verfarkas(this, generalDarab(), generalPozicio()));

        }
        if(frakcio.equals("repuloLeny")){
            valaszthatoEgysegek.add(new Griff(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Sarkany(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Pteranodon(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Fonix(this, generalDarab(), generalPozicio()));
            valaszthatoEgysegek.add(new Pegazus(this, generalDarab(), generalPozicio()));
        }


        valaszthatoVarazslatok.add(new Villamcsapas(this));
        valaszthatoVarazslatok.add(new Feltamasztas(this));
        valaszthatoVarazslatok.add(new Tuzlabda(this));
        valaszthatoVarazslatok.add(new MagicArrow(this));
        valaszthatoVarazslatok.add(new Teleport(this));


        valasztEgysegek();
        valasztVarazslatok();
        generalTulajdonsag();
    }

    @Override
    public boolean isGep() {
        return true;
    }

    @Override
    public void automatanVegrehajt() {
        System.out.println("leptem");
    }

    /**
     * Egysegvalasztas a valaszthato egysegek listabol, amiben benne van az osszes egyseg random darabszammal, random pozicion
     */
    private void valasztEgysegek() {
        for (int i = 0; i < valaszthatoEgysegek.size(); i++) {
            if (arany < 500) {
                int index = rand.nextInt(0, valaszthatoEgysegek.size());
                if (!egysegek.contains(valaszthatoEgysegek.get(index))) {
                    arany = arany + valaszthatoEgysegek.get(index).getAr() * valaszthatoEgysegek.get(index).hanyDb();
                    egysegek.add(valaszthatoEgysegek.get(index));
                }
            }
        }
    }

    /**
     * Varazslatok kivalasztasara szolgalo metodus, ami a meglevo valaszthatoVarazslatok listabol valaszt random varazslatokat,
     * amiben benne van az osszes varazslat
     */
    private void valasztVarazslatok() {
        for (int i = 0; i < valaszthatoVarazslatok.size(); i++) {
            if (arany < 800) {
                int varazslatIndex = rand.nextInt(0, valaszthatoVarazslatok.size());
                if (!varazslatok.contains(valaszthatoVarazslatok.get(varazslatIndex))) {
                    arany = arany + valaszthatoVarazslatok.get(varazslatIndex).getAr();
                    varazslatok.add(valaszthatoVarazslatok.get(varazslatIndex));
                }
            }
        }
    }

    /**
     * Random darabszamot generalo metodus
     *
     * @return a random darabszammal ter vissza
     */
    private int generalDarab() {
        return rand.nextInt(10, 25);
    }

    /**
     * Random poziciot generalo metodus
     * Ellenorzi, hogy azonos poziciora nem tehet ket kulonbozo egyseget
     *
     * @return a legeneralt pozicioval ter vissza
     */
    private Pozicio generalPozicio() {
        Pozicio pozicio = new Pozicio(rand.nextInt(0, 10), rand.nextInt(10, 12));
        while (meglevoPoziciok.contains(pozicio)) {
            pozicio = new Pozicio(rand.nextInt(0, 10), rand.nextInt(10, 12));
            System.out.println(pozicio);
        }
        meglevoPoziciok.add(pozicio);
        return pozicio;
    }

    //?
    private double arSzamitas(){
        if(kepessegszam == 1){
            ar = 5.0;
            kepessegszam++;
            return 5.0;
        } else {
            ar = ar * 1.1;
            kepessegszam++;
            return Math.ceil(ar);
        }
    }

    private void generalTulajdonsag() {
        while (arany <= 1000 - ar) {
            int generalRandomSzam = rand.nextInt(0, 7);

            switch (generalRandomSzam) {
                case 1:
                    this.setTamadas(getTamadas() + 1);
                    arany = arany + arSzamitas();
                    break;
                case 2:
                    this.setVedekezes(getVedekezes() + 1);
                    arany = arany + arSzamitas();
                    break;
                case 3:
                    this.setVarazsero(getVarazsero() + 1);
                    arany = arany + arSzamitas();
                    break;
                case 4:
                    this.setTudas(getTudas() + 1);
                    arany = arany + arSzamitas();
                    break;
                case 5:
                    this.setMoral(getMoral() + 1);
                    arany = arany + arSzamitas();
                    break;
                case 6:
                    this.setSzerencse(getSzerencse() + 1);
                    arany = arany + arSzamitas();
                    break;
            }
        }
    }

}
