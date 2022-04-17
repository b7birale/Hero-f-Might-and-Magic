package com.example.game.exception;

/**
 * Exception osztály, arra az esetre, amikor a hőssel támadnánk vagy varázsolnánk,
 *  de olyan mezőre kattintunk, amelyen nem helyezkedik el egység.
 */
public class NemEgysegreProbalszAkciotVegrehajtaniException extends RuntimeException {
    public NemEgysegreProbalszAkciotVegrehajtaniException() {
        super("Az egyes akciók csak egységekre alkalmazhatóak!");
    }
}
