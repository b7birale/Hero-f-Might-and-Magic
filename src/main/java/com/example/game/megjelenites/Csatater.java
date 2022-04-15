package com.example.game.megjelenites;

import com.example.game.exception.*;
import com.example.game.hos.GepiHos;
import com.example.game.hos.Hos;
import com.example.game.hos.egysegek.Egyseg;
import com.example.game.hos.egysegek.Pozicio;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

import java.util.List;
import java.util.Map;

public class Csatater extends Parent {


    private GepiHos ellenfel;
    private CsataterController csataterController;
    private Hos hos;

    private Canvas jatekterCanvas;
    private Affine affine;

    int oszlop;
    int sor;

    private final Label sajatTulajdonsagKiir;
    private final Label ellenfelEgysegTulajdonsagKiir;
    private final Label hibaLabel;
    private final Label varazslatSebezLabel;
    private final Label sajatVarazslatCimKiir;
    private final Label kiirManna;

    private final GraphicsContext g;

    private String lenyomottGomb = null;
    private Map<String, String> gombbolVarazslatTipusba;


    public Csatater(Hos hos, String frakcio) {

        this.hos = hos;
        this.ellenfel = new GepiHos(frakcio);
        this.csataterController = new CsataterController(hos, ellenfel);
        Pozicio pozicio = new Pozicio(sor, oszlop);

        jatekterCanvas = new Canvas(600, 400);
        affine = new Affine();
        affine.appendScale(600 / 12f, 400 / 10f);
        g = this.jatekterCanvas.getGraphicsContext2D();
        jatekterCanvas.setLayoutX(325);
        jatekterCanvas.setLayoutY(200);

        jatekterCanvas.setOnMouseClicked(this::egerLenyomas);
        this.setOnKeyPressed(this::gombLenyomas);
        this.setOnKeyReleased(this::gombElenged);

        varazslatSebezLabel = new Label();
        sajatVarazslatCimKiir = new Label();
        sajatTulajdonsagKiir = new Label();
        ellenfelEgysegTulajdonsagKiir = new Label();
        hibaLabel = new Label();
        kiirManna = new Label();

        gombbolVarazslatTipusba = Map.of(
                "V", "Villamcsapas",
                "Z", "Tuzlabda",
                "F", "Feltamasztas",
                "N", "MagikusNyilvesszo",
                "T", "Teleport"
        );


//BUTTONOK
        varazslatTipusLabelek();
        ellenfelVarazslatkiir();
        ellenfelEgysegKiir();

//ALAPADATOK A JÁTÉKOSRÓL ÉS AZ ELLENFÉLRŐL + A GOMBJAIK

        Label jatekosLabel = jatekosLabel();

        Label cpuLabel = cpuLabel();

        Button sajatVarakozasButton = sajatVarakozasButton();
        Button sajatTamadasButton = sajatTamadasButton();
        sajatVarazslatCimKiir();

        Label ellenfelVarazslatLabel = ellenfelVarazslatLabel();
        Label ellenfelEgysegLabel = ellenfelEgysegLabel();
        Label ellenfelTulajdonsagLabel = ellenfelTulajdonsagLabel();

        getChildren().addAll(this.jatekterCanvas, jatekosLabel, cpuLabel, ellenfelVarazslatLabel,
                ellenfelEgysegLabel, ellenfelTulajdonsagLabel, sajatVarakozasButton, sajatTamadasButton);


    }


//TOVÁBBI ADATOK

    //JÁTÉKOS KIIRATÁS ------------------------------------------------
    private void varazslatTipusLabelek() {
        List<Label> varazslatLabel =
                hos.getVarazslatok()
                        .stream()
                        .map(varazslat -> new Label("    " + varazslat.getNev()))
                        .toList();

        int meret = 130;
        for (Label label : varazslatLabel) {
            label.setTextFill(Color.WHITE);
            label.setFont(new Font("Candara", 16));
            label.setLayoutX(10);
            label.setLayoutY(meret);
            meret += 40;
        }
        getChildren().addAll(varazslatLabel);
    }

    private Label jatekosLabel() {
        Label jatekosLabel = new Label();
        jatekosLabel.setText("JÁTÉKOS");
        jatekosLabel.setTextFill(Color.WHITE);
        jatekosLabel.setFont(new Font("Candara", 20));
        jatekosLabel.setLayoutX(10);
        jatekosLabel.setLayoutY(10);
        return jatekosLabel;
    }


    private Button sajatVarakozasButton() {
        Button sajatVarakozasButton = new Button();
        sajatVarakozasButton.setText("Várakozás");
        sajatVarakozasButton.setTextFill(Color.RED);
        sajatVarakozasButton.setFont(new Font("Candara", 16));
        sajatVarakozasButton.setLayoutX(105);
        sajatVarakozasButton.setLayoutY(40);
        return sajatVarakozasButton;
    }

