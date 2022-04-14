package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A program hibát dob, ha olyan helyen (pl. pályán kívűl vagy üres mezőn)
 *  próbálunk alkalmazni egy varázslatot, amit nem lehet.
 * Ezt a hibát kezeli le a VarazslatokCsakEgysegekreAlkalmazhatoakException osztály.
 */
public class VarazslatokCsakEgysegekreAlkalmazhatoakException extends RuntimeException {
    public VarazslatokCsakEgysegekreAlkalmazhatoakException() {
        super("A varázslatok csak egységekre alkalmazhatóak!");
    }
}
