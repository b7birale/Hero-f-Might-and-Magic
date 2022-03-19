

package com.example.heros_of_might_and_magic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public static String nehezseg;

    public static int arany;

    public void again(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("nehezsegi_szintek.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void konnyu(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Hero.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Hero.fxml"));
        root = loader.load();

        arany = 1300;

        Hero macska = loader.getController();
        macska.writeGold(arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        nehezseg = "konnyu";

    }

    public void kozepes(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Hero.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Hero.fxml"));
        root = loader.load();

        arany = 1000;

        Hero scene2Controller = loader.getController();
        scene2Controller.writeGold(arany);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        nehezseg = "kozepes";



    }

    public void nehez(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("Hero.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Hero.fxml"));
        root = loader.load();

        arany = 700;

        Hero scene2Controller = loader.getController();
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




