package com.example.game.exception;

/** Futásidejű Exception osztály.
 * A programnak tudnia kell kezelni, hogy ha valamelyik varázslatot nem vetted meg,
 *  akkor azt ne tudd hasznáni, ne legyen kiírva, ne dolgozzon vele a program.
 *  Erre való a NincsAdottTipusuVarazslatodException osztály.
 */
public class NincsAdottTipusuVarazslatException extends Exception {

    public NincsAdottTipusuVarazslatException() {
        super("Ilyen varázslatod nincsen!");
    }

}
