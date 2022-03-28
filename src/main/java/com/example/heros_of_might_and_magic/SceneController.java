

package com.example.heros_of_might_and_magic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public static String nehezseg;

    public static int arany;

    public void again(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Nehezsegi_szintek.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void konnyu(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Tulajdonsagok.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tulajdonsagok.fxml"));
        root = loader.load();

        arany = 1300;

        TulajdonsagController macska = loader.getController();
        macska.writeGold(arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        nehezseg = "konnyu";

    }

    public void kozepes(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Tulajdonsagok.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tulajdonsagok.fxml"));
        root = loader.load();

        arany = 1000;

        TulajdonsagController scene2Controller = loader.getController();
        scene2Controller.writeGold(arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        nehezseg = "kozepes";



    }

    public void nehez(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Tulajdonsagok.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tulajdonsagok.fxml"));
        root = loader.load();

        arany = 700;

        TulajdonsagController scene2Controller = loader.getController();
        scene2Controller.writeGold(arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        nehezseg = "nehez";
        arany = 700;

    }




    /*
    public void tovabb(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    */





}




