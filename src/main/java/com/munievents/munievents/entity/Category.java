package com.munievents.munievents.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    //TODO: hacemos la relacion de uno a muchos
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category" )
    private Set<Event> events;

}
