package com.example.heros_of_might_and_magic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class controll {
    @FXML

    int arany;

    public void konnyu(ActionEvent e){
        arany = 1300;
    }
    public void kozepes(ActionEvent e){
        arany = 1000;
    }
    public void nehez(ActionEvent e){
        arany = 700;
    }
}
