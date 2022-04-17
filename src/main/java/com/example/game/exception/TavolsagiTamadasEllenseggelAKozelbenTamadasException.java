package com.example.game.exception;

/**
 * Futásidejű exception osztály.
 * A program hibát dob, ha egy egységgel megpróbálunk megtámadni egy tőlünk távol lévő egységet.
 * (A "távol" itt azt jelenti, hogy nem a közvetlen környezetünkben van.)
 * A program akkor is hibát dob, ha ezt egy íjász egységgel próbáljuk megtenni úgy,
 *  hogy közben van legalább egy ellenséges egység a közvetlen környezetünkben.
 *  Ezt a hibát kezeli le a TavolsagiTamadasEllenseggelAKozelbenTamadasException osztály.
 */
public class TavolsagiTamadasEllenseggelAKozelbenTamadasException extends  RuntimeException{
    public TavolsagiTamadasEllenseggelAKozelbenTamadasException() {
        super("Nem lehet tavolsagi tamadast vegrehajtani ellenseggel a kozelben!");
    }
}
