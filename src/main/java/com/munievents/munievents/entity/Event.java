package com.munievents.munievents.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "evento")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    private String ubicacion;
    private double precio;
    private String fecha_creacion;
    private int categoria_idcategoria;
}
