package com.aneirine.generation_tree.jpa.families.persistence;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import lombok.*;
import com.aneirine.generation_tree.jpa.families.persistence.enums.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FamilyMember extends BaseEntity {

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "surname")
    protected String surname;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    protected Gender gender;

}
