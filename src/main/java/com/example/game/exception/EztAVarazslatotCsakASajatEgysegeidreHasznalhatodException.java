package com.example.game.exception;

/**
 * Futásidejű exception osztály.
 * Azt a hibát kezeli le, mikor egy olyan varázslatot próbálunk egy ellenséges egységre alkalmazni,
 *  amit csak a sajátunkra lehet. (Ilyen varázslat pl. a feltámasztás.)
 */
public class EztAVarazslatotCsakASajatEgysegeidreHasznalhatodException extends RuntimeException {
    public EztAVarazslatotCsakASajatEgysegeidreHasznalhatodException() {
        super("Ezt a varázslatot csak a saját egységeidre használhatod");
    }
}
