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
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

import java.util.List;
import java.util.Map;

import static com.example.game.megjelenites.Palya.OSZLOPOK_SZAMA;
import static com.example.game.megjelenites.Palya.SOROK_SZAMA;
import static java.util.Objects.requireNonNull;
import static javafx.scene.paint.Color.WHITE;

/**
 * A csatateret modellezi le minden velejárójával együtt.
 */

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
    private final Label korok;
    private final Label userLabel;
    private final Label cpuLabel;
    private final Label ellenfelVarazslatLabel;
    private final Label ellenfelEgysegLabel;
    private final Label ellenfelTulajdonsagLabel;
    private final Label kritikus;

    private final GraphicsContext g;

    private String lenyomottGomb = null;
    private Map<String, String> gombbolVarazslatTipusba;


    public Csatater(Hos hos, String frakcio) {

        this.hos = hos;
        this.ellenfel = new GepiHos(frakcio);
        this.csataterController = new CsataterController(hos, ellenfel);

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
        korok = new Label();
        userLabel = new Label();
        cpuLabel = new Label();
        ellenfelEgysegLabel = new Label();
        ellenfelVarazslatLabel = new Label();
        ellenfelTulajdonsagLabel = new Label();
        kritikus = new Label();

        gombbolVarazslatTipusba = Map.of(
                "V", "Villamcsapas",
                "Z", "Tuzlabda",
                "F", "Feltamasztas",
                "N", "MagikusNyilvesszo",
                "E", "Erosites"
        );


//BUTTONOK
        varazslatTipusLabelek();
        ellenfelVarazslatkiir();
        ellenfelEgysegKiir();
        //ellenfelTulajdonsagKiir();

//ALAPADATOK A JÁTÉKOSRÓL ÉS AZ ELLENFÉLRŐL + A GOMBJAIK

        Label jatekosLabel = jatekosLabel();

        Label cpuLabel = cpuLabel();

        Button sajatVarakozasButton = new Button();
        sajatVarakozasButton.setText("Várakozás");
        sajatVarakozasButton.setTextFill(Color.RED);
        sajatVarakozasButton.setFont(new Font("Candara", 16));
        sajatVarakozasButton.setLayoutX(10);
        sajatVarakozasButton.setLayoutY(40);
        sajatVarakozasButton.setOnAction(event -> {
            csataterController.varakozik();
            frissitKepernyot();
        });
        sajatVarazslatCimKiir();
        kiirKor();

        Label ellenfelVarazslatLabel = ellenfelVarazslatLabel();
        Label ellenfelEgysegLabel = ellenfelEgysegLabel();
        Label ellenfelTulajdonsagLabel = ellenfelTulajdonsagLabel();

        getChildren().addAll(this.jatekterCanvas, jatekosLabel, cpuLabel, ellenfelVarazslatLabel,
                ellenfelEgysegLabel, ellenfelTulajdonsagLabel, sajatVarakozasButton);

        frissitKepernyot();

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
            label.setTextFill(WHITE);
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
        jatekosLabel.setTextFill(WHITE);
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
        sajatVarazslatCimKiir.setTextFill(WHITE);
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
        kiirManna.setTextFill(WHITE);
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
            label1.setTextFill(WHITE);
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
            label.setTextFill(WHITE);
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
        ellenfelVarazslatLabel.setTextFill(WHITE);
        ellenfelVarazslatLabel.setFont(new Font("Candara", 20));
        ellenfelVarazslatLabel.setLayoutX(1000);
        ellenfelVarazslatLabel.setLayoutY(40);
        return ellenfelVarazslatLabel;
    }

    private Label ellenfelEgysegLabel() {
        Label ellenfelEgysegLabel = new Label();
        ellenfelEgysegLabel.setText("Egysegek");
        ellenfelEgysegLabel.setTextFill(WHITE);
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
        ellenfelTulajdonsagLabel.setTextFill(WHITE);
        ellenfelTulajdonsagLabel.setFont(new Font("Candara", 20));
        ellenfelTulajdonsagLabel.setLayoutX(1000);
        ellenfelTulajdonsagLabel.setLayoutY(400);
        return ellenfelTulajdonsagLabel;
    }

    private Label cpuLabel() {
        Label cpuLabel = new Label("CPU");
        cpuLabel.setText("CPU");
        cpuLabel.setTextFill(WHITE);
        cpuLabel.setFont(new Font("Candara", 20));
        cpuLabel.setLayoutX(1200);
        cpuLabel.setLayoutY(10);
        return cpuLabel;
    }


