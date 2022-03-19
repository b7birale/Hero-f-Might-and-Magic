package com.example.heros_of_might_and_magic;

public class Tuzlabda extends Varazslat{
    public Tuzlabda() {
        this.nev = "Tuzlabda";
        this.ar = 120;
        this.manna = 9;
        this.leiras = "Egy kivalasztott mezo koruli 3x3-as területen levo osszes" +
                " (sajat, illetve ellenseges) egysegre (varazsero * 20) sebzes okozasa\n";
    }

    //@Override
    public void hasznal(int varazsero){     //parameterbe majd a Sarkanyharcos.varazsero jon
        //sebzes = varazsero*20
    }
}
