package com.aneirine.generation_tree.jpa.families.persistence;

import com.aneirine.generation_tree.jpa.families.persistence.enums.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "FamilyMemberAnimal")
@Table(name = "family_members_animal")
public class FamilyMemberAnimal extends FamilyMember {

    @Column(name = "animal_type")
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;
}