//AKTUÁLIS ADATOK KIIRATÁSA ---------------

    private void kiiratSajatEgysegInfo() {
        sajatTulajdonsagKiir.setTextFill(WHITE);
        sajatTulajdonsagKiir.setFont(new Font("Candara", 20));
        sajatTulajdonsagKiir.setText("Az egység neve: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getNev()
                + "\nAz összes Életerő: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getJelenlegiEletero()
                + "\nLépések száma: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getSebesseg());
        sajatTulajdonsagKiir.setLayoutX(325);
        sajatTulajdonsagKiir.setLayoutY(10);
        getChildren().add(sajatTulajdonsagKiir);
    }

    private void kiiratEllenfelEgysegInfo(Egyseg egyseg) {
        ellenfelEgysegTulajdonsagKiir.setTextFill(WHITE);
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
        varazslatSebezLabel.setTextFill(WHITE);
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
        korok.setFont(new Font("Candara", 20));
        korok.setTextFill(WHITE);
        korok.setText(csataterController.getKor() + ".kör");
        korok.setLayoutX(600);
        korok.setLayoutY(10);
        getChildren().add(korok);
    }

    private void kiiratKritikusSebzes() {
        kritikus.setTextFill(WHITE);
        kritikus.setFont(new Font("Candara", 30));
        kritikus.setText("Kritikus sebzést történt!");
        kritikus.setLayoutX(450);
        kritikus.setLayoutY(670);
        getChildren().add(kritikus);
    }

    //Jáéték vége

    private void vesztettNyertDontetlen() {
        if (csataterController.isNyertel()) {
            getChildren().add(getNyeresLabel("Győztél!", Color.ORANGE));
            jatekterCanvas.setVisible(false);
        } else if (csataterController.isVesztettel()) {
            getChildren().add(getNyeresLabel("Vesztettél!", Color.ORANGE));
            jatekterCanvas.setVisible(false);
        } else if (csataterController.isDontetlen()) {
            getChildren().add(getNyeresLabel("Döntetlen", Color.ORANGE));
            jatekterCanvas.setVisible(false);
        }
    }

    private Label getNyeresLabel(String text, Color color) {
        Label nyertel = new Label();
        nyertel.setFont(new Font("Arial", 80));
        nyertel.setTextFill(color);
        nyertel.setText(text);
        nyertel.setLayoutX(400);
        nyertel.setLayoutY(300);
        return nyertel;
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
            getChildren().remove(kritikus);

            if(lenyomottGomb != null && button == MouseButton.PRIMARY){
                if(!gombbolVarazslatTipusba.containsKey(lenyomottGomb)){
                    throw new EztAGombotNemHasznalhatodException();
                }
                if(kattintottMezo.ures()){
                    throw new AkciokCsakEgysegekreAlkalmazhatoakException();
                }
                String varazslatTipus = gombbolVarazslatTipusba.get(lenyomottGomb);
                csataterController.varazsol(varazslatTipus, kattintottPozicio);
                vesztettNyertDontetlen();
                kiiratEllenfelEgysegInfo(kattintottMezo.getEgyseg());
            }
            else if(button == MouseButton.SECONDARY){
                if(kattintottMezo.ures()){
                    throw new AkciokCsakEgysegekreAlkalmazhatoakException();
                }
                Egyseg kattintottEgyseg = kattintottMezo.getEgyseg();
                csataterController.tamadHos(kattintottMezo.getEgyseg());
                kiiratEllenfelEgysegInfo(kattintottEgyseg);
                vesztettNyertDontetlen();
            }
            else if (kattintottMezo.ures() && button == MouseButton.PRIMARY) {
                csataterController.mozgatEgyseg(kattintottPozicio);
            } else if(button == MouseButton.PRIMARY){
                Egyseg kattintottEgyseg = kattintottMezo.getEgyseg();
                if(csataterController.jelenlegiEgyseg().vajonKritikusSebzes(kattintottEgyseg.getHos().getSzerencse())){
                    csataterController.jelenlegiEgyseg().kritikusSebzes(kattintottEgyseg);
                    kiiratKritikusSebzes();
                }
                else{
                    csataterController.tamad(kattintottMezo.getEgyseg());
                }
                kiiratEllenfelEgysegInfo(kattintottEgyseg);
                vesztettNyertDontetlen();
            }
            frissitKepernyot();
            kiiratSajatEgysegInfo();
        }
        catch (NonInvertibleTransformException e) {
            System.out.println("Nem lehet invertálni");
        }
        catch (NemTudMozogniException | NincsAdottTipusuVarazslatException |
                NincsElegMannaException | EztAGombotNemHasznalhatodException |
                VarazslatokCsakEgysegekreAlkalmazhatoakException e) {
            e.printStackTrace();        //???
            kiiratHiba(e.getMessage());
        }

    }


    //RAJZOLÁS ------------------------
    public void draw() {
        g.setTransform(this.affine);
        g.setFill(WHITE);
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

    private Mezo jelenlegi () {
        return getPalya().getMezo(new Pozicio(sor, oszlop));
    }

    //KÉPERNYŐFRISSÍTÉS
    public void frissitKepernyot() {
        GraphicsContext e = this.jatekterCanvas.getGraphicsContext2D();
        e.setTransform(this.affine);
        tisztitTabla(e);
        csataterController
                .leveszHalottakatPalyarol();
        csataterController
                .getOsszesEgyseg()
                //.stream()
                //.filter(Egyseg::eloE)
                .forEach(egyseg -> rajzolEgyseg(e, egyseg));
        Egyseg jelenlegiEgyseg = csataterController.jelenlegiEgyseg();
        kiemelAktualisEgyseg(e);
        frissitLabels();
        festRacsozat();
    }
    private void kiemelAktualisEgyseg(GraphicsContext e) {
        Egyseg jelenlegiEgyseg = csataterController.jelenlegiEgyseg();
        e.setLineWidth(0.15);
        e.setStroke(Color.LIGHTGREEN);
        e.strokeRect(jelenlegiEgyseg.getPozicio().getOszlop(), jelenlegiEgyseg.getPozicio().getSor(), 1, 1);
    }
    private void frissitLabels() {
        getChildren().remove(kiirManna);
        getChildren().remove(sajatTulajdonsagKiir);
        getChildren().remove(korok);
        kiirManna();
        kiirKor();
    }
    private void tisztitTabla(final GraphicsContext e) {
        for (int sor = 0; sor < SOROK_SZAMA; sor++) {
            for (int oszlop = 0; oszlop < OSZLOPOK_SZAMA; oszlop++) {
                e.setFill(WHITE);
                e.fillRect(oszlop, sor, 1, 1);
            }
        }
    }

    private void rajzolEgyseg(final GraphicsContext e, final Egyseg egyseg) {
        e.drawImage(getEgysegKep(egyseg), egyseg.getPozicio().getOszlop(), egyseg.getPozicio().getSor(), 1, 1);
        e.setLineWidth(0.15);
        e.setStroke(Color.valueOf(egyseg.getKeretSzin()));
        e.strokeRect(egyseg.getPozicio().getOszlop(), egyseg.getPozicio().getSor(), 1, 1);
    }

    private Image getEgysegKep(final Egyseg egyseg) {
        return new Image(
                requireNonNull(
                        this.getClass()
                                .getClassLoader()
                                .getResourceAsStream( "com/example/game/megjelenites/" + egyseg.getNev() + ".png")
                )
        );
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
