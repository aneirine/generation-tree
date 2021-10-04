package com.aneirine.generation_tree.jpa.families.persistence;

import com.aneirine.generation_tree.jpa.families.persistence.enums.Race;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "FamilyMemberPerson")
@Table(name = "family_members_person")
public class FamilyMemberPerson extends FamilyMember {

    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    private Race race;


    //TODO:
    // private List<Relation> relationList;
    // traits
    // live  goals
    // memories
    // gallery
}
