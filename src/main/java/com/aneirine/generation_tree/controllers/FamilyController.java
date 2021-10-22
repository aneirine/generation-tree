package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.jpa.families.FamilyService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FamilyController implements Initializable {

    @FXML
    private TextField textFieldFamilyName;
    @FXML
    private Button buttonConfirm;

    private final FamilyService familyService;
    private final MainController mainController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonConfirm.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String familyName = textFieldFamilyName.getText();
            log.info("Processing family creation with name [{}]", familyName);
            familyService.createFamily(familyName);

            mainController.loadFamiliesNames();
            Stage stage = (Stage) buttonConfirm.getScene().getWindow();
            stage.close();
        });
    }

}
