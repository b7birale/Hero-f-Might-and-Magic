package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * Az érvénytelen billentyűbemeneteket (pl. billentyűkombinációkat) kezeli le.
 */
public class EztAGombotNemHasznalhatodException extends RuntimeException {

    public EztAGombotNemHasznalhatodException() {
        super("Ez a gomb nem csinál semmit!");
    }

}
