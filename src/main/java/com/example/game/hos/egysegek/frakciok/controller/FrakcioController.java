package com.example.game.hos.egysegek.frakciok.controller;

import com.example.game.hos.Hos;
import com.example.game.megjelenites.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FrakcioController {

    Hos hos = new Hos();

    public void setHos(Hos hos) {
        this.hos = hos;
    }

    @FXML
    private Text arany;
    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }



    private Stage stage;
    private Scene scene;
    private Parent root;
    public void eloholtak(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Eloholtak.fxml"));
        root = loader.load();

        EloholtController macska = loader.getController();
        macska.writeGold(SceneController.arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void emberek(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Emberek.fxml"));
        root = loader.load();

        EmberController macska = loader.getController();
        macska.writeGold(SceneController.arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void repuloLenyek(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RepuloLenyek.fxml"));
        root = loader.load();

        RepuloLenyController macska = loader.getController();
        macska.writeGold(SceneController.arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
