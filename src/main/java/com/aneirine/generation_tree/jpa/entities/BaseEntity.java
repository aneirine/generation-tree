package com.aneirine.generation_tree.jpa.entities;

import lombok.Getter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Type(type = "pg-uuid")
    @Column(unique = true, nullable = false, columnDefinition = "uuid")
    protected UUID id;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
    }
}
