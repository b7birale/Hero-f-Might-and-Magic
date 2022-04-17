package com.example.game.exception;

/**
 * Exception osztály, arra az esetre, amikor a hőssel támadnánk vagy varázsolnánk,
 *  de olyan mezőre kattintunk, amelyen nem helyezkedik el egység.
 */
public class AkciokCsakEgysegekreAlkalmazhatoakException extends RuntimeException {
    public AkciokCsakEgysegekreAlkalmazhatoakException() {
        super("Az akciók csak egységekre alkalmazhatóak");
    }
}
