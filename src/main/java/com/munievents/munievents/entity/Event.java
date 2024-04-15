package com.munievents.munievents.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private int id;
    private String nameEvent;
    private String description;
    private String dateEvent;
    private double price;
}
