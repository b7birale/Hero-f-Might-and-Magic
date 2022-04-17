package com.example.game.megjelenites;

import com.example.game.exception.*;
import com.example.game.hos.automataHos;
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


    private automataHos ellenfel;
    private CsataterController csataterController;
    private Hos hos;

    private Canvas negyzetracs;
    private Affine racs;

    int oszlop;
    int sor;

    private final Label sajatEgysegInfoLabel;
    private final Label ellenfelEgysegInfoLabel;
    private final Label hibauzenetLabel;
    private final Label varazslatSebezLabel;
    private final Label nemValtozoVarazslatKiirLabel;
    private final Label mannaKiirLabel;
    private final Label hanyadikKorLabel;
    private final Label kritikusSebzesLabel;

    private final GraphicsContext g;

    private String lenyomottBillenytu = null;
    private final Map<String, String> billentyuConvertToVarazslat;


    public Csatater(Hos hos, String frakcio) {

        this.hos = hos;
        this.ellenfel = new automataHos(frakcio);
        this.csataterController = new CsataterController(hos, ellenfel);

        negyzetracs = new Canvas(600, 400);
        racs = new Affine();
        racs.appendScale(600 / 12f, 400 / 10f);
        g = this.negyzetracs.getGraphicsContext2D();
        negyzetracs.setLayoutX(325);
        negyzetracs.setLayoutY(200);

        negyzetracs.setOnMouseClicked(this::mouseClick);
        this.setOnKeyPressed(this::keyPress);
        this.setOnKeyReleased(this::keyRelease);

        varazslatSebezLabel = new Label();
        nemValtozoVarazslatKiirLabel = new Label();
        sajatEgysegInfoLabel = new Label();
        ellenfelEgysegInfoLabel = new Label();
        hibauzenetLabel = new Label();
        mannaKiirLabel = new Label();
        hanyadikKorLabel = new Label();
        Label felhasznaloLabel1 = new Label();
        Label automataEllenfelLabel = new Label();
        Label ellenfelEgysegLabel1 = new Label();
        Label ellenfelVarazslatLabel1 = new Label();
        Label ellenfelTulajdonsagLabel1 = new Label();
        kritikusSebzesLabel = new Label();

        billentyuConvertToVarazslat = Map.of(
                "V", "Villamcsapas",
                "T", "Tuzlabda",
                "F", "Feltamasztas",
                "N", "MagikusNyilvesszo",
                "E", "Erosites"
        );


//BUTTONOK
        sajatMeglevoVarazslatokLabel();
        kiirEllenfelVarazslataiLabel();
        ellensegesEgysegInfoKiirLabel();

//ALAPADATOK A JÁTÉKOSRÓL ÉS AZ ELLENFÉLRŐL + A GOMBJAIK

        Label felhasznaloLabel = felhasznaloLabel();

        Label automataELlenfelLabel = automataEllenfelLabel();

        Button varakozasGomb = new Button();
        varakozasGomb.setText("Várakozás");
        varakozasGomb.setTextFill(Color.BLACK);
        varakozasGomb.setFont(new Font("Candara", 16));
        varakozasGomb.setLayoutX(10);
        varakozasGomb.setLayoutY(40);
        varakozasGomb.setOnAction(event -> {
            csataterController.passzol();
            updateScreen();
        });
        nemValtozoSajatVarazslatokKiir();
        korszamKiiratas();

        Label ellenfelVarazslatSzovegKiirLabel = ellenfelVarazslatSzovegKiirLabel();
        Label ellenfelEgysegSzovegKiirLabel = ellenfelEgysegSzovegKiirLabel();
        Label ellenfelTulajdonsagSzovegKiirLabel = ellenfelTulajdonsagSzovegKiirLabel();

        getChildren().addAll(this.negyzetracs, felhasznaloLabel, automataELlenfelLabel, ellenfelVarazslatSzovegKiirLabel,
                ellenfelEgysegSzovegKiirLabel, ellenfelTulajdonsagSzovegKiirLabel, varakozasGomb);

        updateScreen();

    }


