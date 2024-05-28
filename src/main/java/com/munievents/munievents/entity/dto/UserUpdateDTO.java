package com.munievents.munievents.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private String image_user;
    private String email;
    private String phone;
    private String full_name;
    private String alias;
    private int qty_event_sub;
}
