package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A játékos csak a pályán belül léphet az egységeivel, maximum csak annyit,
 *  amennyi az adott egység sebessége. Emellett nem léphet olyan mezőre, ahol már áll egy egység.
 * Ezekkel a hibákkal foglalkozik az OdaNemLephetszException osztály.
 */
public class OdaNemLephetszException extends RuntimeException{

    public OdaNemLephetszException() {
        super("Oda nem tudsz lépni!");
    }

}
