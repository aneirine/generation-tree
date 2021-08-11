package com.aneirine.generation_tree.jpa.entities.life_goals;

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

@Entity(name = "LifeGoal")
@Table(name = "life_goals")
public class LifeGoal extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "goal")
    private String goal;

    @Column(name = "description")
    private String description;

    @Column(name = "happiness")
    private Integer happiness;
}
