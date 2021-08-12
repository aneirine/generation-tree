package com.aneirine.generation_tree.jpa.families.repositories;

import com.aneirine.generation_tree.jpa.families.persistence.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyRepository extends JpaRepository<Family, UUID> {
    Family findByName(String name);
}
