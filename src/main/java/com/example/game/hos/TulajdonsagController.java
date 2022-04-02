package com.example.game.hos;


import com.example.game.megjelenites.SceneController;
import com.example.game.hos.varazslatok.VarazslatController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class TulajdonsagController {

    Hos hos = new Hos();

    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }

    private int vasarlasokSzama;
    private int ar;

    private int tamadas;
    private int tudas;
    private int vedekezes;
    private int moral;
    private int szerencse;
    private int varazsero;

    public TulajdonsagController() {
        this.vasarlasokSzama = 0;
        this.ar = 0;
        this.tamadas = 1;
        this.tudas = 1;
        this.vedekezes = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.varazsero = 1;
    }

    @FXML
    private Text nincsElegArany;

    @FXML
    private Text Ar;
    @FXML
    private Text tamadasSzam;
    @FXML
    private Button plusTamadas;
    @FXML
    private Text arany;

    public void plusTamadas() {
        ar = arSzamitas();
        if(this.tamadas + 1 <= 10 && ar <= SceneController.arany){
            this.tamadas += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            tamadasSzam.setText(String.valueOf(tamadas));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas() + " arany"));
        }
        else{
            if(ar > SceneController.arany){
                nincsElegArany.setText("Nincs elég aranyad!");
            }
            if(this.tamadas + 1 > 10){
                nincsElegArany.setText("Nem tudsz több támadást venni!");
            }
        }
    }



    @FXML
    private Text vedekezesSzam;
    @FXML
    private Button plusVedekezes;
    @FXML
    public void plusVedekezes() {
        ar = arSzamitas();
        if(this.vedekezes + 1 <= 10 && ar <= SceneController.arany){
            this.vedekezes += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            vedekezesSzam.setText(String.valueOf(vedekezes));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas() + " arany"));
        }
        else{
            if(ar > SceneController.arany){
                nincsElegArany.setText("Nincs elég aranyad!");
            }
            if(this.vedekezes + 1 > 10){
                nincsElegArany.setText("Nem tudsz több védekezést venni!");
            }
        }
    }


    @FXML
    private Text moralSzam;
    @FXML
    private Button plusMoral;
    @FXML
    public void plusMoral() {
        ar = arSzamitas();
        if(this.moral + 1 <= 10 && ar <= SceneController.arany){
            this.moral += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            moralSzam.setText(String.valueOf(moral));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas() + " arany"));
        }
        else{
            if(ar > SceneController.arany){
                nincsElegArany.setText("Nincs elég aranyad!");
            }
            if(this.moral + 1 > 10){
                nincsElegArany.setText("Nem tudsz több morált venni!");
            }
        }
    }


    @FXML
    private Text szerencseSzam;
    @FXML
    private Button plusSzerencse;
    @FXML
    public void plusSzerencse() {
        ar = arSzamitas();
        if(this.szerencse + 1 <= 10 && ar <= SceneController.arany){
            this.szerencse += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            szerencseSzam.setText(String.valueOf(szerencse));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas() + " arany"));
        }
        else{
            if(ar > SceneController.arany){
                nincsElegArany.setText("Nincs elég aranyad!");
            }
            if(this.szerencse + 1 > 10){
                nincsElegArany.setText("Nem tudsz több szerencsét venni!");
            }
        }
    }



    @FXML
    private Text varazseroSzam;
    @FXML
    private Button plusVarazsero;
    @FXML
    public void plusVarazsero() {
        ar = arSzamitas();
        if(this.varazsero + 1 <= 10 && ar <= SceneController.arany){
            this.varazsero += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            varazseroSzam.setText(String.valueOf(varazsero));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas() + " arany"));
        }
        else{
            if(ar > SceneController.arany){
                nincsElegArany.setText("Nincs elég aranyad!");
            }
            if(this.varazsero + 1 > 10){
                nincsElegArany.setText("Nem tudsz több varázserőt venni!");
            }
        }
    }



    @FXML
    private Text tudasSzam;
    @FXML
    private Button plusTudas;
    @FXML
    public void plusTudas() {
        ar = arSzamitas();
        if(this.tudas + 1 <= 10 && ar <= SceneController.arany){
            this.tudas += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            tudasSzam.setText(String.valueOf(tudas));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas() + " arany"));
        }
        else{
            if(ar > SceneController.arany){
                nincsElegArany.setText("Nincs elég aranyad!");
            }
            if(this.tudas + 1 > 10){
                nincsElegArany.setText("Nem tudsz több tudást venni!");
            }
        }
    }


    public int arSzamitas(){
        double r = 5.00;
        for(int i = 0; i < vasarlasokSzama; i++){
            r += r * 0.1;
            r = ceil(r);
        }
        return (int)r;
    }



    private Stage stage;
    private Scene scene;
    private Parent root;

    public void tovabb(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Varazslatok.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Varazslatok.fxml"));
        root = loader.load();

        VarazslatController macska = loader.getController();
        macska.writeGold(SceneController.arany);

        hos.setTamadas(tamadas);
        hos.setVedekezes(vedekezes);
        hos.setMoral(moral);
        hos.setTudas(tudas);
        hos.setVarazsero(varazsero);
        hos.setSzerencse(szerencse);
        macska.setHos(hos);

        /*
        macska.zombikiir(EgysegController.zombidb);

        */

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
