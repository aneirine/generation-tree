package com.aneirine.generation_tree.jpa.entities.family;

import com.aneirine.generation_tree.jpa.entities.family.enums.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "FamilyMemberPerson")
@Table(name = "family_members_person")
public class FamilyMemberPerson extends FamilyMember{

    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    private Race race;
}
