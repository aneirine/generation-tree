package com.aneirine.generation_tree.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class CreateFamilyController implements Initializable {

    @FXML
    private TextField textFieldFamilyName;
    @FXML
    private Button buttonConfirm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonConfirm.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String text = textFieldFamilyName.getText();
            System.out.println("Family name is " + text);
        });
    }
}
