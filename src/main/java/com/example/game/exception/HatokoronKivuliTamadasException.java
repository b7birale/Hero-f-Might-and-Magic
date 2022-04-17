package com.example.game.exception;

/**
 * Futásideű exception osztály.
 * Lekezeli, hogy csak a közvetlen mellettünk lévő egységeket tudjuk megtámadni, a távolabbiakat ne.
 */
public class HatokoronKivuliTamadasException extends RuntimeException {
    public HatokoronKivuliTamadasException() {
        super("Hatokoron kivuli tamadas!");
    }
}