    private void sajatVarazslatCimKiir() {
        sajatVarazslatCimKiir.setText("Varázslatok");
        sajatVarazslatCimKiir.setTextFill(Color.WHITE);
        sajatVarazslatCimKiir.setFont(new Font("Candara", 20));
        sajatVarazslatCimKiir.setLayoutX(10);
        sajatVarazslatCimKiir.setLayoutY(90);
        getChildren().add(sajatVarazslatCimKiir);
    }

    private Button sajatTamadasButton() {
        Button sajatTamadasButton = new Button();
        sajatTamadasButton.setText("Támadás");
        sajatTamadasButton.setTextFill(Color.RED);
        sajatTamadasButton.setFont(new Font("Candara", 16));
        sajatTamadasButton.setLayoutX(205);
        sajatTamadasButton.setLayoutY(40);
        return sajatTamadasButton;
    }

    private void kiirManna(){
        kiirManna.setTextFill(Color.WHITE);
        kiirManna.setText("| Manna: " + hos.getManna());
        kiirManna.setFont(new Font("Candara", 20));
        kiirManna.setLayoutX(120);
        kiirManna.setLayoutY(90);
        getChildren().add(kiirManna);
    }


    //ELLENFÉL KIIRATÁS ---------------------------

    private void ellenfelEgysegKiir() {
        List<Label> egysegLabel =
                ellenfel.getEgysegek()
                        .stream()
                        .map(egyseg -> new Label("    " + egyseg.getNev() + "    " + egyseg.hanyDb() + " db"))
                        .toList();

        int meret = 260;
        for (Label label1 : egysegLabel) {
            label1.setTextFill(Color.WHITE);
            label1.setFont(new Font("Candara", 20));
            label1.setLayoutX(1000);
            label1.setLayoutY(meret);
            meret += 30;
        }
        getChildren().addAll(egysegLabel);
    }

    private void ellenfelVarazslatkiir() {
        List<Label> varazslatLabel =
                ellenfel.getVarazslatok()
                        .stream()
                        .map(varazslat -> new Label("    " + varazslat.getNev()))
                        .toList();

        int meret = 70;
        for (Label label : varazslatLabel) {
            label.setTextFill(Color.WHITE);
            label.setFont(new Font("Candara", 20));
            label.setLayoutX(1000);
            label.setLayoutY(meret);
            meret += 30;
        }
        getChildren().addAll(varazslatLabel);
    }

    private Label ellenfelVarazslatLabel() {
        Label ellenfelVarazslatLabel = new Label();
        ellenfelVarazslatLabel.setText("Varázslatok");
        ellenfelVarazslatLabel.setTextFill(Color.WHITE);
        ellenfelVarazslatLabel.setFont(new Font("Candara", 20));
        ellenfelVarazslatLabel.setLayoutX(1000);
        ellenfelVarazslatLabel.setLayoutY(40);
        return ellenfelVarazslatLabel;
    }

    private Label ellenfelEgysegLabel() {
        Label ellenfelEgysegLabel = new Label();
        ellenfelEgysegLabel.setText("Egysegek");
        ellenfelEgysegLabel.setTextFill(Color.WHITE);
        ellenfelEgysegLabel.setFont(new Font("Candara", 20));
        ellenfelEgysegLabel.setLayoutX(1000);
        ellenfelEgysegLabel.setLayoutY(230);
        return ellenfelEgysegLabel;
    }

    private Label ellenfelTulajdonsagLabel() {
        Label ellenfelTulajdonsagLabel = new Label();
        ellenfelTulajdonsagLabel.setText("Tulajdonsagok\n" +
                "    tamadas = " + ellenfel.getTamadas() + "\n    vedekezes = " + ellenfel.getVedekezes() +
                "\n    tudas = " + ellenfel.getTudas() + "\n    moral = " + ellenfel.getMoral() +
                "\n    varazsero = " + ellenfel.getVarazsero() + "\n    szerencse = " + ellenfel.getSzerencse());
        ellenfelTulajdonsagLabel.setTextFill(Color.WHITE);
        ellenfelTulajdonsagLabel.setFont(new Font("Candara", 20));
        ellenfelTulajdonsagLabel.setLayoutX(1000);
        ellenfelTulajdonsagLabel.setLayoutY(400);
        return ellenfelTulajdonsagLabel;
    }

    private Label cpuLabel() {
        Label cpuLabel = new Label("CPU");
        cpuLabel.setText("CPU");
        cpuLabel.setTextFill(Color.WHITE);
        cpuLabel.setFont(new Font("Candara", 20));
        cpuLabel.setLayoutX(1200);
        cpuLabel.setLayoutY(10);
        return cpuLabel;
    }


//AKTUÁLIS ADATOK KIIRATÁSA ---------------

