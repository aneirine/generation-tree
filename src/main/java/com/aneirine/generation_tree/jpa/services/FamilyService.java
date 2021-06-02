package com.aneirine.generation_tree.jpa.services;

import com.aneirine.generation_tree.jpa.entities.Family;
import com.aneirine.generation_tree.jpa.repositories.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public void createFamily(String familyName) {
        Family family = Family.builder()
                .name(familyName)
                .build();
        familyRepository.save(family);
    }
}
