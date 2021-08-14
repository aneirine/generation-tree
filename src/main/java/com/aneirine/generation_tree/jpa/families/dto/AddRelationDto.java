package com.aneirine.generation_tree.jpa.families.dto;

import com.aneirine.generation_tree.jpa.families.persistence.enums.RelationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AddRelationDto {
    private String firstMemberUUid;
    private String secondMemberUUid;
    private RelationType relationType;

}
