package com.munievents.munievents.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    //TODO: hacemos la relacion de uno a muchos
    @OneToMany(mappedBy = "category")
    private List<Event> events;

}
