package com.example.game.hos.egysegek;

import com.example.game.exception.NemTamadhatodMegASajatEgysegedException;
import com.example.game.hos.Hos;

import java.util.Random;

import static java.lang.Math.ceil;

/**
 * Egy egységet valósít meg. A különböző egységek ősosztályaként szolgál.
 */
public class Egyseg implements Comparable<Egyseg> {

    protected String nev;
    protected int ar;   //itt minden protected!
    public int jelenlegiEletero;    // public-ra írta át miután packeage-eltem, hogy kellene packeage.elni, hogy újra protected lehessen?
    protected int eredetiEletero;
    protected int minSebzes;
    protected int maxSebzes;
    protected int eletero;
    protected int sebesseg;
    protected Integer kezdemenyezes;
    protected String specialisKepesseg;
    public Pozicio pozicio;
    public Hos hos;
    protected String szin;


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

    public Egyseg(Hos hos, String nev, int ar, int minSebzes, int maxSebzes, int eletero, int sebesseg,
                  int kezdemenyezes, String specialisKepesseg, int jelenlegiEletero, String szin, Pozicio pozicio) {
        this.hos = hos;
        this.nev = nev;
        this.ar = ar;
        this.minSebzes = minSebzes;
        this.maxSebzes = maxSebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
        this.specialisKepesseg = specialisKepesseg;
        this.jelenlegiEletero = jelenlegiEletero;
        this.eredetiEletero = jelenlegiEletero;      //osszEletero fogy, eredetiEletero nem változik
        this.szin = szin;
        this.pozicio = pozicio;
    }


    /**
     * Visszaadja él-e még az adott egység vagy már halott.
     * @return true, ha halott az egység, false, ha még él
     */
    public boolean halottE(){
        return jelenlegiEletero <= 0;
    }

    /**
     * Sebzést hajt végre az adott egységen.
     * Levonja az adott egység jelenlegi, összesített életerejéből a sebzés mértékét.
     * Amennyiben ez több, mint az életerő, úgy nullára állítja az életerőt.
     * Ezzel biztosítja, hogy az életerő ne lehessen negatív szám.
     * @param mennyivel A sebzés mértéke.
     */
    public void sebez(int mennyivel){
        if(this.jelenlegiEletero - mennyivel >= 0 ){
            this.jelenlegiEletero -= mennyivel;
        }
        else{
            this.jelenlegiEletero = 0;
        }
    }

    /**
     * Megnöveli az adott egység életerejét a paraméterben kapott értékkel vagy visszaállítja azt az eredeti értékérére.
     * Azt választja, amelyik esetben kisebb lesz az életerő a gyógyítás után.
     * @param mennyivel A gyógyítás maximális mértéke.
     */
    public void gyogyit(int mennyivel){
        this.jelenlegiEletero = Math.min(eredetiEletero, this.jelenlegiEletero + mennyivel);
    }

    //random szám generátor
    private Random rand = new Random();

    /**
     * Kiszámolja hány elem (ember/lény/állat) van az adott egységben.
     * @return Hány darab elem van az adott egységben.
     */
    public int hanyDb(){
        if( this.jelenlegiEletero % this.eletero > 0){
            return ( (this.jelenlegiEletero / this.eletero) +1);
        }
        else{
            return (this.jelenlegiEletero / this.eletero);
        }
    }

    /**
     * Kiszámítja a sebzés mértékét.
     * Függ a támadó egységet birtokló hős támadás tulajdonságától és a támadott egységet birtokló hős védekezés tulajdonságától.
     * @param ellenfelEgyseg A megtámadandó egység.
     * @return A sebzés értéke. Mindig egész szám.
     */
    public int szamolSebzes(Egyseg ellenfelEgyseg){
        double alapsebzes = rand.nextInt(this.minSebzes, this.maxSebzes) * hanyDb(); //this.jelenlegiEletero;
        double sebzes = alapsebzes + alapsebzes*((double)hos.getTamadas()/10); //hős támadástulajdonsága (%-ot ad meg) -> pl: tamadas=7 -> ... * 1.7
        sebzes = sebzes * ((double)ellenfelEgyseg.getHos().getVedekezes()/10);    //ellenfelhos vedekezese (%) -> pl: vedekezes=5 -> sebzes * 0,5 (50%)
        return (int) ceil(sebzes);
    }

    /*
    public void tamad(Egyseg tamadottEgyseg){
        tamadottEgyseg.sebez(szamolSebzes(tamadottEgyseg));
    }

     */

    public boolean isEllenfelEgysegE(Egyseg egyseg){
        return this.hos != egyseg.getHos();
    }

    public void tamad(Egyseg ellenfelEgyseg) {
        if(!isEllenfelEgysegE(ellenfelEgyseg)){
            throw new NemTamadhatodMegASajatEgysegedException();
        }
        ellenfelEgyseg.sebez(szamolSebzes(ellenfelEgyseg));
    }


