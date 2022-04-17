package com.example.game.exception;

/**
 * Futásidejű Exception osztály.
 * A program hibát dob, ha olyan varázslatot akrunk használni, amihez már nem maradt elég mannánk.
 * Ezt a hibát kezeli le a NincsElegMannadAVarazslathozException osztály.
 */
public class NincsElegMannadAVarazslathozException extends RuntimeException {
    public NincsElegMannadAVarazslathozException() {
        super("Nincs elég mannád!");
    }
}
