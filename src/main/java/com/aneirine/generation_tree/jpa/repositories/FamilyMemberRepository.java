package com.aneirine.generation_tree.jpa.repositories;

import com.aneirine.generation_tree.jpa.entities.family.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID> {
}