    public void visszaTamad(int tamadas, Hos ellenfel, Egyseg tamadottEgyseg){
        //ugyanaz mint a támad, csak sebzés = sebzés/2
        double alapsebzes = rand.nextInt(this.minSebzes, this.maxSebzes) * hanyDb(); //this.jelenlegiEletero;
        double sebzes = alapsebzes + alapsebzes*((double)tamadas/10); //hős támadástulajdonsága (%-ot ad meg) -> pl: tamadas=7 -> ... * 1.7
        sebzes = sebzes * ((double)ellenfel.vedekezes/10);    //ellenfelhos vedekezese (%) -> pl: vedekezes=5 -> sebzes * 0,5 (50%)
        int vegeredmeny = (int) ceil(sebzes/2);
        //tamadottEgyseg.csokkentEletero(vegeredmeny);  //Mi a különbség csökkentÉleterő és sebez() közt?
        tamadottEgyseg.sebez(vegeredmeny);
    }

    public boolean vajonKritikusSebzes(int szerencse){
        Random random = new Random();
        int chance = 0;
        chance += szerencse*5;
        chance = 100/chance;
        return random.nextInt(chance) == 0;
    }

    /**
     * Kiszamolja a kritikus sebzést és végre is hajtja azt az ellenséges egységen.
     * @param tamadas A támadó egység hősének támadás tulajdonsága.
     * @param ellenfel A megtámadott egység hőse, azaz az ellenséges hős.
     * @param tamadottEgyseg A megtámadott egység.
     */
    public void kritikusSebzes(int tamadas, Hos ellenfel, Egyseg tamadottEgyseg){
        //ugyanaz mint a támad, csak sebzés = sebzés*2
        //hogyan függ a szerencse tulajdonságtól?
        //5%
        //+5%
        double alapsebzes = rand.nextInt(this.minSebzes, this.maxSebzes) * hanyDb(); //this.jelenlegiEletero;
        double sebzes = alapsebzes + alapsebzes*((double)tamadas/10); //hős támadástulajdonsága (%-ot ad meg) -> pl: tamadas=7 -> ... * 1.7
        sebzes = sebzes * ((double)ellenfel.vedekezes/10);    //ellenfelhos vedekezese (%) -> pl: vedekezes=5 -> sebzes * 0,5 (50%)
        int vegeredmeny = (int) ceil(sebzes*2);
        tamadottEgyseg.sebez(vegeredmeny);
    }

    /*
    public boolean tavolsagiTamadas(){

        //visszaadja, hogy van-e a közvetlen környezetében más egység
        //ha nincs, akkor indítható távolsági támadás

        Pozicio eredeti = this.pozicio;
        Pozicio vizsgalando = new Pozicio(eredeti.getSor(), eredeti.getOszlop());

        vizsgalando.setOszlop(vizsgalando.getOszlop()-1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        vizsgalando.setOszlop(vizsgalando.getOszlop()+1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        vizsgalando.setSor(vizsgalando.getSor()+1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        vizsgalando.setSor(vizsgalando.getSor()-1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        vizsgalando.setSor(vizsgalando.getSor()+1);
        vizsgalando.setOszlop(vizsgalando.getOszlop()+1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        vizsgalando.setSor(vizsgalando.getSor()-1);
        vizsgalando.setOszlop(vizsgalando.getOszlop()+1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        vizsgalando.setSor(vizsgalando.getSor()+1);
        vizsgalando.setOszlop(vizsgalando.getOszlop()-1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        vizsgalando.setSor(vizsgalando.getSor()-1);
        vizsgalando.setOszlop(vizsgalando.getOszlop()-1);
        //if(vizsgalando pozicion van egyseg){return  false;}
        vizsgalando = eredeti;

        return true;

        //probléma: ez minden egységet néz, de csak az ellenséges kellene, hogy számítson

    }
     */


    public boolean kozelharciTamadas(Egyseg tamadottEgyseg){
        return Math.abs(tamadottEgyseg.pozicio.getOszlop() - this.pozicio.getOszlop()) <= 1 &&
                Math.abs(tamadottEgyseg.pozicio.getSor() - this.pozicio.getSor()) <= 1;
        // = a támadott egység a közvetlen közelében van, így indítható közelharci támadás
    }

    public boolean isGep(){
        return hos.isGep();
    }

    @Override
    public int compareTo(final Egyseg o) {
        return o.kezdemenyezes.compareTo(this.kezdemenyezes);
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

    public int getJelenlegiEletero() {
        return jelenlegiEletero;
    }

    public void setJelenlegiEletero(int jelenlegiEletero) {
        this.jelenlegiEletero = jelenlegiEletero;
    }

    public int getEredetiEletero() {
        return eredetiEletero;
    }

    public void setEredetiEletero(int eredetiEletero) {
        this.eredetiEletero = eredetiEletero;
    }

    public Pozicio getPozicio() {
        return pozicio;
    }

    public void setPozicio(Pozicio pozicio) {
        this.pozicio = pozicio;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Hos getHos() {
        return hos;
    }

    public void setHos(Hos hos) {
        this.hos = hos;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }
}
