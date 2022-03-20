package com.example.heros_of_might_and_magic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class Eloholt extends Egyseg{

    @FXML
    private Text arany;
    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }



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
    public int zombiSzam;
    public int vampirSzam;
    public int szellemSzam;
    public int verfarkasSzam;


    @FXML
    private Text mennyisegDemon;
    @FXML
    private Text mennyisegZombi;
    @FXML
    private Text mennyisegVampir;
    @FXML
    private Text mennyisegSzellem;
    @FXML
    private Text mennyisegVerfarkas;


    public void megveszemDemon(ActionEvent event) throws IOException {
        demonSzam += Integer.parseInt(TF_demon.getText());
        SceneController.arany = SceneController.arany - Integer.parseInt(TF_demon.getText())*6; // 6 = démon ára
        arany.setText(String.valueOf(SceneController.arany));
        mennyisegDemon.setText(String.valueOf(demonSzam));
    }

    public void megveszemZombi(ActionEvent event) throws IOException {
        zombiSzam += Integer.parseInt(TF_zombi.getText());
        SceneController.arany = SceneController.arany - Integer.parseInt(TF_zombi.getText())*12; // 12 = zombi ára
        arany.setText(String.valueOf(SceneController.arany));
        mennyisegZombi.setText(String.valueOf(zombiSzam));
    }

    public void megveszemVampir(ActionEvent event) throws IOException {
        vampirSzam += Integer.parseInt(TF_vampir.getText());
        SceneController.arany = SceneController.arany - Integer.parseInt(TF_vampir.getText())*7;
        arany.setText(String.valueOf(SceneController.arany));
        mennyisegVampir.setText(String.valueOf(vampirSzam));
    }

    public void megveszemSzellem(ActionEvent event) throws IOException {
        szellemSzam += Integer.parseInt(TF_szellem.getText());
        SceneController.arany = SceneController.arany - Integer.parseInt(TF_szellem.getText())*8;
        arany.setText(String.valueOf(SceneController.arany));
        mennyisegSzellem.setText(String.valueOf(szellemSzam));
    }

    public void megveszemVerfarkas(ActionEvent event) throws IOException {
        verfarkasSzam += Integer.parseInt(TF_verfarkas.getText());
        SceneController.arany = SceneController.arany - Integer.parseInt(TF_verfarkas.getText())*15;
        arany.setText(String.valueOf(SceneController.arany));
        mennyisegVerfarkas.setText(String.valueOf(verfarkasSzam));
    }








}
