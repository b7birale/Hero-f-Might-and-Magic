package com.example.game.exception;

/**
 * Futásidejű exception osztály, arra az esetre, ha a hőssel egy kör alatt többször is megpróbálnánk valamilyen
 *  cselekvést végezni (támadni vagy varázsolni).
 */
public class KoronkentCsakEgyszerCselekedhetszAHosselException extends RuntimeException {
    public KoronkentCsakEgyszerCselekedhetszAHosselException() {
        super("Egy körben csak egyszer használhatod a hősödet!");
    }
}
