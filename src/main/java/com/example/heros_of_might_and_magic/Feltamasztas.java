package com.example.heros_of_might_and_magic;

public class Feltamasztas extends Varazslat{
    public Feltamasztas() {
        this.nev = "Feltamasztas";
        this.ar = 120;
        this.manna = 6;
        this.leiras = "Egy kivalasztott sajat egyseg feltamasztasa." +
                "Maximalis gyogyitas merteke: (varazsero * 50)" +
                "(de az eredeti egysegszamnal több nem lehet)\n";
    }

    //@Override
    public void hasznal(int varazsero){     //parameterbe majd a Sarkanyharcos.varazsero jon
        //max_gyogyitas = varazsero*50
    }

}
