package com.example.heros_of_might_and_magic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;

public class Eloholt extends Egyseg{

    @FXML
    private Text arany;
    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }

    /*

    @FXML
    private TextField TF_demon;
    @FXML
    private TextField TF_zombi;
    @FXML
    private TextField TF_vampir;
    @FXML
    private TextField TF_szellem;
    @FXML
    private TextField TF_verfarkas;


    public int demonSzam;
    //public int zombiSzam;
    //public int vampirSzam;
    //public int szellemSzam;
    //public int verfarkasSzam;


    @FXML
    private Text mennyisegDemon;


    public void megveszemDemon(ActionEvent event) throws IOException {
        demonSzam += Integer.parseInt(TF_demon.getText());
        SceneController.arany = SceneController.arany - Integer.parseInt(TF_demon.getText())*6;
        arany.setText(String.valueOf(SceneController.arany));
        mennyisegDemon.setText(String.valueOf(demonSzam));
    }

    */






}
