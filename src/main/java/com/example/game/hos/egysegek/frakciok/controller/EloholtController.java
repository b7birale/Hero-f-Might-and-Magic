package com.example.game.hos.egysegek.frakciok.controller;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.eloholtak.*;
import com.example.game.megjelenites.Csatater;
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

    private boolean vasarolt = false;
    @FXML
    private Text nemVasarolt;

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
            vasarolt = true;
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
            vasarolt = true;
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
            vasarolt = true;
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
            vasarolt = true;
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
            vasarolt = true;
        }
    }


    //POZÍCIÓK BEÁLLÍTÁSA ------------------------------------------------------------------------------

    private Pozicio demonPozicio = null;
    private Pozicio zombiPozicio = null;
    private Pozicio vampirPozicio = null;
    private Pozicio szellemPozicio = null;
    private Pozicio verfarkasPozicio = null;

    @FXML
    private Text demonPozicioSor;
    @FXML
    private Text demonPozicioOszlop;
    @FXML
    private Text zombiPozicioSor;
    @FXML
    private Text zombiPozicioOszlop;
    @FXML
    private Text vampirPozicioSor;
    @FXML
    private Text vampirPozicioOszlop;
    @FXML
    private Text szellemPozicioSor;
    @FXML
    private Text szellemPozicioOszlop;
    @FXML
    private Text verfarkasPozicioSor;
    @FXML
    private Text verfarkasPozicioOszlop;

    public void demonSorPlusz() {
        if(demonPozicio == null){
            demonPozicio = new Pozicio(0,0);
        }
        if (demonSzam > 0 && demonPozicio.getSor() < 9) {
            demonPozicio.novelSor();
            demonPozicioSor.setText(String.valueOf(demonPozicio.getSor()));
        }
    }

    public void demonSorMinusz() {
        if(demonPozicio == null){
            demonPozicio = new Pozicio(0,0);
        }
        if (demonSzam > 0 && demonPozicio.getSor() > 0) {
            demonPozicio.csokkentSor();
            demonPozicioSor.setText(String.valueOf(demonPozicio.getSor()));
        }
    }

    public void demonOszlopPlusz() {
        if(demonPozicio == null){
            demonPozicio = new Pozicio(0,0);
        }
        if (demonSzam > 0 && demonPozicio.getOszlop() < 1) {
            demonPozicio.novelOszlop();
            demonPozicioOszlop.setText(String.valueOf(demonPozicio.getOszlop()));
        }
    }

    public void demonOszlopMinusz() {
        if(demonPozicio == null){
            demonPozicio = new Pozicio(0,0);
        }
        if (demonSzam > 0 && demonPozicio.getOszlop() > 0) {
            demonPozicio.csokkentOszlop();
            demonPozicioOszlop.setText(String.valueOf(demonPozicio.getOszlop()));
        }
    }

    public void zombiSorPlusz() {
        if(zombiPozicio == null){
            zombiPozicio = new Pozicio(0,0);
        }
        if (zombiSzam > 0 && zombiPozicio.getSor() < 9) {
            zombiPozicio.novelSor();
            zombiPozicioSor.setText(String.valueOf(zombiPozicio.getSor()));
        }
    }

    public void zombiSorMinusz() {
        if(zombiPozicio == null){
            zombiPozicio = new Pozicio(0,0);
        }
        if (zombiSzam > 0 && zombiPozicio.getSor() > 0) {
            zombiPozicio.csokkentSor();
            zombiPozicioSor.setText(String.valueOf(zombiPozicio.getSor()));
        }
    }

    public void zombiOszlopPlusz() {
        if(zombiPozicio == null){
            zombiPozicio = new Pozicio(0,0);
        }
        if (zombiSzam > 0 && zombiPozicio.getOszlop() < 1) {
            zombiPozicio.novelOszlop();
            zombiPozicioOszlop.setText(String.valueOf(zombiPozicio.getOszlop()));
        }
    }

    public void zombiOszlopMinusz() {
        if(zombiPozicio == null){
            zombiPozicio = new Pozicio(0,0);
        }
        if (zombiSzam > 0 && zombiPozicio.getOszlop() > 0) {
            zombiPozicio.csokkentOszlop();
            zombiPozicioOszlop.setText(String.valueOf(zombiPozicio.getOszlop()));
        }
    }

    public void vampirSorPlusz() {
        if(vampirPozicio == null){
            vampirPozicio = new Pozicio(0,0);
        }
        if (vampirSzam > 0 && vampirPozicio.getSor() < 9) {
            vampirPozicio.novelSor();
            vampirPozicioSor.setText(String.valueOf(vampirPozicio.getSor()));
        }
    }

    public void vampirSorMinusz() {
        if(vampirPozicio == null){
            vampirPozicio = new Pozicio(0,0);
        }
        if (vampirSzam > 0 && vampirPozicio.getSor() > 0) {
            vampirPozicio.csokkentSor();
            vampirPozicioSor.setText(String.valueOf(vampirPozicio.getSor()));
        }
    }

    public void vampirOszlopPlusz() {
        if(vampirPozicio == null){
            vampirPozicio = new Pozicio(0,0);
        }
        if (vampirSzam > 0 && vampirPozicio.getOszlop() < 1) {
            vampirPozicio.novelOszlop();
            vampirPozicioOszlop.setText(String.valueOf(vampirPozicio.getOszlop()));
        }
    }

    public void vampirOszlopMinusz() {
        if(vampirPozicio == null){
            vampirPozicio = new Pozicio(0,0);
        }
        if (vampirSzam > 0 && vampirPozicio.getOszlop() > 0) {
            vampirPozicio.csokkentOszlop();
            vampirPozicioOszlop.setText(String.valueOf(vampirPozicio.getOszlop()));
        }
    }

    public void szellemSorPlusz() {
        if(szellemPozicio == null){
            szellemPozicio = new Pozicio(0,0);
        }
        if (szellemSzam > 0 && szellemPozicio.getSor() < 9) {
            szellemPozicio.novelSor();
            szellemPozicioSor.setText(String.valueOf(szellemPozicio.getSor()));
        }
    }

    public void szellemSorMinusz() {
        if(szellemPozicio == null){
            szellemPozicio = new Pozicio(0,0);
        }
        if (szellemSzam > 0 && szellemPozicio.getSor() > 0) {
            szellemPozicio.csokkentSor();
            szellemPozicioSor.setText(String.valueOf(szellemPozicio.getSor()));
        }
    }

    public void szellemOszlopPlusz() {
        if(szellemPozicio == null){
            szellemPozicio = new Pozicio(0,0);
        }
        if (szellemSzam > 0 && szellemPozicio.getOszlop() < 1) {
            szellemPozicio.novelOszlop();
            szellemPozicioOszlop.setText(String.valueOf(szellemPozicio.getOszlop()));
        }
    }

    public void szellemOszlopMinusz() {
        if(szellemPozicio == null){
            szellemPozicio = new Pozicio(0,0);
        }
        if (szellemSzam > 0 && szellemPozicio.getOszlop() > 0) {
            szellemPozicio.csokkentOszlop();
            szellemPozicioOszlop.setText(String.valueOf(szellemPozicio.getOszlop()));
        }
    }

    public void verfarkasSorPlusz() {
        if(verfarkasPozicio == null){
            verfarkasPozicio = new Pozicio(0,0);
        }
        if (verfarkasSzam > 0 && verfarkasPozicio.getSor() < 9) {
            verfarkasPozicio.novelSor();
            verfarkasPozicioSor.setText(String.valueOf(verfarkasPozicio.getSor()));
        }
    }

    public void verfarkasSorMinusz() {
        if(verfarkasPozicio == null){
            verfarkasPozicio = new Pozicio(0,0);
        }
        if (verfarkasSzam > 0 && verfarkasPozicio.getSor() > 0) {
            verfarkasPozicio.csokkentSor();
            verfarkasPozicioSor.setText(String.valueOf(verfarkasPozicio.getSor()));
        }
    }

    public void verfarkasOszlopPlusz() {
        if(verfarkasPozicio == null){
            verfarkasPozicio = new Pozicio(0,0);
        }
        if (verfarkasSzam > 0 && verfarkasPozicio.getOszlop() < 1) {
            verfarkasPozicio.novelOszlop();
            verfarkasPozicioOszlop.setText(String.valueOf(verfarkasPozicio.getOszlop()));
        }
    }

    public void verfarkasOszlopMinusz() {
        if(verfarkasPozicio == null){
            verfarkasPozicio = new Pozicio(0,0);
        }
        if (verfarkasSzam > 0 && verfarkasPozicio.getOszlop() > 0) {
            verfarkasPozicio.csokkentOszlop();
            verfarkasPozicioOszlop.setText(String.valueOf(verfarkasPozicio.getOszlop()));
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void tovabb(ActionEvent event) throws IOException {
        if(vasarolt){

            /*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("csatater.fxml"));
            root = loader.load();

            CsataterControllerSajat macska = loader.getController();
            //Pozicio macska = loader.getController();
            //???

             */

            Csatater csatater = new Csatater(hos);

            Demon demon = new Demon(hos, demonSzam);
            hos.addEgysegek(demon);

            Szellem szellem = new Szellem(hos, szellemSzam);
            hos.addEgysegek(szellem);

            Vampir vampir = new Vampir(hos, vampirSzam);
            hos.addEgysegek(vampir);

            Verfarkas verfarkas = new Verfarkas(hos, verfarkasSzam);
            hos.addEgysegek(verfarkas);

            Zombi zombi = new Zombi(hos, zombiSzam);
            hos.addEgysegek(zombi);

            //macska.setHos(hos);


            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(csatater);
            stage.setScene(scene);
            stage.show();

            csatater.draw();
            stage.setResizable(true);
            stage.setFullScreen(true);
        }
        else{
            nemVasarolt.setText("Még nem vásároltál egységet!");
        }

    }
}
