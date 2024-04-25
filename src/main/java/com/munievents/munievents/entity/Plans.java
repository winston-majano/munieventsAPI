package com.munievents.munievents.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "plans")
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int price;
    private int qty_event;

    //TODO: hacemos la relacion de uno a muchos
    @OneToMany(cascade = CascadeType.ALL)
    private List<Subscription> subscription;
}
