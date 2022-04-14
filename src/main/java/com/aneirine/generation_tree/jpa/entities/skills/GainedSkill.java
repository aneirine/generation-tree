package com.aneirine.generation_tree.jpa.entities.skills;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import com.aneirine.generation_tree.jpa.families.persistence.FamilyMember;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * The information about {@link com.aneirine.generation_tree.jpa.families.persistence.FamilyMember}
 * who gained this skill
 */

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "GainedSkill")
@Table(name = "gained_skills")
public class GainedSkill extends BaseEntity {

    @ManyToOne
    private Skill skill;

    @Column(name = "level")
    private Integer level;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GainedSkill that = (GainedSkill) o;
        return Objects.equals(skill, that.skill) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, level);
    }
}
