package com.aneirine.generation_tree.jpa.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Family")
@Table(name = "families")
public class Family extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<FamilyMember> familyMembers;

}
