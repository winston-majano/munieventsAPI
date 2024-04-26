package com.munievents.munievents.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int puntuation;
    private LocalDateTime creation_date;
    private int event_id;
    private int user_id;

}
