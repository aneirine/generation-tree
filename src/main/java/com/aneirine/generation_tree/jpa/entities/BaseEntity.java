package com.aneirine.generation_tree.jpa.entities;

import lombok.Getter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @Type(type = "pg-uuid")
    @Column(unique = true, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
    }
}