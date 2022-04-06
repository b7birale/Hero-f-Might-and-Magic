package com.example.game.megjelenites;

import com.example.game.hos.EllenfelHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import com.example.game.hos.egysegek.emberek.Foldmuves;
import com.example.game.hos.varazslatok.Varazslat;
import com.example.game.hos.varazslatok.Villamcsapas;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Csatater extends Parent {


    private Hos ellenfel = new EllenfelHos();
    private CsataterController csataterController;
    private Hos hos;
    private Pozicio pozicio;
    private Egyseg foldmuves;
    private Varazslat villamcsapas;
    private Canvas jatekterCanvas;
    private Affine affine;
    int koordinataX;
    int koordinataY;
    private int ellenfelSor;
    private int hosSor = 0;


    public Csatater(Hos hos) {

        this.ellenfelSor = 0;
        this.foldmuves = new Foldmuves(hos, hos.getDb());
        this.villamcsapas = new Villamcsapas(hos);
        this.hos = hos;
        this.csataterController = new CsataterController();
        this.pozicio = new Pozicio(koordinataY, koordinataX);

        jatekterCanvas = new Canvas(600, 400);
        affine = new Affine();
        affine.appendScale(600 / 12f, 400 / 10f);
        jatekterCanvas.setLayoutX(325);
        jatekterCanvas.setLayoutY(200);
        jatekterCanvas.setOnMousePressed(this::egerLenyomas);

        Button inicializal = new Button("mehet");
        inicializal.setOnAction(ActionEvent -> {
            egysegLetesz();
            inicializal.setDisable(true);
        });
        inicializal.setLayoutX(10);
        inicializal.setLayoutY(200);

//BUTTONOK
        varazslatGombok();

//LABELEK
        //JÁTÉKOS
        Label userLabel = new Label();
        userLabel.setText("JÁTÉKOS");
        userLabel.setTextFill(Color.RED);
        userLabel.setFont(new Font("Arial", 20));
        userLabel.setLayoutX(10);
        userLabel.setLayoutY(10);


        //CPU
        Label cpuLabel = new Label();
        cpuLabel.setText("CPU");
        cpuLabel.setTextFill(Color.RED);
        cpuLabel.setFont(new Font("Arial", 20));
        cpuLabel.setLayoutX(1200);
        cpuLabel.setLayoutY(10);

        //VARÁZSLAT
        Label varazslatLabel = new Label();
        varazslatLabel.setText("Varázslatok:");
        varazslatLabel.setTextFill(Color.RED);
        varazslatLabel.setFont(new Font("Arial", 20));
        varazslatLabel.setLayoutX(10);
        varazslatLabel.setLayoutY(40);


        getChildren().addAll(this.jatekterCanvas, userLabel, cpuLabel, varazslatLabel, inicializal);

        frissitKepernyot();
    }


    private void egerLenyomas(MouseEvent event) {
        double egerX = event.getX();
        double egerY = event.getY();

        try {
            Point2D koordinata = this.affine.inverseTransform(egerX, egerY);
            // X = OSZLOP
            koordinataX = (int) koordinata.getX();
            // Y = SOR
            koordinataY = (int) koordinata.getY();
            System.out.println("Oszlop: " + koordinataX + ", Sor: " + koordinataY);

        } catch (NonInvertibleTransformException e) {
            System.out.println("Nem lehet invertálni");
        }
    }

    public void draw() {
        GraphicsContext g = this.jatekterCanvas.getGraphicsContext2D();
        g.setTransform(this.affine);

        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0, 0, 400, 200);

        g.setStroke(Color.BLACK);
        g.setLineWidth(0.03);

        for (int i = 0; i <= 12; i++) {
            g.strokeLine(i, 0, i, 10);
        }
        for (int j = 0; j <= 10; j++) {
            g.strokeLine(0, j, 12, j);
        }
    }

    public void ellenfelLetesz() {
        ellenfel.getEgysegek()
                .stream()
                .forEach(egyseg -> {
                    csataterController.lehelyez(new Pozicio(ellenfelSor++, Palya.OSZLOPOK_SZAMA - 1));
                });
        frissitKepernyot();
    }

    public void egysegLetesz() {
        for (int i = 0; i < hos.getEgysegek().size(); i++) {
            csataterController.lehelyez(new Pozicio(hosSor++, 1));
            frissitKepernyot();
        }
    }


    public void frissitKepernyot() {

        GraphicsContext e = this.jatekterCanvas.getGraphicsContext2D();
        e.setTransform(this.affine);

        for (int sor = 0; sor < Palya.SOROK_SZAMA; sor++) {
            for (int oszlop = 0; oszlop < Palya.OSZLOPOK_SZAMA; oszlop++) {

                if (!csataterController.getPalya().getMezo(new Pozicio(sor, oszlop)).ures()) {
                    for (int i = 0; i < hos.getEgysegek().size(); i++) {

                        if (Objects.equals(hos.getEgysegek().get(i).getNev(), "Foldmuves")) {
                            e.setFill(Color.RED);
                            e.fillRect(0, 0, 1, 1);
                            //hos.getEgysegek().remove(0);
                        }
                        else if (Objects.equals(hos.getEgysegek().get(i).getNev(), "Ijasz")) {
                            e.setFill(Color.GREEN);
                            e.fillRect(0, 1, 1, 1);
                            //hos.getEgysegek().remove(0);
                        }
                        else if (Objects.equals(hos.getEgysegek().get(i).getNev(), "Griff")){
                            e.setFill(Color.PINK);
                            e.fillRect(0,2, 1, 1);
                            //hos.getEgysegek().remove(0);
                        }
                        else if (Objects.equals(hos.getEgysegek().get(i).getNev(), "Zombi")){
                            e.setFill(Color.GRAY);
                            e.fillRect(0,3, 1, 1);
                            //hos.getEgysegek().remove(0);
                        }
                        else if (Objects.equals(hos.getEgysegek().get(i).getNev(), "Lovag")){
                            e.setFill(Color.YELLOW);
                            e.fillRect(0,4, 1, 1);
                            //hos.getEgysegek().remove(0);
                        }
                    }
                }
            }
        }
    }

    public void varazslatGombok() {
        List<Button> varazslatGombok =
                hos.getVarazslatok()
                        .stream()
                        .map(varazslat1 -> new Button(varazslat1.getNev()))
                        .toList();

        int meret = 80;
        for (int i = 0; i < varazslatGombok.size(); i++) {
            varazslatGombok.get(i).setLayoutX(10);
            varazslatGombok.get(i).setLayoutY(meret);
            meret += 40;
            varazslatGombok.get(i).setOnAction(actionEvent -> {
                hos.varazsol(villamcsapas.getNev(), hos.getEgysegek());
            });

            varazslatGombok.get(i).setOnAction(actionEvent -> {
                //itt kéne a varázslat sebzését levonni az egységek életerejéből
                //nem működik ebben a szarban már semmi
                villamcsapas.vegrehajt(hos.getEgysegek());
                System.out.println(foldmuves.getJelenlegiEletero());
            });
        }

        getChildren().addAll(varazslatGombok);
    }


    public CsataterController getCsataterController() {
        return csataterController;
    }

    public void setCsataterController(CsataterController csataterController) {
        this.csataterController = csataterController;
    }

    public Hos getHos() {
        return hos;
    }

    public void setHos(Hos hos) {
        this.hos = hos;
    }


    //// TODO: 2022. 04. 03. Kitölteni képpel vagy színnel a cellákat
}