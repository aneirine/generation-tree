package com.aneirine.generation_tree.jpa.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "families")
public class Family extends BaseEntity {

    @Column(name = "name")
    private String name;

}
