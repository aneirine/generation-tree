package com.aneirine.generation_tree.jpa.entities.family;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import lombok.*;
import com.aneirine.generation_tree.jpa.entities.family.enums.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "FamilyMember")
@Table(name = "family_members")
public class FamilyMember extends BaseEntity {

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "surname")
    protected String surname;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    protected Gender gender;

    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    protected Race race;

    //TODO:
    // private List<Relation> relationList;
    // traits
    // live  goals
    // memories
    // gallery

}
