package com.munievents.munievents.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table (name = "news")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String descripcion;
    private String image_news;


}
