package com.example.heros_of_might_and_magic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Varazslat {

    int ar;
    int manna;
    String nev;
    String leiras;

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public void hasznal(){

    }

    @FXML
    private Text arany;
    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }

    @FXML
    private Text villamcsapas_megvette;
    boolean villamcsapas = false;

    public void buyVillamcsapas(){
        if(!villamcsapas){
            villamcsapas = true;
            villamcsapas_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 60;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            villamcsapas_megvette.setText("Már megvetted!");
        }

    }

    @FXML
    private Text tuzlabda_megvette;
    boolean tuzlabda = false;
    public void buyTuzlabda(){
        if(!tuzlabda) {
            tuzlabda = true;
            tuzlabda_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 120;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            tuzlabda_megvette.setText("Már megvetted!");
        }
    }

    @FXML
    private Text feltamasztas_megvette;
    boolean feltamasztas = false;
    public void buyFeltamasztas(){
        if(!feltamasztas) {
            feltamasztas = true;
            feltamasztas_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 120;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            feltamasztas_megvette.setText("Már megvetted!");
        }
    }


    @FXML
    private Text teleport_megvette;
    boolean teleport = false;
    public void buyTeleport(){
        if(!teleport) {
            teleport = true;
            teleport_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 100;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            teleport_megvette.setText("Már megvetted!");
        }
    }

    @FXML
    private Text magikusnyilvesszo_megvette;
    boolean magikusNyilvesszo = false;
    public void buyMagikusNyilvesszo(){
        if(!magikusNyilvesszo) {
            magikusNyilvesszo = true;
            magikusnyilvesszo_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 50;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            magikusnyilvesszo_megvette.setText("Már megvetted!");
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void tovabb(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Frakciok.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Frakciok.fxml"));
        root = loader.load();

        Frakcio macska = loader.getController();
        macska.writeGold(SceneController.arany);


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