    private void kiiratSajatEgysegInfo(Pozicio pozicio) {
        sajatTulajdonsagKiir.setTextFill(Color.WHITE);
        sajatTulajdonsagKiir.setFont(new Font("Candara", 20));
        sajatTulajdonsagKiir.setText("Az egység neve: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getNev()
                + "\nAz összes Életerő: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getJelenlegiEletero()
                + "\nLépések száma: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getSebesseg());
        sajatTulajdonsagKiir.setLayoutX(325);
        sajatTulajdonsagKiir.setLayoutY(10);
        getChildren().add(sajatTulajdonsagKiir);
    }

    private void kiiratEllenfelEgysegInfo(Egyseg egyseg) {
        ellenfelEgysegTulajdonsagKiir.setTextFill(Color.WHITE);
        ellenfelEgysegTulajdonsagKiir.setFont(new Font("Candara", 20));
        ellenfelEgysegTulajdonsagKiir.setText("Az ellenfélegyseg neve: " + egyseg.getNev() +
                "\nösszes életerejük: " + egyseg.getJelenlegiEletero() +
                "\ndb: " + egyseg.hanyDb());
        ellenfelEgysegTulajdonsagKiir.setLayoutX(725);
        ellenfelEgysegTulajdonsagKiir.setLayoutY(10);
        getChildren().add(ellenfelEgysegTulajdonsagKiir);
    }

    private void VillamcsapasSebezLabel(Mezo kattintottMezo) {
        varazslatSebezLabel.setFont(new Font("Candara", 20));
        varazslatSebezLabel.setLayoutX(450);
        varazslatSebezLabel.setLayoutY(150);
        varazslatSebezLabel.setTextFill(Color.WHITE);
        varazslatSebezLabel.setText("Megsebzett ellenfél: " + kattintottMezo.getEgyseg().getNev() +
                "\nMegsebzett ellenfél maradék életereje: " + kattintottMezo.getEgyseg().getJelenlegiEletero());
        getChildren().add(varazslatSebezLabel);
    }

    //HIBAÜZENET KIIRATÁSA
    private void kiiratHiba(String uzenet) {
        hibaLabel.setTextFill(Color.RED);
        hibaLabel.setFont(new Font("Candara", 30));
        hibaLabel.setText(uzenet);
        hibaLabel.setLayoutX(500);
        hibaLabel.setLayoutY(625);
        getChildren().add(hibaLabel);
    }

    //JELENLEGI KÖR KIIRATÁSA
    private void kiirKor() {
        Label kor = new Label();
        kor.setFont(new Font("Candara", 20));
        kor.setTextFill(Color.WHITE);
        kor.setText(csataterController.korszamlalo() + ".kör");
        kor.setLayoutX(10);
        kor.setLayoutY(600);
        getChildren().add(kor);
    }

    //Jáéték vége
    private void vesztettNyertDontetlen() {
        if (csataterController.isNyertel()) {
            Label nyertel = new Label();
            nyertel.setFont(new Font("Arial", 80));
            nyertel.setTextFill(Color.GREEN);
            nyertel.setText("Győzelem");
            nyertel.setLayoutX(400);
            nyertel.setLayoutY(300);
            getChildren().add(nyertel);
            jatekterCanvas.setVisible(false);
        } else if (csataterController.isVesztettel()) {
            Label vesztettel = new Label();
            vesztettel.setFont(new Font("Arial", 80));
            vesztettel.setTextFill(Color.RED);
            vesztettel.setText("Vereség");
            vesztettel.setLayoutX(400);
            vesztettel.setLayoutY(300);
            getChildren().add(vesztettel);
            jatekterCanvas.setVisible(false);
        } else if (csataterController.isDontetlen()) {
            Label dontetlen = new Label();
            dontetlen.setFont(new Font("Arial", 80));
            dontetlen.setTextFill(Color.BLUE);
            dontetlen.setText("Döntetlen");
            dontetlen.setLayoutX(400);
            dontetlen.setLayoutY(300);
            getChildren().add(dontetlen);
            jatekterCanvas.setVisible(false);
        }
    }

    //BILLENYTŰK ÉS EGÉR-KLIKKELÉS--------------------------------

    private void gombElenged(KeyEvent keyEvent) {
        lenyomottGomb = null;
    }

    private void gombLenyomas(KeyEvent keyEvent) {
        if (gombbolVarazslatTipusba.containsKey(keyEvent.getCode().getChar())) {
            lenyomottGomb = keyEvent.getCode().getChar();
        }
    }

    private void egerLenyomas(MouseEvent event) {
        double egerX = event.getX();
        double egerY = event.getY();

        try {
            Point2D koordinata = this.affine.inverseTransform(egerX, egerY);
            Pozicio kattintottPozicio = new Pozicio((int) koordinata.getY(), (int) koordinata.getX());
            Mezo kattintottMezo = csataterController.getMezo(kattintottPozicio);
            MouseButton button = event.getButton();
            getChildren().remove(hibaLabel);
            getChildren().remove(ellenfelEgysegTulajdonsagKiir);
            getChildren().remove(varazslatSebezLabel);

            if(lenyomottGomb != null && button == MouseButton.PRIMARY){
                if(!gombbolVarazslatTipusba.containsKey(lenyomottGomb)){
                    throw new EztAGombotNemHasznalhatodException();
                }
                String varazslatTipus = gombbolVarazslatTipusba.get(lenyomottGomb);
                csataterController.varazsol(varazslatTipus, kattintottPozicio);
            }

            if(button == MouseButton.SECONDARY){
                if(kattintottMezo.ures()){
                    throw new AkciokCsakEgysegekreAlkalmazhatoakException();
                }
                Egyseg kattintottEgyseg = kattintottMezo.getEgyseg();
                csataterController.tamadHos(kattintottMezo.getEgyseg());
                kiiratEllenfelEgysegInfo(kattintottMezo.getEgyseg());
                kiiratEllenfelEgysegInfo(kattintottEgyseg);
                vesztettNyertDontetlen();
            }
            else if (kattintottMezo.ures() && button == MouseButton.PRIMARY) {
                csataterController.mozgatEgyseg(kattintottPozicio);
            } else if(button == MouseButton.PRIMARY){
                Egyseg kattintottEgyseg = kattintottMezo.getEgyseg();
                csataterController.tamad(kattintottMezo.getEgyseg());
                kiiratEllenfelEgysegInfo(kattintottEgyseg);
                vesztettNyertDontetlen();
            }
            frissitKepernyot();
            kiiratSajatEgysegInfo(kattintottPozicio);
        }
        catch (NonInvertibleTransformException e) {
            System.out.println("Nem lehet invertálni");
        }
        catch (NemTudMozogniException | NincsAdottTipusuVarazslatException |
                NincsElegMannaException | EztAGombotNemHasznalhatodException |
                VarazslatokCsakEgysegekreAlkalmazhatoakException e) {
            e.printStackTrace();
            kiiratHiba(e.getMessage());
        }

    }


    //RAJZOLÁS ------------------------
    public void draw() {
        g.setTransform(this.affine);
        g.setFill(Color.WHITE);
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

    private void festRacsozat () {
        GraphicsContext g = this.jatekterCanvas.getGraphicsContext2D();
        g.setTransform(this.affine);
        g.setStroke(Color.BLACK);
        g.setLineWidth(0.022);
        for (int i = 0; i <= 12; i++) {
            g.strokeLine(i, 0, i, 10);
        }
        for (int j = 0; j <= 10; j++) {
            g.strokeLine(0, j, 12, j);
        }
    }


//EGYÉB FONTOS METÓDUSOK -------------------------

    public void egysegLetesz() {
        hos.getEgysegek()
                .forEach(csataterController::lehelyez);
        ellenfel.getEgysegek()
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
                    e.setStroke(Color.DARKRED);
                    e.setLineWidth(0.1);
                    e.strokeRect(csataterController.jelenlegiEgysegOSzlop(),
                            csataterController.JelenlegiEgysegSor(), 1, 1);
                } else {
                    e.setFill(Color.WHITE);
                }
                e.fillRect(oszlop, sor, 1, 1);
                festRacsozat();
                for (int i = 0; i < ellenfel.getEgysegek().size(); i++) {
                    e.setLineWidth(0.15);
                    e.setStroke(Color.GOLD);
                    e.strokeRect(ellenfel.getEgysegek().get(i).getPozicio().getOszlop(),ellenfel.getEgysegek().get(i).getPozicio().getSor(),1,1);
                }
                getChildren().remove(kiirManna);
                kiirManna();
                getChildren().remove(sajatTulajdonsagKiir);
            }
        }
    }

    private Mezo jelenlegi () {
        return getPalya().getMezo(new Pozicio(sor, oszlop));
    }


    //GETTEREK ÉS SETTEREK

    private Palya getPalya () {
        return csataterController.getPalya();
    }
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



    /*
    //sorrend választás?
    public Egyseg soronKovetkezo(List<Egyseg> egysegek){
        Egyseg[] sorrend = new Egyseg[egysegek.size()];
        for(int i=0; i<egysegek.size(); i++){
            sorrend[i] = egysegek.get(i);
        }
        for(int i = sorrend.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sorrend[j].getKezdemenyezes() < sorrend[j + 1].getKezdemenyezes()) {
                    Egyseg puffer = sorrend[j];
                    sorrend[j] = sorrend[j + 1];
                    sorrend[j + 1] = puffer;
                }
            }
        }
        return sorrend[0];
    }

     */

}
