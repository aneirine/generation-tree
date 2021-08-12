package com.aneirine.generation_tree.jpa.families;

import com.aneirine.generation_tree.jpa.families.dto.AddRelationDto;
import com.aneirine.generation_tree.jpa.families.dto.FamilyMemberCreateDto;
import com.aneirine.generation_tree.jpa.families.persistence.Family;
import com.aneirine.generation_tree.jpa.families.persistence.FamilyMember;
import com.aneirine.generation_tree.jpa.families.persistence.FamilyMemberPerson;
import com.aneirine.generation_tree.jpa.families.persistence.Relation;
import com.aneirine.generation_tree.jpa.families.persistence.enums.Race;
import com.aneirine.generation_tree.jpa.families.repositories.FamilyMemberRepository;
import com.aneirine.generation_tree.jpa.families.repositories.FamilyRepository;
import com.aneirine.generation_tree.jpa.families.repositories.RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;
    private final FamilyRepository familyRepository;
    private final RelationRepository relationRepository;

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

    public void addRelation(AddRelationDto dto){
        FamilyMember familyMemberFirst = familyMemberRepository.getById(UUID.fromString(dto.getFirstMemberUUid()));
        FamilyMember familyMemberSecond = familyMemberRepository.getById(UUID.fromString(dto.getSecondMemberUUid()));

        Relation relation = new Relation(familyMemberFirst, familyMemberSecond, dto.getRelationType());
        relationRepository.save(relation);
    }
}
