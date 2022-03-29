package com.example.heros_of_might_and_magic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Eloholt extends Egyseg{

    /*
    public int demonSzam;
    public int zombiSzam;
    public int vampirSzam;
    public int szellemSzam;
    public int verfarkasSzam;

     */

    public Eloholt() {
        this.nev = "egyseg";
        this.ar = 0;
        this.minSebzes = 0;
        this.maxSebzes = 0;
        this.eletero = 0;
        this.sebesseg = 0;
        this.kezdemenyezes = 0;
        this.specialisKepesseg = "nincs";
    }

    public Eloholt(String nev, int ar, int minSebzes, int maxSebzes, int eletero, int sebesseg, int kezdemenyezes, String specialisKepesseg) {
        super(nev, ar, minSebzes, maxSebzes, eletero, sebesseg, kezdemenyezes, specialisKepesseg);
    }
}
