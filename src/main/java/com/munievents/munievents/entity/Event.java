package com.munievents.munievents.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


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

    //TODO: relacionamos la tabla de muchos a uno, muchos eventos tendran una sola categoria
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    private int coins;
}
