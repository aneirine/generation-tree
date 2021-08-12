package com.aneirine.generation_tree.jpa.families.repositories;

import com.aneirine.generation_tree.jpa.families.persistence.FamilyMember;
import com.aneirine.generation_tree.jpa.families.persistence.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RelationRepository extends JpaRepository<Relation, UUID> {
    List<Relation> findAllByFamilyMemberFirstOrFamilyMemberSecond(FamilyMember familyMember);
}
