package com.aneirine.generation_tree.jpa.families.dto;

import com.aneirine.generation_tree.jpa.families.persistence.enums.Gender;
import com.aneirine.generation_tree.jpa.families.persistence.enums.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FamilyMemberCreateDto {
    private UUID familyUuid;
    private String name;
    private String surname;
    private Gender gender;
    private Race race;
}
