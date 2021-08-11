package com.aneirine.generation_tree.jpa.dto;

import com.aneirine.generation_tree.jpa.entities.family.enums.Gender;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMemberCreateDto {
    private UUID familyUuid;
    private String name;
    private String surname;
    private Gender genger;
}
