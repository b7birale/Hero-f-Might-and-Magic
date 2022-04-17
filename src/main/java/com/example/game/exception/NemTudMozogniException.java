package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A játékos csak a pályán belül léphet az egységeivel, maximum csak annyit,
 *  amennyi az adott egység sebessége. Emellett nem léphet olyan mezőre, ahol már áll egy egység.
 * Ezekkel a hibákkal foglalkozik a NemTudMozogniException osztály.
 */
public class NemTudMozogniException extends RuntimeException{

    public NemTudMozogniException() {
        super("Oda nem léphetsz!");
    }

}
