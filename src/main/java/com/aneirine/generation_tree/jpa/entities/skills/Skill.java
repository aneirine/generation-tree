package com.aneirine.generation_tree.jpa.entities.skills;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Skill")
@Table(name = "skills")
public class Skill extends BaseEntity {

    @Column(name = "name")
    private String name;

    private Integer maxLevel;

    private Boolean hidden;

    //TODO: maybe add challenges and statistics, as in Sims games
}
