package com.example.currency;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable {

    @FXML
    public Button idButton;
    @FXML
    public TextField idText1;
    @FXML
    public TextField idText2;
    @FXML
    public ChoiceBox<String> idChoice1;
    @FXML
    public ChoiceBox<String> idChoice2;
    @FXML
    public Button idEmpty;

    String[] currency = {"EUR(€)", "USD($)", "GBP(£)"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idChoice1.getItems().addAll(currency);
        idChoice2.getItems().addAll(currency);
    }

    public String valueChoice1(){

        return idChoice1.getValue();
    }
    public String valueChoice2(){
        return idChoice2.getValue();
    }


    public void convertValue(ActionEvent actionEvent) {
        idButton.setOnAction(event -> onButtonClicked());
    }
    public void onButtonClicked(){

        try {

            double value = Double.parseDouble(idText1.getText());
            String c1 = valueChoice1();
            String c2 = valueChoice2();

            if (c1.equals("EUR(€)") && c2.equals("USD($)")) {
                value *= 1.07;
                idText2.setText(Double.toString(value));
            } else if (c1.equals("USD($)") && c2.equals("EUR(€)")) {
                value /= 1.07;
                idText2.setText(Double.toString(value));
            }

            if (c1.equals("EUR(€)") && c2.equals("GBP(£)")) {
                value *= 0.86;
                idText2.setText(Double.toString(value));
            } else if (c1.equals("GBP(£)") && c2.equals("EUR(€)")) {
                value /= 0.86;
                idText2.setText(Double.toString(value));
            }

            if (c1.equals("USD($)") && c2.equals("GBP(£)")) {
                value *= 0.8;
                idText2.setText(Double.toString(value));
            } else if (c1.equals("GBP(£)") && c2.equals("USD($)")) {
                value /= 0.8;
                idText2.setText(Double.toString(value));
            }

            if (c1.equals(c2)) {
                idText2.setText(Double.toString(value));
            }
        }catch (NumberFormatException e){
            idText2.setText("ERROR: NOT VALUE!");
        }
    }
    public void setEmpty(ActionEvent actionEvent) {

        idEmpty.setOnAction(event -> onEmptyClicked());
    }
    public void onEmptyClicked(){
        idText1.clear();
        idText2.clear();
    }
}