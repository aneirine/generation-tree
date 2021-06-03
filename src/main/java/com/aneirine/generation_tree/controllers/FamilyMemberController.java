package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.jpa.dto.FamilyMemberCreateDto;
import com.aneirine.generation_tree.jpa.entities.Family;
import com.aneirine.generation_tree.jpa.entities.enums.Gender;
import com.aneirine.generation_tree.jpa.services.FamilyMemberService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@RequiredArgsConstructor
public class FamilyMemberController implements Initializable {

    @FXML
    private Button buttonCreateFamilyMember;
    @FXML
    private TextField textFieldFamilyFirstName, textFieldFamilySurname;
    @FXML
    private RadioButton radioButtonMale, radioButtonFemale;

    private final FamilyMemberService familyMemberService;
    private final MainController mainController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        radioButtonMale.setToggleGroup(group);
        radioButtonFemale.setToggleGroup(group);
        buttonCreateFamilyMember.addEventHandler(MouseEvent.MOUSE_CLICKED, this::createFamilyMember);
    }

    private void createFamilyMember(MouseEvent event) {
        Gender gender = radioButtonMale.isSelected() ? Gender.MALE : Gender.FEMALE;
        Family family = mainController.getCurrentFamily();
        familyMemberService.createFamilyMember(
                FamilyMemberCreateDto.builder()
                        .genger(gender)
                        .name(textFieldFamilyFirstName.getText())
                        .surname(textFieldFamilySurname.getText().isEmpty() ? family.getName() : textFieldFamilySurname.getText())
                        .familyUuid(family.getId())
                        .build()
        );
        Stage stage = (Stage) buttonCreateFamilyMember.getScene().getWindow();
        stage.close();
        mainController.loadFamilyTree();
    }
}
