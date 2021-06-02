package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.jpa.services.FamilyService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class FamilyController implements Initializable {

    @FXML
    private TextField textFieldFamilyName;
    @FXML
    private Button buttonConfirm;

    @Autowired
    private FamilyService familyService;
    @Autowired
    private MainController mainController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonConfirm.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String familyName = textFieldFamilyName.getText();
            familyService.createFamily(familyName);

            mainController.loadFamiliesNames();
            Stage stage = (Stage) buttonConfirm.getScene().getWindow();
            stage.close();

        });
    }


}