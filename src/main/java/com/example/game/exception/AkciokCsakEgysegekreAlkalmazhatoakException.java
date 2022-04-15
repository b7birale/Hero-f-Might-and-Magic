package com.example.game.exception;

public class AkciokCsakEgysegekreAlkalmazhatoakException extends RuntimeException {
    public AkciokCsakEgysegekreAlkalmazhatoakException() {
        super("Az akciók csak egységekre alkalmazhatóak");
    }
}
