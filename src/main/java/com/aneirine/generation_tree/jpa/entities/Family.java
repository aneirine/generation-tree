package com.aneirine.generation_tree.jpa.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "families")
public class Family {

    @Id
    @Type(type = "pg-uuid")
    @Column(unique = true, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @Column(name = "name")
    private String name;


    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
    }
}
