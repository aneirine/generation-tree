package com.aneirine.generation_tree.jpa.families.repositories;

import com.aneirine.generation_tree.jpa.families.persistence.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID> {
}
