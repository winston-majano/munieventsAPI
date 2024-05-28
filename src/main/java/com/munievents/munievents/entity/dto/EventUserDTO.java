package com.munievents.munievents.entity.dto;
import java.time.LocalDateTime;

public record EventUserDTO(int id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location, double price, int coins, LocalDateTime creation_date, int category_id, int user_id, String photo) {

}
