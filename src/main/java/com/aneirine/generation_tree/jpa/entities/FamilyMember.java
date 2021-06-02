package com.aneirine.generation_tree.jpa.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "FamilyMember")
@Table(name = "family_members")
public class FamilyMember extends BaseEntity {

    protected String firstName;
    protected String surname;

    //TODO:
    // private List<Relation> relationList;
    // traits
    // live  goals
    // memories
    // gallery

}
