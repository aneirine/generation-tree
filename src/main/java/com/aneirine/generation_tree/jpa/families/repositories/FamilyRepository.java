package com.aneirine.generation_tree.jpa.families.repositories;

import com.aneirine.generation_tree.jpa.families.persistence.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FamilyRepository extends JpaRepository<Family, UUID> {
    Optional<Family> findById(UUID id);

    Optional<Family> findByName(String name);


}
