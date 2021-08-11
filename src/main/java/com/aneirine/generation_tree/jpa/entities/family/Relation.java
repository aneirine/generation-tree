package com.aneirine.generation_tree.jpa.entities.family;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import lombok.*;

import javax.management.relation.RelationType;
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
    private FamilyMember familyMemberFirst;

    @ManyToOne
    private FamilyMember familyMemberSecond;

    @Enumerated(EnumType.STRING)
    private RelationType relationType;
}
