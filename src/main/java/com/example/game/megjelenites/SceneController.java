

package com.example.game.megjelenites;

import com.example.game.hos.TulajdonsagController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Ez a kontroller osztálya annak az ablaknak, ahol kiválaszthatjuk a nehézségi szintet.
 * Ezen ablak megjelenítése, formázása a célja.
 * Adatokat gyűjt a játékos hőséhez, egészen pontosan azt, hogy mennyi aranya lesz az elkövetkezendőkben.
 * Ez az ablak jelenik meg elsőként a játék futtatása során.
 */
public class SceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public static String nehezseg;

    public static int arany;


    public void konnyu(ActionEvent event) throws IOException {

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



}




