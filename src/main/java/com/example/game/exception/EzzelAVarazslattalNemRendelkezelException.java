package com.example.game.exception;

/** Futásidejű Exception osztály.
 * A programnak tudnia kell kezelni, hogy ha valamelyik varázslatot nem vetted meg,
 *  akkor azt ne tudd hasznáni és ne legyen kiírva sem a varázslataid között.
 *  Erre való az EzzelAVarazslattalNemRendelkezelException osztály.
 */
public class EzzelAVarazslattalNemRendelkezelException extends RuntimeException {

    public EzzelAVarazslattalNemRendelkezelException() {
        super("Ilyen varázslatot nem vettél!");
    }

}
