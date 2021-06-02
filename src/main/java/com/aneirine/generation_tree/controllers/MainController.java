package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.config.FxmlView;
import com.aneirine.generation_tree.config.StageManager;
import com.aneirine.generation_tree.jpa.services.FamilyService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class MainController implements Initializable {

    @FXML
    private Button createFamilyButton;
    @FXML
    private ListView listViewFamilies;

    @Lazy
    @Autowired
    private StageManager stageManager;

    private final FamilyService familyService;
    private ObservableList<String> familiesList = FXCollections.observableArrayList();

    public MainController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadFamiliesNames();
        createFamilyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stageManager.addSecondStage(FxmlView.CREATE_FAMILY);
        });
    }


    public void loadFamiliesNames() {
        familiesList.clear();
        familiesList.addAll(familyService.getAllFamiliesNames());
        listViewFamilies.setItems(familiesList);
/*
        userTable.setItems(userList);*/
    }
}
