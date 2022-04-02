package com.example.game.megjelenites;

public class Csatater {
    private Mezo[][] mezok = new Mezo[12][10];

    public Csatater() {
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
