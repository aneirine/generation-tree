package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.config.FxmlView;
import com.aneirine.generation_tree.config.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javax.xml.ws.Action;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class MainController implements Initializable {

    @FXML
    private Button createFamilyButton;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createFamilyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stageManager.addSecondStage(FxmlView.CREATE_FAMILY);
        });
    }
}
