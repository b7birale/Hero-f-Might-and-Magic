package com.example.game.hos.egysegek.frakciok.controller;

import com.example.game.hos.Hos;
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


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void tovabb(ActionEvent event) throws IOException {
        if(vasarolt){
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
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            Csatater csatater = new Csatater(hos);
            csatater.draw();
            stage.setResizable(true);
            stage.setFullScreen(true);
        }
        else{
            nemVasarolt.setText("Még nem vásároltál egységet!");
        }

    }
}
