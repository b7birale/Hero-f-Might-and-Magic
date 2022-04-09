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
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

import java.util.List;
import java.util.Objects;

public class Csatater extends Parent {


    private Hos ellenfel = new EllenfelHos();
    private CsataterController csataterController;
    private Hos hos;
    /*
    private Pozicio pozicio;
    private Egyseg foldmuves;
    private Varazslat villamcsapas;

     */

    private Canvas jatekterCanvas;
    private Affine affine;
    int oszlop;
    int sor;
    private final Label tulajdonsagKiir = new Label();
    //private int ellenfelSor;
    //private int hosSor = 0;


    public Csatater(Hos hos) {

        this.hos = hos;
        this.csataterController = new CsataterController(hos);
        Pozicio pozicio = new Pozicio(sor, oszlop);

        jatekterCanvas = new Canvas(600, 400);
        affine = new Affine();
        affine.appendScale(600 / 12f, 400 / 10f);
        jatekterCanvas.setLayoutX(325);
        jatekterCanvas.setLayoutY(200);
        jatekterCanvas.setOnMouseClicked(this::egerLenyomas);

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
            Pozicio kattintottPozicio = new Pozicio((int) koordinata.getY(), (int) koordinata.getX());
            Mezo kattintottMezo = csataterController.getMezo(kattintottPozicio);

            if (kattintottMezo.ures()) {
                csataterController.mozgatEgyseg(kattintottPozicio);
            } else {
                csataterController.tamad(kattintottMezo.getEgyseg());
            }


            kiiratEgysegInfo();
            frissitKepernyot();

        } catch (NonInvertibleTransformException e) {
            System.out.println("Nem lehet invertálni");
        }
    }

    private void kiiratEgysegInfo() {
        if (!getPalya().getMezo(new Pozicio(sor, oszlop)).ures()) {
            tulajdonsagKiir.setTextFill(Color.RED);
            tulajdonsagKiir.setFont(new Font("Arial", 20));
            tulajdonsagKiir.setText("Az egység neve: " + jelenlegi().getEgyseg().getNev() +
                    "\nDarabszáma: " + jelenlegi().getEgyseg().hanyDb() + "\nÉleterejük összesen: " +
                    jelenlegi().getEgyseg().getJelenlegiEletero() + "\nLépések száma: " +
                    jelenlegi().getEgyseg().getSebesseg());
            tulajdonsagKiir.setLayoutX(325);
            tulajdonsagKiir.setLayoutY(10);
            getChildren().add(tulajdonsagKiir);
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


    public void egysegLetesz() {
        hos.getEgysegek()
                .forEach(csataterController::lehelyez);

        frissitKepernyot();
    }


    public void frissitKepernyot() {

        GraphicsContext e = this.jatekterCanvas.getGraphicsContext2D();
        e.setTransform(this.affine);

        for (int sor = 0; sor < Palya.SOROK_SZAMA; sor++) {
            for (int oszlop = 0; oszlop < Palya.OSZLOPOK_SZAMA; oszlop++) {
                final Mezo jelenlegiMezo = getPalya().getMezo(new Pozicio(sor, oszlop));
                if (!jelenlegiMezo.ures()) {
                    e.setFill(Color.valueOf(jelenlegiMezo.getEgyseg().getSzin()));
                } else {
                    e.setFill(Color.LIGHTGRAY);
                }
                e.fillRect(oszlop, sor, 1, 1);
                festRacsozat();
                getChildren().remove(tulajdonsagKiir);
            }
        }
    }

        public void varazslatGombok () {
            List<Button> varazslatGombok =
                    hos.getVarazslatok()
                            .stream()
                            .map(varazslat1 -> new Button(varazslat1.getNev()))
                            .toList();

            int meret = 80;
            for (Button button : varazslatGombok) {
                button.setLayoutX(10);
                button.setLayoutY(meret);
                meret += 40;
            }
            getChildren().addAll(varazslatGombok);
        }


        private void festRacsozat () {
            GraphicsContext g = this.jatekterCanvas.getGraphicsContext2D();
            g.setTransform(this.affine);
            g.setStroke(Color.BLACK);
            g.setLineWidth(0.03);
            for (int i = 0; i <= 12; i++) {
                g.strokeLine(i, 0, i, 10);
            }
            for (int j = 0; j <= 10; j++) {
                g.strokeLine(0, j, 12, j);
            }
        }

        private Mezo jelenlegi () {
            return getPalya().getMezo(new Pozicio(sor, oszlop));
        }

        private Palya getPalya () {
            return csataterController.getPalya();
        }


        //GETTEREK ÉS SETTEREK

        public CsataterController getCsataterController () {
            return csataterController;
        }

        public void setCsataterController (CsataterController csataterController){
            this.csataterController = csataterController;
        }

        public Hos getHos () {
            return hos;
        }

        public void setHos (Hos hos){
            this.hos = hos;
        }


        //// TODO: 2022. 04. 03. Kitölteni képpel vagy színnel a cellákat

}
