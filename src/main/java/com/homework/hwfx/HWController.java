package com.homework.hwfx;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class HWController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label gLabel;

    @FXML
    private Label kgLabel;

    @FXML
    private TextField textEdit;

    @FXML
    private ChoiceBox<String> chbox;

    @FXML
    private Label tLabel;

    @FXML
    void keyReleased(KeyEvent event) {
        convert();;
    }

    private void convert() {
        Float res = Float.valueOf(textEdit.getText());

        switch (chbox.getValue()) {
            case "Граммы":
                gLabel.setText(String.valueOf(res));
                kgLabel.setText(String.valueOf(res / 1000));
                tLabel.setText(String.valueOf(res / (1000 * 1000)));
                break;
            case "Килограммы":
                gLabel.setText(String.valueOf(res * 1000));
                kgLabel.setText(String.valueOf(res));
                tLabel.setText(String.valueOf(res  / 1000));
                break;
            case "Тонны":
                gLabel.setText(String.valueOf(res * (1000 * 1000)));
                kgLabel.setText(String.valueOf(res * 1000));
                tLabel.setText(String.valueOf(res));
                break;
        }
    }

    @FXML
    void initialize() {
        chbox.setItems(FXCollections.observableArrayList("Граммы", "Килограммы", "Тонны"));
        chbox.setValue("Граммы");
        chbox.setOnAction(event -> {
            if(textEdit.getText().isEmpty())
                convert();
        });
    }

}
