package com.example.conversion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConversionController {
    @FXML
    public TextField idC;

    @FXML
    public TextField idF;
    @FXML
    public Button idButton;

    @FXML
    public void convertValue(ActionEvent actionEvent) {
        idButton.setOnAction(event -> onButtonClicked());
    }
    @FXML
    public void onButtonClicked() {
        try {
            double valueC = Double.parseDouble(idC.getText());
            double op = valueC * 16 + 32;
            idF.setText(Double.toString(op));
        } catch (NumberFormatException e) {
            idF.setText("Wrong Input");
        }
    }
}