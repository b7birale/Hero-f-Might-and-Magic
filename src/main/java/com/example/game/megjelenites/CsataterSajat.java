package com.example.game.megjelenites;

public class CsataterSajat {
    private Mezo[][] mezok = new Mezo[12][10];

    public CsataterSajat() {
        for(int i = 0; i < this.mezok.length; ++i) {
            for(int j = 0; j < this.mezok[0].length; ++j) {
                this.mezok[i][j] = new Mezo();
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
