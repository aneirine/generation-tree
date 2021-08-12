package com.aneirine.generation_tree.jpa.families;

import com.aneirine.generation_tree.jpa.families.dto.AddRelationDto;
import com.aneirine.generation_tree.jpa.families.dto.FamilyMemberCreateDto;
import com.aneirine.generation_tree.jpa.families.persistence.Family;
import com.aneirine.generation_tree.jpa.families.persistence.FamilyMember;
import com.aneirine.generation_tree.jpa.families.persistence.FamilyMemberPerson;
import com.aneirine.generation_tree.jpa.families.persistence.Relation;
import com.aneirine.generation_tree.jpa.families.persistence.enums.Race;
import com.aneirine.generation_tree.jpa.families.persistence.enums.RelationType;
import com.aneirine.generation_tree.jpa.families.repositories.FamilyMemberRepository;
import com.aneirine.generation_tree.jpa.families.repositories.FamilyRepository;
import com.aneirine.generation_tree.jpa.families.repositories.RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

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

    //TODO: recreate relation logic
    //TODO: Test methods
    private static void addSpouse(FamilyMember first, FamilyMember second) {
        Relation relation = new Relation(first, second, RelationType.SPOUSE);
    }

//    private static void addChild(FamilyMember child, FamilyMember parent) {
//        addParentChildRelation(parent, child);
//        List<Relation> relations = relationRepository.findAllByFamilyMemberFirstOrFamilyMemberSecond(parent);
//        FamilyMember parentSecond = relations.stream()
//                .filter(o -> o.getRelationType() == RelationType.SPOUSE)
//                .findFirst().get().ge();
//
//        if (parentSecond != null) {
//            addParentChildRelation(parentSecond, child);
//        }
//
//        addGrandParentsIfExists(parent, parentSecond, child);
//
//    }
//
//    private static void addGrandParentsIfExists(FamilyMember parent1, FamilyMember parent2, FamilyMember child) {
//        List<FamilyMember> grandparents = getParentFromMember(parent1);
//        List<FamilyMember> grandparents2 = getParentFromMember(parent2);
//
//        addGrandParent(Arrays.asList(grandparents, grandparents2), child);
//
//    }
//
//    private static void addGrandParent(List<List<FamilyMember>> grandparents, FamilyMember child) {
//        grandparents.stream().flatMap(Collection::stream).forEach(member -> {
//            member.addRelation(child, RelationType.GRANDCHILD);
//            child.addRelation(member, RelationType.GRANDPARENT);
//        });
//    }
//
//    private static List<FamilyMember> getParentFromMember(FamilyMember parent) {
//        if (parent == null) return new ArrayList<>();
//        List<FamilyMember> parents = parent.getRelations().stream()
//                .filter(o -> o.getType() == RelationType.PARENT)
//                .map(o -> o.getMember())
//                .collect(Collectors.toList());
//        return parents;
//    }
//
//
//    private static void addParentChildRelation(FamilyMember parent, FamilyMember child) {
//        parent.addRelation(child, RelationType.CHILD);
//        child.addRelation(parent, RelationType.PARENT);
//    }
}
