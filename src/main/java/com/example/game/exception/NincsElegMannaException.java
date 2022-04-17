package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A program hibát dob, ha olyan varázslatot akrunk használni, amihez már nem maradt elég mannánk.
 * Ezt a hibát kezeli le a NincsElegMannaException osztály.
 */
public class NincsElegMannaException extends RuntimeException {
    public NincsElegMannaException() {
        super("Nincs elég mannád!");
    }
}
