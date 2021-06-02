package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.config.FxmlView;
import com.aneirine.generation_tree.config.StageManager;
import com.aneirine.generation_tree.jpa.entities.Family;
import com.aneirine.generation_tree.jpa.services.FamilyService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

    @FXML
    private HBox hBoxTree;

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
        createFamilyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                stageManager.addSecondStage(FxmlView.FAMILY));

        listViewFamilies.setOnMouseClicked(event -> loadFamilyTree());
    }

    public void loadFamiliesNames() {
        familiesList.clear();
        familiesList.addAll(familyService.getAllFamiliesNames());
        listViewFamilies.setItems(familiesList);
    }

    private void loadFamilyTree() {
        Family family = familyService.getFamilyByName((String) listViewFamilies.getSelectionModel().getSelectedItem());
        if (family.getFamilyMembers() == null || family.getFamilyMembers().isEmpty()) {
            //TODO: remove previous button from stage
           hBoxTree.getChildren().clear();
            displayButtonInPane();
        } else {
            //TODO: show tree
            family.getFamilyMembers().forEach(temp -> System.out.printf(temp.toString()));
        }
    }

    private void displayButtonInPane(){
        Button button = (Button) stageManager.getElementFromStage(FxmlView.FAMILY_MEMBER_BUTTON);
        hBoxTree.getChildren().add(button);
    }




}
