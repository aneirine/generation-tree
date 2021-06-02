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
public class CreateFamilyController implements Initializable {

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
            String text = textFieldFamilyName.getText();
            System.out.println("Family name is " + text);

            familyService.createFamily(text);
            mainController.loadFamiliesNames();
            //get current stage
            Stage stage = (Stage) buttonConfirm.getScene().getWindow();
            stage.close();

        });
    }


}
