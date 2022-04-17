package com.example.game.exception;

/**
 * Futásidejű exception osztály.
 * A program hibát dob, ha egy egységgel megpróbálunk megtámadni egy tőlünk távol lévő egységet.
 * (A "távol" itt azt jelenti, hogy nem az egység körüli 3x3-as területen van a megtámadni kívánt egység.)
 * A program akkor is hibát dob, ha ezt egy íjász vagy sárkány egységgel próbáljuk megtenni úgy,
 *  hogy közben van legalább egy ellenséges egység a közvetlen környezetünkben.
 *  Ezt a hibát kezeli le a TavolsagiTamadastProbalszInditaniPedigVanEllensegesEgysegAKozeledbenException osztály.
 */
public class TavolsagiTamadastProbalszInditaniPedigVanEllensegesEgysegAKozeledbenException extends  RuntimeException{
    public TavolsagiTamadastProbalszInditaniPedigVanEllensegesEgysegAKozeledbenException() {
        super("Nem tudsz távolsági támadást indítani, mert ellenséges egység van a közvetlen közeledben!");
    }
}
