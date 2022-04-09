package com.example.game.hos.egysegek.frakciok.controller;

import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.repulol_lenyek.*;
import com.example.game.megjelenites.Csatater;
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

public class RepuloLenyController {

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
    private TextField TF_griff;
    @FXML
    private TextField TF_sarkany;
    @FXML
    private TextField TF_pteranodon;
    @FXML
    private TextField TF_pegazus;
    @FXML
    private TextField TF_fonix;


    private int griffSzam;
    private int sarkanySzam;
    private int pteranodonSzam;
    private int pegazusSzam;
    private int fonixSzam;


    private boolean vasarolt = false;
    @FXML
    private Text nemVasarolt;

    @FXML
    private Text nincsElegArany;

    @FXML
    private Text mennyisegGriff;
    @FXML
    private Text mennyisegSarkany;
    @FXML
    private Text mennyisegPteranodon;
    @FXML
    private Text mennyisegPegazus;
    @FXML
    private Text mennyisegFonix;


    public void megveszemGriff(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_griff.getText())*15 < 0){    // 6 = adott egység ára!
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            griffSzam += Integer.parseInt(TF_griff.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_griff.getText())*15; // 6 = démon ára
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegGriff.setText(String.valueOf(griffSzam));
            vasarolt = true;
        }
    }

    public void megveszemSarkany(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_sarkany.getText())*10 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            sarkanySzam += Integer.parseInt(TF_sarkany.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_sarkany.getText())*10;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegSarkany.setText(String.valueOf(sarkanySzam));
            vasarolt = true;
        }
    }

    public void megveszemPteranodon(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_pteranodon.getText())*15 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            pteranodonSzam += Integer.parseInt(TF_pteranodon.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_pteranodon.getText())*15;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegPteranodon.setText(String.valueOf(pteranodonSzam));
            vasarolt = true;
        }
    }

    public void megveszemPegazus(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_pegazus.getText())*7 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            pegazusSzam += Integer.parseInt(TF_pegazus.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_pegazus.getText())*7;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegPegazus.setText(String.valueOf(pegazusSzam));
            vasarolt = true;
        }
    }

    public void megveszemFonix(ActionEvent event) throws IOException {
        if (SceneController.arany - Integer.parseInt(TF_fonix.getText())*12 < 0){
            nincsElegArany.setText("Nincs elég aranyad!");
        }
        else{
            fonixSzam += Integer.parseInt(TF_fonix.getText());
            SceneController.arany = SceneController.arany - Integer.parseInt(TF_fonix.getText())*12;
            arany.setText(String.valueOf(SceneController.arany));
            mennyisegFonix.setText(String.valueOf(fonixSzam));
            vasarolt = true;
        }
    }


    //POZÍCIÓK BEÁLLÍTÁSA ------------------------------------------------------------------------------

    private Pozicio griffPozicio = null;
    private Pozicio sarkanyPozicio = null;
    private Pozicio pegazusPozicio = null;
    private Pozicio pteranodonPozicio = null;
    private Pozicio fonixPozicio = null;

    @FXML
    private Text griffPozicioSor;
    @FXML
    private Text griffPozicioOszlop;
    @FXML
    private Text sarkanyPozicioSor;
    @FXML
    private Text sarkanyPozicioOszlop;
    @FXML
    private Text pegazusPozicioSor;
    @FXML
    private Text pegazusPozicioOszlop;
    @FXML
    private Text pteranodonPozicioSor;
    @FXML
    private Text pteranodonPozicioOszlop;
    @FXML
    private Text fonixPozicioSor;
    @FXML
    private Text fonixPozicioOszlop;

    public void griffSorPlusz() {
        if(griffPozicio == null){
            griffPozicio = new Pozicio(0,0);
        }
        if (griffSzam > 0 && griffPozicio.getSor() < 9) {
            griffPozicio.novelSor();
            griffPozicioSor.setText(String.valueOf(griffPozicio.getSor()));
        }
    }

    public void griffSorMinusz() {
        if(griffPozicio == null){
            griffPozicio = new Pozicio(0,0);
        }
        if (griffSzam > 0 && griffPozicio.getSor() > 0) {
            griffPozicio.csokkentSor();
            griffPozicioSor.setText(String.valueOf(griffPozicio.getSor()));
        }
    }

    public void griffOszlopPlusz() {
        if(griffPozicio == null){
            griffPozicio = new Pozicio(0,0);
        }
        if (griffSzam > 0 && griffPozicio.getOszlop() < 1) {
            griffPozicio.novelOszlop();
            griffPozicioOszlop.setText(String.valueOf(griffPozicio.getOszlop()));
        }
    }

    public void griffOszlopMinusz() {
        if(griffPozicio == null){
            griffPozicio = new Pozicio(0,0);
        }
        if (griffSzam > 0 && griffPozicio.getOszlop() > 0) {
            griffPozicio.csokkentOszlop();
            griffPozicioOszlop.setText(String.valueOf(griffPozicio.getOszlop()));
        }
    }

    public void sarkanySorPlusz() {
        if(sarkanyPozicio == null){
            sarkanyPozicio = new Pozicio(0,0);
        }
        if (sarkanySzam > 0 && sarkanyPozicio.getSor() < 9) {
            sarkanyPozicio.novelSor();
            sarkanyPozicioSor.setText(String.valueOf(sarkanyPozicio.getSor()));
        }
    }

    public void sarkanySorMinusz() {
        if(sarkanyPozicio == null){
            sarkanyPozicio = new Pozicio(0,0);
        }
        if (sarkanySzam > 0 && sarkanyPozicio.getSor() > 0) {
            sarkanyPozicio.csokkentSor();
            sarkanyPozicioSor.setText(String.valueOf(sarkanyPozicio.getSor()));
        }
    }

    public void sarkanyOszlopPlusz() {
        if(sarkanyPozicio == null){
            sarkanyPozicio = new Pozicio(0,0);
        }
        if (sarkanySzam > 0 && sarkanyPozicio.getOszlop() < 1) {
            sarkanyPozicio.novelOszlop();
            sarkanyPozicioOszlop.setText(String.valueOf(sarkanyPozicio.getOszlop()));
        }
    }

    public void sarkanyOszlopMinusz() {
        if(sarkanyPozicio == null){
            sarkanyPozicio = new Pozicio(0,0);
        }
        if (sarkanySzam > 0 && sarkanyPozicio.getOszlop() > 0) {
            sarkanyPozicio.csokkentOszlop();
            sarkanyPozicioOszlop.setText(String.valueOf(sarkanyPozicio.getOszlop()));
        }
    }

    public void pegazusSorPlusz() {
        if(pegazusPozicio == null){
            pegazusPozicio = new Pozicio(0,0);
        }
        if (pegazusSzam > 0 && pegazusPozicio.getSor() < 9) {
            pegazusPozicio.novelSor();
            pegazusPozicioSor.setText(String.valueOf(pegazusPozicio.getSor()));
        }
    }

    public void pegazusSorMinusz() {
        if(pegazusPozicio == null){
            pegazusPozicio = new Pozicio(0,0);
        }
        if (pegazusSzam > 0 && pegazusPozicio.getSor() > 0) {
            pegazusPozicio.csokkentSor();
            pegazusPozicioSor.setText(String.valueOf(pegazusPozicio.getSor()));
        }
    }

    public void pegazusOszlopPlusz() {
        if(pegazusPozicio == null){
            pegazusPozicio = new Pozicio(0,0);
        }
        if (pegazusSzam > 0 && pegazusPozicio.getOszlop() < 1) {
            pegazusPozicio.novelOszlop();
            pegazusPozicioOszlop.setText(String.valueOf(pegazusPozicio.getOszlop()));
        }
    }

    public void pegazusOszlopMinusz() {
        if(pegazusPozicio == null){
            pegazusPozicio = new Pozicio(0,0);
        }
        if (pegazusSzam > 0 && pegazusPozicio.getOszlop() > 0) {
            pegazusPozicio.csokkentOszlop();
            pegazusPozicioOszlop.setText(String.valueOf(pegazusPozicio.getOszlop()));
        }
    }

    public void pteranodonSorPlusz() {
        if(pteranodonPozicio == null){
            pteranodonPozicio = new Pozicio(0,0);
        }
        if (pteranodonSzam > 0 && pteranodonPozicio.getSor() < 9) {
            pteranodonPozicio.novelSor();
            pteranodonPozicioSor.setText(String.valueOf(pteranodonPozicio.getSor()));
        }
    }

    public void pteranodonSorMinusz() {
        if(pteranodonPozicio == null){
            pteranodonPozicio = new Pozicio(0,0);
        }
        if (pteranodonSzam > 0 && pteranodonPozicio.getSor() > 0) {
            pteranodonPozicio.csokkentSor();
            pteranodonPozicioSor.setText(String.valueOf(pteranodonPozicio.getSor()));
        }
    }

    public void pteranodonOszlopPlusz() {
        if(pteranodonPozicio == null){
            pteranodonPozicio = new Pozicio(0,0);
        }
        if (pteranodonSzam > 0 && pteranodonPozicio.getOszlop() < 1) {
            pteranodonPozicio.novelOszlop();
            pteranodonPozicioOszlop.setText(String.valueOf(pteranodonPozicio.getOszlop()));
        }
    }

    public void pteranodonOszlopMinusz() {
        if(pteranodonPozicio == null){
            pteranodonPozicio = new Pozicio(0,0);
        }
        if (pteranodonSzam > 0 && pteranodonPozicio.getOszlop() > 0) {
            pteranodonPozicio.csokkentOszlop();
            pteranodonPozicioOszlop.setText(String.valueOf(pteranodonPozicio.getOszlop()));
        }
    }

    public void fonixSorPlusz() {
        if(fonixPozicio == null){
            fonixPozicio = new Pozicio(0,0);
        }
        if (fonixSzam > 0 && fonixPozicio.getSor() < 9) {
            fonixPozicio.novelSor();
            fonixPozicioSor.setText(String.valueOf(fonixPozicio.getSor()));
        }
    }

    public void fonixSorMinusz() {
        if(fonixPozicio == null){
            fonixPozicio = new Pozicio(0,0);
        }
        if (fonixSzam > 0 && fonixPozicio.getSor() > 0) {
            fonixPozicio.csokkentSor();
            fonixPozicioSor.setText(String.valueOf(fonixPozicio.getSor()));
        }
    }

    public void fonixOszlopPlusz() {
        if(fonixPozicio == null){
            fonixPozicio = new Pozicio(0,0);
        }
        if (fonixSzam > 0 && fonixPozicio.getOszlop() < 1) {
            fonixPozicio.novelOszlop();
            fonixPozicioOszlop.setText(String.valueOf(fonixPozicio.getOszlop()));
        }
    }

    public void fonixOszlopMinusz() {
        if(fonixPozicio == null){
            fonixPozicio = new Pozicio(0,0);
        }
        if (fonixSzam > 0 && fonixPozicio.getOszlop() > 0) {
            fonixPozicio.csokkentOszlop();
            fonixPozicioOszlop.setText(String.valueOf(fonixPozicio.getOszlop()));
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

            Griff griff = new Griff(hos, griffSzam);
            hos.addEgysegek(griff);

            Fonix fonix = new Fonix(hos, fonixSzam);
            hos.addEgysegek(fonix);

            Sarkany sarkany = new Sarkany(hos, sarkanySzam);
            hos.addEgysegek(sarkany);

            Pteranodon pteranodon = new Pteranodon(hos, pteranodonSzam);
            hos.addEgysegek(pteranodon);

            Pegazus pegazus = new Pegazus(hos, pegazusSzam);
            hos.addEgysegek(pegazus);

            //macska.setHos(hos);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(csatater);
            stage.setScene(scene);
            stage.show();

            csatater.draw();
            stage.setResizable(true);
            stage.setFullScreen(true);
        }
        else {
            nemVasarolt.setText("Még nem vásároltál egységet!");
        }

    }


    //GETTEREK ÉS SETTEREK ----------------------------------------------------------

    public Pozicio getGriffPozicio() {
        return griffPozicio;
    }

    public void setGriffPozicio(Pozicio griffPozicio) {
        this.griffPozicio = griffPozicio;
    }

    public Pozicio getSarkanyPozicio() {
        return sarkanyPozicio;
    }

    public void setSarkanyPozicio(Pozicio sarkanyPozicio) {
        this.sarkanyPozicio = sarkanyPozicio;
    }

    public Pozicio getPegazusPozicio() {
        return pegazusPozicio;
    }

    public void setPegazusPozicio(Pozicio pegazusPozicio) {
        this.pegazusPozicio = pegazusPozicio;
    }

    public Pozicio getPteranodonPozicio() {
        return pteranodonPozicio;
    }

    public void setPteranodonPozicio(Pozicio pteranodonPozicio) {
        this.pteranodonPozicio = pteranodonPozicio;
    }

    public Pozicio getFonixPozicio() {
        return fonixPozicio;
    }

    public void setFonixPozicio(Pozicio fonixPozicio) {
        this.fonixPozicio = fonixPozicio;
    }
}
