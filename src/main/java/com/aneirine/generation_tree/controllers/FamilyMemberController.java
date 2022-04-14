package com.aneirine.generation_tree.controllers;

import com.aneirine.generation_tree.jpa.families.FamilyMemberService;
import com.aneirine.generation_tree.jpa.families.dto.FamilyMemberCreateDto;
import com.aneirine.generation_tree.jpa.families.persistence.Family;
import com.aneirine.generation_tree.jpa.families.persistence.enums.Gender;
import com.aneirine.generation_tree.jpa.families.persistence.enums.Race;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

    public void createFamilyMember(MouseEvent event) {
        FamilyMemberCreateDto dto = familyMemberCreateDto();
        if (dto == null) {
            log.error("Cannot create family member, no active family was found");
            return;
        }
        familyMemberService.createFamilyMember(dto);
        Stage stage = (Stage) buttonCreateFamilyMember.getScene().getWindow();
        stage.close();

        mainController.loadFamilyTree();
    }

    private FamilyMemberCreateDto familyMemberCreateDto() {
        Gender gender = radioButtonMale.isSelected() ? Gender.MALE : Gender.FEMALE;
        Family family = mainController.getCurrentFamily();
        if (family == null) {
            //TODO add exception throwing
            return null;
        }
        return FamilyMemberCreateDto.builder()
                .gender(gender)
                .name(textFieldFamilyFirstName.getText())
                .surname(formatSurname(family.getName()))
                .familyUuid(family.getId())
                .race(Race.HUMAN)
                .build();
    }

    private String formatSurname(String familyName) {
        return textFieldFamilySurname.getText().isEmpty() ? familyName : textFieldFamilySurname.getText();
    }
}
