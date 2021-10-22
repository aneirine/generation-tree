package com.aneirine.generation_tree.jpa.families;

import com.aneirine.generation_tree.jpa.families.persistence.Family;
import com.aneirine.generation_tree.jpa.families.repositories.FamilyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;

    public void createFamily(String familyName) {
        Family savedFamily = familyRepository.save(Family.builder()
                .name(familyName)
                .build());
        log.info("Saved new family [{}]", savedFamily);
    }

    public List<String> getAllFamiliesNames() {
        return familyRepository.findAll()
                .stream()
                .map(temp -> temp.getName())
                .collect(Collectors.toList());
    }

    public Family getFamilyByName(String name) {
        return familyRepository.findByName(name);
    }
}
