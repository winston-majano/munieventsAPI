package com.munievents.munievents.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="photos")
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo_url;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event events;

}
