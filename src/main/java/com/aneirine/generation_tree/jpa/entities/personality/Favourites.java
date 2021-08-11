package com.aneirine.generation_tree.jpa.entities.personality;

import com.aneirine.generation_tree.jpa.entities.BaseEntity;
import com.aneirine.generation_tree.jpa.entities.personality.enums.FavouriteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Favourites")
@Table(name = "favourites")
public class Favourites extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "favourite_type")
    @Enumerated(EnumType.STRING)
    private FavouriteType favouriteType;
}
