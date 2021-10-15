package com.aneirine.generation_tree.jpa.families.persistence;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import com.aneirine.generation_tree.jpa.families.persistence.enums.Gender;
import com.aneirine.generation_tree.jpa.families.persistence.enums.RelationType;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

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

    @ElementCollection(fetch  = FetchType.EAGER)
    @CollectionTable(name = "relations")
    @Enumerated(EnumType.STRING)
    protected Map<FamilyMember, RelationType> relations = new HashMap<>();

    public void addRelation(FamilyMember familyMember, RelationType relationType){
        this.relations.put(familyMember, relationType);
    }

}
