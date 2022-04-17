package com.example.game.exception;

/**
 * Futásidejű exception osztály, arra az esetre, ha a hőssel egy kör alatt másodjára is megpróbálnánk valamilyen
 *  cselekvést végezni (támadni vagy varázsolni).
 */
public class MarEgyAkciotVegrehajtottalAHosselEbbenAKorbenException extends RuntimeException {
    public MarEgyAkciotVegrehajtottalAHosselEbbenAKorbenException() {
        super("Már egy akciót végre hajtottál a hőssel ebben a körben");
    }
}
