package com.example.heros_of_might_and_magic;

import java.util.Random;

public class Mezo {
    private int egyseg = (new Random()).nextInt(10);

    public Mezo() {
    }

    public String toString() {
        return "Mezo{egyseg=" + this.egyseg + "}";
    }
}
