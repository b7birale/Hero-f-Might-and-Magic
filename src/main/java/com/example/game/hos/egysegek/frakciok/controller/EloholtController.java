package com.example.game.hos.egysegek.frakciok.controller;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.eloholtak.*;
import com.example.game.megjelenites.CsataterControllerSajat;
import com.example.game.megjelenites.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class EloholtController {
    Hos hos = new Hos();

    public void setHos(Hos hos) {
        this.hos = hos;
    }

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


    private int demonSzam;
    private int zombiSzam;
    private int vampirSzam;
    private int szellemSzam;
    private int verfarkasSzam;


    @FXML
    private Text nincsElegArany;

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
        if (SceneController.arany - Integer.parseInt(TF_demon.getText())*6 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            demonSzam += Integer.parseInt(TF_demon.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_demon.getText())*6; // 6 = démon ára
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegDemon.setText(String.valueOf(demonSzam));
        }
    }

    public void megveszemZombi(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_zombi.getText())*12 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            zombiSzam += Integer.parseInt(TF_zombi.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_zombi.getText())*12;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegZombi.setText(String.valueOf(zombiSzam));
        }
    }

    public void megveszemVampir(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_vampir.getText())*7 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            vampirSzam += Integer.parseInt(TF_vampir.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_vampir.getText())*7;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegVampir.setText(String.valueOf(vampirSzam));
        }
    }

    public void megveszemSzellem(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_szellem.getText())*8 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            szellemSzam += Integer.parseInt(TF_szellem.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_szellem.getText())*8;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegSzellem.setText(String.valueOf(szellemSzam));
        }
    }

    public void megveszemVerfarkas(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_verfarkas.getText())*15 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            verfarkasSzam += Integer.parseInt(TF_verfarkas.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_verfarkas.getText())*15;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegVerfarkas.setText(String.valueOf(verfarkasSzam));
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void tovabb(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("csatater.fxml"));
        root = loader.load();

        CsataterControllerSajat macska = loader.getController();
        //Pozicio macska = loader.getController();
        //???

        Demon demon = new Demon(demonSzam);
        hos.addEgysegek(demon);

        Szellem szellem = new Szellem(szellemSzam);
        hos.addEgysegek(szellem);

        Vampir vampir = new Vampir(vampirSzam);
        hos.addEgysegek(vampir);

        Verfarkas verfarkas = new Verfarkas(verfarkasSzam);
        hos.addEgysegek(verfarkas);

        Zombi zombi = new Zombi(zombiSzam);
        hos.addEgysegek(zombi);

        macska.setHos(hos);


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
