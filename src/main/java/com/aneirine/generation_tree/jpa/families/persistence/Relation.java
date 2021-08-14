package com.aneirine.generation_tree.jpa.families.persistence;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import com.aneirine.generation_tree.jpa.families.persistence.enums.RelationType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Relation")
@Table(name = "relations")
public class Relation extends BaseEntity {

    @ManyToOne
    private FamilyMember relatedMember;

    @Enumerated(EnumType.STRING)
    private RelationType relationType;
}
