package com.example.heros_of_might_and_magic;

public class MagicArrow extends Varazslat {

    public MagicArrow() {
        this.nev = "Magikus nyilvesszo";
        this.ar = 50;
        this.manna = 15;
        this.leiras = "(10/20/30 + (varazsero x 10)) sebzést végez egy kiválasztott ellenséges egységen\n";
    }

    //@Override
    public void hasznal(int varazsero){     //parameterbe majd a Sarkanyharcos.varazsero jon
        //sebzes = varazsero*10 + 10/20/30
    }
}
