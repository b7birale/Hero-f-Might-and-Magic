package com.example.game.hos.varazslatok;

import com.example.game.hos.EmberiHos;
import com.example.game.hos.Hos;
import com.example.game.megjelenites.SceneController;
import com.example.game.hos.egysegek.frakciok.controller.FrakcioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A Varazslat kontroller osztálya.
 * Ez a controller osztálya annak az ablaknak, ahol megvásároljuk a varázslatokat.
 * Ezen ablak megjelenítése, formázása a célja.
 * Adatokat gyűjt a játékos hőséhez. Ez a harmadik ilyen ablak.
 */
public class VarazslatController {

    Hos hos = new EmberiHos();

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

    /**
     * Megvásárolja a villámcsapás varázslatot.
     * A vásárlás csak akkor történik meg ténylegesen, ha van elég aranyunk és még nem vettük meg.
     * Ellenkező esetben megjelenik a figyelmeztető szöveg.
     */
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
    private Text erosites_megvette;
    boolean erosites = false;
    public void buyErosites(){
        if(!erosites && SceneController.arany - 100 >= 0) {
            erosites = true;
            erosites_megvette.setText("Megvetted!");
            SceneController.arany = SceneController.arany - 100;
            arany.setText(String.valueOf(SceneController.arany));
        }
        else{
            if(erosites){
                erosites_megvette.setText("Már megvetted!");
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

    /**
     * Az alul megjelenő tovább gomb metódusa.
     * Továbblépteti a felhasználót a következő ablakra.
     * Eltárolja a hősről szerzett új információkat.
     * @param event
     * @throws IOException
     */
    public void tovabb(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Frakciok.fxml"));
        root = loader.load();

        FrakcioController macska = loader.getController();
        macska.writeGold(SceneController.arany);


        if(villamcsapas){
            Villamcsapas villamcsapas = new Villamcsapas(hos);
            hos.addVarazslatok(villamcsapas);
        }
        if(tuzlabda){
            Tuzlabda tuzlabda = new Tuzlabda(hos);
            hos.addVarazslatok(tuzlabda);
        }
        if(feltamasztas){
            Feltamasztas feltamasztas = new Feltamasztas(hos);
            hos.addVarazslatok(feltamasztas);
        }
        if(erosites){
            Erosites erosites = new Erosites(hos);
            hos.addVarazslatok(erosites);
        }
        if(magikusNyilvesszo){
            MagicArrow magikusNyilvesszo = new MagicArrow(hos);
            hos.addVarazslatok(magikusNyilvesszo);
        }

        macska.setHos(hos);


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}

