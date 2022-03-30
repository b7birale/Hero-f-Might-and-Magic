package com.example.heros_of_might_and_magic;

import com.example.heros_of_might_and_magic.varazslatok.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class VarazslatController {

    Hos hos = new Hos();

    public void setHos(Hos hos) {
        this.hos = hos;
    }

    @FXML
    private Text nincsElegArany;

    @FXML
    private Text arany;
    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }

    @FXML
    private Text villamcsapas_megvette;
    boolean villamcsapas = false;

    public void buyVillamcsapas(){
        if(!villamcsapas && SceneController.arany - 60 >= 0){
            villamcsapas = true;
            villamcsapas_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 60;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            if(villamcsapas){
                villamcsapas_megvette.setText("Már megvetted!");
            }
            else{
                nincsElegArany.setText("Nincs elég aranyad!");
            }
        }

    }

    @FXML
    private Text tuzlabda_megvette;
    boolean tuzlabda = false;
    public void buyTuzlabda(){
        if(!tuzlabda && SceneController.arany - 120 >= 0) {
            tuzlabda = true;
            tuzlabda_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 120;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            if(tuzlabda){
                tuzlabda_megvette.setText("Már megvetted!");
            }
            else{
                nincsElegArany.setText("Nincs elég aranyad!");
            }
        }
    }

    @FXML
    private Text feltamasztas_megvette;
    boolean feltamasztas = false;
    public void buyFeltamasztas(){
        if(!feltamasztas && SceneController.arany - 120 >= 0) {
            feltamasztas = true;
            feltamasztas_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 120;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            if(feltamasztas){
                feltamasztas_megvette.setText("Már megvetted!");
            }
            else{
                nincsElegArany.setText("Nincs elég aranyad!");
            }
        }
    }


    @FXML
    private Text teleport_megvette;
    boolean teleport = false;
    public void buyTeleport(){
        if(!teleport && SceneController.arany - 100 >= 0) {
            teleport = true;
            teleport_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 100;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            if(teleport){
                teleport_megvette.setText("Már megvetted!");
            }
            else{
                nincsElegArany.setText("Nincs elég aranyad!");
            }
        }
    }

    @FXML
    private Text magikusnyilvesszo_megvette;
    boolean magikusNyilvesszo = false;
    public void buyMagikusNyilvesszo(){
        if(!magikusNyilvesszo && SceneController.arany - 50 >= 0) {
            magikusNyilvesszo = true;
            magikusnyilvesszo_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 50;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            if(magikusNyilvesszo){
                magikusnyilvesszo_megvette.setText("Már megvetted!");
            }
            else{
                nincsElegArany.setText("Nincs elég aranyad!");
            }
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void tovabb(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Frakciok.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Frakciok.fxml"));
        root = loader.load();

        FrakcioController macska = loader.getController();
        macska.writeGold(SceneController.arany);

        //ITT ÉN NEM TUDOM MI TÖRTÉNIK ÉS MI NEM ?!

        //List<Varazslat> varazslatok = new ArrayList<Varazslat>();   //próbálkozás, ami nem nagyon jött be, de azért itthagyom egyelőre

        //hos.addVarazslatok();

        if(villamcsapas){
            Villamcsapas villamcsapas = new Villamcsapas();
            villamcsapas.setAr(60);
            villamcsapas.setManna(5);
            hos.addVarazslatok(villamcsapas);
        }
        if(tuzlabda){
            Tuzlabda tuzlabda = new Tuzlabda();
            tuzlabda.setAr(120);
            tuzlabda.setManna(9);
            hos.addVarazslatok(tuzlabda);
        }
        if(feltamasztas){
            Feltamasztas feltamasztas = new Feltamasztas();
            feltamasztas.setAr(120);
            feltamasztas.setManna(6);
            hos.addVarazslatok(feltamasztas);
        }
        if(teleport){
            Teleport teleport = new Teleport();
            teleport.setAr(100);
            teleport.setManna(4);
            hos.addVarazslatok(teleport);
        }
        if(magikusNyilvesszo){
            MagicArrow magikusNyilvesszo = new MagicArrow();
            magikusNyilvesszo.setAr(50);
            magikusNyilvesszo.setManna(15);
            hos.addVarazslatok(magikusNyilvesszo);
        }


        macska.setHos(hos);





        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}

