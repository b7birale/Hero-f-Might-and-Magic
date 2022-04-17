package com.example.game.exception;

/**
 * Futásideű exception osztály.
 * Lekezeli, hogy csak a közvetlen mellettünk lévő egységeket tudjuk megtámadni, a távolabbiakat ne.
 */
public class OlyanEgysegetProbalszTamadniAmiNincsAKozvetlenKozeledbenException extends RuntimeException {
    public OlyanEgysegetProbalszTamadniAmiNincsAKozvetlenKozeledbenException() {
        super("Túl messze van a megtámadni kívant egység!");
    }
}
