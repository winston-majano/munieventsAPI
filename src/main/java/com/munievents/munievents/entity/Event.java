package com.munievents.munievents.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String start_date;
    private String end_date;
    private String location;
    private double price;
    private String creation_date;
    private int category_id;
    //TODO: relacionamos la tabla de muchos a uno, muchos eventos tendran una sola categoria
    //@JsonIgnore
   // @ManyToOne
    //@JoinColumn(name = "categoryId")
    //private Category category;
    private int coins;
    //@JsonIgnore

    // Lo dejo comentado porque da error.
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "event_id")
    // private Set<Photos> photos;


    //private Set<Photos> photosset;
}
