package com.example.game.megjelenites;

public class CsataterSajat {
    private MezoSajat[][] mezok = new MezoSajat[12][10];

    public CsataterSajat() {
        for(int i = 0; i < this.mezok.length; ++i) {
            for(int j = 0; j < this.mezok[0].length; ++j) {
                this.mezok[i][j] = new MezoSajat();
            }
        }

    }

    public void kiiratPalya() {
        for(int i = 0; i < this.mezok.length; ++i) {
            for(int j = 0; j < this.mezok[0].length; ++j) {
                System.out.print(this.mezok[i][j] + " ");
            }

            System.out.println();
        }

    }
}
