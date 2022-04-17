package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A program hibát dob, ha a saját egységünket próbáljuk megtámadni.
 * Ezt a hibát kezeli a SajatEgysegetProbalszTamadniException osztály.
 */
public class SajatEgysegetProbalszTamadniException extends RuntimeException {
    public SajatEgysegetProbalszTamadniException() {
        super("A saját egységed próbálod támadni!");
    }
}
