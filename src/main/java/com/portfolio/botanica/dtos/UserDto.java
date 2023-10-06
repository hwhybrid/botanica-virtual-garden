package com.portfolio.botanica.dtos;

import com.portfolio.botanica.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private UserRole role; // Enum for user role (admin/user)
}
