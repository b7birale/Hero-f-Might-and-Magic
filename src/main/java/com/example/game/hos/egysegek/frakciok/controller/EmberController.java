package com.example.game.hos.egysegek.frakciok.controller;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.megjelenites.Csatater;
import com.example.game.megjelenites.SceneController;
import com.example.game.hos.egysegek.emberek.*;
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

public class EmberController {

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
    private TextField TF_foldmuves;
    @FXML
    private TextField TF_ijasz;
    @FXML
    private TextField TF_lovag;
    @FXML
    private TextField TF_grof;
    @FXML
    private TextField TF_polgar;


    private int foldmuvesSzam;
    private int ijaszSzam;
    private int lovagSzam;
    private int grofSzam;
    private int polgarSzam;

    private boolean vasarolt = false;
    @FXML
    private Text nemVasarolt;

    @FXML
    private Text nincsElegArany;

    @FXML
    private Text mennyisegFoldmuves;
    @FXML
    private Text mennyisegIjasz;
    @FXML
    private Text mennyisegLovag;
    @FXML
    private Text mennyisegGrof;
    @FXML
    private Text mennyisegPolgar;


    public void megveszemFoldmuves(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_foldmuves.getText())*2 < 0){    // 6 = adott egység ára!
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            foldmuvesSzam += Integer.parseInt(TF_foldmuves.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_foldmuves.getText())*2; // 6 = démon ára
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegFoldmuves.setText(String.valueOf(foldmuvesSzam));
            vasarolt = true;
        }
    }

    public void megveszemIjasz(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_ijasz.getText())*6 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            ijaszSzam += Integer.parseInt(TF_ijasz.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_ijasz.getText())*6;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegIjasz.setText(String.valueOf(ijaszSzam));
            vasarolt = true;
        }
    }

    public void megveszemLovag(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_lovag.getText())*10 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            lovagSzam += Integer.parseInt(TF_lovag.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_lovag.getText())*10;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegLovag.setText(String.valueOf(lovagSzam));
            vasarolt = true;
        }
    }

    public void megveszemGrof(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_grof.getText())*8 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            grofSzam += Integer.parseInt(TF_grof.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_grof.getText())*8;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegGrof.setText(String.valueOf(grofSzam));
            vasarolt = true;
        }
    }

    public void megveszemPolgar(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_polgar.getText())*6 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            polgarSzam += Integer.parseInt(TF_polgar.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_polgar.getText())*6;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegPolgar.setText(String.valueOf(polgarSzam));
            vasarolt = true;
        }
    }


    //POZÍCIÓK BEÁLLÍTÁSA ------------------------------------------------------------------------------

    private Pozicio foldmuvesPozicio = null;
    private Pozicio ijaszPozicio = null;
    private Pozicio grofPozicio = null;
    private Pozicio lovagPozicio = null;
    private Pozicio polgarPozicio = null;

    @FXML
    private Text foldmuvesPozicioSor;
    @FXML
    private Text foldmuvesPozicioOszlop;
    @FXML
    private Text ijaszPozicioSor;
    @FXML
    private Text ijaszPozicioOszlop;
    @FXML
    private Text grofPozicioSor;
    @FXML
    private Text grofPozicioOszlop;
    @FXML
    private Text lovagPozicioSor;
    @FXML
    private Text lovagPozicioOszlop;
    @FXML
    private Text polgarPozicioSor;
    @FXML
    private Text polgarPozicioOszlop;

    public void foldmuvesSorPlusz() {
        if(foldmuvesPozicio == null){
            foldmuvesPozicio = new Pozicio(0,0);
        }
        if (foldmuvesSzam > 0 && foldmuvesPozicio.getSor() < 9) {
            foldmuvesPozicio.novelSor();
            foldmuvesPozicioSor.setText(String.valueOf(foldmuvesPozicio.getSor()));
        }
    }

    public void foldmuvesSorMinusz() {
        if(foldmuvesPozicio == null){
            foldmuvesPozicio = new Pozicio(0,0);
        }
        if (foldmuvesSzam > 0 && foldmuvesPozicio.getSor() > 0) {
            foldmuvesPozicio.csokkentSor();
            foldmuvesPozicioSor.setText(String.valueOf(foldmuvesPozicio.getSor()));
        }
    }

    public void foldmuvesOszlopPlusz() {
        if(foldmuvesPozicio == null){
            foldmuvesPozicio = new Pozicio(0,0);
        }
        if (foldmuvesSzam > 0 && foldmuvesPozicio.getOszlop() < 1) {
            foldmuvesPozicio.novelOszlop();
            foldmuvesPozicioOszlop.setText(String.valueOf(foldmuvesPozicio.getOszlop()));
        }
    }

    public void foldmuvesOszlopMinusz() {
        if(foldmuvesPozicio == null){
            foldmuvesPozicio = new Pozicio(0,0);
        }
        if (foldmuvesSzam > 0 && foldmuvesPozicio.getOszlop() > 0) {
            foldmuvesPozicio.csokkentOszlop();
            foldmuvesPozicioOszlop.setText(String.valueOf(foldmuvesPozicio.getOszlop()));
        }
    }

    public void ijaszSorPlusz() {
        if(ijaszPozicio == null){
            ijaszPozicio = new Pozicio(0,0);
        }
        if (ijaszSzam > 0 && ijaszPozicio.getSor() < 9) {
            ijaszPozicio.novelSor();
            ijaszPozicioSor.setText(String.valueOf(ijaszPozicio.getSor()));
        }
    }

    public void ijaszSorMinusz() {
        if(ijaszPozicio == null){
            ijaszPozicio = new Pozicio(0,0);
        }
        if (ijaszSzam > 0 && ijaszPozicio.getSor() > 0) {
            ijaszPozicio.csokkentSor();
            ijaszPozicioSor.setText(String.valueOf(ijaszPozicio.getSor()));
        }
    }

    public void ijaszOszlopPlusz() {
        if(ijaszPozicio == null){
            ijaszPozicio = new Pozicio(0,0);
        }
        if (ijaszSzam > 0 && ijaszPozicio.getOszlop() < 1) {
            ijaszPozicio.novelOszlop();
            ijaszPozicioOszlop.setText(String.valueOf(ijaszPozicio.getOszlop()));
        }
    }

    public void ijaszOszlopMinusz() {
        if(ijaszPozicio == null){
            ijaszPozicio = new Pozicio(0,0);
        }
        if (ijaszSzam > 0 && ijaszPozicio.getOszlop() > 0) {
            ijaszPozicio.csokkentOszlop();
            ijaszPozicioOszlop.setText(String.valueOf(ijaszPozicio.getOszlop()));
        }
    }

    public void grofSorPlusz() {
        if(grofPozicio == null){
            grofPozicio = new Pozicio(0,0);
        }
        if (grofSzam > 0 && grofPozicio.getSor() < 9) {
            grofPozicio.novelSor();
            grofPozicioSor.setText(String.valueOf(grofPozicio.getSor()));
        }
    }

    public void grofSorMinusz() {
        if(grofPozicio == null){
            grofPozicio = new Pozicio(0,0);
        }
        if (grofSzam > 0 && grofPozicio.getSor() > 0) {
            grofPozicio.csokkentSor();
            grofPozicioSor.setText(String.valueOf(grofPozicio.getSor()));
        }
    }

    public void grofOszlopPlusz() {
        if(grofPozicio == null){
            grofPozicio = new Pozicio(0,0);
        }
        if (grofSzam > 0 && grofPozicio.getOszlop() < 1) {
            grofPozicio.novelOszlop();
            grofPozicioOszlop.setText(String.valueOf(grofPozicio.getOszlop()));
        }
    }

    public void grofOszlopMinusz() {
        if(grofPozicio == null){
            grofPozicio = new Pozicio(0,0);
        }
        if (grofSzam > 0 && grofPozicio.getOszlop() > 0) {
            grofPozicio.csokkentOszlop();
            grofPozicioOszlop.setText(String.valueOf(grofPozicio.getOszlop()));
        }
    }

    public void lovagSorPlusz() {
        if(lovagPozicio == null){
            lovagPozicio = new Pozicio(0,0);
        }
        if (lovagSzam > 0 && lovagPozicio.getSor() < 9) {
            lovagPozicio.novelSor();
            lovagPozicioSor.setText(String.valueOf(lovagPozicio.getSor()));
        }
    }

    public void lovagSorMinusz() {
        if(lovagPozicio == null){
            lovagPozicio = new Pozicio(0,0);
        }
        if (lovagSzam > 0 && lovagPozicio.getSor() > 0) {
            lovagPozicio.csokkentSor();
            lovagPozicioSor.setText(String.valueOf(lovagPozicio.getSor()));
        }
    }

    public void lovagOszlopPlusz() {
        if(lovagPozicio == null){
            lovagPozicio = new Pozicio(0,0);
        }
        if (lovagSzam > 0 && lovagPozicio.getOszlop() < 1) {
            lovagPozicio.novelOszlop();
            lovagPozicioOszlop.setText(String.valueOf(lovagPozicio.getOszlop()));
        }
    }

    public void lovagOszlopMinusz() {
        if(lovagPozicio == null){
            lovagPozicio = new Pozicio(0,0);
        }
        if (lovagSzam > 0 && lovagPozicio.getOszlop() > 0) {
            lovagPozicio.csokkentOszlop();
            lovagPozicioOszlop.setText(String.valueOf(lovagPozicio.getOszlop()));
        }
    }

    public void polgarSorPlusz() {
        if(polgarPozicio == null){
            polgarPozicio = new Pozicio(0,0);
        }
        if (polgarSzam > 0 && polgarPozicio.getSor() < 9) {
            polgarPozicio.novelSor();
            polgarPozicioSor.setText(String.valueOf(polgarPozicio.getSor()));
        }
    }

    public void polgarSorMinusz() {
        if(polgarPozicio == null){
            polgarPozicio = new Pozicio(0,0);
        }
        if (polgarSzam > 0 && polgarPozicio.getSor() > 0) {
            polgarPozicio.csokkentSor();
            polgarPozicioSor.setText(String.valueOf(polgarPozicio.getSor()));
        }
    }

    public void polgarOszlopPlusz() {
        if(polgarPozicio == null){
            polgarPozicio = new Pozicio(0,0);
        }
        if (polgarSzam > 0 && polgarPozicio.getOszlop() < 1) {
            polgarPozicio.novelOszlop();
            polgarPozicioOszlop.setText(String.valueOf(polgarPozicio.getOszlop()));
        }
    }

    public void polgarOszlopMinusz() {
        if(polgarPozicio == null){
            polgarPozicio = new Pozicio(0,0);
        }
        if (polgarSzam > 0 && polgarPozicio.getOszlop() > 0) {
            polgarPozicio.csokkentOszlop();
            polgarPozicioOszlop.setText(String.valueOf(polgarPozicio.getOszlop()));
        }
    }




    private Stage stage;
    private Scene scene;
    private Parent root;
    public void tovabb(ActionEvent event) throws IOException {
        if(vasarolt){

            Csatater csatater = new Csatater(hos);

            //FXMLLoader loader = new FXMLLoader(getClass().getResource("csatater.fxml"));
            //root = loader.load();

            // Csatater macska = loader.getController();
            //macska.writeGold(SceneController.arany);

            //HOGYAN TÁROLOM EL EGY EGYSZERŰ LISTÁBAN, HOGY AZ EGYES EGYSÉGEKBŐL MENNYI VAN??

            //macska.setHos(hos);

            Foldmuves foldmuves = new Foldmuves(hos, foldmuvesSzam);
            hos.addEgysegek(foldmuves);

            Grof grof = new Grof(hos, grofSzam);
            hos.addEgysegek(grof);

            Ijasz ijasz = new Ijasz(hos, ijaszSzam);
            hos.addEgysegek(ijasz);

            Lovag lovag = new Lovag(hos, lovagSzam);
            hos.addEgysegek(lovag);

            Polgar polgar = new Polgar(hos, polgarSzam);
            hos.addEgysegek(polgar);


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
