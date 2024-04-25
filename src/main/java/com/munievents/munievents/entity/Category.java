package com.munievents.munievents.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
   // @OneToMany(cascade = CascadeType.ALL,mappedBy = "category" )
   // private List<Event> events;
    //TODO: con el JSon ignore evitamos traer todos los json anidados de las tabalas relacionadas

    //Lo dejo comentado porque da errores.
    // @JsonIgnore
     //@OneToMany(cascade = CascadeType.ALL)
     //@JoinColumn(name = "category_id")




     @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn(name = "category_id")
     private Set<Event> events;

}
