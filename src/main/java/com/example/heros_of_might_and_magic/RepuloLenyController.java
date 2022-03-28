package com.example.heros_of_might_and_magic;

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
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void tovabb(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("csatater.fxml"));
        root = loader.load();

        // Csatater macska = loader.getController();
        //macska.writeGold(SceneController.arany);

        //HOGYAN TÁROLOM EL EGY EGYSZERŰ LISTÁBAN, HOGY AZ EGYES EGYSÉGEKBŐL MENNYI VAN??

        //macska.setHos(hos);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
