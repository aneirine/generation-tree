package com.aneirine.generation_tree.jpa.repositories;

import com.aneirine.generation_tree.jpa.entities.family.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyRepository extends JpaRepository<Family, UUID> {
    Family findByName(String name);
}
