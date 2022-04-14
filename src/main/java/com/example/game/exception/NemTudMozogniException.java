package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A játékos csak a pályán belül léphet az egységeivel, maximum csak annyit,
 *  amennyi az adott egység a sebessége és nem léphet olyan mezőre, ahol már áll egy egység.
 * Ezekkel a hibákkal foglalkozik a NemTudMozogniException osztály.
 */
public class NemTudMozogniException extends Exception{

    public NemTudMozogniException() {
        super("Oda nem léphetsz!");
    }

}
