package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A program hibát dob, ha olyan helyen próbálunk alkalmazni egy varázslatot,
 *  ahol nem lehet  (pl. pályán kívűl vagy üres mezőn).
 * Ezt a hibát kezeli le a NemEgysegreProbalodVegrehajtaniAVarazslatotException osztály.
 */
public class NemEgysegreProbalodVegrehajtaniAVarazslatotException extends RuntimeException {
    public NemEgysegreProbalodVegrehajtaniAVarazslatotException() {
        super("A varázslatokat csak egységekre tudod alkalmazni!");
    }
}
