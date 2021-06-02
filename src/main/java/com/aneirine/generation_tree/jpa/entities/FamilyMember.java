package com.aneirine.generation_tree.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "family_members")
public class FamilyMember extends  BaseEntity{

    protected String firstName;
    protected String surname;

    // will be added
    // private List<Relation> relationList;
    // traits
    // live  goals
    // memories
    // gallery

}
