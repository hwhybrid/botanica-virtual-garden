package com.portfolio.botanica.dtos;

import com.portfolio.botanica.entities.UserRole;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private String email;
}
