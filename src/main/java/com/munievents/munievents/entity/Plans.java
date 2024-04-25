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
<<<<<<< HEAD
    // @OneToMany(mappedBy = "plan_id")
=======
    @OneToMany(cascade = CascadeType.ALL)
>>>>>>> 6b441971759d668a7b4fd9ed93d8facdb7e6cf4f
    private List<Subscription> subscription;
}