//TOVÁBBI ADATOK

    //JÁTÉKOS KIIRATÁS ------------------------------------------------
    private void sajatMeglevoVarazslatokLabel() {
        List<Label> varazslatLabel = hos.getVarazslatok().stream().map(varazslat -> new Label("    " + varazslat.getNev() + "    " + varazslat.billentyuKombinacio() + " \n")).toList();

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

    private Label felhasznaloLabel() {
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

    private void nemValtozoSajatVarazslatokKiir() {
        nemValtozoVarazslatKiirLabel.setText("Varázslatok");
        nemValtozoVarazslatKiirLabel.setTextFill(WHITE);
        nemValtozoVarazslatKiirLabel.setFont(new Font("Candara", 20));
        nemValtozoVarazslatKiirLabel.setLayoutX(10);
        nemValtozoVarazslatKiirLabel.setLayoutY(90);
        getChildren().add(nemValtozoVarazslatKiirLabel);
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

    private void kiirManna() {
        mannaKiirLabel.setTextFill(WHITE);
        mannaKiirLabel.setText("| Manna: " + hos.getManna());
        mannaKiirLabel.setFont(new Font("Candara", 20));
        mannaKiirLabel.setLayoutX(120);
        mannaKiirLabel.setLayoutY(90);
        getChildren().add(mannaKiirLabel);
    }


    //ELLENFÉL KIIRATÁS ---------------------------

    private void ellensegesEgysegInfoKiirLabel() {
        List<Label> egysegLabel = ellenfel.getEgysegek().stream().map(egyseg -> new Label("    " + egyseg.getNev() + "    " + egyseg.hanyDb() + " db")).toList();

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

    private void kiirEllenfelVarazslataiLabel() {
        List<Label> varazslatLabel = ellenfel.getVarazslatok().stream().map(varazslat -> new Label("    " + varazslat.getNev())).toList();

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

    private Label ellenfelVarazslatSzovegKiirLabel() {
        Label ellenfelVarazslatLabel = new Label();
        ellenfelVarazslatLabel.setText("Varázslatok");
        ellenfelVarazslatLabel.setTextFill(WHITE);
        ellenfelVarazslatLabel.setFont(new Font("Candara", 20));
        ellenfelVarazslatLabel.setLayoutX(1000);
        ellenfelVarazslatLabel.setLayoutY(40);
        return ellenfelVarazslatLabel;
    }

    private Label ellenfelEgysegSzovegKiirLabel() {
        Label ellenfelEgysegLabel = new Label();
        ellenfelEgysegLabel.setText("Egysegek");
        ellenfelEgysegLabel.setTextFill(WHITE);
        ellenfelEgysegLabel.setFont(new Font("Candara", 20));
        ellenfelEgysegLabel.setLayoutX(1000);
        ellenfelEgysegLabel.setLayoutY(230);
        return ellenfelEgysegLabel;
    }

    private Label ellenfelTulajdonsagSzovegKiirLabel() {
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


    private Label automataEllenfelLabel() {
        Label automataEllenfelLabel = new Label("AUTOMATA ELLENFEL");
        automataEllenfelLabel.setText("AUTOMATA ELLENFEL");
        automataEllenfelLabel.setTextFill(WHITE);
        automataEllenfelLabel.setFont(new Font("Candara", 20));
        automataEllenfelLabel.setLayoutX(1200);
        automataEllenfelLabel.setLayoutY(10);
        return automataEllenfelLabel;
    }


//AKTUÁLIS ADATOK KIIRATÁSA ---------------

    private void kiirSajatEgysegAllapot() {
        sajatEgysegInfoLabel.setTextFill(WHITE);
        sajatEgysegInfoLabel.setFont(new Font("Candara", 20));
        sajatEgysegInfoLabel.setText("Az egység neve: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getNev()
                + "\nAz összes Életerő: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getJelenlegiEletero()
                + "\nLépések száma: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getSebesseg()
                + "\nMaximális sebzése: " + csataterController.getOsszesEgyseg().get(csataterController.getJelenlegiEgysegIndex()).getMaxSebzes());
        sajatEgysegInfoLabel.setLayoutX(325);
        sajatEgysegInfoLabel.setLayoutY(10);
        getChildren().add(sajatEgysegInfoLabel);
    }

    private void kiirEllensegesEgysegAllapot(Egyseg egyseg) {
        ellenfelEgysegInfoLabel.setTextFill(WHITE);
        ellenfelEgysegInfoLabel.setFont(new Font("Candara", 20));
        ellenfelEgysegInfoLabel.setText("Az ellenfélegyseg neve: " + egyseg.getNev() +
                "\nösszes életerejük: " + egyseg.getJelenlegiEletero() +
                "\ndb: " + egyseg.hanyDb());
        ellenfelEgysegInfoLabel.setLayoutX(725);
        ellenfelEgysegInfoLabel.setLayoutY(10);
        getChildren().add(ellenfelEgysegInfoLabel);
    }

    private void VillamcsapasSebezLabel(Cella kattintottCella) {
        varazslatSebezLabel.setFont(new Font("Candara", 20));
        varazslatSebezLabel.setLayoutX(450);
        varazslatSebezLabel.setLayoutY(150);
        varazslatSebezLabel.setTextFill(WHITE);
        varazslatSebezLabel.setText("Megsebzett ellenfél: " + kattintottCella.getEgyseg().getNev() +
                "\nMegsebzett ellenfél maradék életereje: " + kattintottCella.getEgyseg().getJelenlegiEletero());
        getChildren().add(varazslatSebezLabel);
    }

    //HIBAÜZENET KIIRATÁSA
    private void kiirHibauzenet(String uzenet) {
        hibauzenetLabel.setTextFill(Color.RED);
        hibauzenetLabel.setFont(new Font("Candara", 30));
        hibauzenetLabel.setText(uzenet);
        hibauzenetLabel.setLayoutX(500);
        hibauzenetLabel.setLayoutY(625);
        getChildren().add(hibauzenetLabel);
    }

    //JELENLEGI KÖR KIIRATÁSA
    private void korszamKiiratas() {
        hanyadikKorLabel.setFont(new Font("Candara", 20));
        hanyadikKorLabel.setTextFill(WHITE);
        hanyadikKorLabel.setText(csataterController.getKor() + ".kör");
        hanyadikKorLabel.setLayoutX(600);
        hanyadikKorLabel.setLayoutY(10);
        getChildren().add(hanyadikKorLabel);
    }

    private void kiiratKritikusSebzes() {
        kritikusSebzesLabel.setTextFill(WHITE);
        kritikusSebzesLabel.setFont(new Font("Candara", 30));
        kritikusSebzesLabel.setText("Kritikus sebzést történt!");
        kritikusSebzesLabel.setLayoutX(450);
        kritikusSebzesLabel.setLayoutY(670);
        getChildren().add(kritikusSebzesLabel);
    }

    //Jáéték vége

    private boolean jatekVegkimenetele() {
        if (csataterController.isWin()) {
            getChildren().add(winLabel("Győztél!", Color.ORANGE));
            negyzetracs.setVisible(false);
            return true;
        } else if (csataterController.isLose()) {
            getChildren().add(winLabel("Vesztettél!", Color.ORANGE));
            negyzetracs.setVisible(false);
            return true;
        } else if (csataterController.isDraw()) {
            getChildren().add(winLabel("Döntetlen", Color.ORANGE));
            negyzetracs.setVisible(false);
            return true;
        }
        return false;
    }


    private Label winLabel(String text, Color color) {
        Label nyertel = new Label();
        nyertel.setFont(new Font("Arial", 80));
        nyertel.setTextFill(color);
        nyertel.setText(text);
        nyertel.setLayoutX(400);
        nyertel.setLayoutY(300);
        return nyertel;
    }

    //BILLENYTŰK ÉS EGÉR-KLIKKELÉS--------------------------------

    private void keyRelease(KeyEvent keyEvent) {
        lenyomottBillenytu = null;
    }

    private void keyPress(KeyEvent keyEvent) {
        if (billentyuConvertToVarazslat.containsKey(keyEvent.getCode().getChar())) {
            lenyomottBillenytu = keyEvent.getCode().getChar();
        }
    }

    private void mouseClick(MouseEvent event) {
        double egerX = event.getX();
        double egerY = event.getY();

        try {
            Point2D koordinata = this.racs.inverseTransform(egerX, egerY);
            Pozicio kattintottPozicio = new Pozicio((int) koordinata.getY(), (int) koordinata.getX());
            Cella kattintottCella = csataterController.getMezo(kattintottPozicio);
            MouseButton button = event.getButton();
            getChildren().remove(hibauzenetLabel);
            getChildren().remove(ellenfelEgysegInfoLabel);
            getChildren().remove(varazslatSebezLabel);
            getChildren().remove(kritikusSebzesLabel);

            if (lenyomottBillenytu != null && button == MouseButton.PRIMARY) {
                if (!billentyuConvertToVarazslat.containsKey(lenyomottBillenytu)) {
                    throw new ErvenytelenBillenytuBemenetException();
                }
                if (kattintottCella.ures()) {
                    throw new NemEgysegreProbalszAkciotVegrehajtaniException();
                }
                String varazslatTipus = billentyuConvertToVarazslat.get(lenyomottBillenytu);
                csataterController.hasznalVarazslat(varazslatTipus, kattintottPozicio);
                kiirEllensegesEgysegAllapot(kattintottCella.getEgyseg());
            } else if (button == MouseButton.SECONDARY) {
                if (kattintottCella.ures()) {
                    throw new NemEgysegreProbalszAkciotVegrehajtaniException();
                }
                Egyseg kattintottEgyseg = kattintottCella.getEgyseg();
                csataterController.tamadHossel(kattintottCella.getEgyseg());
                kiirEllensegesEgysegAllapot(kattintottEgyseg);
            } else if (kattintottCella.ures() && button == MouseButton.PRIMARY) {
                csataterController.mozogEgyseg(kattintottPozicio);
            } else if (button == MouseButton.PRIMARY) {
                Egyseg kattintottEgyseg = kattintottCella.getEgyseg();
                if (csataterController.jelenlegiEgyseg().kritikusLeszEASebzes(csataterController.jelenlegiEgyseg().getHos().getSzerencse())) {
                    csataterController.jelenlegiEgyseg().kritikusSebzes(kattintottEgyseg);
                    kiiratKritikusSebzes();
                } else {
                    csataterController.tamad(kattintottCella.getEgyseg());
                }
                kiirEllensegesEgysegAllapot(kattintottEgyseg);
            }
            if (!jatekVegkimenetele()) {
                updateScreen();
                kiirSajatEgysegAllapot();
            }

        } catch (NonInvertibleTransformException e) {
            System.out.println("Nem lehet invertálni");
        } catch (OdaNemLephetszException
                | EzzelAVarazslattalNemRendelkezelException
                | NincsElegMannadAVarazslathozException
                | ErvenytelenBillenytuBemenetException
                | NemEgysegreProbalodVegrehajtaniAVarazslatotException
                | EllensegesEgysegreProbalszOlyanVarazslatotHasznalniAmitCsakSajatraTudszException
                | KoronkentCsakEgyszerCselekedhetszAHosselException
                | NemEgysegreProbalszAkciotVegrehajtaniException
                | OlyanEgysegetProbalszTamadniAmiNincsAKozvetlenKozeledbenException
                | SajatEgysegetProbalszTamadniException
                | TavolsagiTamadastProbalszInditaniPedigVanEllensegesEgysegAKozeledbenException e) {
            kiirHibauzenet(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //RAJZOLÁS ------------------------
    public void rajzolas() {
        g.setTransform(this.racs);
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

    private void rajzolRacsozat() {
        GraphicsContext g = this.negyzetracs.getGraphicsContext2D();
        g.setTransform(this.racs);
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
        hos.getEgysegek().forEach(csataterController::lerakEgyseg);
        ellenfel.getEgysegek().forEach(csataterController::lerakEgyseg);
        updateScreen();
    }

    private Cella jelenlegi() {
        return getPalya().getCella(new Pozicio(sor, oszlop));
    }

    //KÉPERNYŐFRISSÍTÉS
    public void updateScreen() {
        GraphicsContext e = this.negyzetracs.getGraphicsContext2D();
        e.setTransform(this.racs);
        tisztitTabla(e);
        csataterController
                .leveszHalottEgysegeket();
        csataterController
                .getOsszesEgyseg()
                .forEach(egyseg -> rajzolEgyseg(e, egyseg));
        Egyseg jelenlegiEgyseg = csataterController.jelenlegiEgyseg();
        kiemelAktualisEgyseg(e);
        frissitLabels();
        rajzolRacsozat();
    }

    private void kiemelAktualisEgyseg(GraphicsContext e) {
        Egyseg jelenlegiEgyseg = csataterController.jelenlegiEgyseg();
        e.setLineWidth(0.15);
        e.setStroke(Color.LIGHTGREEN);
        e.strokeRect(jelenlegiEgyseg.getPozicio().getOszlop(), jelenlegiEgyseg.getPozicio().getSor(), 1, 1);
    }

    private void frissitLabels() {
        getChildren().remove(mannaKiirLabel);
        getChildren().remove(sajatEgysegInfoLabel);
        getChildren().remove(hanyadikKorLabel);
        kiirManna();
        korszamKiiratas();
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
                                .getResourceAsStream("com/example/game/megjelenites/" + egyseg.getNev() + ".png")
                )
        );
    }


    //GETTEREK ÉS SETTEREK

    private Palya getPalya() {
        return csataterController.getPalya();
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
