package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * Az érvénytelen billentyűbemeneteket (pl. billentyűkombinációkat) kezeli le.
 */
public class ErvenytelenBillenytuBemenetException extends RuntimeException {

    public ErvenytelenBillenytuBemenetException() {
        super("Ez a billentyű nem csinál semmit!");
    }

}
