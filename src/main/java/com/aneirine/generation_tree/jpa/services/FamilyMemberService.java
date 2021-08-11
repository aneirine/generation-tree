package com.aneirine.generation_tree.jpa.services;

import com.aneirine.generation_tree.jpa.dto.FamilyMemberCreateDto;
import com.aneirine.generation_tree.jpa.entities.family.Family;
import com.aneirine.generation_tree.jpa.entities.family.FamilyMember;
import com.aneirine.generation_tree.jpa.entities.family.FamilyMemberPerson;
import com.aneirine.generation_tree.jpa.entities.family.enums.Race;
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
        Family family = familyRepository.findByName(dto.getSurname());

        FamilyMemberPerson familyMemberPerson = new FamilyMemberPerson();
        familyMemberPerson.setRace(Race.HUMAN);
        familyMemberPerson.setSurname(dto.getSurname());
        familyMemberPerson.setFirstName(dto.getName());
        familyMemberPerson.setGender(dto.getGender());

        familyMemberRepository.saveAndFlush(familyMemberPerson);
        family.addFamilyMember(familyMemberPerson);
        familyRepository.saveAndFlush(family);
    }
}
