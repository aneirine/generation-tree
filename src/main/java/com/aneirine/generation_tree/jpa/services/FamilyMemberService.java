package com.aneirine.generation_tree.jpa.services;

import com.aneirine.generation_tree.jpa.dto.FamilyMemberCreateDto;
import com.aneirine.generation_tree.jpa.entities.family.Family;
import com.aneirine.generation_tree.jpa.entities.family.FamilyMember;
import com.aneirine.generation_tree.jpa.repositories.FamilyMemberRepository;
import com.aneirine.generation_tree.jpa.repositories.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;
    private final FamilyRepository familyRepository;

    @Transactional
    public void createFamilyMember(FamilyMemberCreateDto dto) {
        Family family = familyRepository.getById(dto.getFamilyUuid());
        FamilyMember familyMember = FamilyMember.builder()
                .firstName(dto.getName())
                .surname(dto.getSurname())
                .gender(dto.getGender())
                .race(dto.getRace())
                .build();
        familyMemberRepository.save(familyMember);
        family.addFamilyMember(familyMember);
        familyRepository.save(family);
    }
}
