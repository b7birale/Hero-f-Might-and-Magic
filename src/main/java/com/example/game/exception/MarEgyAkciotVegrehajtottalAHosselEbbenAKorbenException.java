package com.example.game.exception;

public class MarEgyAkciotVegrehajtottalAHosselEbbenAKorbenException extends RuntimeException {
    public MarEgyAkciotVegrehajtottalAHosselEbbenAKorbenException() {
        super("Már egy akciót végre hajtottál a hőssel ebben a körben");
    }
}
