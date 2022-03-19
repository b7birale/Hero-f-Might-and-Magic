package com.example.heros_of_might_and_magic;


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
import java.util.List;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class Hero {



    public int tamadas;
    public int tudas;
    public int vedekezes;
    public int moral;
    public int szerencse;
    public int varazsero;
    //public int arany;
    public int manna;
    public int vasarlasokSzama;
    private int ar;

    private List<Varazslat> varazslatok;
    private List<Egyseg> egysegek;

    public Hero() {
        this.tamadas = 1;
        this.vedekezes = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.manna = 0;
        this.ar = 5;
        this.vasarlasokSzama = 0;

    }


    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }



    public int getTamadas() {
        return tamadas;
    }

    @FXML
    private Text Ar;
    @FXML
    private Text tamadasSzam;
    @FXML
    private Button plusTamadas;
    @FXML
    private Text arany;
    public void plusTamadas() {
        ar = arSzamitas(5);
        if(this.tamadas + 1 <= 10 && ar <= SceneController.arany){
            this.tamadas += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            tamadasSzam.setText(String.valueOf(tamadas));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas(5) + " arany"));
        }
        else{
            //println(nem vehetsz tobb tamadast)
        }
        System.out.println("Tamadas: " + tamadas);
        System.out.println("Ar: " + ar);
        System.out.println("Arany: " + SceneController.arany);
    }

    public int getVedekezes() {
        return vedekezes;
    }


    @FXML
    private Text vedekezesSzam;
    @FXML
    private Button plusVedekezes;
    @FXML
    public void plusVedekezes() {
        arSzamitas(5);
        if(this.vedekezes + 1 <= 10 && ar <= SceneController.arany){
            this.vedekezes += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            vedekezesSzam.setText(String.valueOf(vedekezes));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas(5) + " arany"));
        }
        else{
            //println(nem vehetsz tobb vedekezest)
        }
    }

    public int getMoral() {
        return moral;
    }


    @FXML
    private Text moralSzam;
    @FXML
    private Button plusMoral;
    @FXML
    public void plusMoral() {
        arSzamitas(5);
        if(this.moral + 1 <= 10 && ar <= SceneController.arany){
            this.moral += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            moralSzam.setText(String.valueOf(moral));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas(5) + " arany"));
        }
        else{
            //println(nem vehetsz tobb moralt)
        }
    }

    public int getSzerencse() {
        return szerencse;
    }


    @FXML
    private Text szerencseSzam;
    @FXML
    private Button plusSzerencse;
    @FXML
    public void plusSzerencse() {
        arSzamitas(5);
        if(this.szerencse + 1 <= 10 && ar <= SceneController.arany){
            this.szerencse += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            szerencseSzam.setText(String.valueOf(szerencse));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas(5) + " arany"));
        }
        else{
            //println(nem vehetsz tobb szerencset)
        }
    }

    public int getVarazsero() {
        return varazsero;
    }


    @FXML
    private Text varazseroSzam;
    @FXML
    private Button plusVarazsero;
    @FXML
    public void plusVarazsero() {
        arSzamitas(5);
        if(this.varazsero + 1 <= 10 && ar <= SceneController.arany){
            this.varazsero += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            varazseroSzam.setText(String.valueOf(varazsero));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas(5) + " arany"));
        }
        else{
            //println(nem vehetsz tobb varazserot)
        }
    }

    public int getTudas() {
        return tudas;
    }


    @FXML
    private Text tudasSzam;
    @FXML
    private Button plusTudas;
    @FXML
    public void plusTudas() {
        arSzamitas(5);
        if(this.tudas + 1 <= 10 && ar <= SceneController.arany){
            this.tudas += 1;
            vasarlasokSzama++;
            SceneController.arany = SceneController.arany - ar;

            tudasSzam.setText(String.valueOf(tudas));
            arany.setText(String.valueOf(SceneController.arany));
            Ar.setText(String.valueOf(arSzamitas(5) + " arany"));
        }
        else{
            //println(nem vehetsz tobb tudast)
        }
    }

    /*
    public int getArany() {
        return arany;
    }

    public void setArany(int arany) {
        this.arany = arany;
    }

     */

    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    public int arSzamitas(int ar){
        double r = (double)ar;
        for(int i = 0; i < vasarlasokSzama; i++){
            r += r * 0.1;
            System.out.println("r: " + r);
            r = ceil(r);
            System.out.println("r: " + r);
        }
        System.out.println("Arszamitasbol ar: " + ar);
        System.out.println("Vasarlasok szama: " + vasarlasokSzama);
        System.out.println("r: " + r);
        return (int)r;
    }




    private Stage stage;
    private Scene scene;
    private Parent root;

    public void tovabb(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Varazslatok.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Varazslatok.fxml"));
        root = loader.load();

        Varazslat macska = loader.getController();
        macska.writeGold(SceneController.arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
