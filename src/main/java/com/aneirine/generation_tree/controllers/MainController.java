package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.config.FxmlView;
import com.aneirine.generation_tree.config.StageManager;
import com.aneirine.generation_tree.jpa.entities.Family;
import com.aneirine.generation_tree.jpa.entities.FamilyMember;
import com.aneirine.generation_tree.jpa.services.FamilyService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Controller
public class MainController implements Initializable {

    @FXML
    private Button createFamilyButton;
    private Button buttonCreateFamilyMember;
    @FXML
    private ListView listViewFamilies;
    @FXML
    private HBox hBoxTree;

    @Lazy
    @Autowired
    private StageManager stageManager;

    private final FamilyService familyService;

    private ObservableList<String> familiesList = FXCollections.observableArrayList();
    private String currentFamilyName;

    public MainController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonCreateFamilyMember = (Button) stageManager.getElementFromStage(FxmlView.FAMILY_MEMBER_BUTTON);
        loadFamiliesNames();
        createFamilyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                stageManager.addSecondStage(FxmlView.FAMILY));

        listViewFamilies.setOnMouseClicked(event -> loadFamilyTree());
        buttonCreateFamilyMember.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stageManager.addSecondStage(FxmlView.FAMILY_MEMBER);
        });
    }

    public void loadFamiliesNames() {
        familiesList.clear();
        familiesList.addAll(familyService.getAllFamiliesNames());
        listViewFamilies.setItems(familiesList);
    }

    public void loadFamilyTree() {
        System.out.println("FAMILY NAME");
        Family family = familyService.getFamilyByName((String) listViewFamilies.getSelectionModel().getSelectedItem());
        currentFamilyName = family.getName();
        if (family.getFamilyMembers() == null || family.getFamilyMembers().isEmpty()) {
            hBoxTree.getChildren().clear();
            hBoxTree.getChildren().add(buttonCreateFamilyMember);
        } else {
            hBoxTree.getChildren().clear();
            //TODO: show tree
            createMemberIcon();
        }
    }

    private void createMemberIcon() {
        Family family = getCurrentFamily();
        List<VBox> vBoxes = family.getFamilyMembers().stream()
                .map(this::constructMemberIcon)
                .collect(Collectors.toList());

        hBoxTree.getChildren().addAll(vBoxes);
    }

    private VBox constructMemberIcon(FamilyMember member) {
        VBox vBoxMember = (VBox) stageManager.getElementFromStage(FxmlView.MEMBER);
        ImageView imageView = (ImageView) vBoxMember.getChildren().get(0);
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/icons/female-icon-27.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView.setImage(new Image(input));
        Text name = (Text) vBoxMember.getChildren().get(1);
        name.setText(member.getFirstName() + " " + member.getSurname());
        return vBoxMember;
    }

    public Family getCurrentFamily() {
        return familyService.getFamilyByName(currentFamilyName);
    }


}
