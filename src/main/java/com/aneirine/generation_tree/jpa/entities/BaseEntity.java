package com.aneirine.generation_tree.jpa.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
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
