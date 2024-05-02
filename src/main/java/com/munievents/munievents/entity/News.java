package com.munievents.munievents.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table (name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String image_new;


}
