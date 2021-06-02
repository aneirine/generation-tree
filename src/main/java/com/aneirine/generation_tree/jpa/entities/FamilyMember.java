package com.aneirine.generation_tree.jpa.entities;

import com.aneirine.generation_tree.jpa.entities.enums.Gender;
import lombok.*;

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

    //TODO:
    // private List<Relation> relationList;
    // traits
    // live  goals
    // memories
    // gallery

}
