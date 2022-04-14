


package com.example.game.megjelenites;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class JatekApplication extends Application {
    //@Override


    /*
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    */


    public static void main(String[] args) {
        launch(args);


    }



    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Nehezsegi_szintek.fxml"));

        Image icon = new Image("C:\\Users\\biroa\\IdeaProjects\\Heros_of_Might_and_Magic\\src\\icon.jpg");
        stage.getIcons().add(icon);
        stage.setTitle("Heros of Might and Magic");
        stage.setHeight(650);
        stage.setWidth(640);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();

    }



}
