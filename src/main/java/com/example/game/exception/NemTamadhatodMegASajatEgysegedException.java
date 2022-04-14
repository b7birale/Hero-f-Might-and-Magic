package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A program hibát dob, ha a saját egységünket próbáljuk megtámadni.
 * Ezt a hibát kezeli a NemTamadhatodMegASajatEgysegedException osztály.
 */
public class NemTamadhatodMegASajatEgysegedException extends RuntimeException {
    public NemTamadhatodMegASajatEgysegedException() {
        super("Nem támadhatod meg a saját egységed");
    }
}
