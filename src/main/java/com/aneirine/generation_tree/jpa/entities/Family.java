package com.aneirine.generation_tree.jpa.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}
