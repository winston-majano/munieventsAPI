package com.munievents.munievents.entity;

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
    private int id_category;
    private int coins;
}
