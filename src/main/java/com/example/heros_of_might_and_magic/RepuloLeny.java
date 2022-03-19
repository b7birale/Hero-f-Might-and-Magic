package com.example.heros_of_might_and_magic;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class RepuloLeny extends Egyseg{

    @FXML
    private Text arany;
    public void writeGold(int mennyiseg) {
        arany.setText(String.valueOf(mennyiseg));
    }
}